import React, { useState, useMemo } from 'react';
import {
  Sparkles,
  Lightbulb,
  FileText,
  Key,
  Compass,
  Car,
  AlertTriangle,
  Search,
  CheckCircle2,
  Clock,
  Award,
  BookOpen,
} from 'lucide-react';
import { TIPS_DATA, TIP_SECTIONS, TipItem } from '../data/tipsData';

export const TipsScreen: React.FC = () => {
  const [selectedSection, setSelectedSection] = useState<string>('ALL');
  const [searchQuery, setSearchQuery] = useState<string>('');

  const filteredTips = useMemo(() => {
    return TIPS_DATA.filter((item) => {
      const matchSection =
        selectedSection === 'ALL' || item.sectionId === selectedSection;

      if (!matchSection) return false;

      if (!searchQuery.trim()) return true;

      const q = searchQuery.toLowerCase().trim();
      return (
        item.title.toLowerCase().includes(q) ||
        item.sectionTitle.toLowerCase().includes(q) ||
        (item.summary && item.summary.toLowerCase().includes(q)) ||
        (item.example && item.example.toLowerCase().includes(q)) ||
        (item.bullets && item.bullets.some((b) => b.toLowerCase().includes(q)))
      );
    });
  }, [selectedSection, searchQuery]);

  const renderBadge = (item: TipItem) => {
    if (!item.badge) return null;

    let badgeClasses = 'bg-[#FFF4E5] text-[#ED6C02] border-[#FFE2B8]';
    if (item.badgeColor === 'gold') {
      badgeClasses = 'bg-[#FBF6EB] text-[#8A5300] border-[#F1D9A8]';
    } else if (item.badgeColor === 'red') {
      badgeClasses = 'bg-[#FFEBEE] text-[#C62828] border-[#FFCDD2]';
    } else if (item.badgeColor === 'blue') {
      badgeClasses = 'bg-[#E3F2FD] text-[#1565C0] border-[#BBDEFB]';
    } else if (item.badgeColor === 'green') {
      badgeClasses = 'bg-[#E8F5E9] text-[#2E7D32] border-[#C8E6C9]';
    }

    return (
      <span
        className={`text-[11px] font-bold px-2.5 py-0.5 rounded-full border shrink-0 ${badgeClasses}`}
      >
        {item.badge}
      </span>
    );
  };

  const getSectionIcon = (sectionId: string) => {
    switch (sectionId) {
      case 'STRUCTURE':
        return <FileText className="w-5 h-5 text-[#1976D2]" />;
      case 'RULES':
        return <Key className="w-5 h-5 text-[#C9A96E]" />;
      case 'SIGNS':
        return <Compass className="w-5 h-5 text-[#0288D1]" />;
      case 'DIAGRAM':
        return <Car className="w-5 h-5 text-[#2E7D32]" />;
      case 'CRITICAL_NOTE':
        return <AlertTriangle className="w-5 h-5 text-[#C62828]" />;
      default:
        return <Sparkles className="w-5 h-5 text-[#C9A96E]" />;
    }
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header Banner */}
      <div className="bg-[#111D31] rounded-3xl p-5 sm:p-6 text-white border border-[#1C2C45] shadow-lg flex items-center gap-4">
        <div className="w-12 h-12 rounded-2xl bg-[#1C2C45] flex items-center justify-center text-[#C9A96E] shrink-0 border border-[#2B3A52]">
          <Sparkles className="w-6 h-6" />
        </div>
        <div>
          <div className="text-[10px] font-bold text-[#C9A96E] uppercase tracking-wider">
            MẸO THI LÝ THUYẾT A1
          </div>
          <h2 className="text-lg sm:text-xl font-extrabold text-white">
            Ghi nhớ nhanh, chắc chắn đỗ
          </h2>
          <p className="text-xs text-[#B9BEC8] mt-0.5">
            Tổng hợp cấu trúc đề, từ khóa vàng, mẹo biển báo, sa hình và kinh nghiệm chống liệt
          </p>
        </div>
      </div>

      {/* Metric summary for Section 1: Cấu trúc đề thi */}
      <div className="bg-[#FFFDF8] rounded-3xl p-4 sm:p-5 border border-[#E9E4D9] shadow-xs space-y-3">
        <div className="flex items-center justify-between pb-2 border-b border-[#E9E4D9]">
          <div className="flex items-center gap-2">
            <span className="w-6 h-6 rounded-full bg-[#111D31] text-white text-xs flex items-center justify-center font-bold">
              1
            </span>
            <h3 className="font-bold text-sm sm:text-base text-[#111D31]">
              Cấu trúc bộ đề thi A1 mới nhất bạn cần nắm vững
            </h3>
          </div>
          <span className="text-[10px] font-bold px-2 py-0.5 rounded-full bg-[#E3F2FD] text-[#1565C0]">
            Quy định chuẩn
          </span>
        </div>

        <p className="text-xs text-[#5D6B82]">
          Trước khi học mẹo, hãy hiểu rõ &quot;luật chơi&quot; để tối ưu hóa thời gian và chiến thuật làm bài:
        </p>

        <div className="grid grid-cols-2 sm:grid-cols-4 gap-2.5 pt-1">
          <div className="bg-[#F8F5EE] rounded-2xl p-3 border border-[#E9E4D9] text-center">
            <BookOpen className="w-5 h-5 text-[#111D31] mx-auto mb-1" />
            <div className="text-lg sm:text-xl font-extrabold text-[#111D31]">250</div>
            <div className="text-[11px] text-[#5D6B82] font-medium">Câu hỏi ngân hàng</div>
            <div className="text-[10px] text-gray-500 mt-0.5">(Luật, Biển báo, Sa hình)</div>
          </div>

          <div className="bg-[#F8F5EE] rounded-2xl p-3 border border-[#E9E4D9] text-center">
            <FileText className="w-5 h-5 text-[#C9A96E] mx-auto mb-1" />
            <div className="text-lg sm:text-xl font-extrabold text-[#111D31]">25</div>
            <div className="text-[11px] text-[#5D6B82] font-medium">Câu trong đề thi</div>
            <div className="text-[10px] text-gray-500 mt-0.5">(Trắc nghiệm ngẫu nhiên)</div>
          </div>

          <div className="bg-[#F8F5EE] rounded-2xl p-3 border border-[#E9E4D9] text-center">
            <Clock className="w-5 h-5 text-[#1976D2] mx-auto mb-1" />
            <div className="text-lg sm:text-xl font-extrabold text-[#111D31]">19</div>
            <div className="text-[11px] text-[#5D6B82] font-medium">Phút làm bài</div>
            <div className="text-[10px] text-gray-500 mt-0.5">(~45 giây / câu)</div>
          </div>

          <div className="bg-[#FFF4F2] rounded-2xl p-3 border border-[#FFCDD2] text-center">
            <Award className="w-5 h-5 text-[#C62828] mx-auto mb-1" />
            <div className="text-lg sm:text-xl font-extrabold text-[#C62828]">21/25</div>
            <div className="text-[11px] text-[#C62828] font-bold">Điều kiện ĐẠT</div>
            <div className="text-[10px] text-[#D32F2F] mt-0.5 font-bold uppercase">
              Không sai câu liệt
            </div>
          </div>
        </div>

        <div className="bg-[#FFEBEE] border border-[#FFCDD2] rounded-xl p-3 text-xs text-[#C62828] flex items-start gap-2">
          <AlertTriangle className="w-4 h-4 shrink-0 mt-0.5 text-[#C62828]" />
          <div className="leading-relaxed">
            <span className="font-extrabold">CHÚ Ý ĐẶC BIỆT:</span> Làm sai dù chỉ 01 CÂU ĐIỂM LIỆT
            sẽ bị <span className="underline font-bold">TRƯỢT NGAY LẬP TỨC</span> kể cả khi đạt trên
            21 câu đúng!
          </div>
        </div>
      </div>

      {/* Search & Category Filter Pills */}
      <div className="space-y-2 pt-1">
        {/* Search Input */}
        <div className="relative">
          <Search className="w-4 h-4 text-gray-400 absolute left-3.5 top-1/2 -translate-y-1/2" />
          <input
            type="text"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            placeholder="Tìm kiếm mẹo, từ khóa (ví dụ: vòng xuyến, CSGT, nghiêm cấm...)"
            className="w-full pl-9 pr-4 py-2.5 text-xs sm:text-sm rounded-xl border border-[#E9E4D9] bg-[#FFFDF8] text-[#18243A] placeholder-gray-400 focus:outline-none focus:border-[#C9A96E] transition"
          />
          {searchQuery && (
            <button
              onClick={() => setSearchQuery('')}
              className="absolute right-3 top-1/2 -translate-y-1/2 text-xs text-gray-400 hover:text-gray-600 cursor-pointer"
            >
              Xóa
            </button>
          )}
        </div>

        {/* Section Navigation Tabs */}
        <div className="flex gap-1.5 overflow-x-auto pb-1 scrollbar-none">
          {TIP_SECTIONS.map((sec) => {
            const isSelected = selectedSection === sec.id;
            return (
              <button
                key={sec.id}
                onClick={() => setSelectedSection(sec.id)}
                className={`px-3 py-1.5 rounded-xl text-xs font-bold whitespace-nowrap border transition cursor-pointer shrink-0 ${
                  isSelected
                    ? 'bg-[#111D31] text-white border-[#111D31] shadow-xs'
                    : 'bg-[#FFFDF8] text-[#18243A] border-[#E9E4D9] hover:bg-[#F6F1E5]'
                }`}
              >
                {sec.shortLabel}
              </button>
            );
          })}
        </div>
      </div>

      {/* Tips Cards List */}
      <div className="space-y-3.5">
        {filteredTips.map((tip) => {
          return (
            <div
              key={tip.id}
              className="bg-[#FFFDF8] rounded-2xl p-5 border border-[#E9E4D9] shadow-xs space-y-3 hover:border-[#C9A96E]/50 transition"
            >
              {/* Header */}
              <div className="flex items-start justify-between gap-2 pb-2.5 border-b border-[#E9E4D9]">
                <div className="flex items-start gap-2.5">
                  <div className="p-1.5 rounded-xl bg-[#F6F3EB] border border-[#E9E4D9] shrink-0 mt-0.5">
                    {getSectionIcon(tip.sectionId)}
                  </div>
                  <div>
                    <div className="text-[10px] font-bold text-[#8A5300] uppercase tracking-wide">
                      {tip.sectionTitle}
                    </div>
                    <h4 className="font-bold text-sm sm:text-base text-[#111D31] mt-0.5 leading-snug">
                      {tip.title}
                    </h4>
                  </div>
                </div>

                {renderBadge(tip)}
              </div>

              {/* Summary */}
              {tip.summary && (
                <p className="text-xs sm:text-sm text-[#18243A] leading-relaxed font-medium">
                  {tip.summary}
                </p>
              )}

              {/* Bullets List */}
              {tip.bullets && tip.bullets.length > 0 && (
                <div className="space-y-2 bg-[#FAF7F0] p-3.5 rounded-xl border border-[#ECE6D8]">
                  {tip.bullets.map((b, bIdx) => (
                    <div key={bIdx} className="flex items-start gap-2 text-xs sm:text-sm text-[#18243A]">
                      <CheckCircle2 className="w-4 h-4 text-[#2E7D32] shrink-0 mt-0.5" />
                      <div className="leading-relaxed whitespace-pre-line font-medium">
                        {/* Highlight key phrases */}
                        {b.includes('Bị nghiêm cấm') || b.includes('Không được...') ? (
                          <span>
                            {b.split(/(Bị nghiêm cấm|Không được\.\.\.)/g).map((part, pIdx) =>
                              part === 'Bị nghiêm cấm' || part === 'Không được...' ? (
                                <strong key={pIdx} className="text-[#C62828] font-extrabold bg-[#FFEBEE] px-1 rounded">
                                  {part}
                                </strong>
                              ) : (
                                part
                              )
                            )}
                          </span>
                        ) : b.includes('UBND cấp tỉnh') || b.includes('Cơ quan, tổ chức, cá nhân') ? (
                          <span>
                            {b.split(/(UBND cấp tỉnh|Cơ quan, tổ chức, cá nhân)/g).map((part, pIdx) =>
                              part === 'UBND cấp tỉnh' || part === 'Cơ quan, tổ chức, cá nhân' ? (
                                <strong key={pIdx} className="text-[#1565C0] font-extrabold bg-[#E3F2FD] px-1 rounded">
                                  {part}
                                </strong>
                              ) : (
                                part
                              )
                            )}
                          </span>
                        ) : b.includes('HỎA - QUÂN - CÔNG - THƯƠNG') ? (
                          <span>
                            {b.split(/(HỎA - QUÂN - CÔNG - THƯƠNG)/g).map((part, pIdx) =>
                              part === 'HỎA - QUÂN - CÔNG - THƯƠNG' ? (
                                <strong key={pIdx} className="text-[#C62828] font-extrabold bg-[#FFEBEE] px-1 rounded">
                                  {part}
                                </strong>
                              ) : (
                                part
                              )
                            )}
                          </span>
                        ) : (
                          b
                        )}
                      </div>
                    </div>
                  ))}
                </div>
              )}

              {/* Example Box */}
              {tip.example && (
                <div className="bg-[#FBF6EB] border border-[#F1D9A8] rounded-xl p-3 text-xs text-[#6D4C00] flex items-start gap-2">
                  <Lightbulb className="w-4 h-4 text-[#C9A96E] shrink-0 mt-0.5" />
                  <div className="leading-relaxed whitespace-pre-line">
                    <strong className="text-[#8A5300] font-bold">Ví dụ thực tế / Mẹo nhớ: </strong>
                    <span className="italic">{tip.example}</span>
                  </div>
                </div>
              )}
            </div>
          );
        })}

        {filteredTips.length === 0 && (
          <div className="bg-[#FFFDF8] rounded-2xl p-8 text-center border border-[#E9E4D9] space-y-2">
            <Search className="w-8 h-8 text-gray-300 mx-auto" />
            <div className="text-sm font-bold text-[#111D31]">Không tìm thấy mẹo nào phù hợp</div>
            <p className="text-xs text-gray-500">
              Vui lòng thử tìm với từ khóa khác như &quot;vòng xuyến&quot;, &quot;biển cấm&quot;, &quot;sa hình&quot;, v.v.
            </p>
          </div>
        )}
      </div>
    </div>
  );
};
