export interface TipItem {
  id: string;
  sectionId: 'STRUCTURE' | 'RULES' | 'SIGNS' | 'DIAGRAM' | 'CRITICAL_NOTE';
  sectionTitle: string;
  title: string;
  badge?: string;
  badgeColor?: 'gold' | 'red' | 'blue' | 'green' | 'amber';
  summary?: string;
  bullets?: string[];
  content?: string;
  example?: string;
  formula?: string;
}

export interface TipSection {
  id: 'ALL' | 'STRUCTURE' | 'RULES' | 'SIGNS' | 'DIAGRAM' | 'CRITICAL_NOTE';
  label: string;
  shortLabel: string;
  iconName: string;
}

export const TIP_SECTIONS: TipSection[] = [
  { id: 'ALL', label: 'Tất cả mẹo thi', shortLabel: 'Tất cả', iconName: 'Sparkles' },
  { id: 'STRUCTURE', label: '1. Cấu trúc đề thi', shortLabel: 'Cấu trúc đề', iconName: 'FileText' },
  { id: 'RULES', label: '2. Quy tắc & Từ khóa', shortLabel: 'Quy tắc', iconName: 'Key' },
  { id: 'SIGNS', label: '3. Mẹo Biển báo', shortLabel: 'Biển báo', iconName: 'Compass' },
  { id: 'DIAGRAM', label: '4. Mẹo Sa hình', shortLabel: 'Sa hình', iconName: 'Car' },
  { id: 'CRITICAL_NOTE', label: '5. Lưu ý chống liệt', shortLabel: 'Chống liệt', iconName: 'AlertTriangle' },
];

export const TIPS_DATA: TipItem[] = [
  // 1. Cấu trúc đề thi
  {
    id: 'struct-1',
    sectionId: 'STRUCTURE',
    sectionTitle: '1. Cấu trúc bộ đề thi A1 mới nhất bạn cần nắm vững',
    title: 'Hiểu rõ "luật chơi" trước khi bắt đầu học mẹo',
    badge: 'Cấu trúc chuẩn',
    badgeColor: 'blue',
    summary: 'Bộ đề thi sát hạch lý thuyết lái xe mô tô Hạng A1 chuẩn theo quy định hiện hành:',
    bullets: [
      'Tổng số câu hỏi trong ngân hàng: 250 câu (chia làm 3 phần chính: Luật GTĐB, Hệ thống Biển báo và Kỹ năng Sa hình).',
      'Số câu hỏi trong 1 đề thi: 25 câu.',
      'Thời gian làm bài: 19 phút.',
      'Điều kiện ĐẠT: Đúng từ 21/25 câu trở lên VÀ KHÔNG ĐƯỢC SAI CÂU ĐIỂM LIỆT nào.',
    ],
    example: 'Lưu ý sống còn: Kể cả khi bạn làm đúng 24/25 câu, nhưng câu sai duy nhất là câu điểm liệt thì bài thi bị CHẤM TRƯỢT NGAY LẬP TỨC.',
  },

  // 2. Mẹo Quy tắc & Khái niệm
  {
    id: 'rules-keywords',
    sectionId: 'RULES',
    sectionTitle: '2. Mẹo trả lời nhanh các câu hỏi về Quy tắc & Khái niệm',
    title: '2.1. Cụm từ "Vàng" – Thấy là chọn ngay',
    badge: 'Từ khóa vàng',
    badgeColor: 'gold',
    summary: 'Nếu trong các phương án trả lời có chứa những cụm từ sau, hãy chọn ngay mà không cần đọc hết cả câu hỏi:',
    bullets: [
      '"Bị nghiêm cấm" hoặc "Không được..." (Ví dụ: Không được phép, không được quay đầu, không được mang vác...).',
      '"UBND cấp tỉnh" (Thẩm quyền quy định các tuyến đường cấm, đường đi một chiều...).',
      '"Cơ quan, tổ chức, cá nhân" (Trách nhiệm bảo đảm trật tự ATGT hoặc bảo vệ công trình giao thông đường bộ).',
    ],
    example: 'Ví dụ: "Hành vi đua xe, cổ vũ đua xe trái phép có bị nghiêm cấm không?" -> Đáp án luôn là: "Bị nghiêm cấm".\nVí dụ: "Cơ quan nào quy định các đoạn đường cấm đi, đường đi một chiều...?" -> Chọn đáp án có "UBND cấp tỉnh".',
  },
  {
    id: 'rules-vehicles',
    sectionId: 'RULES',
    sectionTitle: '2. Mẹo trả lời nhanh các câu hỏi về Quy tắc & Khái niệm',
    title: '2.2. Mẹo phân biệt phương tiện & độ tuổi lái xe',
    badge: 'Khái niệm & Tuổi',
    badgeColor: 'amber',
    summary: 'Cách phân biệt nhanh các nhóm phương tiện và độ tuổi quy định:',
    bullets: [
      'Xe cơ giới: Chọn đáp án KHÔNG có cụm từ "xe cho người khuyết tật".',
      'Xe thô sơ: Chọn đáp án CÓ cụm từ "xe cho người khuyết tật".',
      'Tuổi lái xe 16 tuổi: Chỉ được điều khiển xe gắn máy dung tích xi lanh dưới 50 cm³.',
      'Tuổi lái xe 18 tuổi: Được điều khiển xe mô tô hai bánh từ 50 cm³ trở lên (Hạng A1, A2) và ô tô con.',
    ],
    example: 'Mẹo nhớ nhanh độ tuổi thi bằng lái xe máy A1: Luôn là 18 tuổi (câu hỏi nào hỏi tuổi lái xe mô tô A1 cứ chọn đáp án 18 tuổi).',
  },
  {
    id: 'rules-priority',
    sectionId: 'RULES',
    sectionTitle: '2. Mẹo trả lời nhanh các câu hỏi về Quy tắc & Khái niệm',
    title: '2.3. Quy tắc nhường đường & Vòng xuyến',
    badge: 'Quy tắc nhường',
    badgeColor: 'blue',
    summary: 'Nguyên tắc nhường đường căn bản tại nơi giao nhau và khu vực công cộng:',
    bullets: [
      'Nhường cho xe đi trên đường ưu tiên, đường chính từ bất kỳ hướng nào tới.',
      'Nhường cho người đi bộ đang đi trên phần đường quy định qua đường.',
      'Nơi giao nhau có vòng xuyến (có báo hiệu đi theo vòng xuyến): Phải nhường đường cho xe đi bên TRÁI.',
      'Nơi giao nhau không có vòng xuyến (không có báo hiệu vòng xuyến): Phải nhường đường cho xe đi bên PHẢI.',
    ],
    example: 'Thần chú vòng xuyến: "CÓ TRÁI - KHÔNG PHẢI" (Có biển vòng xuyến nhường bên Trái, Không có biển nhường bên Phải).',
  },
  {
    id: 'rules-speed',
    sectionId: 'RULES',
    sectionTitle: '2. Mẹo trả lời nhanh các câu hỏi về Quy tắc & Khái niệm',
    title: '2.4. Mẹo tốc độ tối đa cho phép',
    badge: 'Tốc độ tối đa',
    badgeColor: 'green',
    summary: 'Tốc độ quy định cho xe mô tô và xe gắn máy theo Thông tư quy định hiện hành:',
    bullets: [
      'Xe gắn máy (dung tích dưới 50cc), xe máy điện: Tối đa 40 km/h trên mọi cung đường.',
      'Xe mô tô hai bánh (từ 50cc trở lên) trong khu vực đông dân cư:\n  • Đường đôi (có dải phân cách giữa): Tối đa 60 km/h.\n  • Đường hai chiều (không có dải phân cách giữa): Tối đa 50 km/h.',
    ],
    example: 'Đường đôi trong phố (có con lươn ngăn cách): 60 km/h. Đường phố 2 chiều không con lươn: 50 km/h.',
  },

  // 3. Mẹo Biển báo giao thông
  {
    id: 'signs-types',
    sectionId: 'SIGNS',
    sectionTitle: '3. Tuyệt chiêu giải nhanh phần Biển báo giao thông',
    title: '3.1. Nhận diện nhanh 4 nhóm biển báo cơ bản',
    badge: 'Hình dạng & Màu',
    badgeColor: 'blue',
    summary: 'Nhớ các đặc điểm nhận dạng quy chuẩn quốc tế:',
    bullets: [
      'Biển tròn đỏ: Biển CẤM (Cấm điều gì thì vẽ hình điều đó bên trong viền đỏ).',
      'Biển tam giác vàng viền đỏ: Biển NGUY HIỂM (Cảnh báo tình huống nguy hiểm phía trước).',
      'Biển tròn xanh: Biển HIỆU LỆNH (Bắt buộc người tham gia giao thông phải thi hành).',
      'Biển hình vuông / chữ nhật xanh: Biển CHỈ DẪN (Chỉ dẫn hướng đi hoặc thông tin hỗ trợ cần thiết).',
    ],
    example: 'Gặp biển tròn màu xanh lam có hình mũi tên -> Đây là biển hiệu lệnh, bắt buộc phải đi theo hướng mũi tên chỉ.',
  },
  {
    id: 'signs-rules',
    sectionId: 'SIGNS',
    sectionTitle: '3. Tuyệt chiêu giải nhanh phần Biển báo giao thông',
    title: '3.2. Quy tắc cấm "Cấm nhỏ cấm lớn – Cấm lớn không cấm nhỏ"',
    badge: 'Thần chú biển cấm',
    badgeColor: 'red',
    summary: 'Mẹo giải quyết các câu hỏi về biển cấm phương tiện giao thông:',
    bullets: [
      'Cấm xe nhỏ => Cấm luôn xe lớn (Biển cấm ô tô con thì cấm luôn cả ô tô tải, ô tô khách, máy kéo).',
      'Cấm xe lớn => Không cấm xe nhỏ (Biển cấm ô tô tải thì KHÔNG cấm ô tô con, xe máy).',
      'Sơ đồ thứ tự kích thước xe: Xe con -> Xe tải -> Xe máy kéo -> Xe rơ-moóc.',
      'Đặc biệt quan trọng: Biển cấm ô tô con KHÔNG cấm xe mô tô 2 bánh!',
    ],
    example: 'Câu hỏi: "Gặp biển cấm ô tô con, xe mô tô 2 bánh có được đi vào không?" -> Được đi vào bình thường.',
  },

  // 4. Giải mã Sa hình
  {
    id: 'diagram-5steps',
    sectionId: 'DIAGRAM',
    sectionTitle: '4. Giải mã Sa hình – Quy tắc 5 bước ưu tiên',
    title: '4.1. Quy tắc 5 bước xét quyền ưu tiên qua nơi giao nhau',
    badge: '5 bước sa hình',
    badgeColor: 'amber',
    summary: 'Khi gặp câu hỏi về thứ tự xe đi trước/sau, luôn xét lần lượt theo đúng 5 bước:',
    bullets: [
      'Bước 1 - Giao lộ (Nhất chớm): Xe đã chớm vào giao lộ (vượt qua vạch đi bộ) luôn được đi trước.',
      'Bước 2 - Xe ưu tiên (Nhì ưu): Cứu hỏa -> Quân sự -> Công an -> Cứu thương (Nhớ câu: HỎA - QUÂN - CÔNG - THƯƠNG).',
      'Bước 3 - Đường ưu tiên (Tam đường): Xe nằm trên đường có biển ưu tiên (biển hình thoi hoặc tam giác ngược) được đi trước.',
      'Bước 4 - Quyền tay phải không vướng (Tứ phải): Xe nào phía bên tay phải không vướng xe khác thì được quyền đi trước.',
      'Bước 5 - Hướng rẽ (Ngũ hướng): Rẽ phải -> Đi thẳng -> Rẽ trái.',
    ],
    example: 'Thần chú sa hình nằm lòng: "Nhất chớm, nhì ưu, tam đường, tứ phải, ngũ hướng".\nThứ tự xe ưu tiên: "Hỏa - Quân - Công - Thương".',
  },
  {
    id: 'diagram-tricks',
    sectionId: 'DIAGRAM',
    sectionTitle: '4. Giải mã Sa hình – Quy tắc 5 bước ưu tiên',
    title: '4.2. Mẹo "Nhìn hình đoán ý" – Tuyệt chiêu ăn điểm siêu tốc',
    badge: 'Bí kíp nhìn hình',
    badgeColor: 'green',
    summary: 'Các dấu hiệu nhận biết đáp án cực nhanh trong phần sa hình:',
    bullets: [
      'Thấy Cảnh sát giao thông đứng giữa hình (hoặc giơ tay): Chọn ngay Đáp án 3.',
      'Thấy câu hỏi "Xe nào vi phạm quy tắc giao thông?": Thường thì xe con luôn đúng (trừ trường hợp vượt đèn đỏ rõ rệt), bạn chỉ cần chú ý các xe tải hoặc xe khách.',
      'Gặp ngã tư không biển báo, không xe ưu tiên: Tìm xe có hướng rẽ phải hoặc bên phải trống cho đi trước.',
    ],
    example: 'Mẹo hình CSGT: Cứ thấy hình ảnh chiến sĩ CSGT đứng trên bục giữa ngã tư chỉ đường -> Chọn ngay đáp án 3!',
  },

  // 5. Lưu ý chống liệt
  {
    id: 'critical-rules',
    sectionId: 'CRITICAL_NOTE',
    sectionTitle: '5. Lưu ý quan trọng để không bị "liệt" khi đi thi',
    title: '5. Bí quyết tâm lý và chiến thuật không bị rớt oan vì câu liệt',
    badge: 'Sống còn khi thi',
    badgeColor: 'red',
    summary: 'Rất nhiều học viên ôn rất kỹ nhưng vẫn thi trượt vì chủ quan với câu điểm liệt:',
    bullets: [
      'Đọc thật kỹ từng câu hỏi: Tuyệt đối không được chủ quan với câu hỏi điểm liệt (các câu về hành vi bị nghiêm cấm, nồng độ cồn, ma túy, chạy quá tốc độ, đi vào đường ngược chiều...).',
      'Giữ tâm lý bình tĩnh: Nên đến địa điểm thi sớm trước 30 phút để kiểm tra lại thông tin, số báo danh và ổn định tâm lý trước khi vào phòng máy tính.',
      'Chiến thuật 2 phút cuối: Tuyệt đối KHÔNG nộp bài sớm! Luôn dành trọn 2 phút cuối cùng để rà soát lại 100% tất cả 25 câu trả lời, kiểm tra cẩn thận các câu điểm liệt trước khi bấm "Kết thúc".',
    ],
    example: 'Quy tắc vàng trong phòng thi: "Làm bài cẩn thận - Rà soát 2 phút cuối - Không bao giờ nộp bài trước khi kiểm tra lại câu điểm liệt".',
  },
];
