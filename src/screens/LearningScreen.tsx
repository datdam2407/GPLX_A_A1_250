import React, { useState } from 'react';
import {
  Bookmark,
  BookmarkCheck,
  CheckCircle2,
  XCircle,
  AlertTriangle,
  Lightbulb,
  ArrowLeft,
  ArrowRight,
  Grid,
  X,
} from 'lucide-react';
import {
  CATEGORIES,
  Question,
  QuestionCategory,
  QuestionProgressEntity,
} from '../types';

interface LearningScreenProps {
  questions: Question[];
  currentIndex: number;
  selectedAnswer: number | null;
  isChecked: boolean;
  selectedCategory: QuestionCategory;
  progressList: QuestionProgressEntity[];
  isWrongPracticeMode?: boolean;
  onSelectCategory: (category: QuestionCategory) => void;
  onSelectAnswer: (index: number) => void;
  onCheckAnswer: () => void;
  onNextQuestion: () => void;
  onPrevQuestion: () => void;
  onJumpToQuestion: (index: number) => void;
  onToggleBookmark: (questionId: number) => void;
}

export const LearningScreen: React.FC<LearningScreenProps> = ({
  questions,
  currentIndex,
  selectedAnswer,
  isChecked,
  selectedCategory,
  progressList,
  isWrongPracticeMode = false,
  onSelectCategory,
  onSelectAnswer,
  onCheckAnswer,
  onNextQuestion,
  onPrevQuestion,
  onJumpToQuestion,
  onToggleBookmark,
}) => {
  const [showJumpDialog, setShowJumpDialog] = useState(false);

  const currentQuestion: Question | undefined = questions[currentIndex];
  const currentProgress = currentQuestion
    ? progressList.find((p) => p.questionId === currentQuestion.id)
    : undefined;
  const isBookmarked = Boolean(currentProgress?.isBookmarked);

  if (!currentQuestion) {
    return (
      <div className="p-8 text-center bg-[#FFFDF8] rounded-2xl border border-[#E9E4D9]">
        <p className="text-gray-500">Không tìm thấy câu hỏi trong danh mục này.</p>
        <button
          onClick={() => onSelectCategory('ALL')}
          className="mt-4 px-4 py-2 bg-[#111D31] text-white rounded-xl text-sm font-semibold"
        >
          Xem tất cả câu hỏi
        </button>
      </div>
    );
  }

  return (
    <div className="space-y-4 pb-24">
      {/* Categories Horizontal Filter - Hidden in wrong practice mode as requested */}
      {!isWrongPracticeMode && (
        <div className="flex gap-2 overflow-x-auto pb-1 no-scrollbar -mx-4 px-4">
          {CATEGORIES.map((cat) => {
            const isSelected = selectedCategory === cat.key;
            return (
              <button
                key={cat.key}
                onClick={() => onSelectCategory(cat.key)}
                className={`px-3.5 py-1.5 rounded-full text-xs font-semibold whitespace-nowrap transition cursor-pointer border ${
                  isSelected
                    ? 'bg-[#111D31] text-white border-[#111D31]'
                    : 'bg-[#FFFDF8] text-[#18243A] border-[#E9E4D9] hover:bg-[#F6F1E5]'
                }`}
              >
                {cat.title}
              </button>
            );
          })}
        </div>
      )}

      {/* Question Card */}
      <div className="bg-[#FFFDF8] rounded-3xl p-5 sm:p-6 border border-[#E9E4D9] shadow-sm space-y-4">
        <div className="flex items-center justify-between pb-3 border-b border-[#E9E4D9]">
          <div className="flex items-center gap-2">
            <span className="text-xs sm:text-sm font-bold text-[#111D31]">
              Câu {currentIndex + 1} / {questions.length}
            </span>
            {currentQuestion.isCritical && (
              <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-md bg-[#FFEBEE] text-[#C62828] text-[10px] font-extrabold uppercase">
                <AlertTriangle className="w-3 h-3" />
                Điểm liệt
              </span>
            )}
          </div>

          <button
            onClick={() => onToggleBookmark(currentQuestion.id)}
            title={isBookmarked ? 'Bỏ lưu' : 'Lưu câu hỏi'}
            className="p-1.5 text-gray-400 hover:text-[#C9A96E] rounded-xl hover:bg-[#F6F3EB] transition cursor-pointer"
          >
            {isBookmarked ? (
              <BookmarkCheck className="w-5 h-5 text-[#C9A96E] fill-[#C9A96E]" />
            ) : (
              <Bookmark className="w-5 h-5" />
            )}
          </button>
        </div>

        {/* Question Text */}
        <p className="text-sm sm:text-base font-semibold text-[#18243A] leading-relaxed">
          {currentQuestion.question}
        </p>

        {/* Question Illustration / Image if available */}
        {currentQuestion.imageUrl && (
          <div className="rounded-2xl overflow-hidden bg-white border border-[#E9E4D9] p-2 flex justify-center">
            <img
              src={currentQuestion.imageUrl}
              alt="Hình minh họa câu hỏi"
              className="max-h-56 object-contain rounded-xl"
              loading="lazy"
            />
          </div>
        )}

        {/* Options List */}
        <div className="space-y-2.5 pt-1">
          {currentQuestion.options.map((option, optIdx) => {
            const letter = String.fromCharCode(65 + optIdx); // 'A', 'B', 'C', 'D'
            const isSelected = selectedAnswer === optIdx;
            const isCorrectAnswer = optIdx === currentQuestion.correctIndex;

            let containerStyle =
              'border-[#E9E4D9] bg-white text-[#18243A] hover:bg-[#FBF8F1]';
            let letterStyle = 'bg-[#EEEAE1] text-[#18243A]';

            if (!isChecked) {
              if (isSelected) {
                containerStyle = 'border-[#C9A96E] bg-[#FBF6EB] shadow-xs';
                letterStyle = 'bg-[#111D31] text-white';
              }
            } else {
              // Answer is checked
              if (isCorrectAnswer) {
                containerStyle = 'border-[#2E7D32] bg-[#E8F5E9] text-[#1B5E20] font-medium';
                letterStyle = 'bg-[#2E7D32] text-white';
              } else if (isSelected && !isCorrectAnswer) {
                containerStyle = 'border-[#C62828] bg-[#FFEBEE] text-[#B71C1C]';
                letterStyle = 'bg-[#C62828] text-white';
              } else {
                containerStyle = 'border-gray-200 bg-gray-50 opacity-60';
              }
            }

            return (
              <button
                key={optIdx}
                onClick={() => onSelectAnswer(optIdx)}
                disabled={isChecked}
                className={`w-full p-3.5 rounded-2xl border-2 text-left transition flex items-start gap-3 cursor-pointer ${containerStyle}`}
              >
                <div
                  className={`w-6 h-6 rounded-full flex items-center justify-center shrink-0 text-xs font-bold ${letterStyle}`}
                >
                  {letter}
                </div>
                <div className="text-xs sm:text-sm leading-relaxed flex-1">
                  {option}
                </div>
                {isChecked && isCorrectAnswer && (
                  <CheckCircle2 className="w-5 h-5 text-[#2E7D32] shrink-0" />
                )}
                {isChecked && isSelected && !isCorrectAnswer && (
                  <XCircle className="w-5 h-5 text-[#C62828] shrink-0" />
                )}
              </button>
            );
          })}
        </div>

        {/* Check Answer Button / Feedback */}
        <div className="pt-2">
          {!isChecked ? (
            <button
              onClick={onCheckAnswer}
              disabled={selectedAnswer === null}
              className={`w-full py-3.5 rounded-xl font-bold text-sm transition cursor-pointer ${
                selectedAnswer !== null
                  ? 'bg-[#111D31] text-white hover:bg-[#1C2C45] shadow-sm'
                  : 'bg-gray-200 text-gray-400 cursor-not-allowed'
              }`}
            >
              Kiểm tra đáp án
            </button>
          ) : (
            <div className="bg-[#FFF9E6] border border-[#FFD54F] rounded-2xl p-4 space-y-2">
              <div className="flex items-center gap-1.5 text-xs font-bold text-[#8A5300]">
                <Lightbulb className="w-4 h-4 text-[#ED6C02]" />
                <span>Giải thích & Mẹo ghi nhớ:</span>
              </div>
              <p className="text-xs sm:text-sm text-[#5D3E00] leading-relaxed">
                {currentQuestion.explanation || 'Không có giải thích bổ sung.'}
              </p>
            </div>
          )}
        </div>
      </div>

      {/* Navigation Controls - Balanced for mobile & desktop */}
      <div className="grid grid-cols-3 gap-2 sm:gap-3 w-full pt-1 pb-4">
        <button
          onClick={onPrevQuestion}
          disabled={currentIndex === 0}
          className={`w-full h-12 rounded-2xl border text-xs sm:text-sm font-bold flex items-center justify-center gap-1 sm:gap-1.5 px-2 transition cursor-pointer shadow-xs ${
            currentIndex > 0
              ? 'bg-[#FFFDF8] border-[#E9E4D9] text-[#111D31] hover:bg-[#F6F1E5]'
              : 'opacity-40 cursor-not-allowed border-gray-200 text-gray-400 bg-white'
          }`}
        >
          <ArrowLeft className="w-4 h-4 shrink-0" />
          <span className="truncate">Câu trước</span>
        </button>

        <button
          onClick={() => setShowJumpDialog(true)}
          className="w-full h-12 rounded-2xl border border-[#E9E4D9] bg-[#FFFDF8] hover:bg-[#F6F1E5] text-xs sm:text-sm font-bold text-[#111D31] flex items-center justify-center gap-1 sm:gap-1.5 px-2 transition cursor-pointer shadow-xs"
        >
          <Grid className="w-4 h-4 text-[#C9A96E] shrink-0" />
          <span className="truncate">Danh sách</span>
        </button>

        <button
          onClick={onNextQuestion}
          disabled={currentIndex === questions.length - 1}
          className={`w-full h-12 rounded-2xl border text-xs sm:text-sm font-bold flex items-center justify-center gap-1 sm:gap-1.5 px-2 transition cursor-pointer shadow-xs ${
            currentIndex < questions.length - 1
              ? 'bg-[#111D31] border-[#111D31] text-white hover:bg-[#1C2C45]'
              : 'opacity-40 cursor-not-allowed border-gray-200 text-gray-400 bg-white'
          }`}
        >
          <span className="truncate">Câu tiếp</span>
          <ArrowRight className="w-4 h-4 shrink-0" />
        </button>
      </div>

      {/* Jump Question Modal Dialog */}
      {showJumpDialog && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-lg w-full max-h-[85vh] flex flex-col shadow-2xl border border-[#E9E4D9] overflow-hidden animate-in fade-in zoom-in-95 duration-150">
            <div className="px-5 py-4 border-b border-[#E9E4D9] flex items-center justify-between">
              <div>
                <h3 className="font-bold text-[#111D31] text-base">
                  Chọn câu hỏi
                </h3>
                <p className="text-xs text-[#7B8290]">
                  Tổng cộng {questions.length} câu hỏi
                </p>
              </div>
              <button
                onClick={() => setShowJumpDialog(false)}
                className="p-1.5 rounded-full hover:bg-gray-100 text-gray-500"
              >
                <X className="w-5 h-5" />
              </button>
            </div>

            <div className="p-4 overflow-y-auto flex-1">
              <div className="grid grid-cols-5 sm:grid-cols-6 gap-2">
                {questions.map((q, idx) => {
                  const isCur = idx === currentIndex;
                  const prog = progressList.find((p) => p.questionId === q.id);
                  const isWrong = (prog?.wrongCount || 0) > 0;
                  const isMastered = (prog?.correctCount || 0) > 0 && !isWrong;

                  let cellBg = 'bg-[#EAE5D9] text-[#111D31]';
                  let borderStyle = 'border-transparent';

                  if (isCur) {
                    cellBg = 'bg-[#111D31] text-white font-bold ring-2 ring-[#C9A96E]';
                  } else if (isWrong) {
                    cellBg = 'bg-[#FFEBEE] text-[#C62828] font-semibold border-[#FFCDD2]';
                  } else if (isMastered) {
                    cellBg = 'bg-[#E8F5E9] text-[#2E7D32] font-semibold border-[#C8E6C9]';
                  }

                  return (
                    <button
                      key={q.id}
                      onClick={() => {
                        onJumpToQuestion(idx);
                        setShowJumpDialog(false);
                      }}
                      className={`h-11 rounded-xl text-xs flex flex-col items-center justify-center border transition cursor-pointer relative ${cellBg} ${borderStyle}`}
                    >
                      <span>{idx + 1}</span>
                      {q.isCritical && (
                        <span className="text-[8px] font-bold text-[#C62828] -mt-0.5">
                          !
                        </span>
                      )}
                      {prog?.isBookmarked && (
                        <span className="absolute top-1 right-1 w-1.5 h-1.5 rounded-full bg-[#C9A96E]" />
                      )}
                    </button>
                  );
                })}
              </div>
            </div>

            <div className="p-4 border-t border-[#E9E4D9] bg-[#F6F3EB] flex items-center justify-around text-[11px] text-[#7B8290]">
              <div className="flex items-center gap-1.5">
                <span className="w-3 h-3 rounded-full bg-[#111D31]" />
                <span>Đang chọn</span>
              </div>
              <div className="flex items-center gap-1.5">
                <span className="w-3 h-3 rounded-full bg-[#E8F5E9] border border-[#2E7D32]" />
                <span>Đã đúng</span>
              </div>
              <div className="flex items-center gap-1.5">
                <span className="w-3 h-3 rounded-full bg-[#FFEBEE] border border-[#C62828]" />
                <span>Đã sai</span>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
