# Ôn Thi GPLX A1 - Ứng dụng Ôn Thi Bằng Lái Xe Máy (React)

Ứng dụng web ôn thi 250 câu hỏi lý thuyết sát hạch bằng lái xe máy hạng A1/A theo chuẩn mới nhất của Bộ Giao thông Vận tải. Ứng dụng được viết lại hoàn toàn sang React + TypeScript + Tailwind CSS, giữ nguyên 100% logic nghiệp vụ, ngân hàng câu hỏi, và tính năng từ phiên bản gốc.

## Các tính năng chính

1. **Lộ trình học tập & Trang chủ (Home)**
   - Theo dõi tiến độ hoàn thành bộ đề (% đã học, biểu đồ tròn trực quan).
   - Thống kê nhanh: Đã thuộc, Cần ôn lại (câu làm sai), Độ chính xác %.
   - Lối tắt truy cập nhanh vào tất cả các phân hệ của ứng dụng.

2. **Luyện tập 250 câu hỏi theo chủ đề (Learning)**
   - Phân loại rõ ràng: 20 câu điểm liệt, Khái niệm và quy tắc, Văn hóa giao thông, Kỹ thuật lái xe, Biển báo đường bộ, Sa hình giao thông.
   - Hiển thị hình ảnh minh họa sa hình và biển báo giao thông sắc nét.
   - Tính năng lưu câu hỏi (Bookmark) để xem lại sau.
   - Chế độ kiểm tra đáp án ngay: đánh dấu đúng (xanh), sai (đỏ), hiển thị mẹo và giải thích chi tiết.
   - Hộp thoại chọn nhanh câu hỏi (Palette) với trạng thái màu sắc trực quan (đang chọn, đã đúng, đã sai).

3. **Mô phỏng thi thử sát hạch (Mock Exam)**
   - Tạo ngẫu nhiên đề thi 25 câu chuẩn cấu trúc Bộ GTVT: 2 câu điểm liệt, 12 câu quy tắc, 2 câu văn hóa/kỹ thuật, 5 câu biển báo, 4 câu sa hình.
   - Đồng hồ đếm ngược 19:00 phút chuẩn kỳ thi sát hạch thực tế (cảnh báo đỏ khi còn dưới 2 phút).
   - Đánh dấu câu hỏi cần xem lại (★).
   - Tự động nộp bài khi hết thời gian, có hộp thoại xác nhận số câu chưa làm trước khi nộp.
   - Tự động chấm điểm theo quy chế: Đạt khi đúng ≥ 21/25 câu và KHÔNG sai bất kỳ câu điểm liệt nào.

4. **Xem kết quả & Chi tiết bài thi (Exam Result)**
   - Đánh giá ĐẠT / KHÔNG ĐẠT, nêu rõ nguyên nhân (sai câu điểm liệt hay chưa đủ điểm).
   - Hiệu ứng pháo hoa chúc mừng khi thi đỗ.
   - Xem lại chi tiết toàn bộ 25 câu: đáp án bạn đã chọn, đáp án đúng của hệ thống, và lời giải thích.

5. **Lịch sử thi thử (History)**
   - Lưu trữ toàn bộ kết quả các bài thi đã làm trên thiết bị (LocalStorage).
   - Xem lại bài thi cũ kèm toàn bộ câu trả lời chi tiết.
   - Xóa từng bài thi hoặc xóa toàn bộ lịch sử thi.

6. **Ôn tập câu làm sai (Wrong Questions)**
   - Tự động tổng hợp danh sách các câu đã từng trả lời sai cả trong lúc học và lúc thi thử.
   - Hiển thị số lần sai, cảnh báo câu điểm liệt.
   - Nút "Luyện ngay" để mở chế độ luyện tập dành riêng cho các câu làm sai.

7. **Tra cứu 185 biển báo & vạch kẻ đường (Traffic Signs)**
   - Đầy đủ 185 biển báo: Biển cấm, Biển nguy hiểm, Biển hiệu lệnh, Biển chỉ dẫn, Biển phụ, Vạch và tín hiệu.
   - Tìm kiếm nhanh bằng tên, mã hiệu hoặc mô tả ý nghĩa.
   - Liên kết trực tiếp đến câu hỏi thi liên quan.

8. **Mẹo ghi nhớ 100% đậu (Study Tips)**
   - Tổng hợp thần chú giải sa hình: "Nhất chớm, nhì ưu, tam đường, tứ hướng".
   - Thứ tự xe ưu tiên: "Hỏa - Quân - Thương - Hộ".
   - Mẹo từ khóa "Bị nghiêm cấm", "Không được phép".
   - Quy tắc tốc độ xe máy trong và ngoài đô thị, độ tuổi lái xe, thứ bậc biển báo.

9. **Thống kê học tập (Stats)**
   - Thống kê tỷ lệ hoàn thành, độ chính xác, tỷ lệ đỗ thi thử.
   - Biểu đồ tiến độ chi tiết theo từng chủ đề.
   - Hỗ trợ đặt lại (reset) tiến độ học tập khi muốn ôn lại từ đầu.

## Công nghệ sử dụng

- **Frontend**: React 19, TypeScript
- **Styling**: Tailwind CSS v4, Lucide Icons
- **Hiệu ứng**: Canvas Confetti
- **Lưu trữ**: LocalStorage
- **Build tool**: Vite 6
