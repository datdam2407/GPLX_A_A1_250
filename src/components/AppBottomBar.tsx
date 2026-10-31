import React from 'react';
import { Home, BookOpen, Timer, BarChart3 } from 'lucide-react';
import { Screen } from '../types';

interface AppBottomBarProps {
  currentScreen: Screen;
  onNavigate: (screen: Screen) => void;
}

export const AppBottomBar: React.FC<AppBottomBarProps> = ({
  currentScreen,
  onNavigate,
}) => {
  const isExamTab =
    currentScreen === 'EXAM_INTRO' ||
    currentScreen === 'EXAM_PLAYING' ||
    currentScreen === 'EXAM_RESULT';

  const navItems = [
    {
      id: 'HOME' as Screen,
      label: 'Trang chủ',
      icon: Home,
      isSelected: currentScreen === 'HOME',
    },
    {
      id: 'LEARNING' as Screen,
      label: 'Học tập',
      icon: BookOpen,
      isSelected: currentScreen === 'LEARNING',
    },
    {
      id: 'EXAM_INTRO' as Screen,
      label: 'Thi thử',
      icon: Timer,
      isSelected: isExamTab,
    },
    {
      id: 'STATS' as Screen,
      label: 'Thống kê',
      icon: BarChart3,
      isSelected: currentScreen === 'STATS',
    },
  ];

  return (
    <nav className="fixed bottom-0 left-0 right-0 z-30 bg-[#FFFDF8] border-t border-[#E9E4D9] shadow-lg">
      <div className="max-w-2xl mx-auto flex items-center justify-around h-16 px-2">
        {navItems.map((item) => {
          const Icon = item.icon;
          const active = item.isSelected;
          return (
            <button
              key={item.id}
              onClick={() => onNavigate(item.id)}
              className={`flex flex-col items-center justify-center py-1.5 px-3 rounded-xl transition cursor-pointer ${
                active ? 'bg-[#EAE5D9] text-[#111D31]' : 'text-[#7B8290] hover:text-[#18243A]'
              }`}
            >
              <Icon className="w-5 h-5" />
              <span className={`text-[11px] mt-1 font-medium ${active ? 'font-bold text-[#111D31]' : ''}`}>
                {item.label}
              </span>
            </button>
          );
        })}
      </div>
    </nav>
  );
};
