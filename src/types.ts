export type Screen =
  | 'HOME'
  | 'LEARNING'
  | 'EXAM_INTRO'
  | 'EXAM_PLAYING'
  | 'EXAM_RESULT'
  | 'HISTORY'
  | 'WRONG_QUESTIONS'
  | 'SIGNS'
  | 'TIPS'
  | 'STATS';

export type QuestionCategory =
  | 'ALL'
  | 'CRITICAL'
  | 'RULES'
  | 'CULTURE'
  | 'TECHNIQUE'
  | 'SIGNS'
  | 'DIAGRAM';

export interface CategoryInfo {
  key: QuestionCategory;
  title: string;
  shortTitle: string;
}

export const CATEGORIES: CategoryInfo[] = [
  { key: 'ALL', title: 'Tất cả câu hỏi', shortTitle: 'Tất cả' },
  { key: 'CRITICAL', title: '20 Câu điểm liệt', shortTitle: 'Điểm liệt' },
  { key: 'RULES', title: 'Khái niệm và quy tắc', shortTitle: 'Quy tắc' },
  { key: 'CULTURE', title: 'Văn hóa giao thông', shortTitle: 'Văn hóa' },
  { key: 'TECHNIQUE', title: 'Kỹ thuật lái xe', shortTitle: 'Kỹ thuật' },
  { key: 'SIGNS', title: 'Biển báo đường bộ', shortTitle: 'Biển báo' },
  { key: 'DIAGRAM', title: 'Sa hình giao thông', shortTitle: 'Sa hình' },
];

export interface Question {
  id: number;
  question: string;
  options: string[];
  correctIndex: number;
  explanation: string;
  category: QuestionCategory;
  isCritical: boolean;
  tip?: string | null;
  imageUrl?: string | null;
}

export interface TrafficSign {
  id: string;
  order: number;
  name: string;
  category: string;
  description: string;
  imageUrl?: string | null;
  relatedQuestionId?: string | null;
}

export interface StudyTip {
  title: string;
  category: string;
  content: string;
  example: string;
}

export interface ExamResultEntity {
  id: number;
  examTitle: string;
  dateMillis: number;
  score: number;
  totalQuestions: number;
  isPassed: boolean;
  failedDueToCritical: boolean;
  timeSpentSeconds: number;
  userAnswersJson: string; // e.g. "1:2,2:0,3:1"
}

export interface QuestionProgressEntity {
  questionId: number;
  isBookmarked: boolean;
  wrongCount: number;
  correctCount: number;
  lastSelectedOption: number | null;
  lastAnsweredTimestamp: number;
}

export interface ExamReviewItem {
  question: Question;
  selectedIndex: number | null;
  isCorrect: boolean;
  isCritical: boolean;
}
