import React, { useState } from 'react';
import {
  Timer,
  AlertTriangle,
  CheckCircle2,
  XCircle,
  Play,
  RotateCcw,
  Shuffle,
  FileCode,
  X,
  Upload,
} from 'lucide-react';
import { ExamResultEntity } from '../types';

interface ExamIntroScreenProps {
  examResults: ExamResultEntity[];
  onStartExam: (testNumber?: number, title?: string) => void;
}

export const ExamIntroScreen: React.FC<ExamIntroScreenProps> = ({
  examResults,
  onStartExam,
}) => {
  const [showImportModal, setShowImportModal] = useState(false);
  const [jsonInput, setJsonInput] = useState('');
  const [importStatus, setImportStatus] = useState<string | null>(null);

  // 10 fixed exam sets
  const examSets = Array.from({ length: 10 }, (_, i) => i + 1);

  // Helper to find the latest result for a test
  const getLatestResultForTest = (testNum: number) => {
    const targetTitle = `Đề thi số ${testNum}`;
    const targetTitleAlt = `Đề số ${testNum}`;
    return examResults.find(
      (r) =>
        r.examTitle.includes(targetTitle) ||
        r.examTitle.includes(targetTitleAlt) ||
        r.examTitle.includes(`Đề ${testNum}`)
    );
  };

  const handleApplyCustomJson = () => {
    if (!jsonInput.trim()) {
      setImportStatus('Vui lòng dán nội dung JSON hoặc chọn tệp tin.');
      return;
    }
    try {
      const parsed = JSON.parse(jsonInput);
      localStorage.setItem('gplx_custom_exams_v1', JSON.stringify(parsed));
      setImportStatus('✓ Đã nạp thành công 10 bộ đề thi cố định!');
      setTimeout(() => {
        setShowImportModal(false);
        setImportStatus(null);
        setJsonInput('');
      }, 1200);
    } catch {
      setImportStatus('Lỗi: Cú pháp JSON không hợp lệ. Vui lòng kiểm tra lại!');
    }
  };

  const handleFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = (event) => {
      const content = event.target?.result as string;
      setJsonInput(content);
    };
    reader.readAsText(file);
  };

  const handleResetToDefault = () => {
    localStorage.removeItem('gplx_custom_exams_v1');
    setImportStatus('✓ Đã khôi phục bộ 10 đề thi chuẩn Bộ GTVT!');
    setTimeout(() => {
      setShowImportModal(false);
      setImportStatus(null);
    }, 1000);
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header Banner */}
      <div className="bg-[#111D31] rounded-3xl p-5 sm:p-6 text-white border border-[#1C2C45] shadow-lg flex flex-col sm:flex-row sm:items-center justify-between gap-4">
        <div>
          <div className="text-[10px] font-bold text-[#C9A96E] uppercase tracking-wider mb-1">
            SÁT HẠCH MÔ TÔ HẠNG A1
          </div>
          <h2 className="text-xl sm:text-2xl font-black text-white">
            10 Bộ đề thi cố định
          </h2>
          <p className="text-xs text-[#B9BEC8] mt-1 max-w-md">
            Bộ đề chuẩn hóa theo ngân hàng 250 câu hỏi mới nhất của Bộ Giao thông Vận tải.
          </p>
        </div>

        <div className="flex items-center gap-2">
          <button
            onClick={() => onStartExam(undefined, 'Đề thi ngẫu nhiên')}
            className="flex-1 sm:flex-none px-4 py-2.5 bg-[#C9A96E] hover:bg-[#D8B97F] text-[#111D31] rounded-xl text-xs font-bold flex items-center justify-center gap-1.5 shadow-md transition cursor-pointer"
          >
            <Shuffle className="w-3.5 h-3.5" />
            <span>Đề ngẫu nhiên</span>
          </button>

          <button
            onClick={() => setShowImportModal(true)}
            title="Nhập file JSON bộ đề thi"
            className="px-3 py-2.5 bg-[#1C2C45] hover:bg-[#2B3A52] text-[#F1D9A8] rounded-xl text-xs font-semibold flex items-center justify-center gap-1.5 border border-[#2B3A52] transition cursor-pointer"
          >
            <FileCode className="w-4 h-4" />
            <span className="hidden sm:inline">Nhập JSON</span>
          </button>
        </div>
      </div>

      {/* Requirement Box (Exact specification requested by user) */}
      <div className="bg-[#FFFDF8] rounded-2xl p-4 sm:p-5 border border-[#E9E4D9] shadow-xs space-y-2.5">
        <div className="flex items-start gap-2.5">
          <div className="p-1.5 rounded-lg bg-[#EAE5D9] text-[#111D31] shrink-0 mt-0.5">
            <Timer className="w-4 h-4" />
          </div>
          <div className="text-xs sm:text-sm text-[#18243A] leading-relaxed">
            <span className="font-extrabold text-[#111D31]">Cấu trúc đề: </span>
            25 câu hỏi, 19 phút. Cần trả lời đúng{' '}
            <span className="font-bold text-[#2E7D32]">21/25</span> và không sai câu liệt để{' '}
            <span className="font-bold text-[#2E7D32]">ĐẠT</span>.
          </div>
        </div>

        <div className="p-3 bg-[#FFF9E6] border border-[#FFD54F] rounded-xl flex items-start gap-2.5 text-xs text-[#8A5300] leading-relaxed">
          <AlertTriangle className="w-4 h-4 text-[#C62828] shrink-0 mt-0.5" />
          <div>
            <span className="font-extrabold text-[#C62828]">Chú ý: </span>
            Làm sai dù chỉ{' '}
            <span className="font-extrabold text-[#C62828]">01 CÂU ĐIỂM LIỆT</span> sẽ bị{' '}
            <span className="font-extrabold text-[#C62828]">TRƯỢT NGAY LẬP TỨC</span> kể cả khi đạt trên 21 câu đúng.
          </div>
        </div>
      </div>

      {/* 10 Fixed Exam Sets List */}
      <div className="space-y-3">
        <div className="flex items-center justify-between px-1">
          <h3 className="text-sm sm:text-base font-bold text-[#111D31]">
            Danh sách 10 đề thi sát hạch
          </h3>
          <span className="text-xs text-[#7B8290]">10 đề chuẩn Bộ GTVT</span>
        </div>

        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
          {examSets.map((testNum) => {
            const latestResult = getLatestResultForTest(testNum);

            let statusBadge = (
              <span className="text-[11px] font-medium text-[#7B8290] bg-[#EAE5D9] px-2.5 py-0.5 rounded-md">
                Chưa làm
              </span>
            );

            if (latestResult) {
              if (latestResult.isPassed) {
                statusBadge = (
                  <span className="inline-flex items-center gap-1 text-[11px] font-bold text-[#2E7D32] bg-[#E8F5E9] px-2.5 py-0.5 rounded-md border border-[#C8E6C9]">
                    <CheckCircle2 className="w-3 h-3" />
                    ĐẠT · {latestResult.score}/25
                  </span>
                );
              } else {
                statusBadge = (
                  <span className="inline-flex items-center gap-1 text-[11px] font-bold text-[#C62828] bg-[#FFEBEE] px-2.5 py-0.5 rounded-md border border-[#FFCDD2]">
                    <XCircle className="w-3 h-3" />
                    {latestResult.failedDueToCritical
                      ? `TRƯỢT LIỆT · ${latestResult.score}/25`
                      : `KHÔNG ĐẠT · ${latestResult.score}/25`}
                  </span>
                );
              }
            }

            return (
              <div
                key={testNum}
                className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs flex flex-col justify-between gap-3 hover:border-[#C9A96E]/60 transition"
              >
                <div className="space-y-1.5">
                  <div className="flex items-center justify-between">
                    <span className="font-extrabold text-sm sm:text-base text-[#111D31]">
                      Đề số {testNum}
                    </span>
                    {statusBadge}
                  </div>

                  <div className="flex items-center gap-3 text-xs text-[#7B8290]">
                    <span>25 câu hỏi</span>
                    <span>•</span>
                    <span>19 phút</span>
                  </div>
                </div>

                <button
                  onClick={() => onStartExam(testNum, `Đề thi số ${testNum}`)}
                  className={`w-full py-2.5 px-4 rounded-xl font-bold text-xs flex items-center justify-center gap-1.5 transition cursor-pointer shadow-xs ${
                    latestResult
                      ? 'bg-[#1C2C45] hover:bg-[#111D31] text-white'
                      : 'bg-[#111D31] hover:bg-[#1C2C45] text-white'
                  }`}
                >
                  {latestResult ? (
                    <>
                      <RotateCcw className="w-3.5 h-3.5 text-[#F1D9A8]" />
                      <span>Thi lại đề số {testNum}</span>
                    </>
                  ) : (
                    <>
                      <Play className="w-3.5 h-3.5 fill-white" />
                      <span>Bắt đầu thi đề {testNum}</span>
                    </>
                  )}
                </button>
              </div>
            );
          })}
        </div>
      </div>

      {/* Modal: Import Custom JSON */}
      {showImportModal && (
        <div className="fixed inset-0 z-50 bg-black/60 flex items-center justify-center p-4">
          <div className="bg-[#FFFDF8] rounded-3xl max-w-lg w-full p-6 shadow-2xl border border-[#E9E4D9] space-y-4 animate-in fade-in zoom-in-95">
            <div className="flex items-center justify-between border-b border-[#E9E4D9] pb-3">
              <div className="flex items-center gap-2">
                <FileCode className="w-5 h-5 text-[#C9A96E]" />
                <h3 className="font-extrabold text-[#111D31] text-base">
                  Nhập file JSON 10 bộ đề thi
                </h3>
              </div>
              <button
                onClick={() => {
                  setShowImportModal(false);
                  setImportStatus(null);
                }}
                className="p-1 rounded-full text-gray-400 hover:text-gray-700"
              >
                <X className="w-5 h-5" />
              </button>
            </div>

            <p className="text-xs text-[#7B8290] leading-relaxed">
              Bạn có thể tải lên tệp tin <span className="font-mono text-gray-800">.json</span> chứa cấu trúc 10 bộ đề hoặc dán trực tiếp mã JSON vào ô dưới đây:
            </p>

            <div className="flex items-center gap-2">
              <label className="flex-1 px-3 py-2 border border-dashed border-[#C9A96E] rounded-xl bg-[#FBF6EB] hover:bg-[#F6EED8] cursor-pointer flex items-center justify-center gap-2 text-xs font-bold text-[#111D31] transition">
                <Upload className="w-4 h-4 text-[#C9A96E]" />
                <span>Chọn file .json từ máy tính</span>
                <input
                  type="file"
                  accept=".json,application/json"
                  onChange={handleFileUpload}
                  className="hidden"
                />
              </label>

              <button
                onClick={handleResetToDefault}
                className="px-3 py-2 border border-[#E9E4D9] rounded-xl bg-white hover:bg-gray-50 text-xs font-semibold text-gray-700 transition cursor-pointer"
              >
                Đặt lại mặc định
              </button>
            </div>

            <textarea
              rows={8}
              value={jsonInput}
              onChange={(e) => setJsonInput(e.target.value)}
              placeholder="Dán nội dung file JSON vào đây..."
              className="w-full p-3 text-xs font-mono bg-white border border-[#E9E4D9] rounded-xl focus:outline-none focus:ring-2 focus:ring-[#C9A96E]/50 focus:border-[#C9A96E]"
            />

            {importStatus && (
              <div
                className={`p-3 rounded-xl text-xs font-medium ${
                  importStatus.startsWith('✓')
                    ? 'bg-[#E8F5E9] text-[#2E7D32]'
                    : 'bg-[#FFEBEE] text-[#C62828]'
                }`}
              >
                {importStatus}
              </div>
            )}

            <div className="grid grid-cols-2 gap-3 pt-2">
              <button
                onClick={() => {
                  setShowImportModal(false);
                  setImportStatus(null);
                }}
                className="py-2.5 px-4 rounded-xl border border-[#E9E4D9] text-[#18243A] text-xs font-bold hover:bg-[#F6F1E5] transition cursor-pointer"
              >
                Đóng
              </button>
              <button
                onClick={handleApplyCustomJson}
                className="py-2.5 px-4 rounded-xl bg-[#111D31] hover:bg-[#1C2C45] text-white text-xs font-bold shadow-sm transition cursor-pointer"
              >
                Lưu và áp dụng
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
