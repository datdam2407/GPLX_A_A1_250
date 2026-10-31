import React from 'react';
import {
  BookOpen,
  Timer,
  AlertTriangle,
  XCircle,
  MapPin,
  Sparkles,
  History,
  Car,
  ArrowRight,
} from 'lucide-react';
import { QuestionCategory, QuestionProgressEntity, Screen } from '../types';

interface HomeScreenProps {
  progressList: QuestionProgressEntity[];
  onNavigate: (screen: Screen) => void;
  onSelectCategory: (category: QuestionCategory) => void;
  onStartWrongPractice: (wrongIds: number[]) => void;
}

export const HomeScreen: React.FC<HomeScreenProps> = ({
  progressList,
  onNavigate,
  onSelectCategory,
  onStartWrongPractice,
}) => {
  const totalQuestions = 250;
  const learnedCount = progressList.filter(
    (p) => p.correctCount > 0 || p.wrongCount > 0
  ).length;
  const masteredCount = progressList.filter(
    (p) => p.correctCount > 0 && p.wrongCount === 0
  ).length;
  const wrongQuestions = progressList.filter((p) => p.wrongCount > 0);
  const wrongCount = wrongQuestions.length;

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

  const progressPercent =
    totalQuestions > 0 ? Math.round((learnedCount / totalQuestions) * 100) : 0;

  // SVG Circular progress math
  const strokeWidth = 6;
  const radius = 32;
  const circumference = 2 * Math.PI * radius;
  const strokeDashoffset =
    circumference - (progressPercent / 100) * circumference;

  return (
    <div className="space-y-4 pb-20">
      {/* Hero Section */}
      <div className="bg-[#111D31] rounded-3xl p-6 text-white shadow-lg relative overflow-hidden border border-[#1C2C45]">
        <div className="relative z-10">
          <div className="text-[11px] font-bold text-[#C9A96E] uppercase tracking-widest mb-1.5">
            LỘ TRÌNH CỦA BẠN
          </div>
          <h2 className="text-2xl sm:text-3xl font-extrabold leading-tight text-white mb-2">
            Vững lý thuyết.<br />Tự tin cầm lái.
          </h2>
          <p className="text-xs sm:text-sm text-[#C1C7D0] mb-6 max-w-sm">
            Mỗi ngày một chút — tiến gần hơn đến bằng lái A1.
          </p>

          <div className="flex items-center justify-between pt-2 border-t border-[#1C2C45]/80">
            <div>
              <div className="text-3xl sm:text-4xl font-extrabold text-[#F1D9A8] leading-none mb-1">
                {progressPercent}%
              </div>
              <div className="text-xs text-[#B9BEC8]">
                Hoàn thành bộ câu hỏi
              </div>
            </div>

            {/* Circular Progress Indicator */}
            <div className="relative flex items-center justify-center w-20 h-20">
              <svg className="w-20 h-20 -rotate-90" viewBox="0 0 80 80">
                <circle
                  cx="40"
                  cy="40"
                  r={radius}
                  stroke="#2B3A52"
                  strokeWidth={strokeWidth}
                  fill="transparent"
                />
                <circle
                  cx="40"
                  cy="40"
                  r={radius}
                  stroke="#C9A96E"
                  strokeWidth={strokeWidth}
                  strokeDasharray={circumference}
                  strokeDashoffset={strokeDashoffset}
                  strokeLinecap="round"
                  fill="transparent"
                  className="transition-all duration-700 ease-out"
                />
              </svg>
              <div className="absolute text-[11px] font-bold text-white text-center">
                {learnedCount}/{totalQuestions}
              </div>
            </div>
          </div>
        </div>

        {/* Ambient decorative graphic */}
        <div className="absolute -right-10 -bottom-10 w-44 h-44 bg-[#C9A96E]/10 rounded-full blur-2xl pointer-events-none" />
      </div>

      {/* Stats Cards Row */}
      <div className="grid grid-cols-3 gap-2.5">
        <div className="bg-[#FFFDF8] rounded-2xl p-3.5 border border-[#E9E4D9] shadow-sm text-center">
          <div className="text-xs text-[#7B8290] font-medium mb-1">Đã thuộc</div>
          <div className="text-xl sm:text-2xl font-bold text-[#111D31]">
            {masteredCount}
          </div>
        </div>

        <div className="bg-[#FFFDF8] rounded-2xl p-3.5 border border-[#E9E4D9] shadow-sm text-center">
          <div className="text-xs text-[#7B8290] font-medium mb-1">Cần ôn lại</div>
          <div
            className={`text-xl sm:text-2xl font-bold ${
              wrongCount > 0 ? 'text-[#C62828]' : 'text-[#111D31]'
            }`}
          >
            {wrongCount}
          </div>
        </div>

        <div className="bg-[#FFFDF8] rounded-2xl p-3.5 border border-[#E9E4D9] shadow-sm text-center">
          <div className="text-xs text-[#7B8290] font-medium mb-1">Chính xác</div>
          <div className="text-xl sm:text-2xl font-bold text-[#111D31]">
            {accuracy}%
          </div>
        </div>
      </div>

      {/* Primary Action Button */}
      <button
        onClick={() => {
          onSelectCategory('ALL');
          onNavigate('LEARNING');
        }}
        className="w-full bg-[#111D31] hover:bg-[#1C2C45] text-white p-4 rounded-2xl shadow-md flex items-center justify-between transition cursor-pointer group"
      >
        <span className="font-bold text-base">Tiếp tục học lý thuyết</span>
        <div className="flex items-center text-[#F1D9A8] group-hover:translate-x-1 transition-transform">
          <ArrowRight className="w-5 h-5" />
        </div>
      </button>

      {/* Shortcuts Section */}
      <div>
        <h3 className="text-base sm:text-lg font-bold text-[#111D31] mb-3 px-1">
          Học tập & Rèn luyện
        </h3>

        <div className="grid grid-cols-2 gap-3">
          {/* 1. 250 Questions */}
          <button
            onClick={() => {
              onSelectCategory('ALL');
              onNavigate('LEARNING');
            }}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <BookOpen className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">250 câu hỏi</div>
              <div className="text-xs text-[#7B8290] mt-0.5">Ôn luyện theo chủ đề</div>
            </div>
          </button>

          {/* 2. Mock Exam */}
          <button
            onClick={() => onNavigate('EXAM_INTRO')}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <Timer className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Thi thử A1</div>
              <div className="text-xs text-[#7B8290] mt-0.5">25 câu · 19 phút</div>
            </div>
          </button>

          {/* 3. 20 Critical Questions */}
          <button
            onClick={() => {
              onSelectCategory('CRITICAL');
              onNavigate('LEARNING');
            }}
            className="bg-[#FFFDF8] hover:bg-[#FDF2F2] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#FFEBEE] text-[#C62828] rounded-xl w-fit mb-3">
              <AlertTriangle className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm flex items-center gap-1.5">
                20 câu điểm liệt
              </div>
              <div className="text-xs text-[#C62828] font-medium mt-0.5">
                Sai là trượt ngay!
              </div>
            </div>
          </button>

          {/* 4. Wrong Questions */}
          <button
            onClick={() => {
              if (wrongCount > 0) {
                onStartWrongPractice(wrongQuestions.map((q) => q.questionId));
              } else {
                onNavigate('WRONG_QUESTIONS');
              }
            }}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <XCircle className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Câu làm sai</div>
              <div className="text-xs text-[#7B8290] mt-0.5">
                {wrongCount > 0 ? `${wrongCount} câu cần sửa` : 'Chưa có câu sai'}
              </div>
            </div>
          </button>

          {/* 5. All Signs */}
          <button
            onClick={() => onNavigate('SIGNS')}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <MapPin className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Tất cả biển báo</div>
              <div className="text-xs text-[#7B8290] mt-0.5">
                185 biển báo & vạch kẻ
              </div>
            </div>
          </button>

          {/* 6. Tips */}
          <button
            onClick={() => onNavigate('TIPS')}
            className="bg-[#FFFDF8] hover:bg-[#FBF6EB] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#FFF4E5] text-[#ED6C02] rounded-xl w-fit mb-3">
              <Sparkles className="w-5 h-5 text-[#C9A96E]" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Mẹo thi 100% đậu</div>
              <div className="text-xs text-[#7B8290] mt-0.5">Ghi nhớ thần tốc</div>
            </div>
          </button>

          {/* 7. History */}
          <button
            onClick={() => onNavigate('HISTORY')}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <History className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Lịch sử thi thử</div>
              <div className="text-xs text-[#7B8290] mt-0.5">Xem lại điểm & bài làm</div>
            </div>
          </button>

          {/* 8. Diagrams */}
          <button
            onClick={() => {
              onSelectCategory('DIAGRAM');
              onNavigate('LEARNING');
            }}
            className="bg-[#FFFDF8] hover:bg-[#F6F1E5] p-3.5 rounded-2xl border border-[#E9E4D9] shadow-sm text-left transition cursor-pointer flex flex-col justify-between"
          >
            <div className="p-2.5 bg-[#EAE5D9] text-[#111D31] rounded-xl w-fit mb-3">
              <Car className="w-5 h-5" />
            </div>
            <div>
              <div className="font-bold text-[#18243A] text-sm">Sa hình & Kỹ thuật</div>
              <div className="text-xs text-[#7B8290] mt-0.5">Quy tắc nhường đường</div>
            </div>
          </button>
        </div>
      </div>
    </div>
  );
};
