import { useState, useEffect, useRef } from 'react';
import {
  allQuestions,
  criticalQuestions,
  getQuestionsByCategory,
  getQuestionById,
  generateExamQuestions,
} from './data/questionBank';
import {
  loadAllProgress,
  loadAllExamResults,
  recordQuestionAnswer,
  toggleQuestionBookmark,
  resetProgress as clearStorageProgress,
  saveExamResultItem,
  deleteExamResultItem,
  clearAllExamResults,
  syncAndGetWrongQuestionIds,
} from './data/storage';
import {
  ExamResultEntity,
  ExamReviewItem,
  Question,
  QuestionCategory,
  QuestionProgressEntity,
  Screen,
} from './types';
import { AppTopBar } from './components/AppTopBar';
import { AppBottomBar } from './components/AppBottomBar';
import { Toast } from './components/Toast';
import { HomeScreen } from './screens/HomeScreen';
import { LearningScreen } from './screens/LearningScreen';
import { ExamIntroScreen } from './screens/ExamIntroScreen';
import { ExamPlayScreen } from './screens/ExamPlayScreen';
import { ExamResultScreen } from './screens/ExamResultScreen';
import { HistoryScreen } from './screens/HistoryScreen';
import { WrongQuestionsScreen } from './screens/WrongQuestionsScreen';
import { SignsScreen } from './screens/SignsScreen';
import { TipsScreen } from './screens/TipsScreen';
import { StatsScreen } from './screens/StatsScreen';

export function App() {
  // Navigation
  const [currentScreen, setCurrentScreen] = useState<Screen>('HOME');
  const [selectedCategory, setSelectedCategory] = useState<QuestionCategory>('ALL');

  // Stored state
  const [progressList, setProgressList] = useState<QuestionProgressEntity[]>(() =>
    loadAllProgress()
  );
  const [examResults, setExamResults] = useState<ExamResultEntity[]>(() =>
    loadAllExamResults()
  );

  // Learning Mode State
  const [learningQuestions, setLearningQuestions] = useState<Question[]>(allQuestions);
  const [learningIndex, setLearningIndex] = useState<number>(0);
  const [learningSelectedAnswer, setLearningSelectedAnswer] = useState<number | null>(null);
  const [learningIsChecked, setLearningIsChecked] = useState<boolean>(false);

  // Exam Mode State
  const [examQuestions, setExamQuestions] = useState<Question[]>([]);
  const [currentExamIndex, setCurrentExamIndex] = useState<number>(0);
  const [examAnswers, setExamAnswers] = useState<Record<number, number>>({});
  const [markedExamQuestions, setMarkedExamQuestions] = useState<number[]>([]);
  const [examSecondsRemaining, setExamSecondsRemaining] = useState<number>(19 * 60);
  const [isExamRunning, setIsExamRunning] = useState<boolean>(false);

  // Exam Results
  const [lastResultEntity, setLastResultEntity] = useState<ExamResultEntity | null>(null);
  const [lastReviewItems, setLastReviewItems] = useState<ExamReviewItem[]>([]);

  // Snackbar Toast
  const [snackbarMessage, setSnackbarMessage] = useState<string | null>(null);

  const showSnackbar = (msg: string) => {
    setSnackbarMessage(msg);
  };

  // Exam Countdown Timer
  const timerRef = useRef<number | null>(null);

  useEffect(() => {
    if (isExamRunning && examSecondsRemaining > 0) {
      timerRef.current = window.setInterval(() => {
        setExamSecondsRemaining((prev) => {
          if (prev <= 1) {
            clearInterval(timerRef.current!);
            return 0;
          }
          return prev - 1;
        });
      }, 1000);
    } else {
      if (timerRef.current) clearInterval(timerRef.current);
    }

    return () => {
      if (timerRef.current) clearInterval(timerRef.current);
    };
  }, [isExamRunning]);

  // Handle Timer Reaching 0
  useEffect(() => {
    if (isExamRunning && examSecondsRemaining === 0) {
      handleFinalizeExam('Hết giờ làm bài!');
    }
  }, [examSecondsRemaining, isExamRunning]);

  const [isWrongPracticeMode, setIsWrongPracticeMode] = useState<boolean>(false);

  // Sync wrong questions across all exams on load
  useEffect(() => {
    syncAndGetWrongQuestionIds(allQuestions);
    setProgressList(loadAllProgress());
  }, []);

  // --- LEARNING MODE HANDLERS ---
  const handleSelectCategory = (cat: QuestionCategory) => {
    setIsWrongPracticeMode(false);
    const list =
      cat === 'ALL'
        ? allQuestions
        : cat === 'CRITICAL'
        ? criticalQuestions
        : getQuestionsByCategory(cat);

    setSelectedCategory(cat);
    setLearningQuestions(list);
    setLearningIndex(0);
    setLearningSelectedAnswer(null);
    setLearningIsChecked(false);
  };

  const handleStartWrongPractice = (wrongIds?: number[]) => {
    // Sync all wrong questions from both fixed 10 exams and 250 questions
    const allWrongIds = syncAndGetWrongQuestionIds(allQuestions);
    const targetIds =
      wrongIds && wrongIds.length > 0
        ? Array.from(new Set([...wrongIds, ...allWrongIds]))
        : allWrongIds;

    const list = allQuestions.filter((q) => targetIds.includes(q.id));
    if (list.length === 0) {
      showSnackbar('Bạn chưa có câu trả lời sai nào!');
      return;
    }
    setIsWrongPracticeMode(true);
    setLearningQuestions(list);
    setLearningIndex(0);
    setLearningSelectedAnswer(null);
    setLearningIsChecked(false);
    setCurrentScreen('LEARNING');
  };

  const handleSelectLearningAnswer = (index: number) => {
    if (learningIsChecked) return;
    setLearningSelectedAnswer(index);
  };

  const handleCheckLearningAnswer = () => {
    const q = learningQuestions[learningIndex];
    if (!q) return;
    if (learningSelectedAnswer === null) {
      showSnackbar('Vui lòng chọn một đáp án trước!');
      return;
    }

    const isCorrect = learningSelectedAnswer === q.correctIndex;
    setLearningIsChecked(true);

    const updated = recordQuestionAnswer(q.id, learningSelectedAnswer, isCorrect);
    setProgressList(updated);
  };

  const handleNextLearningQuestion = () => {
    if (learningIndex < learningQuestions.length - 1) {
      setLearningIndex((prev) => prev + 1);
      setLearningSelectedAnswer(null);
      setLearningIsChecked(false);
    } else {
      showSnackbar('Bạn đã hoàn thành câu hỏi cuối cùng của danh mục này!');
    }
  };

  const handlePrevLearningQuestion = () => {
    if (learningIndex > 0) {
      setLearningIndex((prev) => prev - 1);
      setLearningSelectedAnswer(null);
      setLearningIsChecked(false);
    }
  };

  const handleJumpToLearningQuestion = (index: number) => {
    if (index >= 0 && index < learningQuestions.length) {
      setLearningIndex(index);
      setLearningSelectedAnswer(null);
      setLearningIsChecked(false);
    }
  };

  const handleToggleBookmark = (questionId: number) => {
    const updated = toggleQuestionBookmark(questionId);
    setProgressList(updated);
  };

  const [currentExamTitle, setCurrentExamTitle] = useState<string>('Đề thi sát hạch A1');
  const [currentExamTestNumber, setCurrentExamTestNumber] = useState<number | undefined>(undefined);

  // --- EXAM MODE HANDLERS ---
  const handleStartExam = (testNumber?: number, title?: string) => {
    const questions = generateExamQuestions(testNumber);
    const examName = title || (testNumber ? `Đề thi số ${testNumber}` : 'Đề thi ngẫu nhiên');
    setCurrentExamTitle(examName);
    setCurrentExamTestNumber(testNumber);
    setExamQuestions(questions);
    setCurrentExamIndex(0);
    setExamAnswers({});
    setMarkedExamQuestions([]);
    setExamSecondsRemaining(19 * 60);
    setIsExamRunning(true);
    setCurrentScreen('EXAM_PLAYING');
  };

  const handleSelectExamAnswer = (optIndex: number) => {
    if (!isExamRunning) return;
    setExamAnswers((prev) => ({
      ...prev,
      [currentExamIndex]: optIndex,
    }));
  };

  const handleToggleMarkExamQuestion = () => {
    setMarkedExamQuestions((prev) => {
      if (prev.includes(currentExamIndex)) {
        return prev.filter((i) => i !== currentExamIndex);
      } else {
        return [...prev, currentExamIndex];
      }
    });
  };

  const handleNextExamQuestion = () => {
    if (currentExamIndex < examQuestions.length - 1) {
      setCurrentExamIndex((prev) => prev + 1);
    }
  };

  const handlePrevExamQuestion = () => {
    if (currentExamIndex > 0) {
      setCurrentExamIndex((prev) => prev - 1);
    }
  };

  const handleJumpToExamQuestion = (index: number) => {
    if (index >= 0 && index < examQuestions.length) {
      setCurrentExamIndex(index);
    }
  };

  const handleFinalizeExam = (reason?: string) => {
    setIsExamRunning(false);

    let correctCount = 0;
    let failedDueToCritical = false;
    const reviewList: ExamReviewItem[] = [];
    const answersMapForDb: Record<number, number> = {};

    examQuestions.forEach((q, idx) => {
      const userChoice = examAnswers[idx] !== undefined ? examAnswers[idx] : null;
      const isCorrect = userChoice !== null && userChoice === q.correctIndex;

      if (isCorrect) {
        correctCount++;
      } else if (q.isCritical) {
        failedDueToCritical = true;
      }

      reviewList.push({
        question: q,
        selectedIndex: userChoice,
        isCorrect,
        isCritical: q.isCritical,
      });

      // Record question progress: if userChoice is null, it is an incorrect attempt in exam
      recordQuestionAnswer(q.id, userChoice !== null ? userChoice : -1, isCorrect);
      if (userChoice !== null) {
        answersMapForDb[q.id] = userChoice;
      } else {
        answersMapForDb[q.id] = -1;
      }
    });

    // Update progressList state
    setProgressList(loadAllProgress());

    // Vietnamese A1 test pass condition: >= 21/25 and no critical question wrong
    const isPassed = correctCount >= 21 && !failedDueToCritical;
    const timeSpent = 19 * 60 - examSecondsRemaining;
    const answersString = Object.entries(answersMapForDb)
      .map(([k, v]) => `${k}:${v}`)
      .join(',');

    const savedResult = saveExamResultItem({
      examTitle: currentExamTitle,
      dateMillis: Date.now(),
      score: correctCount,
      totalQuestions: 25,
      isPassed,
      failedDueToCritical,
      timeSpentSeconds: timeSpent,
      userAnswersJson: answersString,
    });

    setExamResults(loadAllExamResults());
    setLastResultEntity(savedResult);
    setLastReviewItems(reviewList);
    setCurrentScreen('EXAM_RESULT');

    if (reason) {
      showSnackbar(reason);
    }
  };

  const handleCancelExam = () => {
    setIsExamRunning(false);
    setExamAnswers({});
    setMarkedExamQuestions([]);
    setCurrentScreen('EXAM_INTRO');
  };

  // View past exam from History
  const handleViewPastExam = (exam: ExamResultEntity) => {
    const pairs: Record<number, number> = {};
    if (exam.userAnswersJson) {
      exam.userAnswersJson.split(',').forEach((item) => {
        const [qIdStr, ansStr] = item.split(':');
        const qId = parseInt(qIdStr, 10);
        const ans = parseInt(ansStr, 10);
        if (!isNaN(qId) && !isNaN(ans)) {
          pairs[qId] = ans;
        }
      });
    }

    const reviewItems: ExamReviewItem[] = [];
    Object.entries(pairs).forEach(([qIdStr, selectedIdx]) => {
      const qId = parseInt(qIdStr, 10);
      const q = getQuestionById(qId);
      if (q) {
        reviewItems.push({
          question: q,
          selectedIndex: selectedIdx,
          isCorrect: selectedIdx === q.correctIndex,
          isCritical: q.isCritical,
        });
      }
    });

    setLastResultEntity(exam);
    setLastReviewItems(reviewItems);
    setCurrentScreen('EXAM_RESULT');
  };

  const handleDeleteHistoryExam = (id: number) => {
    const updated = deleteExamResultItem(id);
    setExamResults(updated);
    showSnackbar('Đã xóa bài thi khỏi lịch sử!');
  };

  const handleClearAllHistory = () => {
    clearAllExamResults();
    setExamResults([]);
    showSnackbar('Đã xóa toàn bộ lịch sử thi thử!');
  };

  const handleResetProgress = () => {
    clearStorageProgress();
    setProgressList([]);
    showSnackbar('Đã đặt lại toàn bộ tiến độ ôn luyện!');
  };

  // Screen titles & subtitles matching Android Compose
  const getScreenMeta = (): { title: string; subtitle: string } => {
    switch (currentScreen) {
      case 'HOME':
        return { title: 'Ôn Thi GPLX A1', subtitle: 'BẰNG LÁI XE MÁY A1 · A' };
      case 'LEARNING':
        return {
          title: 'Luyện tập 250 câu',
          subtitle: `${learningQuestions.length} CÂU HỎI CHUẨN`,
        };
      case 'EXAM_INTRO':
        return { title: 'Thi thử sát hạch', subtitle: '25 CÂU · 19 PHÚT' };
      case 'EXAM_PLAYING':
        return { title: 'Đang làm bài thi', subtitle: 'TỰ ĐỘNG CHẤM ĐIỂM' };
      case 'EXAM_RESULT':
        return { title: 'Kết quả thi', subtitle: 'CHI TIẾT ĐÁP ÁN' };
      case 'HISTORY':
        return { title: 'Lịch sử thi thử', subtitle: 'LƯU TRỮ TRÊN THIẾT BỊ' };
      case 'WRONG_QUESTIONS':
        return { title: 'Câu trả lời sai', subtitle: 'ÔN TẬP MỤC TIÊU' };
      case 'SIGNS':
        return {
          title: 'Tất cả biển báo',
          subtitle: '185 BIỂN BÁO & VẠCH KẺ ĐẦY ĐỦ',
        };
      case 'TIPS':
        return { title: 'Mẹo ghi nhớ nhanh', subtitle: 'BÍ QUYẾT 100% ĐỖ' };
      case 'STATS':
        return { title: 'Thống kê học tập', subtitle: 'TIẾN ĐỘ & TỶ LỆ ĐỖ' };
      default:
        return { title: 'Ôn Thi GPLX A1', subtitle: 'BẰNG LÁI XE MÁY A1 · A' };
    }
  };

  const screenMeta = getScreenMeta();
  const canGoBack = currentScreen !== 'HOME';

  const handleNavigateBack = () => {
    if (currentScreen === 'EXAM_PLAYING') {
      handleCancelExam();
    } else {
      setCurrentScreen('HOME');
    }
  };

  return (
    <div className="min-h-screen bg-[#F6F3EB] text-[#18243A] flex flex-col font-sans">
      <Toast message={snackbarMessage} onClose={() => setSnackbarMessage(null)} />

      {/* Top Bar */}
      <AppTopBar
        title={screenMeta.title}
        subtitle={screenMeta.subtitle}
        canNavigateBack={canGoBack}
        onNavigateBack={handleNavigateBack}
      />

      {/* Main Container */}
      <main className="flex-1 w-full max-w-2xl mx-auto px-4 py-4">
        {currentScreen === 'HOME' && (
          <HomeScreen
            progressList={progressList}
            onNavigate={(screen) => setCurrentScreen(screen)}
            onSelectCategory={handleSelectCategory}
            onStartWrongPractice={handleStartWrongPractice}
          />
        )}

        {currentScreen === 'LEARNING' && (
          <LearningScreen
            questions={learningQuestions}
            currentIndex={learningIndex}
            selectedAnswer={learningSelectedAnswer}
            isChecked={learningIsChecked}
            selectedCategory={selectedCategory}
            progressList={progressList}
            isWrongPracticeMode={isWrongPracticeMode}
            onSelectCategory={handleSelectCategory}
            onSelectAnswer={handleSelectLearningAnswer}
            onCheckAnswer={handleCheckLearningAnswer}
            onNextQuestion={handleNextLearningQuestion}
            onPrevQuestion={handlePrevLearningQuestion}
            onJumpToQuestion={handleJumpToLearningQuestion}
            onToggleBookmark={handleToggleBookmark}
          />
        )}

        {currentScreen === 'EXAM_INTRO' && (
          <ExamIntroScreen
            examResults={examResults}
            onStartExam={handleStartExam}
          />
        )}

        {currentScreen === 'EXAM_PLAYING' && (
          <ExamPlayScreen
            questions={examQuestions}
            currentIndex={currentExamIndex}
            answers={examAnswers}
            markedQuestions={markedExamQuestions}
            secondsRemaining={examSecondsRemaining}
            onSelectAnswer={handleSelectExamAnswer}
            onNextQuestion={handleNextExamQuestion}
            onPrevQuestion={handlePrevExamQuestion}
            onJumpToQuestion={handleJumpToExamQuestion}
            onToggleMark={handleToggleMarkExamQuestion}
            onSubmitExam={() => handleFinalizeExam()}
            onCancelExam={handleCancelExam}
          />
        )}

        {currentScreen === 'EXAM_RESULT' && (
          <ExamResultScreen
            result={lastResultEntity}
            reviewItems={lastReviewItems}
            onRetryCurrentExam={() => handleStartExam(currentExamTestNumber, currentExamTitle)}
            onChooseOtherExam={() => setCurrentScreen('EXAM_INTRO')}
          />
        )}

        {currentScreen === 'HISTORY' && (
          <HistoryScreen
            examResults={examResults}
            onViewExam={handleViewPastExam}
            onDeleteExam={handleDeleteHistoryExam}
            onClearAllHistory={handleClearAllHistory}
            onStartExam={handleStartExam}
          />
        )}

        {currentScreen === 'WRONG_QUESTIONS' && (
          <WrongQuestionsScreen
            progressList={progressList}
            onStartPractice={handleStartWrongPractice}
          />
        )}

        {currentScreen === 'SIGNS' && <SignsScreen />}

        {currentScreen === 'TIPS' && <TipsScreen />}

        {currentScreen === 'STATS' && (
          <StatsScreen
            progressList={progressList}
            examResults={examResults}
            onResetProgress={handleResetProgress}
          />
        )}
      </main>

      {/* Bottom Bar: hidden during EXAM_PLAYING matching Android Compose */}
      {currentScreen !== 'EXAM_PLAYING' && (
        <AppBottomBar
          currentScreen={currentScreen}
          onNavigate={(screen) => {
            if (screen === 'LEARNING') {
              handleSelectCategory('ALL');
            }
            setCurrentScreen(screen);
          }}
        />
      )}
    </div>
  );
}

export default App;
