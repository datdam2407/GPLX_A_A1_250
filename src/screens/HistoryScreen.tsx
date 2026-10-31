import React, { useState } from 'react';
import {
  History,
  Timer,
  Trash2,
  AlertTriangle,
  ArrowRight,
  Clock,
  CheckCircle2,
  XCircle,
} from 'lucide-react';
import { ExamResultEntity } from '../types';

interface HistoryScreenProps {
  examResults: ExamResultEntity[];
  onViewExam: (exam: ExamResultEntity) => void;
  onDeleteExam: (id: number) => void;
  onClearAllHistory: () => void;
  onStartExam: () => void;
}

export const HistoryScreen: React.FC<HistoryScreenProps> = ({
  examResults,
  onViewExam,
  onDeleteExam,
  onClearAllHistory,
  onStartExam,
}) => {
  const [showClearConfirm, setShowClearConfirm] = useState(false);

  const formatDate = (millis: number) => {
    const d = new Date(millis);
    const day = String(d.getDate()).padStart(2, '0');
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const year = d.getFullYear();
    const hours = String(d.getHours()).padStart(2, '0');
    const minutes = String(d.getMinutes()).padStart(2, '0');
    return `${day}/${month}/${year} · ${hours}:${minutes}`;
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header */}
      <div className="flex items-center justify-between px-1">
        <div>
          <h2 className="text-xl font-bold text-[#111D31]">Lịch sử thi thử</h2>
          <p className="text-xs text-[#7B8290]">
            Đã lưu {examResults.length} lượt thi thử trên thiết bị
          </p>
        </div>

        {examResults.length > 0 && (
          <button
            onClick={() => setShowClearConfirm(true)}
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-xl border border-red-200 text-[#C62828] hover:bg-red-50 text-xs font-semibold transition cursor-pointer"
          >
            <Trash2 className="w-3.5 h-3.5" />
            <span>Xóa tất cả</span>
          </button>
        )}
      </div>

      {/* Empty State */}
      {examResults.length === 0 ? (
        <div className="bg-[#FFFDF8] rounded-3xl p-8 border border-[#E9E4D9] text-center space-y-4 shadow-sm my-6">
          <div className="w-16 h-16 rounded-full bg-[#EAE5D9] text-[#111D31] flex items-center justify-center mx-auto">
            <History className="w-8 h-8" />
          </div>
          <div>
            <h3 className="font-bold text-[#111D31] text-base">
              Chưa có lịch sử thi thử nào
            </h3>
            <p className="text-xs text-[#7B8290] mt-1 max-w-xs mx-auto">
              Hãy thử sức với bài thi mô phỏng 25 câu hỏi chuẩn sát hạch A1 để kiểm tra trình độ của bạn!
            </p>
          </div>
          <button
            onClick={onStartExam}
            className="px-6 py-3 bg-[#111D31] hover:bg-[#1C2C45] text-white rounded-2xl font-bold text-xs sm:text-sm inline-flex items-center gap-2 shadow-md transition cursor-pointer"
          >
            <Timer className="w-4 h-4 text-[#F1D9A8]" />
            <span>Bắt đầu thi thử ngay</span>
          </button>
        </div>
      ) : (
        <div className="space-y-3">
          {examResults.map((exam) => {
            const isPassed = exam.isPassed;
            const minutes = Math.floor(exam.timeSpentSeconds / 60);
            const seconds = exam.timeSpentSeconds % 60;
            const timeText = `${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;

            return (
              <div
                key={exam.id}
                className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs flex flex-col sm:flex-row sm:items-center justify-between gap-3 hover:border-[#C9A96E]/50 transition"
              >
                <div className="space-y-1">
                  <div className="flex items-center gap-2">
                    <span
                      className={`inline-flex items-center gap-1 px-2.5 py-0.5 rounded-full text-xs font-bold ${
                        isPassed
                          ? 'bg-[#E8F5E9] text-[#2E7D32]'
                          : 'bg-[#FFEBEE] text-[#C62828]'
                      }`}
                    >
                      {isPassed ? (
                        <>
                          <CheckCircle2 className="w-3.5 h-3.5" />
                          <span>ĐẠT</span>
                        </>
                      ) : (
                        <>
                          <XCircle className="w-3.5 h-3.5" />
                          <span>KHÔNG ĐẠT</span>
                        </>
                      )}
                    </span>

                    <span className="text-xs text-[#7B8290]">
                      {formatDate(exam.dateMillis)}
                    </span>
                  </div>

                  <div className="flex items-center gap-4 text-xs pt-1">
                    <div className="font-extrabold text-sm text-[#18243A]">
                      {exam.score} / {exam.totalQuestions} câu
                    </div>
                    <div className="flex items-center gap-1 text-[#7B8290]">
                      <Clock className="w-3.5 h-3.5" />
                      <span>{timeText}</span>
                    </div>
                    {exam.failedDueToCritical && (
                      <span className="text-[10px] font-bold text-[#C62828] bg-[#FFEBEE] px-1.5 py-0.5 rounded">
                        Sai điểm liệt
                      </span>
                    )}
                  </div>
                </div>

                <div className="flex items-center gap-2 pt-2 sm:pt-0 border-t sm:border-t-0 border-gray-100">
                  <button
                    onClick={() => onViewExam(exam)}
                    className="flex-1 sm:flex-initial px-4 py-2 bg-[#111D31] hover:bg-[#1C2C45] text-white rounded-xl text-xs font-bold flex items-center justify-center gap-1 transition cursor-pointer"
                  >
                    <span>Xem lại</span>
                    <ArrowRight className="w-3.5 h-3.5 text-[#F1D9A8]" />
                  </button>

                  <button
                    onClick={() => onDeleteExam(exam.id)}
                    title="Xóa bài thi này"
                    className="p-2 text-gray-400 hover:text-[#C62828] hover:bg-red-50 rounded-xl transition cursor-pointer"
                  >
                    <Trash2 className="w-4 h-4" />
                  </button>
                </div>
              </div>
            );
          })}
        </div>
      )}

      {/* Clear All Confirm Modal */}
      {showClearConfirm && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-sm w-full p-6 shadow-2xl border border-[#E9E4D9] space-y-4 animate-in fade-in zoom-in-95">
            <div className="w-12 h-12 rounded-full bg-[#FFEBEE] text-[#C62828] flex items-center justify-center mx-auto">
              <AlertTriangle className="w-6 h-6" />
            </div>

            <div className="text-center">
              <h3 className="font-extrabold text-[#111D31] text-lg">
                Xóa tất cả lịch sử?
              </h3>
              <p className="text-xs text-[#7B8290] mt-1">
                Tất cả {examResults.length} bài thi đã lưu sẽ bị xóa vĩnh viễn. Hành động này không thể hoàn tác.
              </p>
            </div>

            <div className="grid grid-cols-2 gap-3 pt-2">
              <button
                onClick={() => setShowClearConfirm(false)}
                className="py-3 px-4 rounded-xl border border-[#E9E4D9] text-[#18243A] text-xs font-bold hover:bg-[#F6F1E5] transition cursor-pointer"
              >
                Hủy bỏ
              </button>
              <button
                onClick={() => {
                  setShowClearConfirm(false);
                  onClearAllHistory();
                }}
                className="py-3 px-4 rounded-xl bg-[#C62828] hover:bg-[#B71C1C] text-white text-xs font-bold shadow-sm transition cursor-pointer"
              >
                Xác nhận xóa
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
