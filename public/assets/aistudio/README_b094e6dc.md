# Ôn Thi A1 A — Demo prototype V1

Prototype giao diện mobile-first cho ứng dụng ôn thi giấy phép lái xe A1/A.

## Chạy thử
- Giải nén ZIP.
- Mở `index.html` bằng Chrome, Edge hoặc Safari.
- Có thể bật DevTools > Device Toolbar để xem kích thước Android.
- Không cần cài đặt, server, tài khoản hoặc kết nối mạng.

## Các màn hình
1. Home — tiến độ và lối tắt.
2. Learning — câu hỏi mẫu, chọn đáp án, kiểm tra và giải thích.
3. Exam — bài thi demo 25 câu, đồng hồ, đánh dấu câu, nộp bài.
4. Result — điểm demo và trạng thái đạt/chưa đạt.
5. Statistics — tiến độ theo chủ đề và lịch sử mẫu.

## Lưu ý quan trọng
- Đây là prototype UI chạy trên trình duyệt, **không phải APK Android**.
- Dữ liệu câu hỏi và thống kê đều là dữ liệu minh họa; không phải ngân hàng 250 câu đã xác minh.
- Logic chấm điểm chỉ để trình diễn luồng thao tác; chưa đủ điều kiện dùng luyện thi thật.
- Chưa có SQLite, đồng bộ, sao lưu, kiểm thử pháp lý hoặc tích hợp nội dung PDF chính thức.

## Hướng triển khai tiếp
1. Chuẩn hóa bộ câu hỏi chính thức thành JSON (ID, nội dung, đáp án, giải thích, chủ đề, ảnh, cờ điểm liệt).
2. Xác minh quy tắc thi, số câu, thời gian và ngưỡng đạt theo văn bản hiện hành.
3. Chuyển giao diện sang Flutter hoặc Kotlin/Jetpack Compose.
4. Thêm SQLite/Room, lưu tiến độ và kiểm thử trên thiết bị Android.
