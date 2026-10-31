import React, { useState, useMemo } from 'react';
import { Search, Compass, ExternalLink } from 'lucide-react';
import { trafficSigns } from '../data/questionBank';

const SIGN_CATEGORIES = [
  'Tất cả',
  'BIỂN BÁO CẤM',
  'BIỂN BÁO NGUY HIỂM',
  'BIỂN HIỆU LỆNH',
  'BIỂN CHỈ DẪN',
  'BIỂN PHỤ',
  'VẠCH VÀ TÍN HIỆU',
  'BIỂN BÁO KHÁC',
];

export const SignsScreen: React.FC = () => {
  const [selectedCategory, setSelectedCategory] = useState('Tất cả');
  const [searchQuery, setSearchQuery] = useState('');

  const filteredSigns = useMemo(() => {
    return trafficSigns.filter((sign) => {
      const matchesCategory =
        selectedCategory === 'Tất cả' ||
        sign.category.toLowerCase() === selectedCategory.toLowerCase();

      const q = searchQuery.trim().toLowerCase();
      const matchesSearch =
        q === '' ||
        sign.name.toLowerCase().includes(q) ||
        sign.description.toLowerCase().includes(q) ||
        sign.id.toLowerCase().includes(q) ||
        sign.category.toLowerCase().includes(q);

      return matchesCategory && matchesSearch;
    });
  }, [selectedCategory, searchQuery]);

  return (
    <div className="space-y-4 pb-20">
      {/* Search Input */}
      <div className="relative">
        <Search className="absolute left-3.5 top-1/2 -translate-y-1/2 w-4 h-4 text-[#7B8290]" />
        <input
          type="text"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
          placeholder="Tìm kiếm trong 185 biển báo & vạch kẻ..."
          className="w-full bg-[#FFFDF8] border border-[#E9E4D9] rounded-2xl pl-10 pr-4 py-3 text-xs sm:text-sm text-[#18243A] placeholder-[#7B8290] focus:outline-none focus:ring-2 focus:ring-[#C9A96E]/50 focus:border-[#C9A96E] shadow-xs"
        />
      </div>

      {/* Categories Horizontal Scroll */}
      <div className="flex gap-2 overflow-x-auto pb-1 no-scrollbar -mx-4 px-4">
        {SIGN_CATEGORIES.map((cat) => {
          const isSelected = selectedCategory === cat;
          return (
            <button
              key={cat}
              onClick={() => setSelectedCategory(cat)}
              className={`px-3 py-1.5 rounded-full text-xs font-semibold whitespace-nowrap transition cursor-pointer border ${
                isSelected
                  ? 'bg-[#111D31] text-white border-[#111D31]'
                  : 'bg-[#FFFDF8] text-[#18243A] border-[#E9E4D9] hover:bg-[#F6F1E5]'
              }`}
            >
              {cat}
            </button>
          );
        })}
      </div>

      {/* Results Header */}
      <div className="flex items-center justify-between text-xs text-[#7B8290] px-1">
        <span>Hiển thị {filteredSigns.length} biển báo</span>
        {searchQuery && (
          <button
            onClick={() => setSearchQuery('')}
            className="text-[#C9A96E] font-semibold hover:underline"
          >
            Xóa tìm kiếm
          </button>
        )}
      </div>

      {/* Signs Grid / Cards */}
      {filteredSigns.length === 0 ? (
        <div className="bg-[#FFFDF8] rounded-2xl p-8 border border-[#E9E4D9] text-center space-y-2 shadow-xs my-4">
          <Compass className="w-8 h-8 text-gray-400 mx-auto" />
          <p className="text-sm font-semibold text-[#18243A]">
            Không tìm thấy biển báo phù hợp
          </p>
          <p className="text-xs text-[#7B8290]">
            Hãy thử tìm kiếm với từ khóa khác hoặc chuyển sang danh mục "Tất cả".
          </p>
        </div>
      ) : (
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
          {filteredSigns.map((sign) => {
            return (
              <div
                key={sign.id}
                className="bg-[#FFFDF8] rounded-2xl p-4 border border-[#E9E4D9] shadow-xs flex flex-col justify-between hover:border-[#C9A96E]/50 transition"
              >
                <div>
                  <div className="flex items-start justify-between gap-2 mb-2">
                    <span className="text-[10px] font-bold px-2 py-0.5 rounded-md bg-[#EAE5D9] text-[#111D31] uppercase">
                      {sign.category}
                    </span>
                    {sign.relatedQuestionId && (
                      <span className="text-[10px] text-[#C9A96E] font-semibold flex items-center gap-0.5">
                        <ExternalLink className="w-3 h-3" />
                        Câu {sign.relatedQuestionId}
                      </span>
                    )}
                  </div>

                  {/* Sign Image */}
                  {sign.imageUrl ? (
                    <div className="h-32 w-full rounded-xl bg-white border border-[#E9E4D9] p-2 flex items-center justify-center mb-3">
                      <img
                        src={sign.imageUrl}
                        alt={sign.name}
                        className="max-h-full max-w-full object-contain"
                        loading="lazy"
                      />
                    </div>
                  ) : (
                    <div className="h-28 w-full rounded-xl bg-[#F6F3EB] border border-dashed border-[#E9E4D9] flex items-center justify-center text-gray-400 text-xs mb-3">
                      Hình minh họa biển báo
                    </div>
                  )}

                  <h3 className="font-bold text-xs sm:text-sm text-[#18243A] leading-snug mb-1">
                    {sign.name}
                  </h3>

                  <p className="text-xs text-[#7B8290] leading-relaxed line-clamp-3">
                    {sign.description}
                  </p>
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
};
