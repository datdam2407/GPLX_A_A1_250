import { ExamResultEntity, QuestionProgressEntity } from '../types';

const PROGRESS_KEY = 'gplx_question_progress_v1';
const RESULTS_KEY = 'gplx_exam_results_v1';

export function loadAllProgress(): QuestionProgressEntity[] {
  try {
    const raw = localStorage.getItem(PROGRESS_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch (e) {
    console.error('Failed to load progress from localStorage', e);
    return [];
  }
}

export function saveAllProgress(list: QuestionProgressEntity[]): void {
  try {
    localStorage.setItem(PROGRESS_KEY, JSON.stringify(list));
  } catch (e) {
    console.error('Failed to save progress to localStorage', e);
  }
}

export function recordQuestionAnswer(
  questionId: number,
  selectedIndex: number,
  isCorrect: boolean
): QuestionProgressEntity[] {
  const current = loadAllProgress();
  const index = current.findIndex((p) => p.questionId === questionId);
  const now = Date.now();

  let updatedList: QuestionProgressEntity[];
  if (index >= 0) {
    const item = current[index];
    const updated: QuestionProgressEntity = {
      ...item,
      wrongCount: isCorrect ? item.wrongCount : item.wrongCount + 1,
      correctCount: isCorrect ? item.correctCount + 1 : item.correctCount,
      lastSelectedOption: selectedIndex,
      lastAnsweredTimestamp: now,
    };
    updatedList = [...current];
    updatedList[index] = updated;
  } else {
    const newItem: QuestionProgressEntity = {
      questionId,
      isBookmarked: false,
      wrongCount: isCorrect ? 0 : 1,
      correctCount: isCorrect ? 1 : 0,
      lastSelectedOption: selectedIndex,
      lastAnsweredTimestamp: now,
    };
    updatedList = [...current, newItem];
  }

  saveAllProgress(updatedList);
  return updatedList;
}

export function toggleQuestionBookmark(questionId: number): QuestionProgressEntity[] {
  const current = loadAllProgress();
  const index = current.findIndex((p) => p.questionId === questionId);

  let updatedList: QuestionProgressEntity[];
  if (index >= 0) {
    const item = current[index];
    const updated: QuestionProgressEntity = {
      ...item,
      isBookmarked: !item.isBookmarked,
    };
    updatedList = [...current];
    updatedList[index] = updated;
  } else {
    const newItem: QuestionProgressEntity = {
      questionId,
      isBookmarked: true,
      wrongCount: 0,
      correctCount: 0,
      lastSelectedOption: null,
      lastAnsweredTimestamp: Date.now(),
    };
    updatedList = [...current, newItem];
  }

  saveAllProgress(updatedList);
  return updatedList;
}

export function resetProgress(): void {
  try {
    localStorage.removeItem(PROGRESS_KEY);
  } catch (e) {
    console.error('Failed to reset progress', e);
  }
}

export function loadAllExamResults(): ExamResultEntity[] {
  try {
    const raw = localStorage.getItem(RESULTS_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch (e) {
    console.error('Failed to load exam results from localStorage', e);
    return [];
  }
}

export function saveExamResultItem(data: Omit<ExamResultEntity, 'id'>): ExamResultEntity {
  const current = loadAllExamResults();
  const newId = Date.now();
  const item: ExamResultEntity = {
    ...data,
    id: newId,
  };
  const updated = [item, ...current];
  try {
    localStorage.setItem(RESULTS_KEY, JSON.stringify(updated));
  } catch (e) {
    console.error('Failed to save exam result', e);
  }
  return item;
}

export function deleteExamResultItem(id: number): ExamResultEntity[] {
  const current = loadAllExamResults();
  const updated = current.filter((r) => r.id !== id);
  try {
    localStorage.setItem(RESULTS_KEY, JSON.stringify(updated));
  } catch (e) {
    console.error('Failed to delete exam result', e);
  }
  return updated;
}

export function clearAllExamResults(): void {
  try {
    localStorage.removeItem(RESULTS_KEY);
  } catch (e) {
    console.error('Failed to clear exam results', e);
  }
}

// Synchronize all wrong answers from both past exams and learning mode into progress
export function syncAndGetWrongQuestionIds(allQuestions: { id: number; correctIndex: number }[]): number[] {
  const currentProgress = loadAllProgress();
  const progressMap = new Map<number, QuestionProgressEntity>();
  currentProgress.forEach((p) => progressMap.set(p.questionId, p));

  const allExams = loadAllExamResults();
  let hasChanges = false;

  allExams.forEach((exam) => {
    if (!exam.userAnswersJson) return;
    const entries = exam.userAnswersJson.split(',').filter(Boolean);
    entries.forEach((entry) => {
      const parts = entry.split(':');
      if (parts.length === 2) {
        const qId = parseInt(parts[0], 10);
        const ans = parseInt(parts[1], 10);
        if (!isNaN(qId) && !isNaN(ans)) {
          const qObj = allQuestions.find((q) => q.id === qId);
          if (qObj) {
            const isCorrect = ans >= 0 && ans === qObj.correctIndex;
            if (!isCorrect) {
              const existing = progressMap.get(qId);
              if (!existing) {
                progressMap.set(qId, {
                  questionId: qId,
                  isBookmarked: false,
                  wrongCount: 1,
                  correctCount: 0,
                  lastSelectedOption: ans >= 0 ? ans : null,
                  lastAnsweredTimestamp: exam.dateMillis || Date.now(),
                });
                hasChanges = true;
              } else if (existing.wrongCount === 0) {
                existing.wrongCount = 1;
                hasChanges = true;
              }
            }
          }
        }
      }
    });
  });

  if (hasChanges) {
    const updated = Array.from(progressMap.values());
    saveAllProgress(updated);
  }

  return Array.from(progressMap.values())
    .filter((p) => p.wrongCount > 0)
    .map((p) => p.questionId);
}
