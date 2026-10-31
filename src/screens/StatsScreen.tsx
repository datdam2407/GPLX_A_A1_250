import React, { useState } from 'react';
import {
  BarChart3,
  RotateCcw,
  AlertTriangle,
  Award,
  CheckCircle2,
  BookOpen,
} from 'lucide-react';
import { allQuestions } from '../data/questionBank';
import {
  CATEGORIES,
  ExamResultEntity,
  QuestionProgressEntity,
} from '../types';

interface StatsScreenProps {
  progressList: QuestionProgressEntity[];
  examResults: ExamResultEntity[];
  onResetProgress: () => void;
}

export const StatsScreen: React.FC<StatsScreenProps> = ({
  progressList,
  examResults,
  onResetProgress,
}) => {
  const [showResetConfirm, setShowResetConfirm] = useState(false);

  const totalQuestions = 250;
  const learnedCount = progressList.filter(
    (p) => p.correctCount > 0 || p.wrongCount > 0
  ).length;
  const masteredCount = progressList.filter(
    (p) => p.correctCount > 0 && p.wrongCount === 0
  ).length;

  const totalCorrectAttempts = progressList.reduce(
    (acc, cur) => acc + cur.correctCount,
    0
  );
  const totalWrongAttempts = progressList.reduce(
    (acc, cur) => acc + cur.wrongCount,
    0
  );
  const totalAttempts = totalCorrectAttempts + totalWrongAttempts;
  const accuracy =
    totalAttempts > 0 ? Math.round((totalCorrectAttempts / totalAttempts) * 100) : 0;

  const passedExamsCount = examResults.filter((e) => e.isPassed).length;
  const passRate =
    examResults.length > 0
      ? Math.round((passedExamsCount / examResults.length) * 100)
      : 0;

  const progressPercent =
    totalQuestions > 0 ? Math.round((learnedCount / totalQuestions) * 100) : 0;

  // Breakdown by category (excluding 'ALL')
  const categoryStats = CATEGORIES.filter((c) => c.key !== 'ALL').map((cat) => {
    const questionsInCat =
      cat.key === 'CRITICAL'
        ? allQuestions.filter((q) => q.isCritical)
        : allQuestions.filter((q) => q.category === cat.key);

    const learnedInCat = questionsInCat.filter((q) => {
      const prog = progressList.find((p) => p.questionId === q.id);
      return (prog?.correctCount || 0) > 0 || (prog?.wrongCount || 0) > 0;
    }).length;

    const percent =
      questionsInCat.length > 0
        ? Math.round((learnedInCat / questionsInCat.length) * 100)
        : 0;

    return {
      category: cat,
      total: questionsInCat.length,
      learned: learnedInCat,
      percent,
    };
  });

  return (
    <div className="space-y-4 pb-20">
      {/* Title */}
      <div>
        <div className="text-[10px] font-bold text-[#C9A96E] uppercase tracking-wider">
          TỔNG QUAN HỌC TẬP
        </div>
        <h2 className="text-xl font-extrabold text-[#111D31]">
          Thống kê kết quả & tiến độ
        </h2>
      </div>

      {/* Main KPI Cards */}
      <div className="grid grid-cols-2 gap-3">
        {/* Progress Card */}
        <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs space-y-1">
          <div className="flex items-center justify-between text-[#7B8290]">
            <span className="text-xs font-semibold">Tiến độ câu hỏi</span>
            <BookOpen className="w-4 h-4 text-[#C9A96E]" />
          </div>
          <div className="text-2xl font-black text-[#111D31]">
            {progressPercent}%
          </div>
          <div className="text-[11px] text-[#7B8290]">
            {learnedCount}/{totalQuestions} câu đã học ({masteredCount} đã thuộc)
          </div>
        </div>

        {/* Accuracy Card */}
        <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs space-y-1">
          <div className="flex items-center justify-between text-[#7B8290]">
            <span className="text-xs font-semibold">Độ chính xác</span>
            <CheckCircle2 className="w-4 h-4 text-[#2E7D32]" />
          </div>
          <div className="text-2xl font-black text-[#111D31]">
            {accuracy}%
          </div>
          <div className="text-[11px] text-[#7B8290]">
            {totalCorrectAttempts}/{totalAttempts} lượt trả lời đúng
          </div>
        </div>

        {/* Exam Pass Rate Card */}
        <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs space-y-1">
          <div className="flex items-center justify-between text-[#7B8290]">
            <span className="text-xs font-semibold">Tỷ lệ đỗ thi thử</span>
            <Award className="w-4 h-4 text-[#ED6C02]" />
          </div>
          <div className="text-2xl font-black text-[#111D31]">
            {passRate}%
          </div>
          <div className="text-[11px] text-[#7B8290]">
            {passedExamsCount}/{examResults.length} lượt thi đỗ
          </div>
        </div>

        {/* Exams Taken Card */}
        <div className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs space-y-1">
          <div className="flex items-center justify-between text-[#7B8290]">
            <span className="text-xs font-semibold">Số đề đã thi</span>
            <BarChart3 className="w-4 h-4 text-[#111D31]" />
          </div>
          <div className="text-2xl font-black text-[#111D31]">
            {examResults.length}
          </div>
          <div className="text-[11px] text-[#7B8290]">
            Lưu trong lịch sử máy
          </div>
        </div>
      </div>

      {/* Category Breakdown Progress */}
      <div className="bg-[#FFFDF8] rounded-3xl p-5 border border-[#E9E4D9] shadow-xs space-y-4">
        <h3 className="font-bold text-sm sm:text-base text-[#111D31]">
          Tiến độ theo từng chủ đề
        </h3>

        <div className="space-y-3">
          {categoryStats.map((item) => {
            const isCritical = item.category.key === 'CRITICAL';
            return (
              <div key={item.category.key} className="space-y-1.5">
                <div className="flex items-center justify-between text-xs">
                  <span
                    className={`font-semibold ${
                      isCritical ? 'text-[#C62828] font-bold' : 'text-[#18243A]'
                    }`}
                  >
                    {item.category.title}
                  </span>
                  <span className="text-[#7B8290]">
                    {item.learned}/{item.total} câu ({item.percent}%)
                  </span>
                </div>

                <div className="h-2.5 w-full bg-[#EAE5D9] rounded-full overflow-hidden">
                  <div
                    className={`h-full rounded-full transition-all duration-500 ${
                      isCritical ? 'bg-[#C62828]' : 'bg-[#111D31]'
                    }`}
                    style={{ width: `${item.percent}%` }}
                  />
                </div>
              </div>
            );
          })}
        </div>
      </div>

      {/* Reset Progress Section */}
      <div className="pt-2">
        <button
          onClick={() => setShowResetConfirm(true)}
          className="w-full py-3.5 px-4 bg-white hover:bg-red-50 text-[#C62828] border border-red-200 rounded-2xl font-bold text-xs sm:text-sm flex items-center justify-center gap-2 transition cursor-pointer shadow-xs"
        >
          <RotateCcw className="w-4 h-4" />
          <span>Đặt lại tiến độ học tập</span>
        </button>
      </div>

      {/* Reset Confirm Modal */}
      {showResetConfirm && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-sm w-full p-6 shadow-2xl border border-[#E9E4D9] space-y-4 animate-in fade-in zoom-in-95">
            <div className="w-12 h-12 rounded-full bg-[#FFEBEE] text-[#C62828] flex items-center justify-center mx-auto">
              <AlertTriangle className="w-6 h-6" />
            </div>

            <div className="text-center">
              <h3 className="font-extrabold text-[#111D31] text-lg">
                Đặt lại tiến độ?
              </h3>
              <p className="text-xs text-[#7B8290] mt-1">
                Tất cả dữ liệu số lần làm đúng, làm sai và bookmark câu hỏi sẽ bị xóa về 0. (Lịch sử thi thử vẫn được giữ lại).
              </p>
            </div>

            <div className="grid grid-cols-2 gap-3 pt-2">
              <button
                onClick={() => setShowResetConfirm(false)}
                className="py-3 px-4 rounded-xl border border-[#E9E4D9] text-[#18243A] text-xs font-bold hover:bg-[#F6F1E5] transition cursor-pointer"
              >
                Hủy bỏ
              </button>
              <button
                onClick={() => {
                  setShowResetConfirm(false);
                  onResetProgress();
                }}
                className="py-3 px-4 rounded-xl bg-[#C62828] hover:bg-[#B71C1C] text-white text-xs font-bold shadow-sm transition cursor-pointer"
              >
                Xác nhận đặt lại
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
