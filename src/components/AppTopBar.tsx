import React from 'react';
import { ArrowLeft } from 'lucide-react';

interface AppTopBarProps {
  title: string;
  subtitle: string;
  canNavigateBack: boolean;
  onNavigateBack: () => void;
}

export const AppTopBar: React.FC<AppTopBarProps> = ({
  title,
  subtitle,
  canNavigateBack,
  onNavigateBack,
}) => {
  return (
    <header className="sticky top-0 z-30 w-full bg-[#111D31] text-white shadow-md border-b border-[#1C2C45] px-4 py-3">
      <div className="max-w-2xl mx-auto flex items-center justify-between">
        <div className="flex items-center gap-3">
          {canNavigateBack && (
            <button
              onClick={onNavigateBack}
              aria-label="Quay lại"
              className="p-1.5 -ml-1 text-[#C9A96E] hover:text-[#F1D9A8] hover:bg-[#1C2C45] rounded-xl transition cursor-pointer"
            >
              <ArrowLeft className="w-5 h-5" />
            </button>
          )}
          <div>
            <div className="text-[10px] font-bold tracking-wider text-[#C9A96E] uppercase">
              {subtitle}
            </div>
            <h1 className="text-base font-bold leading-tight text-white line-clamp-1">
              {title}
            </h1>
          </div>
        </div>
        <div className="flex items-center">
          <span className="px-2 py-0.5 text-[10px] font-semibold tracking-wider bg-[#1C2C45] text-[#F1D9A8] rounded-md border border-[#2B3A52]">
            HẠNG A1
          </span>
        </div>
      </div>
    </header>
  );
};
