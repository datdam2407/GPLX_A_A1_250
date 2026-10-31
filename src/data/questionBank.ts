import rawQuestionsData from './questions_a1.json';
import rawSignsData from './traffic_signs.json';
import { FIXED_EXAMS_MAP } from './fixedExams';
import { Question, QuestionCategory, TrafficSign, StudyTip } from '../types';

function parseCategory(categoryStr: string): QuestionCategory {
  const lower = (categoryStr || '').toLowerCase();
  if (lower.includes('khái niệm') || lower.includes('quy tắc')) return 'RULES';
  if (lower.includes('văn hóa')) return 'CULTURE';
  if (lower.includes('kỹ thuật')) return 'TECHNIQUE';
  if (lower.includes('biển báo')) return 'SIGNS';
  if (lower.includes('sa hình')) return 'DIAGRAM';
  return 'RULES';
}

function shuffleArray<T>(array: T[]): T[] {
  const arr = [...array];
  for (let i = arr.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }
  return arr;
}

// Parse official 250 questions
export const allQuestions: Question[] = (rawQuestionsData.questions || []).map((raw: any) => {
  const options = (raw.options || []).map((o: any) => (typeof o === 'string' ? o : o.text || ''));
  const correctIdx = typeof raw.correct_answer === 'number'
    ? raw.correct_answer - 1
    : (raw.options || []).findIndex((o: any) => o.is_correct === true);

  const img = raw.images && raw.images.length > 0 && raw.images[0]?.url
    ? raw.images[0].url
    : null;

  return {
    id: (raw.id ?? 0) + 1,
    question: raw.question || '',
    options,
    correctIndex: correctIdx >= 0 ? correctIdx : 0,
    explanation: raw.explanation || '',
    category: parseCategory(raw.category),
    isCritical: Boolean(raw.is_critical_question),
    imageUrl: img,
  };
});

export const criticalQuestions: Question[] = allQuestions.filter((q) => q.isCritical);

export function getQuestionsByCategory(category: QuestionCategory): Question[] {
  if (category === 'ALL') return allQuestions;
  if (category === 'CRITICAL') return criticalQuestions;
  return allQuestions.filter((q) => q.category === category);
}

export function getQuestionById(id: number): Question | undefined {
  return allQuestions.find((q) => q.id === id);
}

// Generate deterministic 25-question exam for a fixed test number (1 to 10)
export function getFixedExamQuestions(testNumber: number): Question[] {
  // Check if custom exams exist in localStorage
  try {
    const rawCustom = localStorage.getItem('gplx_custom_exams_v1');
    if (rawCustom) {
      const parsed = JSON.parse(rawCustom);
      const customTest = parsed[testNumber] || parsed[`de_${testNumber}`] || parsed[testNumber - 1];
      if (Array.isArray(customTest) && customTest.length > 0) {
        // If elements are IDs
        if (typeof customTest[0] === 'number') {
          const questions = customTest
            .map((id) => getQuestionById(id))
            .filter((q): q is Question => q !== undefined);
          if (questions.length === 25) return questions;
        }
        // If elements are Question objects
        if (customTest[0] && typeof customTest[0] === 'object' && 'question' in customTest[0]) {
          return customTest;
        }
      }
    }
  } catch (e) {
    console.warn('Error reading custom exams', e);
  }

  // Use the exact 10 fixed exam sets from the user provided data
  if (FIXED_EXAMS_MAP[testNumber] && FIXED_EXAMS_MAP[testNumber].length === 25) {
    return FIXED_EXAMS_MAP[testNumber];
  }

  const tIdx = Math.max(0, Math.min(9, testNumber - 1));

  // 1. Critical questions: exactly 2 per test
  const critList = allQuestions.filter((q) => q.isCritical);
  const testCritical = critList.slice(tIdx * 2, tIdx * 2 + 2);

  // 2. Rules questions (non-critical)
  const rulesList = allQuestions.filter((q) => q.category === 'RULES' && !q.isCritical);
  const rulesPerTest = 10;
  const testRules = rulesList.slice(tIdx * rulesPerTest, (tIdx + 1) * rulesPerTest);

  // 3. Culture & Technique
  const cultTechList = allQuestions.filter(
    (q) => (q.category === 'CULTURE' || q.category === 'TECHNIQUE') && !q.isCritical
  );
  const cultTechPerTest = 2;
  const testCultTech = cultTechList.slice(tIdx * cultTechPerTest, (tIdx + 1) * cultTechPerTest);

  // 4. Signs
  const signsList = allQuestions.filter((q) => q.category === 'SIGNS');
  const signsPerTest = 6;
  const testSigns = signsList.slice(tIdx * signsPerTest, (tIdx + 1) * signsPerTest);

  // 5. Diagrams
  const diagramList = allQuestions.filter((q) => q.category === 'DIAGRAM');
  const diagramPerTest = 5;
  const testDiagram = diagramList.slice(tIdx * diagramPerTest, (tIdx + 1) * diagramPerTest);

  // Combine to standard 25 questions (2 + 10 + 2 + 6 + 5 = 25)
  const combined: Question[] = [
    ...testCritical,
    ...testRules,
    ...testCultTech,
    ...testSigns,
    ...testDiagram,
  ];

  if (combined.length < 25) {
    const ids = new Set(combined.map((q) => q.id));
    for (const q of allQuestions) {
      if (!ids.has(q.id) && !q.isCritical) {
        combined.push(q);
        ids.add(q.id);
        if (combined.length === 25) break;
      }
    }
  }

  return combined.slice(0, 25);
}

// Generate standard 25-question mock exam according to Vietnamese A1 exam regulations
export function generateExamQuestions(testNumber?: number): Question[] {
  if (typeof testNumber === 'number' && testNumber >= 1 && testNumber <= 10) {
    return getFixedExamQuestions(testNumber);
  }

  const criticalPool = shuffleArray(allQuestions.filter((q) => q.isCritical));
  const rulesPool = shuffleArray(allQuestions.filter((q) => q.category === 'RULES' && !q.isCritical));
  const signsPool = shuffleArray(allQuestions.filter((q) => q.category === 'SIGNS'));
  const diagramPool = shuffleArray(allQuestions.filter((q) => q.category === 'DIAGRAM'));
  const cultureTechPool = shuffleArray(
    allQuestions.filter((q) => (q.category === 'CULTURE' || q.category === 'TECHNIQUE') && !q.isCritical)
  );

  // 2 critical + 12 rules + 2 culture/tech + 5 signs + 4 diagrams = 25 questions
  const exam: Question[] = [
    ...criticalPool.slice(0, 2),
    ...rulesPool.slice(0, 12),
    ...cultureTechPool.slice(0, 2),
    ...signsPool.slice(0, 5),
    ...diagramPool.slice(0, 4),
  ];

  return shuffleArray(exam);
}

// Parse traffic signs
export const trafficSigns: TrafficSign[] = (rawSignsData.signs || []).map((s: any) => {
  return {
    id: s.id || '',
    order: s.order || 0,
    name: s.name || '',
    category: s.category?.name || 'BIỂN BÁO KHÁC',
    description: s.description || '',
    imageUrl: s.image?.url || null,
    relatedQuestionId: s.related_question?.question_id || null,
  };
});

import { TIPS_DATA } from './tipsData';

export const studyTips: StudyTip[] = TIPS_DATA.map((t) => ({
  title: t.title,
  category: t.sectionTitle,
  content: [t.summary, ...(t.bullets || [])].filter(Boolean).join('\n'),
  example: t.example || '',
}));

