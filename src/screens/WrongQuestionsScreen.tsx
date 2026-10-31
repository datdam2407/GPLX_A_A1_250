import React from 'react';
import {
  CheckCircle2,
  Play,
  AlertTriangle,
  Lightbulb,
} from 'lucide-react';
import { allQuestions } from '../data/questionBank';
import { QuestionProgressEntity } from '../types';

interface WrongQuestionsScreenProps {
  progressList: QuestionProgressEntity[];
  onStartPractice: (wrongIds: number[]) => void;
}

export const WrongQuestionsScreen: React.FC<WrongQuestionsScreenProps> = ({
  progressList,
  onStartPractice,
}) => {
  const wrongProgress = progressList.filter((p) => p.wrongCount > 0);
  const wrongQuestions = wrongProgress.map((prog) => {
    const q = allQuestions.find((item) => item.id === prog.questionId);
    return {
      progress: prog,
      question: q,
    };
  }).filter((item): item is { progress: QuestionProgressEntity; question: NonNullable<typeof item.question> } => Boolean(item.question));

  if (wrongQuestions.length === 0) {
    return (
      <div className="bg-[#FFFDF8] rounded-3xl p-8 border border-[#E9E4D9] text-center space-y-4 shadow-sm my-8">
        <div className="w-16 h-16 rounded-full bg-[#E8F5E9] text-[#2E7D32] flex items-center justify-center mx-auto">
          <CheckCircle2 className="w-9 h-9" />
        </div>
        <div>
          <h3 className="font-extrabold text-[#111D31] text-lg">
            Không có câu trả lời sai!
          </h3>
          <p className="text-xs sm:text-sm text-[#7B8290] mt-1 max-w-sm mx-auto leading-relaxed">
            Tuyệt vời! Hiện tại bạn chưa có câu hỏi nào bị làm sai trong quá trình học và thi thử.
          </p>
        </div>
      </div>
    );
  }

  return (
    <div className="space-y-4 pb-20">
      {/* Action Header */}
      <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs flex items-center justify-between">
        <div>
          <h2 className="text-base sm:text-lg font-bold text-[#111D31]">
            Danh sách câu làm sai
          </h2>
          <p className="text-xs text-[#C62828] font-medium">
            {wrongQuestions.length} câu cần củng cố kiến thức
          </p>
        </div>

        <button
          onClick={() => onStartPractice(wrongQuestions.map((w) => w.question.id))}
          className="px-4 py-2.5 bg-[#111D31] hover:bg-[#1C2C45] text-white rounded-xl text-xs font-bold flex items-center gap-1.5 shadow-sm transition cursor-pointer"
        >
          <Play className="w-3.5 h-3.5 fill-white" />
          <span>Luyện ngay</span>
        </button>
      </div>

      {/* Cards List */}
      <div className="space-y-3">
        {wrongQuestions.map(({ progress, question }) => {
          const correctLetter = String.fromCharCode(65 + question.correctIndex);
          const correctText = question.options[question.correctIndex];

          return (
            <div
              key={question.id}
              className="bg-[#FFFDF8] rounded-2xl p-4 sm:p-5 border border-[#E9E4D9] shadow-xs space-y-3 hover:border-[#C9A96E]/40 transition"
            >
              <div className="flex items-center justify-between pb-2 border-b border-[#E9E4D9]">
                <div className="flex items-center gap-2">
                  <span className="font-bold text-sm text-[#111D31]">
                    Câu {question.id}
                  </span>
                  {question.isCritical && (
                    <span className="inline-flex items-center gap-1 px-2 py-0.5 rounded-md bg-[#FFEBEE] text-[#C62828] text-[9px] font-extrabold uppercase">
                      <AlertTriangle className="w-2.5 h-2.5" />
                      Điểm liệt
                    </span>
                  )}
                </div>

                <span className="text-xs font-bold text-[#C62828] bg-[#FFEBEE] px-2 py-0.5 rounded-md">
                  Sai {progress.wrongCount} lần
                </span>
              </div>

              {/* Question Text */}
              <p className="text-xs sm:text-sm font-semibold text-[#18243A] leading-relaxed">
                {question.question}
              </p>

              {/* Illustration if present */}
              {question.imageUrl && (
                <div className="rounded-xl overflow-hidden bg-white border border-[#E9E4D9] p-2 flex justify-center">
                  <img
                    src={question.imageUrl}
                    alt="Hình minh họa"
                    className="max-h-44 object-contain rounded-lg"
                  />
                </div>
              )}

              {/* Highlighted Correct Answer */}
              <div className="p-3 bg-[#E8F5E9] rounded-xl text-xs font-semibold text-[#1B5E20] flex items-start gap-2 border border-[#C8E6C9]">
                <CheckCircle2 className="w-4 h-4 text-[#2E7D32] shrink-0 mt-0.5" />
                <div className="leading-relaxed">
                  <span className="font-bold">Đáp án đúng: {correctLetter}. </span>
                  {correctText}
                </div>
              </div>

              {/* Explanation tip */}
              {question.explanation && (
                <div className="p-3 bg-[#FFF9E6] rounded-xl text-xs text-[#8A5300] flex items-start gap-2 border border-[#FFE082]">
                  <Lightbulb className="w-4 h-4 text-[#ED6C02] shrink-0 mt-0.5" />
                  <div className="leading-relaxed">
                    <span className="font-bold">Mẹo ghi nhớ: </span>
                    {question.explanation}
                  </div>
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
};
