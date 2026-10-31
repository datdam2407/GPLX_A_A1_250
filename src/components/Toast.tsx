import React, { useEffect } from 'react';
import { Info, X } from 'lucide-react';

interface ToastProps {
  message: string | null;
  onClose: () => void;
  duration?: number;
}

export const Toast: React.FC<ToastProps> = ({ message, onClose, duration = 3000 }) => {
  useEffect(() => {
    if (!message) return;
    const timer = setTimeout(() => {
      onClose();
    }, duration);
    return () => clearTimeout(timer);
  }, [message, duration, onClose]);

  if (!message) return null;

  return (
    <div className="fixed top-16 left-1/2 -translate-x-1/2 z-50 max-w-sm w-[90%] bg-[#111D31] text-white px-4 py-3 rounded-2xl shadow-2xl border border-[#C9A96E]/40 flex items-center justify-between animate-in fade-in slide-in-from-top-4 duration-200">
      <div className="flex items-center gap-2.5 text-xs sm:text-sm font-medium">
        <Info className="w-4 h-4 text-[#F1D9A8] shrink-0" />
        <span>{message}</span>
      </div>
      <button
        onClick={onClose}
        className="p-1 text-gray-400 hover:text-white rounded-lg transition"
      >
        <X className="w-4 h-4" />
      </button>
    </div>
  );
};
