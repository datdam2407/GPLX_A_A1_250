import React, { useEffect } from 'react';
import confetti from 'canvas-confetti';
import {
  Trophy,
  Frown,
  CheckCircle2,
  XCircle,
  AlertTriangle,
  RotateCcw,
  Clock,
  Check,
  Grid,
} from 'lucide-react';
import { ExamResultEntity, ExamReviewItem } from '../types';

interface ExamResultScreenProps {
  result: ExamResultEntity | null;
  reviewItems: ExamReviewItem[];
  onRetryCurrentExam: () => void;
  onChooseOtherExam: () => void;
}

export const ExamResultScreen: React.FC<ExamResultScreenProps> = ({
  result,
  reviewItems,
  onRetryCurrentExam,
  onChooseOtherExam,
}) => {
  useEffect(() => {
    if (result?.isPassed) {
      confetti({
        particleCount: 80,
        spread: 70,
        origin: { y: 0.6 },
        colors: ['#C9A96E', '#111D31', '#2E7D32', '#F1D9A8'],
      });
    }
  }, [result?.isPassed]);

  if (!result) {
    return (
      <div className="p-8 text-center bg-[#FFFDF8] rounded-2xl border border-[#E9E4D9]">
        <p className="text-gray-500">Không tìm thấy kết quả bài thi.</p>
        <button
          onClick={onChooseOtherExam}
          className="mt-4 px-4 py-2 bg-[#111D31] text-white rounded-xl text-sm font-semibold cursor-pointer"
        >
          Chọn đề thi
        </button>
      </div>
    );
  }

  const isPassed = result.isPassed;
  const isCriticalFailed = result.failedDueToCritical;
  const minutes = Math.floor(result.timeSpentSeconds / 60);
  const seconds = result.timeSpentSeconds % 60;
  const timeFormatted = `${String(minutes).padStart(2, '0')} phút ${String(seconds).padStart(2, '0')} giây`;

  return (
    <div className="space-y-4 pb-20">
      {/* Result Hero Banner */}
      <div
        className={`rounded-3xl p-6 text-white text-center shadow-lg border relative overflow-hidden ${
          isPassed
            ? 'bg-[#111D31] border-[#1C2C45]'
            : 'bg-[#2C1819] border-[#4A2628]'
        }`}
      >
        <div className="flex flex-col items-center">
          <div
            className={`w-16 h-16 rounded-full flex items-center justify-center mb-3 shadow-inner ${
              isPassed ? 'bg-[#1C2C45] text-[#F1D9A8]' : 'bg-[#4A2628] text-[#EF5350]'
            }`}
          >
            {isPassed ? (
              <Trophy className="w-8 h-8 text-[#C9A96E]" />
            ) : (
              <Frown className="w-8 h-8" />
            )}
          </div>

          <div className="text-[10px] font-bold uppercase tracking-widest text-[#C9A96E] mb-1">
            KẾT QUẢ BÀI THI SÁT HẠCH
          </div>

          <h2 className="text-3xl sm:text-4xl font-black mb-2">
            {isPassed ? 'ĐẠT (CHÚC MỪNG)' : 'KHÔNG ĐẠT'}
          </h2>

          <p className="text-xs sm:text-sm text-[#D1D5DB] max-w-sm leading-relaxed">
            {isPassed ? (
              'Xin chúc mừng! Bạn đã đủ điều kiện vượt qua bài sát hạch lý thuyết.'
            ) : isCriticalFailed ? (
              <span>
                Rất tiếc! Bạn đã trả lời{' '}
                <span className="font-extrabold text-[#FF5252]">sai câu hỏi điểm liệt</span>, bài thi{' '}
                <span className="font-extrabold text-[#FF5252]">bị chấm trượt ngay lập tức</span>.
              </span>
            ) : (
              'Rất tiếc! Bạn chưa đạt đủ số câu đúng tối thiểu (21/25 câu).'
            )}
          </p>
        </div>
      </div>

      {/* Summary Score Card: 2 balanced, elegant columns */}
      <div className="bg-[#FFFDF8] rounded-2xl p-4 sm:p-5 border border-[#E9E4D9] shadow-sm grid grid-cols-2 divide-x divide-[#E9E4D9]">
        {/* Column 1: Điểm số */}
        <div className="text-center px-3 sm:px-4">
          <div className="text-[11px] sm:text-xs text-[#7B8290] font-bold uppercase tracking-wider mb-1">
            Điểm số đạt được
          </div>
          <div
            className={`text-3xl sm:text-4xl font-black leading-none ${
              isPassed ? 'text-[#2E7D32]' : 'text-[#C62828]'
            }`}
          >
            {result.score}/{result.totalQuestions}
          </div>
          <div className="text-[11px] text-[#7B8290] font-medium mt-1.5">
            Chuẩn đạt: ≥ 21/25 câu
          </div>
        </div>

        {/* Column 2: Thời gian làm bài */}
        <div className="text-center px-3 sm:px-4 flex flex-col items-center justify-center">
          <div className="text-[11px] sm:text-xs text-[#7B8290] font-bold uppercase tracking-wider mb-1">
            Thời gian hoàn thành
          </div>
          <div className="text-xl sm:text-2xl font-black text-[#111D31] flex items-center justify-center gap-1.5 leading-none">
            <Clock className="w-4 h-4 text-[#C9A96E] shrink-0" />
            <span>{timeFormatted}</span>
          </div>
          <div className="text-[11px] text-[#7B8290] font-medium mt-1.5">
            Thời gian tối đa: 19 phút
          </div>
        </div>
      </div>

      {/* Action Buttons: Clearly distinguished colors */}
      <div className="grid grid-cols-2 gap-3">
        {/* Button 1: Làm đề khác (Warm Gold) */}
        <button
          onClick={onChooseOtherExam}
          className="py-3.5 px-4 bg-[#C9A96E] hover:bg-[#D8B97F] text-[#111D31] rounded-2xl font-extrabold text-xs sm:text-sm flex items-center justify-center gap-2 shadow-md transition cursor-pointer"
        >
          <Grid className="w-4 h-4 text-[#111D31]" />
          <span>Làm đề khác</span>
        </button>

        {/* Button 2: Làm lại đề này (Deep Navy with Gold Icon) */}
        <button
          onClick={onRetryCurrentExam}
          className="py-3.5 px-4 bg-[#111D31] hover:bg-[#1C2C45] text-white rounded-2xl font-extrabold text-xs sm:text-sm flex items-center justify-center gap-2 border border-[#1C2C45] shadow-md transition cursor-pointer"
        >
          <RotateCcw className="w-4 h-4 text-[#F1D9A8]" />
          <span>Làm lại đề này</span>
        </button>
      </div>

      {/* Detail Review List */}
      <div className="space-y-3 pt-2">
        <h3 className="text-base font-bold text-[#111D31] px-1">
          Chi tiết bài thi ({reviewItems.length} câu)
        </h3>

        {reviewItems.map((item, idx) => {
          const q = item.question;
          const userChoice = item.selectedIndex;
          const isCorrect = item.isCorrect;

          return (
            <div
              key={q.id}
              className={`bg-[#FFFDF8] rounded-2xl p-4 sm:p-5 border-2 shadow-xs space-y-3 ${
                isCorrect ? 'border-[#C8E6C9]' : 'border-[#FFCDD2]'
              }`}
            >
              <div className="flex items-center justify-between pb-2 border-b border-[#E9E4D9]">
                <div className="flex items-center gap-2">
                  <span className="font-bold text-xs sm:text-sm text-[#111D31]">
                    Câu {idx + 1}
                  </span>
                  {q.isCritical && (
                    <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-md bg-[#FFEBEE] text-[#C62828] text-[9px] font-extrabold uppercase">
                      <AlertTriangle className="w-2.5 h-2.5" />
                      Điểm liệt
                    </span>
                  )}
                </div>

                <div
                  className={`flex items-center gap-1 text-xs font-bold px-2 py-0.5 rounded-md ${
                    isCorrect
                      ? 'bg-[#E8F5E9] text-[#2E7D32]'
                      : 'bg-[#FFEBEE] text-[#C62828]'
                  }`}
                >
                  {isCorrect ? (
                    <>
                      <Check className="w-3.5 h-3.5" />
                      <span>Đúng</span>
                    </>
                  ) : (
                    <>
                      <XCircle className="w-3.5 h-3.5" />
                      <span>{userChoice === null ? 'Chưa chọn' : 'Sai'}</span>
                    </>
                  )}
                </div>
              </div>

              {/* Question text */}
              <p className="text-xs sm:text-sm font-semibold text-[#18243A] leading-relaxed">
                {q.question}
              </p>

              {/* Image if present */}
              {q.imageUrl && (
                <div className="rounded-xl overflow-hidden bg-white border border-[#E9E4D9] p-2 flex justify-center">
                  <img
                    src={q.imageUrl}
                    alt="Hình câu hỏi"
                    className="max-h-44 object-contain rounded-lg"
                  />
                </div>
              )}

              {/* Options breakdown */}
              <div className="space-y-1.5 text-xs">
                {q.options.map((opt, optIdx) => {
                  const letter = String.fromCharCode(65 + optIdx);
                  const isThisCorrect = optIdx === q.correctIndex;
                  const isThisChosen = optIdx === userChoice;

                  let optBg = 'bg-white text-gray-700 border-gray-100';
                  if (isThisCorrect) {
                    optBg = 'bg-[#E8F5E9] text-[#1B5E20] border-[#A5D6A7] font-semibold';
                  } else if (isThisChosen) {
                    optBg = 'bg-[#FFEBEE] text-[#B71C1C] border-[#EF9A9A]';
                  }

                  return (
                    <div
                      key={optIdx}
                      className={`p-2.5 rounded-xl border flex items-start gap-2 ${optBg}`}
                    >
                      <span className="font-bold shrink-0">{letter}.</span>
                      <span className="flex-1">{opt}</span>
                      {isThisCorrect && (
                        <CheckCircle2 className="w-4 h-4 text-[#2E7D32] shrink-0" />
                      )}
                      {isThisChosen && !isThisCorrect && (
                        <XCircle className="w-4 h-4 text-[#C62828] shrink-0" />
                      )}
                    </div>
                  );
                })}
              </div>

              {/* Explanation tip */}
              {q.explanation && (
                <div className="bg-[#FFF9E6] border border-[#FFE082] rounded-xl p-3 text-xs text-[#6D4C00] leading-relaxed">
                  <span className="font-bold">💡 Giải thích: </span>
                  {q.explanation}
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
};
