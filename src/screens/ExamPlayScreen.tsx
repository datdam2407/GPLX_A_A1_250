import { useState } from 'react';
import {
  Timer,
  Star,
  AlertTriangle,
  ArrowLeft,
  ArrowRight,
  CheckCircle,
  AlertCircle,
} from 'lucide-react';
import { Question } from '../types';

interface ExamPlayScreenProps {
  questions: Question[];
  currentIndex: number;
  answers: Record<number, number>; // questionIndex -> chosen option index
  markedQuestions: number[]; // questionIndices marked with star
  secondsRemaining: number;
  onSelectAnswer: (optionIndex: number) => void;
  onNextQuestion: () => void;
  onPrevQuestion: () => void;
  onJumpToQuestion: (index: number) => void;
  onToggleMark: () => void;
  onSubmitExam: () => void;
  onCancelExam: () => void;
}

export const ExamPlayScreen: React.FC<ExamPlayScreenProps> = ({
  questions,
  currentIndex,
  answers,
  markedQuestions,
  secondsRemaining,
  onSelectAnswer,
  onNextQuestion,
  onPrevQuestion,
  onJumpToQuestion,
  onToggleMark,
  onSubmitExam,
  onCancelExam,
}) => {
  const [showSubmitModal, setShowSubmitModal] = useState(false);
  const [showCancelModal, setShowCancelModal] = useState(false);

  const currentQuestion = questions[currentIndex];
  const isMarked = markedQuestions.includes(currentIndex);
  const chosenOption = answers[currentIndex];

  const minutes = Math.floor(secondsRemaining / 60);
  const seconds = secondsRemaining % 60;
  const timerText = `${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;
  const isTimeWarning = secondsRemaining <= 120; // less than 2 minutes

  const answeredCount = Object.keys(answers).length;
  const unansweredCount = questions.length - answeredCount;

  if (!currentQuestion) return null;

  return (
    <div className="space-y-4 pb-12">
      {/* Exam Header with Live Timer */}
      <div className="bg-[#111D31] -mx-4 -mt-4 px-4 py-3 sm:px-6 sm:py-3.5 text-white flex items-center justify-between shadow-md">
        <div>
          <div className="text-[10px] font-bold text-[#F1D9A8] uppercase tracking-wider">
            ĐỀ THI SÁT HẠCH A1
          </div>
          <div className="text-base sm:text-lg font-bold">
            Câu {currentIndex + 1} / {questions.length}
          </div>
        </div>

        <div className="flex items-center gap-2">
          <div
            className={`flex items-center gap-1.5 px-3 py-1.5 rounded-xl font-bold text-sm tracking-wider ${
              isTimeWarning
                ? 'bg-[#C62828] text-white animate-pulse'
                : 'bg-[#1E2E48] text-[#F1D9A8]'
            }`}
          >
            <Timer className="w-4 h-4" />
            <span>{timerText}</span>
          </div>

          <button
            onClick={() => setShowCancelModal(true)}
            className="text-xs px-2.5 py-1.5 rounded-xl bg-white/10 hover:bg-white/20 text-gray-300 hover:text-white transition cursor-pointer"
          >
            Thoát
          </button>
        </div>
      </div>

      {/* Question Card */}
      <div className="bg-[#FFFDF8] rounded-3xl p-5 sm:p-6 border border-[#E9E4D9] shadow-sm space-y-4">
        <div className="flex items-center justify-between pb-2 border-b border-[#E9E4D9]">
          <div className="flex items-center gap-2">
            <span className="text-xs font-bold text-[#111D31]">
              Câu hỏi số {currentIndex + 1}
            </span>
            {currentQuestion.isCritical && (
              <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-md bg-[#FFEBEE] text-[#C62828] text-[10px] font-extrabold uppercase">
                <AlertTriangle className="w-3 h-3" />
                Câu điểm liệt
              </span>
            )}
          </div>

          <button
            onClick={onToggleMark}
            className={`flex items-center gap-1 px-2.5 py-1 rounded-xl text-xs font-semibold transition cursor-pointer ${
              isMarked
                ? 'bg-[#FBF6EB] text-[#C9A96E] border border-[#C9A96E]'
                : 'bg-[#F6F3EB] text-[#7B8290] hover:text-[#18243A]'
            }`}
          >
            <Star
              className={`w-3.5 h-3.5 ${
                isMarked ? 'fill-[#C9A96E] text-[#C9A96E]' : ''
              }`}
            />
            <span>{isMarked ? 'Đã đánh dấu' : 'Đánh dấu'}</span>
          </button>
        </div>

        {/* Question Content */}
        <p className="text-sm sm:text-base font-semibold text-[#18243A] leading-relaxed">
          {currentQuestion.question}
        </p>

        {/* Illustration if present */}
        {currentQuestion.imageUrl && (
          <div className="rounded-2xl overflow-hidden bg-white border border-[#E9E4D9] p-2 flex justify-center">
            <img
              src={currentQuestion.imageUrl}
              alt="Hình câu hỏi"
              className="max-h-52 object-contain rounded-xl"
            />
          </div>
        )}

        {/* Option choices */}
        <div className="space-y-2.5 pt-1">
          {currentQuestion.options.map((option, optIdx) => {
            const letter = String.fromCharCode(65 + optIdx);
            const isSelected = chosenOption === optIdx;

            return (
              <button
                key={optIdx}
                onClick={() => onSelectAnswer(optIdx)}
                className={`w-full p-3.5 rounded-2xl border-2 text-left transition flex items-start gap-3 cursor-pointer ${
                  isSelected
                    ? 'border-[#C9A96E] bg-[#FBF6EB] shadow-xs'
                    : 'border-[#E9E4D9] bg-white text-[#18243A] hover:bg-[#FBF8F1]'
                }`}
              >
                <div
                  className={`w-6 h-6 rounded-full flex items-center justify-center shrink-0 text-xs font-bold ${
                    isSelected
                      ? 'bg-[#111D31] text-white'
                      : 'bg-[#EEEAE1] text-[#18243A]'
                  }`}
                >
                  {letter}
                </div>
                <div className="text-xs sm:text-sm leading-relaxed flex-1">
                  {option}
                </div>
              </button>
            );
          })}
        </div>
      </div>

      {/* Question 5x5 Grid Palette */}
      <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9]">
        <div className="flex items-center justify-between mb-3 text-xs">
          <span className="font-semibold text-[#18243A]">
            Danh sách câu hỏi ({answeredCount}/{questions.length} đã chọn)
          </span>
          <span className="text-[11px] text-[#7B8290]">
            Bấm số để chuyển nhanh
          </span>
        </div>

        <div className="grid grid-cols-5 gap-2">
          {questions.map((_, idx) => {
            const isCurrent = idx === currentIndex;
            const isAnswered = answers[idx] !== undefined;
            const isMarkedQ = markedQuestions.includes(idx);

            let bg = 'bg-[#EAE5D9] text-[#111D31]';
            let border = 'border-[#E9E4D9]';

            if (isCurrent) {
              bg = 'bg-[#111D31] text-white';
              border = 'border-[#111D31] ring-2 ring-[#C9A96E]';
            } else if (isAnswered) {
              bg = 'bg-[#E2EAF8] text-[#1C2C45] font-semibold';
              border = 'border-[#C5D5F0]';
            }

            return (
              <button
                key={idx}
                onClick={() => onJumpToQuestion(idx)}
                className={`h-10 rounded-xl text-xs flex items-center justify-center font-bold border transition cursor-pointer relative ${bg} ${border}`}
              >
                <span>{idx + 1}</span>
                {isMarkedQ && (
                  <span className="absolute top-0.5 right-1 text-[#C9A96E] text-[10px]">
                    ★
                  </span>
                )}
              </button>
            );
          })}
        </div>
      </div>

      {/* Navigation and Submit Controls */}
      <div className="flex items-center justify-between gap-2 pt-2">
        <button
          onClick={onPrevQuestion}
          disabled={currentIndex === 0}
          className={`flex items-center gap-1 px-3.5 py-3 rounded-2xl border text-xs sm:text-sm font-semibold transition cursor-pointer ${
            currentIndex > 0
              ? 'bg-[#FFFDF8] border-[#E9E4D9] text-[#111D31] hover:bg-[#F6F1E5]'
              : 'opacity-40 cursor-not-allowed border-gray-200 text-gray-400'
          }`}
        >
          <ArrowLeft className="w-4 h-4" />
          <span>Câu trước</span>
        </button>

        <button
          onClick={() => setShowSubmitModal(true)}
          className="flex-1 max-w-[160px] py-3 rounded-2xl bg-[#2E7D32] hover:bg-[#256828] text-white font-bold text-xs sm:text-sm flex items-center justify-center gap-1.5 shadow-md transition cursor-pointer"
        >
          <CheckCircle className="w-4 h-4" />
          <span>Nộp bài</span>
        </button>

        <button
          onClick={onNextQuestion}
          disabled={currentIndex === questions.length - 1}
          className={`flex items-center gap-1 px-3.5 py-3 rounded-2xl border text-xs sm:text-sm font-semibold transition cursor-pointer ${
            currentIndex < questions.length - 1
              ? 'bg-[#111D31] border-[#111D31] text-white hover:bg-[#1C2C45]'
              : 'opacity-40 cursor-not-allowed border-gray-200 text-gray-400'
          }`}
        >
          <span>Câu tiếp</span>
          <ArrowRight className="w-4 h-4" />
        </button>
      </div>

      {/* Confirm Submit Dialog Modal */}
      {showSubmitModal && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-sm w-full p-6 shadow-2xl border border-[#E9E4D9] space-y-4 animate-in fade-in zoom-in-95">
            <div className="w-12 h-12 rounded-full bg-[#E8F5E9] text-[#2E7D32] flex items-center justify-center mx-auto">
              <CheckCircle className="w-6 h-6" />
            </div>

            <div className="text-center">
              <h3 className="font-extrabold text-[#111D31] text-lg">
                Xác nhận nộp bài?
              </h3>
              <p className="text-xs text-[#7B8290] mt-1">
                Bạn đã làm <span className="font-bold text-[#111D31]">{answeredCount}</span>/
                {questions.length} câu hỏi.
              </p>
              {unansweredCount > 0 && (
                <div className="mt-3 p-3 bg-[#FFF4E5] border border-[#FFE0B2] rounded-xl text-left flex items-start gap-2">
                  <AlertCircle className="w-4 h-4 text-[#ED6C02] shrink-0 mt-0.5" />
                  <span className="text-xs text-[#ED6C02]">
                    Còn <span className="font-bold">{unansweredCount}</span> câu chưa trả lời. Bạn có chắc muốn nộp ngay?
                  </span>
                </div>
              )}
            </div>

            <div className="grid grid-cols-2 gap-3 pt-2">
              <button
                onClick={() => setShowSubmitModal(false)}
                className="py-3 px-4 rounded-xl border border-[#E9E4D9] text-[#18243A] text-xs font-bold hover:bg-[#F6F1E5] transition cursor-pointer"
              >
                Làm tiếp
              </button>
              <button
                onClick={() => {
                  setShowSubmitModal(false);
                  onSubmitExam();
                }}
                className="py-3 px-4 rounded-xl bg-[#2E7D32] hover:bg-[#256828] text-white text-xs font-bold shadow-sm transition cursor-pointer"
              >
                Nộp ngay
              </button>
            </div>
          </div>
        </div>
      )}

      {/* Confirm Cancel Dialog Modal */}
      {showCancelModal && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-sm w-full p-6 shadow-2xl border border-[#E9E4D9] space-y-4 animate-in fade-in zoom-in-95">
            <div className="w-12 h-12 rounded-full bg-[#FFEBEE] text-[#C62828] flex items-center justify-center mx-auto">
              <AlertTriangle className="w-6 h-6" />
            </div>

            <div className="text-center">
              <h3 className="font-extrabold text-[#111D31] text-lg">
                Thoát bài thi?
              </h3>
              <p className="text-xs text-[#7B8290] mt-1">
                Kết quả bài thi này sẽ bị hủy bỏ và không được lưu vào lịch sử.
              </p>
            </div>

            <div className="grid grid-cols-2 gap-3 pt-2">
              <button
                onClick={() => setShowCancelModal(false)}
                className="py-3 px-4 rounded-xl border border-[#E9E4D9] text-[#18243A] text-xs font-bold hover:bg-[#F6F1E5] transition cursor-pointer"
              >
                Ở lại
              </button>
              <button
                onClick={() => {
                  setShowCancelModal(false);
                  onCancelExam();
                }}
                className="py-3 px-4 rounded-xl bg-[#C62828] hover:bg-[#B71C1C] text-white text-xs font-bold shadow-sm transition cursor-pointer"
              >
                Hủy bài thi
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
