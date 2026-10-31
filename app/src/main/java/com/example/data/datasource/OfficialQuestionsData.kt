package com.example.data.datasource

import com.example.data.model.Question
import com.example.data.model.QuestionCategory

val officialQuestionsList = listOf(
    Question(
        id = 1,
        question = """Phần của đường bộ được sử dụng cho phương tiện giao thông đường bộ đi lại là gì?""",
        options = listOf("""Phần mặt đường và lề đường.""", """Phần đường xe chạy.""", """Phần đường xe cơ giới."""),
        correctIndex = 1,
        explanation = """Mẹo: Phần đường = 2 chữ = Chọn đáp án 2""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 2,
        question = """“Người tham gia giao thông đường bộ" gồm những đối tượng nào?""",
        options = listOf("""Người điều khiển, người được chở trên phương tiện tham gia giao thông đường bộ""", """Người điều khiển, dẫn dắt vật nuôi trên đường bộ; người đi bộ trên đường bộ.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Điều khiển xe, được người khác chở, dẫn dắt súc vật hay đi bộ trên đường đều là tham gia giao thông.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 3,
        question = """Hành vi nào sau đây bị nghiêm cấm?""",
        options = listOf("""Điều khiển xe cơ giới lạng lách, đánh võng, rú ga liên tục khi tham gia giao thông trên đường.""", """Xúc phạm, đe dọa, cản trở, chống đối hoặc không chấp hành hiệu lệnh, hướng dẫn, yêu cầu kiểm tra, kiểm soát của người thi hành công vụ về bảo đảm trật tự, an toàn giao thông đường bộ.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Lạng lách rú ga – Chống đối công an – Cả hai đều cấm !""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 4,
        question = """Khi hiệu lệnh của người điều khiển giao thông trái với tín hiệu đèn giao thông hoặc biển báo hiệu đường bộ thì người tham gia giao thông đường bộ phải chấp hành báo hiệu đường bộ nào dưới đây?""",
        options = listOf("""Theo hiệu lệnh của người điều khiển giao thông.""", """Theo tín hiệu đèn giao thông.""", """Theo biển báo hiệu đường bộ."""),
        correctIndex = 0,
        explanation = """Tuân thủ: ̉“Người – Đèn – Biển” (Thứ tự ưu tiên từ cao xuống thấp). “Nghe người trước, nhìn đèn sau, biển báo đứng cuối hàng!”""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 5,
        question = """Khi lái xe trong khu đông dân cư, khu vực cơ sở khám bệnh, chữa bệnh trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi trong thời gian nào?""",
        options = listOf("""Từ 22 giờ ngày hôm trước đến 05 giờ ngày hôm sau.""", """Từ 05 giờ đến 22 giờ.""", """Từ 23 giờ ngày hôm trước đến 05 giờ sáng hôm sau."""),
        correctIndex = 1,
        explanation = """Còi 5 đến 22 – Đêm ngủ yên, “Còi thì chỉ bấm ban ngày, 5 giờ sáng đến 10 giờ tối, ban đêm để người ta ngủ thôi!”""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 6,
        question = """Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào sau đây không được phép?""",
        options = listOf("""Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống hoặc vật khác quệt xuống đường khi xe đang chạy.""", """Sử dụng xe để chở người hoặc hàng hóa; để chân chạm xuống đất khi khởi hành.""", """Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.""", """Chở người ngồi sau dưới 16 tuổi."""),
        correctIndex = 0,
        explanation = """“Buông tay – Kéo đẩy – Quệt chân, dễ tai nạn, tuyệt đối cấm!”""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 7,
        question = """Trường hợp người được chở trên xe mô tô, xe gắn máy, các loại xe tương tự xe mô tô và các loại xe tương tự xe gắn máy không đội "mũ bảo hiểm cho người đi mô tô, xe máy" hoặc không cài quai đúng quy cách (trừ trường hợp chở người bệnh đi cấp cứu, trẻ em dưới 06 tuổi, áp giải người có hành vi vi phạm pháp luật) thì việc xử phạt vi phạm hành chính được quy định như thế nào?""",
        options = listOf("""Không bị xử phạt chỉ bị nhắc nhở.""", """Người được chở không bị xử phạt, chỉ xử phạt người điều khiển xe mô tô, xe gắn máy.""", """Người được chở bị xử phạt, không xử phạt người điều khiển xe mô tô, xe gắn máy.""", """Xử phạt cả người điều khiển và người được chở trên xe mô tô, xe gắn máy."""),
        correctIndex = 3,
        explanation = """Người ngồi sau không đội mũ bảo hiểm khi tham gia giao thông, sẽ bị xử phạt cả người điều khiển và người ngồi sau theo nghị định 168/2024/NĐ-CP""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 8,
        question = """Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Phải nhường đường cho xe đi đến từ bên phải.""", """Xe báo hiệu xin đường trước, xe đó được đi trước.""", """Phải nhường đường cho xe đi đến từ bên trái."""),
        correctIndex = 0,
        explanation = """Đường giao nhau không có báo hiệu đi theo vòng xuyến nhường bên phải, có báo hiệu nhường bên trái. “Có trái – không phải!”""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 9,
        question = """Người lái xe được phép vượt xe khác về bên phải trong trường hợp nào dưới đây?""",
        options = listOf("""Xe phía trước có tín hiệu rẽ trái hoặc đang rẽ trái hoặc khi xe chuyên dùng đang làm việc trên đường mà không thể vượt bên trái.""", """Xe phía trước đang đi sát lề đường bên trái.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Bình thường vượt trái, khi gặp Xe rẽ trái hoặc đang làm việc (xe chuyên dùng ) mới được vượt phải.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 10,
        question = """Người có giấy phép lái xe chưa bị trừ hết 12 điểm, được phục hồi điểm giấy phép lái xe trong trường hợp nào sau đây?""",
        options = listOf("""Không được phục hồi.""", """Được phục hồi đủ 12 điểm, nếu không bị trừ điểm trong thời hạn 12 tháng từ ngày bị trừ điểm gần nhất."""),
        correctIndex = 1,
        explanation = """12 tháng không bị trừ điểm → phục hồi đủ 12 điểm!""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 11,
        question = """Những hành vi nào sau đây thể hiện là người có văn hóa giao thông?""",
        options = listOf("""Luôn tuân thủ pháp luật về trật tự, an toàn giao thông đường bộ, nhường nhịn và giúp đỡ người khác.""", """Đi nhanh, vượt đèn đỏ nếu không có lực lượng Công an.""", """Bấm còi và nháy đèn liên tục để cảnh báo xe khác.""", """Tránh nhường đường để đi nhanh hơn."""),
        correctIndex = 0,
        explanation = """Tuân luật + Nhường nhịn + Giúp đỡ = Văn hóa giao thông!""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 12,
        question = """Khi điều khiển xe mô tô tay ga xuống đường dốc dài, độ dốc cao, người lái xe cần thực hiện các thao tác nào dưới đây để bảo đảm an toàn?""",
        options = listOf("""Giữ tay ga ở mức độ phù hợp, sử dụng phanh trước và phanh sau để giảm tốc độ.""", """Nhả hết tay ga, tắt động cơ, sử dụng phanh trước và phanh sau để giảm tốc độ.""", """Sử dụng phanh trước để giảm tốc độ kết hợp với tắt chìa khóa điện của xe."""),
        correctIndex = 0,
        explanation = """Xuống dốc tay ga hợp lý, phanh trước phanh sau giảm tốc an toàn.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 13,
        question = """Khi điều khiển xe mô tô quay đầu, người lái xe cần thực hiện như thế nào để bảo đảm an toàn?""",
        options = listOf("""Bật tín hiệu báo rẽ trước khi quay đầu, từ từ giảm tốc độ đến mức có thể dừng lại.""", """Chỉ quay đầu xe tại những nơi được phép quay đầu.""", """Quan sát an toàn các phương tiện tới từ phía trước, phía sau, hai bên đồng thời nhường đường cho xe từ bên phải và phía trước đi tới.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Muốn quay đầu thì nhớ bật đèn, chọn nơi cho phép, quan sát và nhường đường.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 14,
        question = """Biển nào cấm quay đầu xe?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Không biển nào.""", """Cả hai biển.."""),
        correctIndex = 1,
        explanation = """Biển 1 là biển cấm xe rẽ trái. Biển 2 là biển cấm xe quay đầu. Biển báo cấm quay đầu không có giá trị cấm rẽ trái.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/313.jpg?v=202606091805"""
    ),
    Question(
        id = 15,
        question = """Khi gặp biển nào xe ưu tiên theo luật định vẫn phải dừng lại?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: Đường cấm không áp dụng với xe ưu tiên - Biển 2: dừng lại áp dụng với tất cả phương tiện kể cả xe ưu tiên - Biển 3: Cấm đi ngược chiều không áp dụng với xe ưu tiên. Nên đáp án 2""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/329.jpg?v=202606091805"""
    ),
    Question(
        id = 16,
        question = """Biển này có ý nghĩa như thế nào?""",
        options = listOf("""Cấm dừng xe về hướng bên trái.""", """Cấm dừng và đỗ xe theo hướng bên phải.""", """Được phép đỗ xe và dừng xe theo hướng bên phải."""),
        correctIndex = 1,
        explanation = """Biển chính: cấm dừng và đỗ xe - Biển phụ: hướng mũi tên chỉ bên phải - Cấm dừng và đỗ xe theo hướng bên phải.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/354.jpg?v=202606091805"""
    ),
    Question(
        id = 17,
        question = """Biển nào báo hiệu "Giao nhau có tín hiệu đèn"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: Giao nhau với đường sắt có rào chắn - Biển 2: Giao nhau với đường ưu tiên - Biển 3: Giao nhau với tin hiệu đèn ( chú ý đèn giao thông trong biển). Hỏi đèn thì kiếm đèn mà chọn.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/372.jpg?v=202606091805"""
    ),
    Question(
        id = 18,
        question = """Biển nào báo hiệu "Đường giao nhau" của các tuyến đường cùng cấp?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: Giao nhau tuyến đường cùng cấp - Biển 2: Giao nhau với đường không ưu tiên - Biển 3: Giao nhau với đường ưu tiên ( biển tam giác ngược)""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/387.jpg?v=202606091805"""
    ),
    Question(
        id = 19,
        question = """Biển nào dưới đây là biển "Cầu hẹp"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: Cầu tạm - Biển 2: Cầu hẹp - Biển 3: Cầu quay – cầu cất.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/401.jpg?v=202606091805"""
    ),
    Question(
        id = 20,
        question = """Biển nào (đặt trước ngã ba, ngã tư) cho phép xe được rẽ sang hướng khác?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Không biển nào."""),
        correctIndex = 2,
        explanation = """Hướng đi phải theo các xe bắt buộc đi thẳng - Biển 2: Hướng đi phải theo các xe rẽ phải hoặc rẽ trái ( lưu ý biển này đặt “SAU” ngã 3, ngã 4) - Nên đáp án không có biển nào. Mẹo nhớ: đặt trước ngã ba chọn đáp án 3.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/432.jpg?v=202606091805"""
    ),
    Question(
        id = 21,
        question = """Biển số 1 có ý nghĩa như thế nào?""",
        options = listOf("""Biển chỉ dẫn hết cấm đỗ xe theo giờ trong khu vực.""", """Biển chỉ dẫn hết hiệu lực khu vực đỗ xe trên các tuyến đường đối ngoại.""", """Biển chỉ dẫn khu vực đỗ xe trên các tuyến đường đối ngoại."""),
        correctIndex = 0,
        explanation = """Biển 1: Hết cấm đỗ xe theo giờ trong khu vực - Biển 2: Hết cấm đỗ xe trong khu vực - Biển 3: Hết khu vực đỗ xe.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/445.jpg?v=202606091805"""
    ),
    Question(
        id = 22,
        question = """Tại đoạn đường có biển "Làn đường dành riêng cho từng loại xe" dưới đây, các phương tiện có được phép chuyển sang làn khác để đi theo hành trình mong muốn khi đến gần nơi đường bộ giao nhau hay không?""",
        options = listOf("""Được phép chuyển sang làn khác.""", """Không được phép chuyển sang làn khác, chỉ được đi trong làn quy định theo biển."""),
        correctIndex = 0,
        explanation = """Biển số R.412 Làn đường dành riêng cho từng loại xe hoặc nhóm xe: Khi đến gần nơi đường bộ giao nhau, xe được phép chuyển làn để đi theo hành trình mong muốn. Việc chuyển làn phải thực hiện theo đúng quy định.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/461.jpg?v=202606091805"""
    ),
    Question(
        id = 23,
        question = """Theo tín hiệu đèn, xe nào được phép đi?""",
        options = listOf("""Xe con và xe khách.""", """Xe mô tô."""),
        correctIndex = 0,
        explanation = """Xe con và xe khách đèn xanh nên được phép đi. Xe mô tô đèn đỏ dừng lại.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/499.jpg?v=202606091805"""
    ),
    Question(
        id = 24,
        question = """Xe nào được quyền đi trước trong trường hợp này?""",
        options = listOf("""Xe mô tô.""", """Xe con."""),
        correctIndex = 0,
        explanation = """Thứ tự xét xe đi: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái Xe mô tô đang trên đường ưu tiên và biển phụ ưu tiên rẽ trái qua đường ưu tiên nên được quyền đi trước.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/525.jpg?v=202606091805"""
    ),
    Question(
        id = 25,
        question = """Bạn có được phép vượt xe mô tô phía trước không?""",
        options = listOf("""Cho phép.""", """Không được vượt."""),
        correctIndex = 1,
        explanation = """Phía trước là đường ưu tiên (biển báo tam giác ngược), không được vượt mà phải nhường.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/556.jpg?v=202606091805"""
    ),
    Question(
        id = 26,
        question = """“Làn đường” là gì?""",
        options = listOf("""Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.""", """Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có đủ chiều rộng cho xe chạy an toàn.""", """Là đường cho xe ô tô chạy, dừng, đỗ an toàn."""),
        correctIndex = 1,
        explanation = """Làn đường có chiều rộng cho xe chạy an toàn""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 27,
        question = """Hành vi nào dưới đây bị nghiêm cấm?""",
        options = listOf("""Sử dụng xe đạp đi trên các tuyến quốc lộ.""", """Rải vật sắc nhọn, đổ chất gây trơn trượt trên đường bộ.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """Không cấm đi xe đạp trên quốc lộ, nhưng rải vật nhọn hoặc đổ chất gây trơn trượt gây nguy hiểm sẽ bị cấm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 28,
        question = """Các hành vi nào sau đây bị cấm đối với phương tiện tham gia giao thông đường bộ?""",
        options = listOf("""Cải tạo xe ô tô loại khác thành xe ô tô chở người phục vụ mục đích quốc phòng, an ninh.""", """Cải tạo trái phép; cố ý can thiệp làm sai lệch chỉ số trên đồng hồ báo quãng đường đã chạy của xe ô tô; cắt, hàn, tẩy xóa, đục sửa, đóng lại trái phép số khung, số động cơ của xe cơ giới, xe máy chuyên dùng."""),
        correctIndex = 1,
        explanation = """Hễ có từ :trái phép, can thiệp sai lệch, tẩy xóa, đục sửa thì chắc chắn là hành vi bị cấm. Mục đích quốc phòng, an ninh nếu được cấp phép thì không bị cấm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 29,
        question = """Khi ở một vị trí vừa có biển báo hiệu đặt cố định vừa có biển báo hiệu tạm thời mà hai biển có ý nghĩa khác nhau, người tham gia giao thông đường bộ phải chấp hành hiệu lệnh của biển báo hiệu nào?""",
        options = listOf("""Biển báo hiệu đặt cố định.""", """Biển báo hiệu tạm thời.""", """Theo quyết định của người tham gia giao thông nhưng phải bảo đảm an toàn."""),
        correctIndex = 1,
        explanation = """Biển tạm thời = Ưu tiên xử lý tình huống giao thông bất thường, nên phải chấp hành trước.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 30,
        question = """Người lái xe không được vượt xe khác khi gặp trường hợp nào dưới đây?""",
        options = listOf("""Trên cầu hẹp có một làn đường; nơi đường giao nhau, đường bộ giao nhau cùng mức với đường sắt; khi gặp xe ưu tiên.""", """Trên cầu có từ 02 làn xe trở lên.""", """Trên đường có 02 làn đường được phân chia làn bằng vạch kẻ nét đứt."""),
        correctIndex = 0,
        explanation = """Đáp án đúng là: 1, Vì đây là những tình huống tiềm ẩn nguy cơ tai nạn cao và bị cấm vượt theo luật.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 31,
        question = """Người được chở trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông đường bộ không được thực hiện hành vi nào sau đây?""",
        options = listOf("""Mang, vác vật cồng kềnh.""", """Bám, kéo hoặc đẩy các phương tiện khác.""", """Dùng tay cầm điện thoại hoặc các thiết bị điện tử khác.""", """Ý 1 và ý 2."""),
        correctIndex = 3,
        explanation = """Người ngồi sau: không vác, bám kéo phương tiện khác nhưng Được sử dụng điện thoại nhé.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 32,
        question = """Trong các trường hợp dưới đây, để bảo đảm an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào?""",
        options = listOf("""Phải đội mũ bảo hiểm theo đúng quy chuẩn kỹ thuật quốc gia và cài quai đúng quy cách, không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).""", """Phải đội mũ bảo hiểm khi trời mưa gió hoặc trời quá nắng; có thể sử dụng ô, điện thoại di động, thiết bị âm thanh nhưng phải bảo đảm an toàn.""", """Phải đội mũ bảo hiểm khi cảm thấy mất an toàn giao thông hoặc khi chuẩn bị di chuyển quãng đường xa."""),
        correctIndex = 0,
        explanation = """Đáp án đúng là: 1. Vì đây là phương án phù hợp nhất với quy định pháp luật và nguyên tắc an toàn giao thông.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 33,
        question = """Người lái xe phải nhanh chóng giảm tốc độ, đi sát lề đường bên phải hoặc dừng lại để nhường đường cho các loại xe nào dưới đây?""",
        options = listOf("""Xe chữa cháy của Cảnh sát phòng cháy, chữa cháy và cứu nạn, cứu hộ và xe chữa cháy của các lực lượng khác; xe của lực lượng quân sự, công an và kiểm sát; đoàn xe có xe Cảnh sát giao thông dẫn đường; xe cứu thương; xe hộ đê không có tín hiệu ưu tiên theo quy định.""", """Xe ưu tiên gồm xe chữa cháy của Cảnh sát phòng cháy, chữa cháy và cứu nạn, cứu hộ và xe chữa cháy của các lực lượng khác được huy động đi làm nhiệm vụ chữa cháy; xe của lực lượng quân sự, công an và kiểm sát đi làm nhiệm vụ khẩn cấp; đoàn xe có xe Cảnh sát giao thông dẫn đường; xe cứu thương đi làm nhiệm vụ cấp cứu; xe hộ đê đi làm nhiệm vụ; xe đi làm nhiệm vụ cứu nạn, cứu hộ, khắc phục sự cố thiên tai, dịch bệnh hoặc xe đi làm nhiệm vụ trong tình trạng khẩn cấp theo quy định của pháp luật; đoàn xe tang.""", """Xe ô tô, xe máy, đoàn xe đang diễu hành có tổ chức có báo tín hiệu xin vượt bằng còi và đèn."""),
        correctIndex = 1,
        explanation = """Gặp Xe ưu tiên đang làm nhiệm vụ bắt buộc phải nhường!""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 34,
        question = """Khi có xe xin vượt, người lái xe mô tô xử lý như thế nào nếu đủ điều kiện an toàn cho xe phía sau vượt?""",
        options = listOf("""Giảm tốc độ, có tín hiệu rẽ phải để báo hiệu cho người điều khiển phương tiện tham gia giao thông đường bộ phía sau biết được vượt và đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được cản trở đối với xe xin vượt.""", """Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua, không được gây trở ngại đối với xe xin vượt.""", """Tăng tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua."""),
        correctIndex = 0,
        explanation = """Xe sau xin vượt thi phải giảm tốc độ và đi sát về bên phải.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 35,
        question = """Người có giấy phép lái xe đã bị trừ hết điểm phải làm gì để phục hồi điểm giấy phép lái xe?""",
        options = listOf("""Không vi phạm pháp luật trật tự, an toàn giao thông đường bộ trong thời gian 12 tháng kể từ ngày bị trừ hết điểm.""", """Sau thời hạn ít nhất là 06 tháng kể từ ngày bị trừ hết điểm, người có phép lái xe được tham gia kiểm tra nội dung kiến thức pháp luật về trật tự, an toàn giao thông đường bộ theo quy định, có kết quả đạt yêu cầu thì được phục hồi đủ 12 điểm.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """• Phục hồi điểm: Sau khi thi lại bài kiểm tra nội dung kiến thức pháp luật giao thông đường bộ. Đây là quy định.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 36,
        question = """Khái niệm về văn hóa giao thông được hiểu như thế nào là đúng?""",
        options = listOf("""Là sự hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông, là ý thức trách nhiệm với cộng đồng khi tham gia giao thông.""", """Là sự tôn trọng, nhường nhịn, giúp đỡ và ứng xử có văn hóa giữa những người tham gia giao thông với nhau.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Đáp án đúng: 3. Vì văn hóa giao thông gồm cả ý thức pháp luật và cách ứng xử có văn hóa trên đường.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 37,
        question = """Khi điều khiển xe trên đường vòng người lái xe cần phải làm gì để bảo đảm an toàn?""",
        options = listOf("""Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng coi, đèn; giảm tốc độ tới mức cần thiết, về số thấp và thực hiện quay vòng với tốc độ phù hợp với bán kính cong của đường vòng.""", """Quan sát cẩn thận các chướng ngại vật và báo hiệu bằng còi, đèn; tăng tốc để nhanh chóng qua đường vòng và giảm tốc độ sau khi qua đường vòng."""),
        correctIndex = 0,
        explanation = """Qua đường vòng ưu tiên giảm tốc độ để đảm bảo an toàn, không nên tăng tốc vì dễ xảy ra tình huống nguy hiểm.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 38,
        question = """Tay ga trên xe mô tô hai bánh có tác dụng gì dưới đây?""",
        options = listOf("""Để điều khiển xe chạy về phía trước.""", """Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.""", """Để điều khiển xe chạy lùi.""", """Ý 1 và ý 2."""),
        correctIndex = 3,
        explanation = """Tay ga trên xe tay ga giúp điều tiết tốc độ của xe và giúp xe đi về phía trước, không có tác dụng cho xe chạy lùi.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 39,
        question = """Biển nào cấm xe rẽ trái?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Cấm rẽ trái không cấm quay đầu - Biển 2: Cấm quay đầu không cấm rẽ trái. Nên chọn biển 1.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/314.jpg?v=202606091805"""
    ),
    Question(
        id = 40,
        question = """Biển nào cấm tất cả các loại xe cơ giới và thô sơ đi lại trên đường, trừ xe ưu tiên theo luật định (nếu đường vẫn cho xe chạy được)?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Đường cấm không áp dụng với xe ưu tiên - Biển 2: Dừng lại áp dụng với tất cả các phương tiện với cả xe ưu tiên. Nên chọn biển 1.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/330.jpg?v=202606091805"""
    ),
    Question(
        id = 41,
        question = """Biển nào là biển "Tốc độ tối đa cho phép về ban đêm"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70km/h/ Biển 2: Tốc độ tối đa 50km/h.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/360.jpg?v=202606091805"""
    ),
    Question(
        id = 42,
        question = """Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?""",
        options = listOf("""Biển 1 và Biển 2.""", """Biển 1 và Biển 3.""", """Biển 2 và Biển 3.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: Giao nhau đường sắt có rào chắm - Biển 2: Báo hiệu giao nhau đường 2 chiều - Biển 3: Giao nhau đường sắt vuông góc với đường bộ. Nên chọn biển 1 và 3.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/373.jpg?v=202606091805"""
    ),
    Question(
        id = 43,
        question = """Biển nào báo hiệu "Đường hai chiều"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: Đường 2 chiều - Biển 2: Nhường đường cho xe cơ giới ngược chiều qua đường hẹp - Biển 3: Được ưu tiên qua nơi đường hẹp.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/389.jpg?v=202606091805"""
    ),
    Question(
        id = 44,
        question = """Gặp biển nào người tham gia giao thông phải đi chậm và thận trọng đề phòng khả năng xuất hiện và di chuyển bất ngờ của trẻ em trên mặt đường?""",
        options = listOf("""Biển 1.""", """Biển 2."""),
        correctIndex = 1,
        explanation = """Biển 1: Nhường đường dành cho người đi bộ - Biển 2: Báo hiệu thường có trẻ em ngang, trường học.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/411.jpg?v=202606091805"""
    ),
    Question(
        id = 45,
        question = """Biển nào báo hiệu "Hướng đi thẳng phải theo"?""",
        options = listOf("""Biển 1.""", """Biển 2"""),
        correctIndex = 0,
        explanation = """Biển 1: Biển báo hiệu lệnh hướng đi thẳng phải theo - Biển 2: Đường 1 chiều.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/433.jpg?v=202606091805"""
    ),
    Question(
        id = 46,
        question = """Biển nào chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường?""",
        options = listOf("""Biển 1.""", """Biển 2""", """Cả hai biển""", """Không biển nào."""),
        correctIndex = 0,
        explanation = """Biển 1: Người đi bộ sử dụng Cầu vượt ( đi lên là cầu vượt) - Biển 2: Người đi bộ sử dụng hầm chui ( đi xuống là hầm chui).""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/450.jpg?v=202606091805"""
    ),
    Question(
        id = 47,
        question = """Biển nào chỉ dẫn người lái xe đi được cả hai hướng?""",
        options = listOf("""Biển 1.""", """Biển 2."""),
        correctIndex = 1,
        explanation = """Biển 1: Chỉ dẫn hưỡng rẽ bên phải - Biển 2: Chỉ dẫn đi cả 2 hướng.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/474.jpg?v=202606091805"""
    ),
    Question(
        id = 48,
        question = """Theo tín hiệu đèn, xe nào đi là đúng quy tắc giao thông?""",
        options = listOf("""Xe khách, xe mô tô.""", """Xe con, xe tải.""", """Xe tải, xe mô tô."""),
        correctIndex = 1,
        explanation = """Xe con và xe tải đang trên làn đường có tín hiệu đèn xanh nên được phép đi. Đèn xanh được đi – đèn đỏ phải dừng.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/500.jpg?v=202606091805"""
    ),
    Question(
        id = 49,
        question = """Muốn vượt xe phía trước, người lái xe mô tô phải có tín hiệu như thế nào dưới đây để bảo đảm an toàn?""",
        options = listOf("""Bấm còi liên tục để xe phía trước biết xe mình xin vượt.""", """Rú ga liên tục để xe phía trước biết xe mình xin vượt.""", """Báo hiệu nhấp nháy bằng đèn chiếu sáng phía trước hoặc còi."""),
        correctIndex = 2,
        explanation = """Quy tắc vượt xe: chỉ vượt khi đủ điều kiện an toàn, có tín hiệu, giữ khoảng cách, không vượt ở cầu hẹp/đường cong/tầm nhìn hạn chế/giao cắt. Đáp án đúng mô tả đúng trình tự/tình huống an toàn: “Báo hiệu nhấp nháy bằng đèn chiếu sáng phía trước hoặc còi.”. (Câu điểm liệt – bắt buộc nắm chắc).""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 50,
        question = """Khi lái xe trong khu đông dân cư, khu vực cơ sở khám bệnh, chữa bệnh trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi trong thời gian nào?""",
        options = listOf("""Từ 22 giờ ngày hôm trước đến 05 giờ ngày hôm sau.""", """Từ 05 giờ đến 22 giờ.""", """Từ 23 giờ ngày hôm trước đến 05 giờ sáng hôm sau."""),
        correctIndex = 1,
        explanation = """Quy tắc an toàn và pháp luật cấm tuyệt đối hành vi/điều kiện nêu trong đáp án đúng: “Từ 05 giờ đến 22 giờ.”, nhằm phòng ngừa nguy hiểm và vi phạm. Các đáp án còn lại không bao trùm đầy đủ hoặc không phù hợp.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 51,
        question = """Khổ giới hạn của đường bộ được hiểu như thế nào là đúng?""",
        options = listOf("""Khổ giới hạn của đường bộ là khoảng trống có kích thước giới hạn về chiều rộng, chiều cao của đường bộ để các xe, bao gồm cả hàng hoá xếp trên xe đi qua được an toàn và được xác định theo quy chuẩn, tiêu chuẩn kỹ thuật của đường bộ.""", """Là khoảng trống có kích thước giới hạn về chiều rộng của đường, cầu, bến phà, hầm trên đường bộ để các xe kể cả hàng hóa xếp trên xe đi qua được an toàn.""", """Là khoảng trống có kích thước giới hạn về chiều cao của cầu, bến phà, hầm trên đường bộ để các xe đi qua được an toàn."""),
        correctIndex = 0,
        explanation = """Khổ giới hạn của đường bộ là khoảng trống có kích thước giới hạn về chiều rộng, chiều cao.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 52,
        question = """Người điều khiển giao thông đường bộ được hiểu như thế nào là đúng?""",
        options = listOf("""Là người điều khiển phương tiện tham gia giao thông đường bộ.""", """Là Cảnh sát giao thông và người được giao nhiệm vụ hướng dẫn giao thông trên đường bộ.""", """Là người tham gia giao thông đường bộ."""),
        correctIndex = 1,
        explanation = """Cảnh sát giao thông điều phối luồng xe ngoài đường.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 53,
        question = """Hành vi nào sau đây bị cấm?""",
        options = listOf("""Lắp đặt, sử dụng thiết bị âm thanh, ánh sáng trên xe cơ giới, xe máy chuyên dùng gây mất trật tự, an toàn giao thông đường bộ.""", """Cản trở người, phương tiện tham gia giao thông trên đường bộ; ném gạch, đất, đá, cát hoặc vật thể khác vào người, phương tiện đang tham gia giao thông trên đường bộ.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Cả đáp 1 và 2 đều là hành vi bị nghiêm cấm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 54,
        question = """Tại nơi đường giao nhau, khi đèn điều khiển giao thông có tín hiệu màu vàng, người điều khiển phương tiện tham gia giao thông phải chấp hành như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Dừng lại trước vạch dừng; trường hợp đang đi trên vạch dừng hoặc đã đi qua vạch dừng mà tín hiệu đèn màu vàng thì được đi tiếp; trường hợp tín hiệu đèn màu vàng nhấp nháy, người điều khiển phương tiện tham gia giao thông đường bộ được đi nhưng phải quan sát, giảm tốc độ hoặc dừng lại nhường đường cho người đi bộ, xe lăn của người khuyết tật qua đường hoặc các phương tiện khác.""", """Tăng tốc độ nhanh chóng vượt qua nút giao.""", """Quan sát, giảm tốc độ, từ từ vượt qua nút giao."""),
        correctIndex = 0,
        explanation = """Tín hiệu đèn vàng có hai trường hợp, một là đèn tín hiệu giao thông đỏ vàng xanh nếu chuyển qua giây vàng mà lỡ qua vạch dừng thì đi tiếp. Còn lại là tín hiệu vàng nhấp nháy báo đi chậm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 55,
        question = """Khi điều khiển phương tiện tham gia giao thông, hành vi nào sau đây bị cấm?""",
        options = listOf("""Dùng tay cầm và sử dụng điện thoại hoặc thiết bị điện tử khác.""", """Chỉ được chở người trên thùng xe ô tô chở hàng trong trường hợp chở người đi làm nhiệm vụ cứu nạn, cứu hộ, phòng, chống thiên tai, dịch bệnh hoặc thực hiện nhiệm vụ khẩn cấp."""),
        correctIndex = 0,
        explanation = """Đáp án 1 là đúng vì Hành vi sử dụng điện thoại khi tham gia giao thông là bị nghiêm cấm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 56,
        question = """Người được chở trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông đường bộ có được bám, kéo hoặc đẩy các phương tiện khác không?""",
        options = listOf("""Được phép.""", """Được bám trong trường hợp phương tiện của mình bị hỏng.""", """Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng.""", """Không được phép."""),
        correctIndex = 3,
        explanation = """Không được phép đẩy kéo các phương tiện khác.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 57,
        question = """Thứ tự xuống phà như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe thô sơ, người đi bộ xuống trước, xe cơ giới, xe máy chuyên dùng xuống sau.""", """Xe cơ giới, xe máy chuyên dùng xuống trước, xe thô sơ, người đi bộ xuống sau.""", """Xe cơ giới, xe thô sơ xuống trước, xe máy chuyên dùng, người đi bộ xuống sau."""),
        correctIndex = 1,
        explanation = """Khi xuống phà, xe cơ giới, xe máy chuyên dùng xuống trước, xe thô sơ, người đi bộ xuống sau; khi lên bến, người đi bộ lên trước, các phương tiện giao thông đường bộ lên sau theo hướng dẫn của người điều khiển giao thông. Đây là quy định hiện hành.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 58,
        question = """Khi có tín hiệu của xe ưu tiên, người và phương tiện tham gia giao thông đường bộ phải tuân thủ quy định nào dưới đây?""",
        options = listOf("""Giảm tốc độ, đi sát lề đường bên phải hoặc dừng lại để nhường đường.""", """Tăng tốc độ và đi sát lề đường bên phải để nhường đường.""", """Giảm tốc độ, đi sát lề đường bên trái để nhường đường."""),
        correctIndex = 0,
        explanation = """Gặp xe ưu tiên đang phát tín hiệu ưu tiên, các phương tiện bắt buộc phải Giảm tốc độ, đi sát lề đường bên phải hoặc dừng lại để nhường đường.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 59,
        question = """Những trường hợp nào dưới đây không được đi trên đường cao tốc, trừ người, phương tiện giao thông đường bộ và thiết bị phục vụ việc quản lý, bảo trì đường cao tốc?""",
        options = listOf("""Xe máy chuyên dùng có tốc độ thiết kế nhỏ hơn tốc độ tối thiểu quy định đối với đường cao tốc, xe chở người bốn bánh có gắn động cơ, xe chở hàng bốn bánh có gắn động cơ, xe mô tô, xe gắn máy, các loại xe tương tự xe mô tô, xe gắn máy, xe thô sơ, người đi bộ.""", """Xe máy chuyên dùng có tốc độ thiết kế lớn hơn tốc độ tối thiểu quy định đối với đường cao tốc.""", """Xe ô tô và xe máy chuyên dùng có tốc độ thiết kế lớn hơn 80 km/h."""),
        correctIndex = 0,
        explanation = """Đáp án đúng: 1. Vì đây là tập hợp đầy đủ và chính xác các phương tiện và đối tượng không được phép đi vào đường cao tốc theo luật.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 60,
        question = """Trách nhiệm của tổ chức, cá nhân đứng tên trong giấy chứng nhận đăng ký xe khi chưa thực hiện thu hồi chứng nhận đăng ký xe, biển số xe được quy định như thế nào?""",
        options = listOf("""Tiếp tục chịu trách nhiệm của chủ xe.""", """Không chịu trách nhiệm sau khi đã chuyển nhượng, trao đổi, tặng, cho."""),
        correctIndex = 0,
        explanation = """Chưa sang tên – Trách nhiệm còn nguyên. Muốn hết trách nhiệm → Phải thu hồi biển số và đăng ký xe theo đúng thủ tục. Đáp án 1 là đúng.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 61,
        question = """Người lái xe không điều khiển xe đi đúng làn đường quy định, phóng nhanh, vượt ẩu, vượt đèn đỏ, đi vào đường cấm được coi là hành vi nào trong các hành vi dưới đây?""",
        options = listOf("""Là thiếu văn hóa giao thông, vi phạm pháp luật về trật tự, an toàn giao thông đường bộ.""", """Là thiếu văn hóa giao thông."""),
        correctIndex = 0,
        explanation = """Các hành vi trên không chỉ là hành vi thiếu văn hóa giao thông mà còn gây mất an toàn giao thông đường bộ, vi phạm pháp luật.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 62,
        question = """Khi điều khiển xe qua đường sắt, người lái xe cần phải thực hiện các thao tác nào dưới đây để bảo đảm an toàn?""",
        options = listOf("""Khi có chuông báo hoặc thanh chắn đã hạ xuống, người lái xe phải dừng xe tạm thời đúng khoảng cách an toàn, kéo phanh tay nếu đường dốc hoặc phải chờ lâu""", """Khi không có chuông báo hoặc thanh chắn không hạ xuống, người lái xe cần phải quan sát nếu thấy đủ điều kiện an toàn thì về số thấp, tăng ga nhẹ và không thay đổi số trong quá trình vượt qua đường sắt để tránh động cơ chết máy cho xe cho vượt qua.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Cả hai đáp án tương ứng với 2 tình huống đều tuân theo quy tắc đảm bảo an toàn khi qua đường sắt, đúng với Luật Trật tự, an toàn giao thông đường bộ hiện hành.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 63,
        question = """Gương chiếu hậu của xe mô tô hai bánh có tác dụng gì dưới đây?""",
        options = listOf("""Để quan sát an toàn phía bên trái khi chuẩn bị rẽ trái.""", """Để quan sát an toàn phía bên phải khi chuẩn bị rẽ phải.""", """Để quan sát an toàn phía sau của bên trái và bên phải trước khi chuyển hướng.""", """Để quan sát an toàn phía trước cả bên trái và bên phải trước khi chuyển hướng."""),
        correctIndex = 2,
        explanation = """Chiếu hậu có nghĩa là phía sau, gương chiếu hậu sẽ giúp bạn quan sát được phía sau cả bên phải lẫn bên trái.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 64,
        question = """Biển nào xe được phép rẽ trái?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Không biển nào."""),
        correctIndex = 1,
        explanation = """Biển 1: cấm rẽ trái được quay đầu - Biển 2: cấm quay đầu được rẽ trái.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/322.jpg?v=202606091805"""
    ),
    Question(
        id = 65,
        question = """Biển báo này có ý nghĩa như thế nào?""",
        options = listOf("""Tốc độ tối đa cho phép về ban đêm cho các phương tiện là 70 km/h.""", """Tốc độ tối thiểu cho phép về ban đêm cho các phương tiện là 70 km/h."""),
        correctIndex = 0,
        explanation = """Biển báo có viền đỏ tương ứng với loại biển báo cấm, kèm theo ghi chú thêm 70 (có nghĩa là 70km/h), có ý nghĩa là không được vượt quá con số đó –> tối đa chỉ tới 70km/h.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/335.jpg?v=202606091805"""
    ),
    Question(
        id = 66,
        question = """Biển nào báo hiệu hạn chế tốc độ của phương tiện không vượt quá trị số ghi trên biển?""",
        options = listOf("""Biển 1.""", """Biển 2."""),
        correctIndex = 1,
        explanation = """Biển 1: Biển báo tốc độ tối thiểu - Biển 2: Biển báo tốc độ tối đa.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/362.jpg?v=202606091805"""
    ),
    Question(
        id = 67,
        question = """Biển nào báo hiệu đường bộ giao nhau với đường sắt không có rào chắn?""",
        options = listOf("""Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: Giao nhau với đường sát có rào chắn - Biển 2: Giao nhau với đường sắt không rào chắn - Biển 3: Nơi đường sắt giao vuông góc với đường bộ.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/374.jpg?v=202606091805"""
    ),
    Question(
        id = 68,
        question = """Biển nào báo hiệu phải giảm tốc độ, nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp?""",
        options = listOf("""Biển 1.""", """Biển 2""", """Biển 3"""),
        correctIndex = 1,
        explanation = """Biển 1: Đường 2 chiều - Biển 2: Giảm tốc độ nhường đường cho xe cơ giới đi ngược chiều - Biển 3: Được ưu tiên qua nơi đường hẹp.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/390.jpg?v=202606091805"""
    ),
    Question(
        id = 69,
        question = """Biển nào chỉ dẫn nơi bắt đầu đoạn đường dành cho người đi bộ?""",
        options = listOf("""Biển 1""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: Nhường đường dành cho người đi bộ - Biển 2: Bắt đầu đoạn đường dành (màu xanh) cho người đi bộ - Biển 3: Báo hiệu có trẻ em cắt ngang qua.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/412.jpg?v=202606091805"""
    ),
    Question(
        id = 70,
        question = """Biển nào báo hiệu "Đường một chiều"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 1,
        explanation = """Biển 1: Hướng đi thẳng phải theo (hình tròn nền xanh phải theo) - Biển 2: Đường 1 chiều. (Một = mập, chọn mũi tên mập hơn) hơn là chọn)""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/434.jpg?v=202606091805"""
    ),
    Question(
        id = 71,
        question = """Biển nào chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển.""", """Không biển nào."""),
        correctIndex = 1,
        explanation = """Hầm chui đi xuống, cầu vượt đi lên.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/451.jpg?v=202606091805"""
    ),
    Question(
        id = 72,
        question = """Người lái xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy không được thực hiện các hành vi nào sau đây?""",
        options = listOf("""Đi xe dàn hàng ngang; đi xe vào phần đường dành cho người đi bộ và phương tiện khác.""", """Sử dụng ô, thiết bị âm thanh, trừ thiết bị trợ thính.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Chọn đáp án đúng “Cả hai ý trên.” vì phù hợp với quy tắc/định nghĩa chính thức của Luật GTĐB và quy chuẩn báo hiệu. Các lựa chọn khác thiếu, sai hoặc trái quy tắc. (Câu điểm liệt – bắt buộc nắm chắc).""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 73,
        question = """Theo tín hiệu đèn, xe nào đi là đúng quy tắc giao thông?""",
        options = listOf("""Xe khách, xe mô tô.""", """Xe con, xe tải.""", """Xe tải, xe mô tô."""),
        correctIndex = 1,
        explanation = """Xe con và xe tải đang trên làn đường có tín hiệu đèn xanh nên được phép đi. Đèn xanh được đi – đèn đỏ phải dừng.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/500.jpg?v=202606091805"""
    ),
    Question(
        id = 74,
        question = """Xe nào vi phạm quy tắc giao thông?""",
        options = listOf("""Xe khách.""", """Xe mô tô.""", """Xe con.""", """Xe con và xe mô tô."""),
        correctIndex = 2,
        explanation = """Vạch màu vàng nét liền không được đè. Xe con quay đầu đè vạch vàng nên sai.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/527.jpg?v=202606091805"""
    ),
    Question(
        id = 75,
        question = """Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông?""",
        options = listOf("""Xe mô tô.""", """Xe ô tô con.""", """Không xe nào vi phạm.""", """Cả hai xe."""),
        correctIndex = 3,
        explanation = """Biển báo hiệu lệnh hướng đi thẳng: nhưng xe con phát tín hiệu rẽ trái, xe mô tô rẽ phải nên sai cả 2 xe.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/559.jpg?v=202606091805"""
    ),
    Question(
        id = 76,
        question = """Dải phân cách được lắp đặt để làm gì?""",
        options = listOf("""Để phân chia các làn đường dành cho xe cơ giới và xe thô sơ trên đường cao tốc.""", """Để phân chia phần đường xe chạy thành hai chiều riêng biệt hoặc để phân chia phần đường dành cho xe cơ giới và xe thô sơ hoặc của nhiều loại xe khác nhau trên cùng một chiều đường.""", """Để phân tách phần đường xe chạy và hành lang an toàn giao thông."""),
        correctIndex = 1,
        explanation = """Dải phân cách để phân chia 2 chiều xe chạy riêng biệt.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 77,
        question = """Người điều khiển phương tiện tham gia giao thông đường bộ gồm những đối tượng nào dưới đây?""",
        options = listOf("""Người điều khiển xe cơ giới, người điều khiển xe thô sơ.""", """Người điều khiển xe máy chuyên dùng.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Người điều khiển phương tiện giao thông gồm cả xe cơ giới và xe máy chuyên dùng.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 78,
        question = """Việc sản xuất, sử dụng, mua, bán trái phép biển số xe có bị nghiêm cấm hay không?""",
        options = listOf("""Không bị nghiêm cấm.""", """Bị nghiêm cấm.""", """Bị nghiêm cấm tuỳ trường hợp."""),
        correctIndex = 1,
        explanation = """Biển số xe là tài sản do cơ quan nhà nước có thẩm quyền cấp phát, việc làm giả, mua bán, sử dụng trái phép biển số bị nghiêm cấm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 79,
        question = """Người lái xe trên đường cần chấp hành quy định về tốc độ tối đa như thế nào?""",
        options = listOf("""Chỉ lớn hơn tốc độ tối đa cho phép khi đường vắng.""", """Chỉ lớn hơn tốc độ tối đa cho phép khi vào ban đêm.""", """Không vượt quá tốc độ tối đa cho phép."""),
        correctIndex = 2,
        explanation = """Không được vượt quá tốc độ cho phép.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 80,
        question = """Người lái xe sử dụng đèn như thế nào khi đi trên các đoạn đường qua khu đông dân cư có hệ thống chiếu sáng đang hoạt động?""",
        options = listOf("""Chỉ bật đèn chiếu xa (đèn pha).""", """Bật đèn chiếu xa (đèn pha) khi đường vắng, bật đèn chiếu gần (đèn cốt) khi có xe đi ngược chiều.""", """Chỉ bật đèn chiếu gần (đèn cốt)."""),
        correctIndex = 2,
        explanation = """Trong khu đông dân cư chỉ bật đèn chiếu gần (đèn cốt), tránh bật đèn pha gây ảnh hưởng người đối diện.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 81,
        question = """Người lái xe, người được chở trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy phải thực hiện quy định nào dưới đây?""",
        options = listOf("""Đội mũ bảo hiểm theo đúng quy chuẩn kỹ thuật quốc gia và cài quai đúng quy cách.""", """Người lái xe phải đội mũ bảo hiểm, người được chở trên xe không nhất thiết phải đội mũ bảo hiểm.""", """Phải đội mũ bảo hiểm nhưng không nhất thiết phải cài quai."""),
        correctIndex = 0,
        explanation = """Cứ đi xe mô tô, xe gắn máy: Phải đội mũ (), + cài quai = đúng luật.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 82,
        question = """Khi lái xe trong đô thị và khu đông dân cư trong thời gian từ 22 giờ ngày hôm trước đến 05 giờ ngày hôm sau, nếu cần vượt một xe khác, người lái xe phải báo hiệu như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Chỉ được báo hiệu bằng còi.""", """Phải báo hiệu bằng cả còi và đèn.""", """Chỉ được báo hiệu bằng đèn."""),
        correctIndex = 2,
        explanation = """Còi 5 đến 22 – Đêm ngủ yên, “Còi thì chỉ bấm ban ngày, 5 giờ sáng đến 10 giờ tối, ban đêm để người ta ngủ thôi!”""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 83,
        question = """Khi đang lái xe, phía trước có một xe Cảnh sát giao thông không phát tín hiệu ưu tiên, người lái xe có được phép vượt hay không?""",
        options = listOf("""Không được vượt.""", """Được phép vượt ở phần đường dành cho người đi bộ qua đường.""", """Được vượt khi bảo đảm an toàn."""),
        correctIndex = 2,
        explanation = """Xe ưu tiên không có tín hiệu → không có quyền ưu tiên.➡ Đáp án có chữ “bảo đảm an toàn” thường là đáp án đúng nếu không có cấm rõ ràng.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 84,
        question = """Theo quy định về độ tuổi, người đủ bao nhiêu tuổi trở lên thì được cấp giấy phép lái xe mô tô hai bánh có dung tích xi lanh đến 125 cm3 và xe ô tô chở người đến 8 chỗ (không kể chỗ của người lái xe); xe ô tô tải và ô tô chuyên dùng có khối lượng toàn bộ theo thiết kế đến 3.500 kg?""",
        options = listOf("""16 tuổi.""", """17 tuổi""", """18 tuổi."""),
        correctIndex = 2,
        explanation = """👉18 tuổi – A1, B, C1. Đủ 18 tuổi là đủ điều kiện thi và được cấp bằng lái xe mô tô đến 125 cm³ và ô tô đến 8 chỗ hoặc tải trọng đến 3.500 kg.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 85,
        question = """Trên đường bộ, trong khu vực đông dân cư, đường đôi hoặc đường một chiều có từ hai làn xe cơ giới trở lên, xe mô tô hai bánh, ô tô chở người đến 28 chỗ không kể chỗ của người lái xe tham gia giao thông với tốc độ khai thác tối đa cho phép là bao nhiêu?""",
        options = listOf("""60 km/h.""", """50 km/h.""", """40 km/h."""),
        correctIndex = 0,
        explanation = """Trong khu vực đông dân cư: Đường đôi có 2 làn đường: 60km/h - Đường 1 chiều có 1 làn đường: 50km/h.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 86,
        question = """Người lái xe có văn hóa giao thông khi tham gia giao thông đường bộ phải đáp ứng các điều kiện nào dưới đây?""",
        options = listOf("""Hiểu biết và chấp hành nghiêm chỉnh pháp luật về giao thông đường bộ; có ý thức trách nhiệm với cộng đồng khi tham gia giao thông; tôn trọng, nhường nhịn,giúp đỡ và ứng xử có văn hóa với những người cùng tham gia giao thông.""", """Điều khiển xe vượt quá tốc độ, đi không đúng làn đường."""),
        correctIndex = 0,
        explanation = """👉 Có văn hóa – Là phải hiểu luật, nhường nhịn và ứng xử đúng mực.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 87,
        question = """Trong các loại nhiên liệu dưới đây, loại nhiên liệu nào giảm thiểu ô nhiễm môi trường?""",
        options = listOf("""Xăng và dầu diesel.""", """Xăng sinh học và khí sinh học.""", """Ý 1 và ý 2."""),
        correctIndex = 1,
        explanation = """Cứ sinh học – là sạch môi trường.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 88,
        question = """Để bảo đảm an toàn khi tham gia giao thông, người lái xe mô tô hai bánh cần điều khiển tay ga như thế nào?""",
        options = listOf("""Tăng ga thật mạnh, giảm ga từ từ.""", """Tăng ga thật mạnh, giảm ga thật nhanh.""", """Tăng ga từ từ, giảm ga thật nhanh.""", """Tăng ga từ từ, giảm ga từ từ."""),
        correctIndex = 2,
        explanation = """Cách điều khiển tay ga an toàn: tăng ga từ từ, giảm ga thật nhanh.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 89,
        question = """Biển nào cấm các phương tiện rẽ phải?""",
        options = listOf("""Biển 1 và 2.""", """Biển 1 và 3.""", """Biển 2 và 3.""", """Cả ba biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Cấm các phương tiện rẽ phải - Biển 2: Cấm các phương tiện rẽ phải và quay đầu - Biển 3: Cấm xe ô tô rẽ phải và quay đầu - Nên chọn biển 1 và biển 2.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/317.jpg?v=202606091805"""
    ),
    Question(
        id = 90,
        question = """Biển này có hiệu lực đối với xe mô tô hai bánh, ba bánh chở hàng không?""",
        options = listOf("""Có.""", """Không."""),
        correctIndex = 0,
        explanation = """Cấm 2 bánh và 4 bánh cấm luôn cả 3 bánh.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/345.jpg?v=202606091805"""
    ),
    Question(
        id = 91,
        question = """Số 50 ghi trên biển báo dưới đây có ý nghĩa như thế nào?""",
        options = listOf("""Tốc độ tối đa các xe cơ giới được phép chạy.""", """Tốc độ tối thiểu các xe cơ giới được phép chạy."""),
        correctIndex = 0,
        explanation = """Biển tròn viền đỏ là biển báo cấm, kèm chú thích con số bên trong. Đây là con số không được vượt quá (tối đa).""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/364.jpg?v=202606091805"""
    ),
    Question(
        id = 92,
        question = """Biển nào báo hiệu sắp đến chỗ giao nhau giữa đường bộ và đường sắt?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả 1 và biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: Giao nhau đường sắt không rào chắn - Biển 2: Giao nhau với đường ưu tiên - Biển 3: Giao nhau với tàu điện.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/375.jpg?v=202606091805"""
    ),
    Question(
        id = 93,
        question = """Biển nào chỉ dẫn "Được ưu tiên qua đường hẹp"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả 2 và biển 3."""),
        correctIndex = 2,
        explanation = """Biển 1: Đường 2 chiều - Biển 2: Giảm tốc độ nhường đường cho xe cơ giới đi ngược chiều - Biển 3: Được ưu tiên qua nơi đường hẹp.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/391.jpg?v=202606091805"""
    ),
    Question(
        id = 94,
        question = """Biển nào dưới đây báo hiệu gần đến đoạn đường thường có trẻ em đi ngang qua?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: Nhường đường cho người đi bộ - Biển 2: Có trẻ em đi ngang qua - Biển 3: Đường người đi xe đạp cắt qua.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/413.jpg?v=202606091805"""
    ),
    Question(
        id = 95,
        question = """Trong các biển dưới đây biển nào là biển "Hết tốc độ tối đa cho phép"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Hết hạn chế tốc độ tối đa cho phép - Biển 2: Hết mọi lệnh cấm - Biển 3: Hết hạn chế tốc độ tối thiểu.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/435.jpg?v=202606091805"""
    ),
    Question(
        id = 96,
        question = """Biển nào báo hiệu "Nơi đỗ xe dành cho người khuyết tật"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: Đường dành cho xe thô sơ - Biển 2: Nơi đỗ xe dành cho người khuyết tật - Biển 3: Dành cho người đi bộ.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/452.jpg?v=202606091805"""
    ),
    Question(
        id = 97,
        question = """Vạch mũi tên chỉ hướng trên mặt đường nào dưới đây cho phép xe chỉ được đi thẳng và rẽ phải?""",
        options = listOf("""Vạch 1.""", """Vạch 2 và vạch 3.""", """Vạch 3.""", """Vạch 1 và vạch 2."""),
        correctIndex = 2,
        explanation = """Vạch 1: rẽ phải - Vạch 2: đi thẳng và rẽ trái - Vạch 3: đi thẳng và rẽ phải.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/476.jpg?v=202606091805"""
    ),
    Question(
        id = 98,
        question = """Theo hướng mũi tên, thứ tự các xe đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe khách, xe tải, xe mô tô, xe con.""", """Xe con, xe khách, xe tải, xe mô tô.""", """Xe mô tô, xe tải, xe khách, xe con.""", """Xe mô tô, xe tải, xe con, xe khách."""),
        correctIndex = 2,
        explanation = """Tại vòng xuyến không có biển báo nhường xe đi bên phải ( có biển báo nhường xe đi bên trái) Thứ tự: Xe mô tô – xe tải – xe khách – xe con.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/504.jpg?v=202606091805"""
    ),
    Question(
        id = 99,
        question = """Theo hướng mũi tên, xe nào được phép đi?""",
        options = listOf("""Xe mô tô, xe con.""", """Xe con, xe tải.""", """Xe mô tô, xe tải.""", """Cả ba xe."""),
        correctIndex = 2,
        explanation = """Gặp CSGT ưu tiên chọn đáp án 3, trừ trường hợp CSGT đừng trên bục giơ 2 tay sẽ chọn đáp án 4.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/529.jpg?v=202606091805"""
    ),
    Question(
        id = 100,
        question = """Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?""",
        options = listOf("""Xe con, xe tải, xe khách.""", """Xe tải, xe khách, xe mô tô.""", """Xe khách, xe mô tô, xe con.""", """Cả bốn xe."""),
        correctIndex = 1,
        explanation = """Hướng mũi tên đỏ xe đang di chuyển, không có mũi tên đỏ là đang dừng. Xe con trên làn rẽ phải có tín hiệu đèn xanh– rẽ phải đúng -> Xe tải trên làn đi thẳng có tín hiệu đèn đỏ dừng lại nhưng đi thẳng là sai -> Xe khách trên làn rẽ trái có tín hiệu đèn xanh nhưng đi thẳng sai -> Xe mô tô trên làn có tín hiệu đỏ dừng lại nhưng đi thẳng là sai.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/562.jpg?v=202606091805"""
    ),
    Question(
        id = 101,
        question = """Vạch kẻ đường là gì?""",
        options = listOf("""Là báo hiệu đường bộ để hỗ trợ cảnh báo nguy hiểm cho người tham gia giao thông đường bộ.""", """Là vạch chỉ sự phân chia làn đường, vị trí hoặc hướng đi, vị trí dừng lại.""", """Là báo hiệu cho người tham gia giao thông đường bộ về các thông tin của đường bộ.""", """Cả ba ý trên."""),
        correctIndex = 1,
        explanation = """Câu hỏi có chữ Vạch thì chọn đáp án có chữ Vạch đầu câu""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 102,
        question = """Hành vi đưa xe cơ giới, xe máy chuyên dùng tham gia giao thông đường bộ nào dưới đây bị cấm?""",
        options = listOf("""Không có chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường.""", """Hết niên hạn sử dụng.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Xe không kiểm định hoặc quá hạn = cấm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 103,
        question = """Khi điều khiển phương tiện tham gia giao thông, những hành vi nào dưới đây bị nghiêm cấm?""",
        options = listOf("""Thay đổi tốc độ của xe nhiều lần.""", """Điều khiển phương tiện sau 23 giờ trong ngày.""", """Lạng lách, đánh võng, rú ga liên tục."""),
        correctIndex = 2,
        explanation = """Các hành vi như lạng lách, đánh võng, rú ga là đặc trưng của việc phá hoại trật tự an toàn giao thông → luôn chọn là hành vi bị cấm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 104,
        question = """Phương tiện tham gia giao thông đường bộ di chuyển với tốc độ thấp hơn phải đi như thế nào?""",
        options = listOf("""Đi về bên trái theo chiều đi của mình.""", """Đi về bên phải theo chiều đi của mình.""", """Đi ở bất cứ bên nào nhưng phải bấm đèn cảnh báo nguy hiểm để báo hiệu cho các phương tiện khác."""),
        correctIndex = 1,
        explanation = """Chậm (nhường) phải, nhanh (vượt) trái ➡ Nhớ câu nói này để dễ dàng chọn đáp án đúng khi hỏi về vị trí di chuyển của phương tiện tốc độ thấp.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 105,
        question = """Nơi nào cấm quay đầu xe?""",
        options = listOf("""Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, gầm cầu vượt, ngầm.""", """Tại nơi đường bộ giao nhau cùng mức với đường sắt, đường hẹp, đường dốc, đoạn đường cong tầm nhìn bị che khuất, trên đường cao tốc, trong hầm đường bộ, trên đường một chiều.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Cấm quay đầu xe trên cầu và trong hầm, đây là quy định.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 106,
        question = """Người lái xe mô tô hai bánh, xe gắn máy được phép chở tối đa hai người trong những trường hợp nào?""",
        options = listOf("""Chở người bệnh đi cấp cứu; áp giải người có hành vi vi phạm pháp luật; trẻ em dưới 12 tuổi; người già yếu hoặc người khuyết tật.""", """Người đã uống rượu, bia; người trong cơ thể có chất ma tuý.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Chở 2 khi thật cần: áp giải, người bệnh, trẻ nhỏ, người yếu. ➡ Nhớ kỹ những trường hợp đặc biệt cho phép chở 2 người.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 107,
        question = """Khi điều khiển xe chạy trên đường, biết có xe sau xin vượt, nếu đủ điều kiện an toàn người điều khiển phương tiện phải làm gì?""",
        options = listOf("""Tăng tốc độ và ra hiệu cho xe sau vượt, không được gây trở ngại cho xe xin vượt.""", """Giảm tốc độ, có tín hiệu rẽ phải để báo hiệu cho người điều khiển phương tiện tham gia giao thông đường bộ phía sau biết được vượt và đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được cản trở đối với xe xin vượt.""", """Cho xe đi sát về bên trái của phần đường xe chạy và ra hiệu cho xe sau vượt, không được gây trở ngại cho xe xin vượt."""),
        correctIndex = 1,
        explanation = """Chậm (nhường) phải, nhanh (vượt) trái ➡ Nhớ câu nói này để dễ dàng chọn đáp án đúng khi hỏi về vị trí di chuyển của phương tiện tốc độ thấp""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 108,
        question = """Khi đang lái xe, phía trước có một xe cứu thương đang phát tín hiệu ưu tiên, người lái xe có được phép vượt hay không?""",
        options = listOf("""Không được vượt.""", """Được vượt khi đang đi trên cầu.""", """Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.""", """Được vượt khi bảo đảm an toàn."""),
        correctIndex = 0,
        explanation = """Gặp Xe ưu tiên đang làm nhiệm vụ bắt buộc phải nhường, không được vượt.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 109,
        question = """Người đủ 16 tuổi đến dưới 18 tuổi chỉ được điều khiển các loại xe nào dưới đây?""",
        options = listOf("""Xe mô tô hai bánh có dung tích xi-lanh đến 125 cm3.""", """Xe gắn máy.""", """3. Xe ô tô chở người đến 08 chỗ (không kể chỗ của người lái xe); xe ô tô tải và ô tô chuyên dùng có khối lượng toàn bộ theo thiết kế đến 3.500 kg; các loại xe ô tô quy định cho giấy phép lái xe hạng B kéo rơ moóc có khối lượng toàn bộ theo thiết kế đến 750 kg.""", """Cả ba ý trên."""),
        correctIndex = 1,
        explanation = """16 - dưới 18 tuổi chỉ được điều khiển xe gắn máy.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 110,
        question = """Trên đường bộ (trừ đường cao tốc) trong khu vực đông dân cư, đường hai chiều hoặc đường một chiều có một làn xe cơ giới, xe mô tô hai bánh, ô tô chở người đến 28 chỗ không kể chỗ của người lái xe tham gia giao thông với tốc độ khai thác tối đa cho phép là bao nhiêu?""",
        options = listOf("""60 km/h.""", """50 km/h.""", """40 km/h."""),
        correctIndex = 1,
        explanation = """Trong khu vực đông dân cư: Đường đôi có 2 làn đường: 60km/h - Đường 1 chiều có 1 làn đường: 50km/h.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 111,
        question = """Người lái xe mô tô có văn hóa giao thông khi tham gia giao thông phải tuân thủ những quy định nào dưới đây?""",
        options = listOf("""Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; đội mũ bảo hiểm đúng quy chuẩn kỹ thuật quốc gia, cài quai đúng quy cách.""", """Điều khiển xe đi trên phần đường, làn đường có ít phương tiện tham gia giao thông.""", """Điều khiển xe và đội mũ bảo hiểm ở nơi có biển báo bắt buộc đội mũ bảo hiểm."""),
        correctIndex = 0,
        explanation = """Đi đúng làn, bên phải, mũ bảo hiểm chuẩn ➡ Câu trả lời đầy đủ nhất, đầy đủ các quy định cơ bản về văn hóa giao thông.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 112,
        question = """Các biện pháp tiết kiệm nhiên liệu khi chạy xe?""",
        options = listOf("""Bảo dưỡng xe theo định kỳ và có kế hoạch lộ trình trước khi xe chạy.""", """Kiểm tra áp suất lốp theo quy định và chạy xe với tốc độ phù hợp với tình trạng mặt đường và mật độ giao thông trên đường.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Chăm xe tốt + chạy hợp lý = tiết kiệm nhiên liệu. Nên chọn cả hai ý trên.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 113,
        question = """Để tránh đổ, ngã khi điều khiển xe mô tô hai bánh ở nơi đường xấu, nhỏ và hẹp, người lái xe cần xử lý như thế nào?""",
        options = listOf("""Đi ở tốc độ thấp, quan sát liên tục khoảng cách từ 05 m đến 10 m phía trước để điều chỉnh sớm hướng di chuyển.""", """Trong quá trình di chuyển không nên dùng phanh trước tránh làm khóa bánh dẫn hướng.""", """Không được lắc người sang trái hoặc phải nhiều, trọng tâm cơ thể cần trùng với trọng tâm của xe.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Đi chậm, quan sát sớm, phanh nhẹ, giữ cân bằng -> bình tĩnh xử lý để đảm bảo an toàn.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 114,
        question = """Biển nào cấm các phương tiện rẽ trái?""",
        options = listOf("""Biển 1 và 2.""", """Biển 1 và 3.""", """Biển 2 và 3.""", """Cả ba biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Cấm các phương tiện rẽ trái - Biển 2: Cấm các phương tiện rẽ trái và quay đầu - Biển 3: Cấm xe ô tô rẽ trái và quay đầu.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/318.jpg?v=202606091805"""
    ),
    Question(
        id = 115,
        question = """Biển này có ý nghĩa như thế nào?""",
        options = listOf("""Cấm xe cơ giới (trừ xe ưu tiên theo luật định) đi thẳng.""", """Cấm các loại xe cơ giới và xe mô tô (trừ xe ưu tiên theo luật định) đi về bên trái và bên phải.""", """Hướng trái và phải không cấm xe cơ giới."""),
        correctIndex = 1,
        explanation = """Thứ nhất: Đây là loại biển báo cấm kèm chú thích xe ô tô (xe cơ giới) và xe mô tô (có người ngồi trên). Thứ 2, biển phụ chỉ định hai chiều trái phải. Vì thế chọn đáp án 2.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/346.jpg?v=202606091805"""
    ),
    Question(
        id = 116,
        question = """Biển báo dưới đây có ý nghĩa như thế nào?""",
        options = listOf("""Báo hiệu tốc độ tối đa cho phép các xe cơ giới chạy.""", """Báo hiệu tốc độ tối thiểu cho phép các xe cơ giới chạy."""),
        correctIndex = 1,
        explanation = """Đây là biển báo hiệu lệnh đi kèm số chỉ định, thể hiện rằng người lái xe cần duy trì tốc độ từ 60 trở lên -> biển báo tốc độ tối thiểu.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/366.jpg?v=202606091805"""
    ),
    Question(
        id = 117,
        question = """Biển nào báo hiệu "Cửa chui"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: Đường cần vòng - Biển 2: Cửa chui - Biển 3: Đường hầm (có chiều sâu).""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/376.jpg?v=202606091805"""
    ),
    Question(
        id = 118,
        question = """Biển nào báo hiệu "Đường đôi"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 2,
        explanation = """Đường 2 chiều (mũi tên lên xuống trước mặt) - Biển 2: Giao nhau (cắt ngang) đường 2 chiều - Biển 3: Đường đôi.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/393.jpg?v=202606091805"""
    ),
    Question(
        id = 119,
        question = """Biển nào sau đây là biển "Dốc xuống nguy hiểm"?""",
        options = listOf("""Biển 1.""", """Biển 2."""),
        correctIndex = 0,
        explanation = """9 Lên 10 Xuống.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/415.jpg?v=202606091805"""
    ),
    Question(
        id = 120,
        question = """Trong các biển dưới đây biển nào là biển "Hết tốc độ tối thiểu"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: Hết cấm tốc độ tối đa - Biển 2: Hết mọi lệnh cấm - Biển 3: Hết tốc độ tối thiểu.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/437.jpg?v=202606091805"""
    ),
    Question(
        id = 121,
        question = """Gặp biển báo này, người tham gia giao thông phải xử lý như thế nào?""",
        options = listOf("""Dừng xe tại khu vực có trạm Cảnh sát giao thông.""", """Tiếp tục lưu thông với tốc độ bình thường.""", """Phải giảm tốc độ đến mức an toàn và không được vượt khi đi qua khu vực này."""),
        correctIndex = 2,
        explanation = """Biển báo này báo trước vị trí trạm Cảnh sát Giao thông đường bộ để người tham gia giao thông nhận biết khu vực có lực lượng CSGT làm nhiệm vụ kiểm tra, kiểm soát giao thông. Phải giảm tốc độ và không được vượt.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/454.jpg?v=202606091805"""
    ),
    Question(
        id = 122,
        question = """Vạch kẻ đường nào dưới đây là vạch phân chia hai chiều xe chạy (vạch tim đường), xe không được lấn làn, không được đè lên vạch?""",
        options = listOf("""Vạch 1.""", """Vạch 2.""", """Vạch 3.""", """Cả ba vạch."""),
        correctIndex = 1,
        explanation = """Hai chiều màu vàng, cùng chiều (một chiều) màu trắng. Vạch đứt được đè, vạch liền thì không!""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/478.jpg?v=202606091805"""
    ),
    Question(
        id = 123,
        question = """Trong trường hợp này xe nào đỗ vi phạm quy tắc giao thông?""",
        options = listOf("""Xe tải.""", """Xe con và mô tô.""", """Cả ba xe.""", """Xe con và xe tải."""),
        correctIndex = 0,
        explanation = """Biển báo chính cấm dừng và cấm đỗ, biển phụ hình xe tải, nên chỉ cấm tải.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/505.jpg?v=202606091805"""
    ),
    Question(
        id = 124,
        question = """Trong hình dưới đây, xe nào chấp hành đúng quy tắc giao thông?""",
        options = listOf("""Chỉ xe khách, xe mô tô.""", """Tất cả các loại xe trên.""", """Không xe nào chấp hành đúng quy tắc giao thông."""),
        correctIndex = 1,
        explanation = """Hướng mũi tên đỏ xe đang di chuyển, không có mũi tên đỏ là đang dừng. Xe con đang trên làn có tín hiệu đèn xanh làn rẽ phải – rẽ phải đúng. Xe tải trên làn đi thẳng có tín hiệu đèn xanh - đi thẳng đúng. Xe khách trên làn rẽ trái có tín hiệu đèn đỏ dừng lại đúng/ Xe mô tô trên làn rẽ trái có tín hiệu đỏ dừng lại là đúng.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/538.jpg?v=202606091805"""
    ),
    Question(
        id = 125,
        question = """Các xe đi theo hướng mũi tên, xe nào chấp hành đúng quy tắc giao thông?""",
        options = listOf("""Xe tải, xe mô tô.""", """Xe khách, xe mô tô.""", """Xe tải, xe con.""", """Xe mô tô, xe con."""),
        correctIndex = 1,
        explanation = """Hướng mũi tên đỏ xe đang di chuyển, không có mũi tên đỏ là đang dừng. Xe con trên làn rẽ phải có tín hiệu đèn đỏ nhưng rẽ phải sai. Xe tải trên làn đi thẳng có tín hiệu đèn đỏ - đi thẳng sai. Xe khách trên làn rẽ trái có tín hiệu đèn xanh- rẽ trái đúng. Xe mô tô trên làn rẽ trái có tín hiệu đèn xanh – rẽ trái đúng.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/565.jpg?v=202606091805"""
    ),
    Question(
        id = 126,
        question = """Người điều khiển phương tiện tham gia giao thông đường bộ được hiểu như thế nào là đúng?""",
        options = listOf("""Là người điều khiển xe cơ giới, người điều khiển xe thô sơ, người điều khiển xe máy chuyên dùng.""", """Là người được giao nhiệm vụ hướng dẫn giao thông trên đường bộ.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Nếu hỏi người điều khiển phương tiện → chọn nhóm người trực tiếp cầm lái.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 127,
        question = """Tổ chức đua xe được phép thực hiện khi nào?""",
        options = listOf("""Trên đường phố không có người qua lại.""", """Được người dân ủng hộ.""", """Được cơ quan có thẩm quyền cấp phép."""),
        correctIndex = 2,
        explanation = """Đua xe phải được cấp phép – Không tự ý dù vắng người hay được ủng hộ.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 128,
        question = """Có bao nhiêu nhóm biển báo hiệu đường bộ?""",
        options = listOf("""Ba nhóm: Biển báo cấm, biển báo nguy hiểm và biển hiệu lệnh.""", """Bốn nhóm: Biển báo cấm, biển báo nguy hiểm, biển hiệu lệnh và biển phụ.""", """Năm nhóm: Biển báo cấm, biển báo nguy hiểm, biển hiệu lệnh, biển chỉ dẫn, biển phụ."""),
        correctIndex = 2,
        explanation = """Có 5 nhóm biển báo.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 129,
        question = """Trên một chiều đường có vạch kẻ phân làn đường, người lái xe cơ giới, xe máy chuyên dùng phải điều khiển xe đi trên làn đường nào?""",
        options = listOf("""Đi trên làn đường bên phải trong cùng.""", """Đi trên làn đường bên trái.""", """Đi ở bất cứ làn nào nhưng phải bảo đảm tốc độ cho phép."""),
        correctIndex = 1,
        explanation = """Xe thô sơ đi làm bên phải trong cùng, xe cơ giới đi làn bên trái.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 130,
        question = """Trước khi cho xe chuyển hướng, người lái xe phải làm gì để bảo đảm an toàn giao thông?""",
        options = listOf("""Phải quan sát, bảo đảm khoảng cách an toàn với xe phía sau.""", """Giảm tốc độ và có tín hiệu báo hướng rẽ.""", """Chuyển dần sang làn gần nhất với hướng rẽ. Khi bảo đảm an toàn, không gây trở ngại cho người và phương tiện khác mới được chuyển hướng.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Quan sát trước – Báo hiệu sau – Đi đúng làn ➡ Ba bước chuẩn: Nhìn – Xi nhan – Lấn đúng làn → mới được rẽ.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 131,
        question = """Người lái xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy không được thực hiện các hành vi nào dưới đây?""",
        options = listOf("""Đi xe dàn hàng ngang; buông cả hai tay.""", """Sử dụng xe để kéo, đẩy xe khác, vật khác, dẫn dắt vật nuôi, mang, vác và chở vật cồng kềnh; chở người đứng trên xe, giá đèo hàng hoặc ngồi trên tay lái; xếp hàng hóa trên xe quá giới hạn quy định.""", """Ngồi về một bên điều khiển xe; đứng, nằm trên xe điều khiển xe; thay người lái xe khi xe đang chạy; quay người về phía sau để điều khiển xe hoặc bịt mắt điều khiển xe; sử dụng chân chống hoặc vật khác quệt xuống đường khi xe đang chạy.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """👉 Dàn hàng – Kéo đẩy – Diễn xiếc ➡ Hành vi nào gây nguy hiểm, mất kiểm soát, cản trở giao thông.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 132,
        question = """Trên đường không phân chia thành hai chiều xe chạy riêng biệt, người điều khiển phương tiện tham gia giao thông đường bộ phải tránh xe đi ngược chiều như thế nào để bảo đảm an toàn?""",
        options = listOf("""Giảm tốc độ và cho xe đi về bên phải theo chiều xe chạy của mình.""", """Một trong hai xe phải dừng lại cho xe kia đi qua mới được đi.""", """Tăng tốc độ, cho xe đi về bên phải theo chiều xe chạy của mình để nhanh chóng vượt qua."""),
        correctIndex = 0,
        explanation = """Nguyên tắc vàng: Giảm tốc độ + Đi về bên phải khi gặp xe đi ngược chiều.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 133,
        question = """Khi tới đường ngang không có người gác, chắn đường bộ, chuông, đèn tín hiệu, người tham gia giao thông đường bộ phải làm gì để bảo đảm an toàn?""",
        options = listOf("""Dừng lại về bên phải đường của mình, trước vạch dừng xe và quan sát hai phía, khi không có phương tiện giao thông đường sắt tới mới được đi qua.""", """Quan sát hai phía, khi không có phương tiện giao thông đường sắt tới thì nhanh chóng đi qua.""", """Dừng lại khoảng cách tối thiểu 3 mét tính từ ray đường sắt gần nhất, khi không có phương tiện giao thông đường sắt tới thì nhanh chóng đi qua."""),
        correctIndex = 0,
        explanation = """Không rào chắn – Dừng bên phải – Quan sát kỹ – Tàu không đến – Mới được qua. Cứ đến đường sắt không chắn thì luôn dừng lại, quan sát, và chỉ qua khi an toàn tuyệt đối.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 134,
        question = """Người có Giấy phép lái xe mô tô hạng A1 không được phép điều khiển loại xe nào dưới đây?""",
        options = listOf("""Xe mô tô hai bánh có dung tích xi-lanh 125 cm3 hoặc có công suất động cơ điện đến 11 kW.""", """Xe mô tô ba bánh.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """Hạng A1: điều khiển xe moto 2 bánh có dung tích từ 125cc và động cơ điện 11kw""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 135,
        question = """Trên đường bộ ngoài khu vực đông dân cư, đường đôi hoặc đường một chiều có từ hai làn xe cơ giới trở lên (trừ đường cao tốc) loại xe nào dưới đây được tham gia giao thông với tốc độ khai thác tối đa cho phép là 70 km/h?""",
        options = listOf("""Xe ô tô chở người đến 28 chỗ không kể chỗ của người lái xe (trừ xe buýt); ô tô tải có trọng tải không lớn hơn 3,5 tấn.""", """Xe ô tô chở người trên 28 chỗ không kể chỗ người lái xe (trừ xe buýt); ô tô tải có trọng tải trên 3,5 tấn (trừ ô tô xi téc).""", """Xe buýt; ô tô đầu kéo kéo sơ mi rơ moóc (trừ ô tô đầu kéo kéo sơ mi rơ moóc xi téc); xe mô tô; ô tô chuyên dùng (trừ ô tô trộn vữa, ô tô trộn bê tông lưu động).""", """Ô tô kéo rơ moóc; ô tô kéo xe khác; ô tô trộn vữa, ô tô trộn bê tông lưu động, ô tô xi téc, ô tô đầu kéo kéo sơ mi rơ moóc xi téc, ô tô kéo theo rơ moóc xi téc."""),
        correctIndex = 2,
        explanation = """Ngoài khu vực dân cư xe mô tô chạy được: Đường 2 làn đường: 70km/h .Đường 1 làn đường: 60km/h. Mẹo nhỏ: bạn đang thi bằng mô tô thấy đáp án có mô tô thì chọn nhé!""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 136,
        question = """Trong các hành vi dưới đây, người lái xe có văn hóa giao thông phải ứng xử như thế nào?""",
        options = listOf("""Điều khiển xe đi bên phải theo chiều đi của mình; đi đúng phần đường, làn đường quy định; dừng, đỗ xe đúng nơi quy định; đã uống rượu, bia thì không lái xe.""", """Điều khiển xe đi trên phần đường, làn đường có ít phương tiện giao thông; dừng xe, đỗ xe ở nơi thuận tiện hoặc theo yêu cầu của hành khách, của người thân.""", """Dừng và đỗ xe ở nơi thuận tiện cho việc chuyên chở hành khách và giao nhận hàng hóa; sử dụng ít rượu, bia thì có thể lái xe."""),
        correctIndex = 0,
        explanation = """Đã uống rượu bia, thì không được lái xe.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 137,
        question = """Khi tầm nhìn bị hạn chế bởi sương mù hoặc mưa to, người lái xe phải thực hiện các thao tác nào để bảo đảm an toàn?""",
        options = listOf("""Tăng tốc độ, chạy gần xe trước, nhìn đèn hậu để định hướng.""", """Giảm tốc độ, chạy cách xa xe trước với khoảng cách an toàn, bật đèn sương mù và đèn chiếu gần.""", """Tăng tốc độ, bật đèn pha vượt qua xe chạy trước."""),
        correctIndex = 1,
        explanation = """Khi tầm nhìn hạn chế thì phải giảm tốc độ.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 138,
        question = """Biển nào cấm máy kéo?""",
        options = listOf("""Biển 1.""", """Biển 2 và biển 3.""", """Biển 1 và biển 3.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Cấm nhỏ cấm luôn lớn theo thứ tự: xe con – xe khách - xe tải - xe máy kéo - xe kéo kéo rơ móc. Nên cấm tải cấm luôn máy kéo chọn cả 2 và 3.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/303.jpg?v=202606091805"""
    ),
    Question(
        id = 139,
        question = """Biển nào xe được phép rẽ trái?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Không biển nào."""),
        correctIndex = 1,
        explanation = """Biển 1: cấm rẽ trái. Biển 2: Khu vực được phép quay đầu xe, rẽ trái được.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/322.jpg?v=202606091805"""
    ),
    Question(
        id = 140,
        question = """Biển phụ đặt dưới biển cấm bóp còi có ý nghĩa như thế nào?""",
        options = listOf("""Báo khoảng cách đến nơi cấm bóp còi.""", """Chiều dài đoạn đường cấm bóp còi từ nơi đặt biển.""", """Báo cấm dùng còi có độ vang xa 500m."""),
        correctIndex = 1,
        explanation = """Biển phụ báo hiệu chiều dài đoạn đường cấp bóp còi.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/347.jpg?v=202606091805"""
    ),
    Question(
        id = 141,
        question = """Gặp biển nào người lái xe phải nhường đường cho người đi bộ?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: Nhường đường cho người đi bộ - Biển 2: Cấm người đi bộ - Biển 3: Dành cho người đi bộ.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/367.jpg?v=202606091805"""
    ),
    Question(
        id = 142,
        question = """Hai biển này có ý nghĩa như thế nào?""",
        options = listOf("""Để chỉ nơi đường sắt giao vuông góc với đường bộ không có rào chắn.""", """Để báo trước sắp đến vị trí giao cắt đường bộ với đường sắt cùng mức, không vuông góc và không có người gác, không có rào chắn.""", """Nơi đường sắt giao nhau với đường bộ."""),
        correctIndex = 0,
        explanation = """Biển báo nơi giao nhau vuông góc đường bộ không rào chắn.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/377.jpg?v=202606091805"""
    ),
    Question(
        id = 143,
        question = """Biển nào báo hiệu "Kết thúc đường đôi"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 2,
        explanation = """Biển 1: đường 2 chiều - Biển 2: đường đôi - Biển 3: kết thúc đường đôi.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/394.jpg?v=202606091805"""
    ),
    Question(
        id = 144,
        question = """Biển báo này có ý nghĩa như thế nào?""",
        options = listOf("""Báo hiệu đường có ổ gà, lồi lõm.""", """Báo hiệu đường có gồ giảm tốc phía trước."""),
        correctIndex = 0,
        explanation = """Biển báo hiệu đường ổ gà, lồi lõm ( 1 là gồ, 2 là ổ gà).""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/419.jpg?v=202606091805"""
    ),
    Question(
        id = 145,
        question = """Biển nào dưới đây báo hiệu hết cấm vượt?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Biển 2 và biển 3."""),
        correctIndex = 3,
        explanation = """Biển 1: Hết tốc độ tối đa - Biển 2: Hết mọi lệnh cấm - Biển 3: Hết cấm vượt.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/438.jpg?v=202606091805"""
    ),
    Question(
        id = 146,
        question = """Gặp biển báo dưới đây, người lái xe có bắt buộc phải chạy vòng theo đảo an toàn theo hướng mũi tên khi muốn chuyển hướng hay không?""",
        options = listOf("""Bắt buộc.""", """Không bắt buộc."""),
        correctIndex = 0,
        explanation = """Biển báo dạng hình tròn, nền xanh là biển báo hiệu lệnh bắt buộc phải tuân thủ theo!""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/455.jpg?v=202606091805"""
    ),
    Question(
        id = 147,
        question = """Theo hướng mũi tên, xe nào chấp hành đúng quy tắc giao thông?""",
        options = listOf("""Xe khách, xe tải, xe mô tô.""", """Xe tải, xe mô tô.""", """Chỉ xe con.""", """Cả bốn xe."""),
        correctIndex = 2,
        explanation = """Hướng mũi tên đỏ xe đang di chuyển, không có mũi tên đỏ là đang dừng. Xe con trên làn rẽ phải có tín hiệu đèn xanh - rẽ phải đúng. Xe tải trên làn đi thẳng có tín hiệu đèn đỏ dừng lại rẽ trái sai. Xe tải trên làn rẽ phải có tín hiệu đèn xanh nhưng rẽ trái sai. Xe khách trên làn rẽ trái có tín hiệu đèn xanh nhưng đi thẳng sai. Xe mô tô trên làn rẽ trái có tín hiệu đèn xanh nhưng rẽ phải sai. Nên chỉ có xe con đúng""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/486.jpg?v=202606091805"""
    ),
    Question(
        id = 148,
        question = """Theo hướng mũi tên, những hướng nào xe gắn máy được phép đi?""",
        options = listOf("""Cả ba hướng.""", """Chỉ hướng 1 và 3.""", """Chỉ hướng 1."""),
        correctIndex = 0,
        explanation = """💡 Cần phân biệt rõ: - Biển ở hướng 2 là biển CẤM MÔ TÔ (xe ≥ 50 phân khối). Biển này KHÔNG cấm xe gắn máy (xe < 50 phân khối). - Biển ở hướng 3 là biển CẤM Ô TÔ. Cũng KHÔNG cấm xe gắn máy. Đề bài đang hỏi xe của người lái là "xe gắn máy" (xe nhỏ dưới 50cc). Do đó, xe gắn máy không bị cấm ở hướng nào cả và được phép đi CẢ 3 HƯỚNG. (Mẹo dễ nhớ: Hỏi Mô tô -> Chọn 2 hướng. Hỏi Gắn máy -> Chọn 3 hướng).""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/507.jpg?v=202606091805"""
    ),
    Question(
        id = 149,
        question = """Theo hướng mũi tên, những hướng nào xe mô tô được phép đi?""",
        options = listOf("""Cả ba hướng.""", """Hướng 1 và 2.""", """Hướng 1 và 3.""", """Hướng 2 và 3."""),
        correctIndex = 2,
        explanation = """Hỏi moto chọn 2 hướng, hỏi gắn máy chọn 3 hướng.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/539.jpg?v=202606091805"""
    ),
    Question(
        id = 150,
        question = """Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?""",
        options = listOf("""Xe của bạn, xe mô tô, xe con.""", """Xe con, xe của bạn, xe mô tô.""", """Xe mô tô, xe con, xe của bạn."""),
        correctIndex = 2,
        explanation = """Phía trước có biển báo giao nhau với đường ưu tiên (tam giác ngược) vì thế bạn phải nhường đường và đi sau cùng. Chọn đáp án số 3.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/567.jpg?v=202606091805"""
    ),
    Question(
        id = 151,
        question = """Người lái xe được hiểu như thế nào là đúng?""",
        options = listOf("""Là người điều khiển xe cơ giới.""", """Là người điều khiển xe thô sơ.""", """Là người điều khiển xe máy chuyên dùng."""),
        correctIndex = 0,
        explanation = """Người lái xe là điều khiển xe cơ giới""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 152,
        question = """Hành vi đua xe trái phép bị xử lý như thế nào?""",
        options = listOf("""Chỉ bị nhắc nhở.""", """Tùy theo mức độ của hành vi vi phạm có thể bị xử lý hành chính hoặc xử lý hình sự."""),
        correctIndex = 1,
        explanation = """Đua xe trái phép sẽ bị phạt hành chính hoặc hình sự nếu gây ra hậu quả nghiêm trọng (tai nạn chết người, thương tích nặng, thiệt hại tài sản lớn...).""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 153,
        question = """Tại nơi có vạch kẻ đường hoặc tại nơi mà người đi bộ, xe lăn của người khuyết tật đang qua đường, người điều khiển phương tiện tham gia giao thông phải thực hiện như thế nào?""",
        options = listOf("""Giảm tốc độ và nhường đường cho người đi bộ, xe lăn của người khuyết tật qua đường đảm bảo an toàn.""", """Quan sát, giảm tốc độ hoặc dừng lại để bảo đảm an toàn cho người đi bộ, xe lăn của người khuyết tật qua đường.""", """Quan sát, tăng tốc độ và điều khiển phương tiện nhanh chóng đi qua."""),
        correctIndex = 1,
        explanation = """Tại nơi có vạch kẻ đường dành cho người đi bộ hoặc khi người đi bộ, người khuyết tật sử dụng xe lăn đang qua đường, người lái xe bắt buộc phải: • Quan sát kỹ lưỡng tình huống phía trước. • Giảm tốc độ hoặc dừng lại hẳn để nhường đường. • Bảo đảm tuyệt đối an toàn cho người đi bộ và người khuyết tật.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 154,
        question = """Người lái xe phải giảm tốc độ, có tín hiệu rẽ phải và đi sát về bên phải của phần đường xe chạy trong các trường hợp nào dưới đây?""",
        options = listOf("""Khi xe chạy phía trước có tín hiệu vượt xe khác.""", """Khi phía trước có xe chạy ngược chiều.""", """Khi xe sau xin vượt nếu đủ điều kiện an toàn.""", """Khi xe sau có tín hiệu vượt bên phải."""),
        correctIndex = 2,
        explanation = """Xe sau xin vượt – nếu an toàn thì nhường.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 155,
        question = """Khi chuyển làn đường, người lái xe phải bật đèn tín hiệu báo rẽ như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Khi bắt đầu chuyển làn đường.""", """Trước khi thay đổi làn đường.""", """Sau khi thay đổi làn đường."""),
        correctIndex = 1,
        explanation = """Muốn rẽ thì phải báo trước (bật xi – nhan)""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 156,
        question = """Trên đường bộ ngoài khu vực đông dân cư, đường hai chiều hoặc đường một chiều có một làn xe cơ giới (trừ đường cao tốc), loại xe nào dưới đây được tham gia giao thông với tốc độ khai thác tối đa cho phép là 60 km/h?""",
        options = listOf("""Xe ô tô chở người đến 28 chỗ không kể chỗ của người lái xe (trừ xe buýt); ô tô tải có trọng tải không lớn hơn 3,5 tấn.""", """Xe ô tô chở người trên 28 chỗ không kể chỗ người lái xe (trừ xe buýt); ô tô tải có trọng tải trên 3,5 tấn (trừ ô tô xi téc).""", """Xe buýt; ô tô đầu kéo kéo sơ mi rơ moóc (trừ ô tô đầu kéo kéo sơ mi rơ moóc xi téc); xe mô tô; ô tô chuyên dùng (trừ ô tô trộn vữa, ô tô trộn bê tông lưu động).""", """Ô tô kéo rơ moóc; ô tô kéo xe khác; ô tô trộn vữa, ô tô trộn bê tông lưu động, ô tô xi téc, ô tô đầu kéo kéo sơ mi rơ moóc xi téc, ô tô kéo theo rơ moóc xi téc."""),
        correctIndex = 2,
        explanation = """Đây là câu hỏi khái niệm/định nghĩa. Đáp án đúng chính là nội dung định nghĩa chuẩn: “Xe buýt; ô tô đầu kéo kéo sơ mi rơ moóc (trừ ô tô đầu kéo kéo sơ mi rơ moóc xi téc); xe mô tô; ô tô chuyên dùng (trừ ô tô trộn vữa, ô tô trộn bê tông lưu động).”. Hãy ghi nhớ từ khóa trong câu hỏi và so khớp với định nghĩa đầy đủ nhất.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 157,
        question = """Khi tránh xe đi ngược chiều, các xe phải nhường đường như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Nơi đường hẹp chỉ đủ cho một xe chạy và có chỗ tránh xe thì xe nào ở gần chỗ tránh hơn phải vào vị trí tránh, nhường đường cho xe đi ngược chiều.""", """Xe xuống dốc phải nhường đường cho xe lên dốc.""", """Xe có chướng ngại vật phía trước phải nhường đường cho xe không có chướng ngại vật phía trước.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Gần chỗ tránh – phải tránh, xuống dốc – phải nhường lên dốc, có vật cản – phải dừng. Nên chọn cả ba ý trên.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 158,
        question = """Tại đường ngang, cầu chung đường sắt, khi có hiệu lệnh của nhân viên gác chắn, đèn đỏ sáng nhấp nháy, chuông kêu, chắn đường bộ đang dịch chuyển hoặc đã đóng, người tham gia giao thông đường bộ phải làm gì để bảo đảm an toàn?""",
        options = listOf("""Dừng lại về bên trái đường của mình, trước vạch dừng xe.""", """Dừng lại giữa đường của mình, trước vạch dừng xe.""", """Dừng lại về bên phải đường của mình, trước vạch dừng xe."""),
        correctIndex = 2,
        explanation = """Hễ có đèn đỏ, chuông, chắn, là dừng bên phải trước vạch.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 159,
        question = """Người có Giấy phép lái xe mô tô hạng A1 được cấp sau ngày 01/01/2025 được phép điều khiển loại xe nào dưới đây?""",
        options = listOf("""Xe mô tô hai bánh có dung tích xi-lanh đến 125 cm3 hoặc có công suất động cơ điện đến 11 kW.""", """Xe mô tô ba bánh.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Hạng A1: Xe mô tô hai bánh có dung tích xi-lanh “ĐẾN’’125 cm3 hoặc có công suất động cơ điện đến 11 kW. Hạng A: bao gồm hạng A1 và trên 125cc.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 160,
        question = """Trên đường bộ ngoài khu vực đông dân cư, đường hai chiều hoặc đường một chiều có một làn xe cơ giới (trừ đường cao tốc), loại xe nào dưới đây được tham gia giao thông với tốc độ khai thác tối đa cho phép là 60 km/h?""",
        options = listOf("""Xe ô tô chở người đến 28 chỗ không kể chỗ của người lái xe (trừ xe buýt); ô tô tải có trọng tải không lớn hơn 3,5 tấn.""", """Xe ô tô chở người trên 28 chỗ không kể chỗ người lái xe (trừ xe buýt); ô tô tải có trọng tải trên 3,5 tấn (trừ ô tô xi téc).""", """Xe buýt; ô tô đầu kéo kéo sơ mi rơ moóc (trừ ô tô đầu kéo kéo sơ mi rơ moóc xi téc); xe mô tô; ô tô chuyên dùng (trừ ô tô trộn vữa, ô tô trộn bê tông lưu động).""", """Ô tô kéo rơ moóc; ô tô kéo xe khác; ô tô trộn vữa, ô tô trộn bê tông lưu động, ô tô xi téc, ô tô đầu kéo kéo sơ mi rơ moóc xi téc, ô tô kéo theo rơ moóc xi téc."""),
        correctIndex = 2,
        explanation = """Ngoài khu vực dân cư xe mô tô chạy được: Có 2 làn đường: 70km/h - Có 1 làn đường: 60km/h Tốc độ có xe mô tô là chọn.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 161,
        question = """Khi tham gia giao thông việc sử dụng còi xe nên dùng như thế nào để thể hiện là người có văn hóa giao thông?""",
        options = listOf("""Chỉ bấm còi khi thật sự cần thiết, không bấm còi liên tục hoặc kéo dài, sử dụng còi với mức âm lượng theo quy định.""", """Bấm còi liên tục để các xe khác nhường đường.""", """Bấm còi to khi đi qua khu vực đông dân cư.""", """Không cần dùng còi, tránh gây tiếng ồn là văn minh."""),
        correctIndex = 0,
        explanation = """Còi – chỉ dùng khi cần, không kéo dài, không ồn ào.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 162,
        question = """Khi đèn pha của xe đi ngược chiều gây chói mắt, làm giảm khả năng quan sát trên đường, người lái xe xử lý như thế nào dưới đây để bảo đảm an toàn?""",
        options = listOf("""Giảm tốc độ, giữ vững tay lái, nhìn chếch sang lề đường bên phải.""", """Bật đèn pha chiếu xa và giữ nguyên tốc độ.""", """Tăng tốc độ, bật đèn pha đối diện xe phía trước."""),
        correctIndex = 0,
        explanation = """Giảm tốc độ để có thể xử lý kịp thời nếu có tình huống bất ngờ. Giữ vững tay lái tránh mất kiểm soát. Nhìn chếch sang lề đường bên phải để tránh ánh sáng chói trực tiếp, giảm mỏi mắt và đảm bảo quan sát an toàn.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 163,
        question = """Biển nào báo hiệu cấm xe mô tô ba bánh chở hàng đi qua?""",
        options = listOf("""Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Cấm xe mô tô - Biển 2: Cấm xe oto - Biển 3: Cấm xe tải - Cấm mô tô, cấm ô tô: cấm luôn cả 3 bánh.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/304.jpg?v=202606091805"""
    ),
    Question(
        id = 164,
        question = """Biển nào xe quay đầu không bị cấm?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 2,
        explanation = """Biển 1: cấm rẽ trái được quay đầu. Biển 2: báo hiệu nơi quay đầu. Nên cả 2 biển.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/323.jpg?v=202606091805"""
    ),
    Question(
        id = 165,
        question = """Chiều dài đoạn đường 500 m từ nơi đặt biển này, người lái xe có được phép bấm còi không?""",
        options = listOf("""Được phép.""", """Không được phép."""),
        correctIndex = 1,
        explanation = """Gặp đáp án có “KHÔNG ĐƯỢC PHÉP” thì chọn ngay là chắc chắn đúng.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/348.jpg?v=202606091805"""
    ),
    Question(
        id = 166,
        question = """Biển nào chỉ đường dành cho người đi bộ, các loại xe không được đi vào khi gặp biển này?""",
        options = listOf("""Biển 1.""", """Biển 1 và 3.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: NHƯỜNG đường cho người đi bộ. Biển 2: CẤM người đi bộ. Biển 3: DÀNH cho người đi bộ. Đường dành là biển màu xanh!""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/368.jpg?v=202606091805"""
    ),
    Question(
        id = 167,
        question = """Biển nào báo hiệu "Hết đoạn đường ưu tiên"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 2,
        explanation = """Biển 1: giao nhau đường không ưu tiên. Biển 2: giao nhau với đường ưu tiên. Biển 3: hết đoạn đường ưu tiên.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/380.jpg?v=202606091805"""
    ),
    Question(
        id = 168,
        question = """Biển nào báo hiệu "Giao nhau với đường hai chiều"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: giao nhau đường 2 chiều. Biển 2: báo hiệu đường đôi. Biển 3: tuyến đường cùng cấp.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/395.jpg?v=202606091805"""
    ),
    Question(
        id = 169,
        question = """Các biển báo này có ý nghĩa như thế nào?""",
        options = listOf("""Để báo trước gần tới đoạn đường có hiện tượng đất đá từ trên ta luy dương sụt lở bất ngờ gây nguy hiểm cho xe cộ và người đi đường.""", """Để báo trước nơi có kết cấu mặt đường rời rạc, khi phương tiện đi qua, làm cho các viên đá, sỏi văng lên gây nguy hiểm và mất an toàn cho người và phương tiện tham gia giao thông.""", """Để cảnh báo những đoạn nền đường yếu, đoạn đường đang theo dõi lún mà việc vận hành xe ở tốc độ cao có thể gây nguy hiểm."""),
        correctIndex = 0,
        explanation = """Đây là biển cảnh báo trước gần tới đoạn đường có hiện tượng đất đá từ trên ta luy dương sụt lở bất ngờ gây nguy hiểm cho xe cộ và người đi đường.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/422.jpg?v=202606091805"""
    ),
    Question(
        id = 170,
        question = """Trong các biển dưới đây biển nào là biển "Hết mọi lệnh cấm"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: hết tốc độ tối đa - Biển 2: hết mọi lệnh cấm - Biển 3: hết tốc độ tối thiểu.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/439.jpg?v=202606091805"""
    ),
    Question(
        id = 171,
        question = """Biển nào báo hiệu "Cầu vượt liên thông"?""",
        options = listOf("""Biển 2 và biển 3.""", """Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1 và Biển 3: báo hiệu cầu vượt liên thông - Biển 2: hiệu cầu vượt cắt qua hình tròn. (Cầu vượt liên thông là có chữ trên biển báo)""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/457.jpg?v=202606091805"""
    ),
    Question(
        id = 172,
        question = """Theo hướng mũi tên, thứ tự các xe đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe tải, xe khách, xe con, xe mô tô.""", """Xe tải, xe mô tô, xe khách, xe con.""", """Xe khách, xe tải, xe con, xe mô tô.""", """Xe mô tô, xe khách, xe tải, xe con."""),
        correctIndex = 1,
        explanation = """Thứ tự xét xe đi: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái. Trường hợp 3 biển báo đường ưu tiên: 1. Xe tải, xe mô tô trên đường ưu tiên, xe tải đi thẳng đi trước mới đến moto rẽ trái đi sau. 2. Xe khác, xe con trên đường không ưu sẽ đi sau xe tải và moto, tương tự xe khách đi thẳng – xe con rẽ trái""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/487.jpg?v=202606091805"""
    ),
    Question(
        id = 173,
        question = """Xe nào đỗ vi phạm quy tắc giao thông?""",
        options = listOf("""Cả hai xe.""", """Không xe nào vi phạm.""", """Chỉ xe mô tô vi phạm.""", """Chỉ xe tải vi phạm."""),
        correctIndex = 0,
        explanation = """Biển báo chính cấm dừng dỗ và biển phụ hướng trước sau nên cả 2 xe.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/508.jpg?v=202606091805"""
    ),
    Question(
        id = 174,
        question = """Trong trường hợp này, thứ tự xe đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe công an đi làm nhiệm vụ khẩn cấp, xe quân sự đi làm nhiệm vụ khẩn cấp, xe con + xe mô tô.""", """Xe quân sự đi làm nhiệm vụ khẩn cấp, xe công an đi làm nhiệm vụ khẩn cấp, xe con + xe mô tô.""", """Xe mô tô + xe con, xe quân sự đi làm nhiệm vụ khẩn cấp, xe công an đi làm nhiệm vụ khẩn cấp."""),
        correctIndex = 1,
        explanation = """rong sa hình xuất hiện xe ưu tiên, chúng ta sẽ xét theo thứ tự Quân sự làm nhiệm vụ -> xe công an làm nhiệm vụ, sau đó sẽ tới xe dân thường.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/540.jpg?v=202606091805"""
    ),
    Question(
        id = 175,
        question = """Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?""",
        options = listOf("""Xe của bạn, xe mô tô, xe con.""", """Xe con, xe của bạn, xe mô tô.""", """Xe mô tô, xe con, xe của bạn."""),
        correctIndex = 1,
        explanation = """Thứ tự xét xe đi theo từng trường hợp: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái. Trường hợp 5: rẽ phải- đi thẳng- xe trái. Xe con rẽ phải- xe của bạn thi thẳng- xe moto cuối.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/568.jpg?v=202606091805"""
    ),
    Question(
        id = 176,
        question = """Trong nhóm các phương tiện giao thông đường bộ dưới đây, nhóm phương tiện nào là xe cơ giới?""",
        options = listOf("""Xe ô tô; máy kéo; xe mô tô hai bánh; xe mô tô ba bánh; xe gắn máy; xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng; xe đạp, xe đạp máy, xe đạp điện.""", """Xe ô tô; rơ moóc được kéo bởi xe ô tô; sơ mi rơ moóc được kéo bởi ô tô đầu kéo; xe chở người bốn bánh có gắn động cơ; xe chở hàng bốn bánh có gắn động cơ; xe mô tô, xe gắn máy và các loại xe tương tự."""),
        correctIndex = 1,
        explanation = """Hỏi thô sơ hay cơ giới đều chọn đáp án có chữ “tương tự” cuối câu""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 177,
        question = """Người điều khiển phương tiện tham gia giao thông đường bộ mà trong máu hoặc hơi thở có nồng độ cồn có bị nghiêm cấm không?""",
        options = listOf("""Bị nghiêm cấm.""", """Không bị nghiêm cấm.""", """Không bị nghiêm cấm, nếu nồng độ cồn trong máu ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông."""),
        correctIndex = 0,
        explanation = """Điều khiển phương tiện có nồng độ cồn đều bị nghiêm cấm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 178,
        question = """Người điều khiển xe mô tô phải quan sát, giảm tốc độ hoặc dừng lại để bảo đảm an toàn trong các trường hợp nào dưới đây?""",
        options = listOf("""Đường hẹp, đường vòng, đường quanh co, đường đèo, dốc.""", """Nơi cầu, cống hẹp, đập tràn, đường ngầm, hầm chui, hầm đường bộ.""", """Trời mưa, gió, sương, khói, bụi, mặt đường trơn trượt, lầy lội, có nhiều đất đá, vật liệu rơi vãi ảnh hưởng đến an toàn giao thông đường bộ.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Thấy nguy hiểm – phải quan sát, giảm tốc, có thể dừng. Tất cả các trường hợp trên đều gây nguy hiểm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 179,
        question = """Khi gặp hiệu lệnh điều khiển của Cảnh sát giao thông như hình dưới đây thì người tham gia giao thông đường bộ phải đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Người tham gia giao thông đường bộ ở các hướng phải dừng lại.""", """Người tham gia giao thông đường bộ ở các hướng được đi theo chiều gậy chỉ của Cảnh sát giao thông.""", """Người tham gia giao thông đường bộ ở phía trước và phía sau người điều khiển được đi tất cả các hướng; người tham gia giao thông đường bộ ở phía bên phải và phía bên trái người điều khiển phải dừng lại.""", """Người tham gia giao thông đường bộ ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông đường bộ ở phía bên phải và phía bên trái người điều khiển được đi tất cả các hướng."""),
        correctIndex = 3,
        explanation = """Gặp CSGT ưu tiên chọn đáp án 3, còn lại trường hợp CSGT đứng trên bục giơ 2 tay như hình trên sẽ chọn đáp án 4.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/44.jpg?v=202606091805"""
    ),
    Question(
        id = 180,
        question = """Người điều khiển phương tiện tham gia giao thông không được dừng xe, đỗ xe ở những vị trí nào sau đây?""",
        options = listOf("""Trên miệng cống thoát nước, miệng hầm của đường điện thoại, điện cao thế, chỗ dành riêng cho xe chữa cháy lấy nước.""", """Trong phạm vi an toàn của đường sắt.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Không được dừng xe trên cống nước nơi không được phép và trong phạm vi đường sắt.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 181,
        question = """Người lái xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy không được thực hiện hành vi nào sau đây?""",
        options = listOf("""Đi trên phần đường, làn đường quy định, chấp hành hiệu lệnh của người điều khiển giao thông, đèn tín hiệu giao thông.""", """Đi xe dàn hàng ngang, đi xe vào phần đường dành cho người đi bộ.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """Không đi xe dàn hàng ngang và đi xe vào phần đường người đi bộ.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 182,
        question = """Người lái xe phải làm gì để bảo đảm an toàn khi lái xe trên đường cong có tầm nhìn bị hạn chế?""",
        options = listOf("""Quan sát, giảm tốc độ hoặc dừng lại để bảo đảm an toàn.""", """Đi sang làn đường của xe ngược chiều để mở rộng tầm nhìn và vượt xe khác.""", """Cho xe đi sát bên phải làn đường, bật tín hiệu báo hiệu để vượt bên phải xe khác."""),
        correctIndex = 0,
        explanation = """Gặp đường cong – phải giảm tốc độ, từ từ quan sát, không vượt ẩu.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 183,
        question = """Người tham gia giao thông đường bộ phải dừng lại về bên phải đường của mình trước vạch dừng xe tại đường ngang, cầu chung đường sắt khi có báo hiệu nào dưới đây?""",
        options = listOf("""Hiệu lệnh của nhân viên gác chắn.""", """Đèn đỏ sáng nhấp nháy, chuông kêu.""", """Chắn đường bộ đang dịch chuyển hoặc đã đóng.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Đến đường ray gặp đèn đỏ, chuông kêu, chắn hạ – phải dừng bên phải trước vạch. Chọn cả ba ý trên.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 184,
        question = """Người có Giấy phép lái xe mô tô hạng A được phép điều khiển loại xe nào dưới đây?""",
        options = listOf("""Xe mô tô hai bánh có dung tích xi-lanh đến 125 cm3 hoặc có công suất động cơ điện đến 11 kW.""", """Xe mô tô hai bánh có dung tích xi-lanh trên 125 cm3 hoặc có công suất động cơ điện trên 11 kW.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Hạng A: bao gồm hạng A1 và Xe mô tô hai bánh có dung tích xi-lanh trên 125 cm3 hoặc có công suất động cơ điện trên 11 kW.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 185,
        question = """Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép đến mức cần thiết, chú ý quan sát và chuẩn bị sẵn sàng những tình huống có thể xảy ra để phòng ngừa tai nạn trong các trường hợp nào dưới đây?""",
        options = listOf("""Gặp biển báo nguy hiểm và cảnh báo trên đường.""", """Gặp biển chỉ dẫn trên đường.""", """Gặp biển báo hết mọi lệnh cấm.""", """Gặp biển báo hết hạn chế tốc độ tối đa cho phép."""),
        correctIndex = 0,
        explanation = """Khi thấy biển báo nguy hiểm – phải giảm tốc, quan sát kỹ.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 186,
        question = """Người điều khiển phương tiện tham giao thông đường bộ gây ra tai nạn giao thông đường bộ, người liên quan đến vụ tai nạn giao thông đường bộ có trách nhiệm gì dưới đây?""",
        options = listOf("""Dừng ngay phương tiện, cảnh báo nguy hiểm, giữ nguyên hiện trường, trợ giúp người bị nạn và báo tin cho cơ quan Công an, cơ sở khám bệnh, chữa bệnh.""", """Ở lại hiện trường vụ tai nạn giao thông đường bộ cho đến khi người của cơ quan Công an đến, trừ trường hợp phải đi cấp cứu, đưa người bị nạn đi cấp cứu hoặc xét thấy bị đe dọa đến tính mạng, sức khỏe nhưng phải đến trình báo ngay cơ quan Công an, Ủy ban nhân dân nơi gần nhất.""", """Cung cấp thông tin xác định danh tính về bản thân, người liên quan đến vụ tai nạn giao thông đường bộ và thông tin liên quan của vụ tai nạn giao thông đường bộ cho cơ quan có thẩm quyền.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Khi gặp tai nạn phía trước nên dừng lại, hỗ trợ, giữ nguyên hiện trường, trình báo đầy đủ.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 187,
        question = """Để đạt được hiệu quả phanh cao nhất, người lái xe mô tô phải sử dụng các kỹ năng như thế nào dưới đây?""",
        options = listOf("""Sử dụng phanh trước.""", """Sử dụng phanh sau.""", """Giảm hết ga, sử dụng đồng thời cả phanh sau và phanh trước."""),
        correctIndex = 2,
        explanation = """Để phanh hiệu quả cần: giảm hết ga, sử dụng cả 2 phanh trước và sau.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 188,
        question = """Biển nào dưới đây xe gắn máy được phép đi vào?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 2,
        explanation = """Biển 1: cấm xe mô tô ( không cấm xe gắn máy) - Biển 2: cấm xe oto ( không cấm xe gắn máy) - Nên chọn cả 2 biển.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/305.jpg?v=202606091805"""
    ),
    Question(
        id = 189,
        question = """Biển nào xe được phép quay đầu nhưng không được rẽ trái?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 0,
        explanation = """Biển 1: Cấm rẽ trái nhưng được quay đầu xe - Biển 2: Bắt buộc rẽ trái. Nên chọn biển 1""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/324.jpg?v=202606091805"""
    ),
    Question(
        id = 190,
        question = """Biển nào xe mô tô hai bánh được đi vào?""",
        options = listOf("""Biển 1 và 2.""", """Biển 1 và 3.""", """Biển 2 và 3."""),
        correctIndex = 1,
        explanation = """Biển 1: cấm xe oto không cấm moto - Biển 2: cấm xe mô tô - Biển 3: cấm xe tải không cấm mô tô. Nên chọn 1 và 3""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/349.jpg?v=202606091805"""
    ),
    Question(
        id = 191,
        question = """Biển nào báo hiệu "Đường dành cho xe thô sơ"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: Đường dành cho xe thô sơ - Biển 2: cấm xe đạp - Biển 3: báo hiệu xe đạp cắt ngang. Nên chọn biển 1""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/369.jpg?v=202606091805"""
    ),
    Question(
        id = 192,
        question = """Biển nào báo hiệu, chỉ dẫn xe đi trên đường này được quyền ưu tiên qua nơi giao nhau?""",
        options = listOf("""Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: giao nhau với đường không ưu tiên (bạn được ưu tiên đi trước) - Biển 2: giao nhau với đường ưu tiên (bạn phải nhường) - Biển 3: bắt đầu đường ưu tiên (bạn được ưu tiên đi trước). Nên chọn biển 1 và 3""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/381.jpg?v=202606091805"""
    ),
    Question(
        id = 193,
        question = """Biển nào báo hiệu "Giao nhau với đường hai chiều"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: đường 2 chiều - Biển 2: giao nhau đường 2 chiều - Biển 3: đường cùng cấp.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/397.jpg?v=202606091805"""
    ),
    Question(
        id = 194,
        question = """Biển nào báo hiệu các phương tiện phải tuân thủ tốc độ tối đa cho phép trên từng làn đường?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả hai biển."""),
        correctIndex = 2,
        explanation = """Biển 1: Biển ghép tốc độ tối đa cho phép trên từng làn đường - Biển 2: Biển ghép tốc độ tối đa cho phép theo phương tiện, trên từng làn đường. Nên chọn cả 2 biển quy định tốc độ tối đa trên từng làn đường.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/427.jpg?v=202606091805"""
    ),
    Question(
        id = 195,
        question = """Biển nào cho phép được quay đầu xe đi theo hướng ngược lại khi đặt biển trước ngã ba, ngã tư?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Không biển nào."""),
        correctIndex = 2,
        explanation = """Biển 1: bắt buộc rẽ trái - Biển 2: bắt buộc rẽ trái và rẽ phải (lưu ý biển đạt sau ngã 3, ngã 4) - Biển 3: bắt buộc đi thẳng hoặc rẽ trái (được phép quay đầu xe). Nên chọn biển 3""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/440.jpg?v=202606091805"""
    ),
    Question(
        id = 196,
        question = """Biển số 1 có ý nghĩa như thế nào?""",
        options = listOf("""Đi thẳng hoặc rẽ trái trên cầu vượt.""", """Đi thẳng hoặc rẽ phải trên cầu vượt.""", """Báo hiệu cầu vượt liên thông."""),
        correctIndex = 2,
        explanation = """Biển 1: báo hiệu cầu vượt liên thông - Biển 2, biển 3: báo hiệu cầu vượt cắt qua""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/458.jpg?v=202606091805"""
    ),
    Question(
        id = 197,
        question = """Theo hướng mũi tên, thứ tự các xe đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe tải, xe con, xe mô tô.""", """Xe con, xe tải, xe mô tô.""", """Xe mô tô, xe con, xe tải.""", """Xe con, xe mô tô, xe tải."""),
        correctIndex = 2,
        explanation = """Thứ tự xét xe đi: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái. Trường hợp 4: bên phải xe nào trống xe đó đi trước Xe mô tô bên tay phải trống nên đi trước – xe con đi thẳng- xe tải rẽ trái.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/490.jpg?v=202606091805"""
    ),
    Question(
        id = 198,
        question = """Xe nào đỗ vi phạm quy tắc giao thông?""",
        options = listOf("""Chỉ xe mô tô.""", """Chỉ xe tải.""", """Cả ba xe.""", """Chỉ xe mô tô và xe tải."""),
        correctIndex = 2,
        explanation = """Xe tải đỗ ngược chiều, còn xe ô tô và mô tô đỗ trên vạch người đi bộ nên cả 3 đều sai.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/509.jpg?v=202606091805"""
    ),
    Question(
        id = 199,
        question = """Trong hình dưới, những xe nào vi phạm quy tắc giao thông?""",
        options = listOf("""Xe con (E), xe mô tô (C).""", """Xe tải (A), xe mô tô (D).""", """Xe khách (B), xe mô tô (C).""", """Xe khách (B), xe mô tô (D)."""),
        correctIndex = 0,
        explanation = """Xe con E đi và làn dành cho xe mô tô - Xe mô tô C đi vào làn danh cho xe ô tô. Mẹo thấy E là chọn!""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/543.jpg?v=202606091805"""
    ),
    Question(
        id = 200,
        question = """Các xe đi theo thứ tự nào là đúng quy tắc giao thông đường bộ?""",
        options = listOf("""Xe của bạn, xe mô tô, xe đạp.""", """Xe mô tô, xe đạp, xe của bạn.""", """Xe đạp, xe mô tô, xe của bạn."""),
        correctIndex = 2,
        explanation = """Thứ tự xét xe đi: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái. Trường hợp 4: bên phải xe nào trống xe đó đi trước. Xe đạp bên tay phải trống đi trước – xe mô tô đi thẳng- xe của bạn rẽ trái đi cuối.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/583.jpg?v=202606091805"""
    ),
    Question(
        id = 201,
        question = """Trong nhóm các phương tiện giao thông đường bộ dưới đây, nhóm phương tiện nào là xe thô sơ?""",
        options = listOf("""Xe đạp, xe đạp máy, xe đạp điện; xe xích lô; xe lăn dùng cho người khuyết tật; xe vật nuôi kéo và các loại xe tương tự.""", """Xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.""", """Xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo."""),
        correctIndex = 0,
        explanation = """Hỏi thô sơ hay cơ giới đều chọn đáp án có chữ “tương tự” cuối câu""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 202,
        question = """Theo Luật Phòng chống tác hại của rượu, bia, đối tượng nào dưới đây bị cấm sử dụng rượu, bia khi tham gia giao thông?""",
        options = listOf("""Người điều khiển xe ô tô, xe mô tô, xe đạp, xe gắn máy.""", """Người được chở trên xe cơ giới.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Đã uống rượu bia thì không lái xe, đồng nghĩa là Người điều khiển xe ô tô, xe mô tô, xe đạp, xe gắn máy không được vi phạm. Người ngồi sau có thể là rơi vào trường hợp say và nhờ người khác chở về, không vi phạm.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 203,
        question = """Khái niệm “đỗ xe” được hiểu như thế nào là đúng?""",
        options = listOf("""Là trạng thái đứng yên của phương tiện giao thông có giới hạn trong một khoảng thời gian cần thiết đủ để cho người lên, xuống phương tiện, xếp dỡ hàng hóa hoặc thực hiện công việc khác.""", """Là trạng thái đứng yên của phương tiện giao thông không giới hạn thời gian.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """Mẹo nhớ: Đỗ xe là trạng thái đứng yên KHÔNG giới hạn thời gian. Dừng xe là trạng thái đứng yên CÓ giới hạn thời gian.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 204,
        question = """Người lái xe được phép vượt xe trên cầu hẹp có một làn đường, đường cong có tầm nhìn bị hạn chế hay không?""",
        options = listOf("""Được phép vượt khi đường vắng.""", """Không được phép vượt.""", """Được phép vượt khi có việc gấp."""),
        correctIndex = 1,
        explanation = """Trên đường cong hạn chế tầm nhìn thì không được vượt vì rất nguy hiểm!""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 205,
        question = """Người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?""",
        options = listOf("""Được phép.""", """Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình.""", """Tùy trường hợp.""", """Không được phép."""),
        correctIndex = 3,
        explanation = """Hành vi kéo, đẩy phương tiện khác khi tham gia giao thông cực kỳ nguy hiểm nên không được phép.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 206,
        question = """Người được chở trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông đường bộ có được sử dụng ô khi trời mưa hay không?""",
        options = listOf("""Được sử dụng.""", """Chỉ người ngồi sau được sử dụng.""", """Không được sử dụng.""", """Được sử dụng nếu không có áo mưa."""),
        correctIndex = 2,
        explanation = """Việc sử dụng ô khi ngồi trên xe máy có thể gây mất cân bằng, che khuất tầm nhìn và ảnh hưởng đến an toàn giao thông. Vì thế người ngồi sau không được phép sử dụng.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 207,
        question = """Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên, đường nhánh phải nhường đường như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Nhường đường cho xe đi ở bên phải mình tới.""", """Nhường đường cho xe đi ở bên trái mình tới.""", """Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới."""),
        correctIndex = 2,
        explanation = """Đang trên đường không ưu tiên, bắt buộc phải nhường đường cho xe từ bất kỳ hướng nào tới.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 208,
        question = """Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây?""",
        options = listOf("""Xe cơ giới, xe máy chuyên dùng phải bật đèn chiếu gần; xe thô sơ phải bật đèn hoặc có vật phát sáng báo hiệu; không dừng xe, đỗ xe trong hầm đường bộ; trường hợp gặp sự cố kỹ thuật hoặc bất khả kháng khác buộc phải dừng xe, đỗ xe, người lái xe, người điều khiển xe máy chuyên dùng phải đưa xe vào vị trí dừng xe, đỗ xe khẩn cấp, nếu không di chuyển được, phải có báo hiệu bằng đèn khẩn cấp và đặt biển hoặc đèn cảnh báo về phía sau xe khoảng cách bảo đảm an toàn.""", """Xe cơ giới, xe máy chuyên dùng phải bật đèn chiếu xa; được dừng xe, đỗ xe khi cần thiết.""", """Phải cho xe chạy trên một làn đường và chỉ chuyển làn ở nơi được phép; được quay đầu xe, lùi xe khi cần thiết."""),
        correctIndex = 0,
        explanation = """Trong hầm đường bộ không được dừng đỗ xe, đây là quy định!""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 209,
        question = """Người lái xe khi tham gia giao thông đường bộ phải đảm bảo các điều kiện nào dưới đây?""",
        options = listOf("""Phải đủ tuổi, sức khỏe theo quy định của pháp luật; có giấy phép lái xe đang còn điểm, còn hiệu lực phù hợp với loại xe đang điều khiển do cơ quan có thẩm quyền cấp (trừ người lái xe gắn máy).""", """Phải là người đứng tên trong đăng ký xe.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Khi tham gia giao thông yêu cầu người điều khiển phải đủ độ tuổi theo quy định, phải có GPLX còn điểm và còn thời hạn sử dụng được cấp bởi cơ quan có thẩm quyền.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 210,
        question = """Khi gặp xe buýt đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây?""",
        options = listOf("""Tăng tốc độ để nhanh chóng vượt qua xe buýt.""", """Quan sát, giảm tốc độ đi qua xe buýt hoặc dừng lại để bảo đảm an toàn.""", """Cả hai ý trên."""),
        correctIndex = 1,
        explanation = """Gặp xe buýt nên dừng – quan sát, giảm tốc, đảm bảo an toàn. Không nên vượt vì rất nguy hiểm.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 211,
        question = """Người có mặt tại nơi xảy ra vụ tai giao thông đường bộ có trách nhiệm gì dưới đây?""",
        options = listOf("""Giúp đỡ, cứu chữa kịp thời người bị nạn; báo tin ngay cho cơ quan Công an, cơ sở khám bệnh, chữa bệnh hoặc Ủy ban nhân dân nơi gần nhất; tham gia bảo vệ hiện trường; tham gia bảo vệ tài sản của người bị nạn; cung cấp thông tin liên quan về vụ tai nạn theo yêu cầu của cơ quan có thẩm quyền.""", """Chụp lại hình ảnh vụ tai nạn (nếu có thiết bị ghi hình) và nhanh chóng rời khỏi hiện trường vụ tai nạn.""", """Cả hai ý trên."""),
        correctIndex = 0,
        explanation = """Gặp tai nạn nên cứu người, báo tin, bảo vệ hiện trường, cung cấp thông tin cho cơ quan có thẩm quyền.""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 212,
        question = """Khi đang lái xe mô tô hoặc ô tô, nếu có nhu cầu sử dụng điện thoại để nhắn tin hoặc gọi điện, người lái xe phải thực hiện như thế nào trong các tình huống nêu dưới đây?""",
        options = listOf("""Giảm tốc độ để bảo đảm an toàn với xe phía trước và sử dụng điện thoại để liên lạc.""", """Giảm tốc độ để dừng xe ở nơi cho phép sau đó sử dụng điện thoại để liên lạc.""", """Tăng tốc độ để cách xa xe phía sau và sử dụng điện thoại để liên lạc."""),
        correctIndex = 1,
        explanation = """Khi điều khiển phương tiện mô tô hoặc ô tô thì không được phép sử dụng điện thoại, vì thế chúng ta nên giảm tốc độ và lựa chọn nơi cho phép dừng đỗ để sử dụng theo đúng quy định.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 213,
        question = """Biển nào báo hiệu cấm xe mô tô đi vào?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3"""),
        correctIndex = 0,
        explanation = """Biển 1: cấm xe mô tô - Biển 2: cấm xe ô tô - Biển 3: cấm xe tải.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/306.jpg?v=202606091805"""
    ),
    Question(
        id = 214,
        question = """Biển nào là biển "Cấm đi ngược chiều"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Cả ba biển."""),
        correctIndex = 1,
        explanation = """Biển 1: biển báo cấm - Biển 2: cấm đi ngược chiều - Biển 3: cấm đỗ xe.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/325.jpg?v=202606091805"""
    ),
    Question(
        id = 215,
        question = """Biển nào xe mô tô hai bánh không được đi vào?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: cấm xe ô tô - Biển 2: cấm xe mô tô - Biển 3: cấm xe tải.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/350.jpg?v=202606091805"""
    ),
    Question(
        id = 216,
        question = """Biển nào báo hiệu sắp đến chỗ giao nhau nguy hiểm?""",
        options = listOf("""Biển 1.""", """Biển 1 và biển 2.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 3,
        explanation = """Biển 1: giao nhau với đường sắt có rào chắn - Biển 2: giao nhau đường ưu tiên - Biển 3: giao nhau tín hiệu đèn. Biển báo hình tam giác nền vàng viền đỏ là biển báo nguy hiểm nên chọn cả 3 biển.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/370.jpg?v=202606091805"""
    ),
    Question(
        id = 217,
        question = """Biển nào báo hiệu "Giao nhau với đường không ưu tiên"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Biển 2 và biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: giao nhau với đường không ưu tiên - Biển 2: giao nhau với đường ưu tiên (tam giác ngược) - Biển 3: bắt đầu đường ưu tiên. Nên chọn biển 1""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/382.jpg?v=202606091805"""
    ),
    Question(
        id = 218,
        question = """Biển nào báo hiệu "Chú ý chướng ngại vật"?""",
        options = listOf("""Biển 1.""", """Biển 2 và biển 3.""", """Biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: báo hiệu kết thúc đường đôi - Biển 2, biển 3: chú ý chướng ngoại vật.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/398.jpg?v=202606091805"""
    ),
    Question(
        id = 219,
        question = """Khi gặp biển nào thì các phương tiện không được đi vào, trừ xe ô tô và xe mô tô?""",
        options = listOf("""Biển 1.""", """Biển 2."""),
        correctIndex = 0,
        explanation = """Biển 1: bắt đầu đoạn đường dành cho ô tôvà mô tô - Biển 2: kết thúc đoạn đường dành cho ô tô và mô tô.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/430.jpg?v=202606091805"""
    ),
    Question(
        id = 220,
        question = """Biển nào không cho phép rẽ phải?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Biển 1 và biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: bắt buộc rẽ trái - Biển 2: rẽ trái, rẽ phải - Biển 3: đi thẳng, rẽ phải. Nên chọn biển 1.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/441.jpg?v=202606091805"""
    ),
    Question(
        id = 221,
        question = """Biển nào báo hiệu "Tuyến đường cầu vượt cắt qua"?""",
        options = listOf("""Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Biển 2 và biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1, Biển 2: cầu vượt cắt qua - Biển 3: biển báo cầu vồng. (Cầu vượt liên thông là có chữ trên biển báo)""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/459.jpg?v=202606091805"""
    ),
    Question(
        id = 222,
        question = """Trường hợp này xe nào được quyền đi trước?""",
        options = listOf("""Xe con.""", """Xe mô tô."""),
        correctIndex = 0,
        explanation = """Biển báo stop nên xe mô tô dừng lại xe con đi.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/492.jpg?v=202606091805"""
    ),
    Question(
        id = 223,
        question = """Xe nào được quyền đi trước trong trường hợp này?""",
        options = listOf("""Xe con.""", """Xe mô tô."""),
        correctIndex = 1,
        explanation = """Cả 2 xe đều đèn xanh: xe mô tô rẽ phải trước, xe con rẽ trái sau""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/517.jpg?v=202606091805"""
    ),
    Question(
        id = 224,
        question = """Trong hình dưới, những xe nào vi phạm quy tắc giao thông?""",
        options = listOf("""Xe con (B), xe mô tô (C).""", """Xe con (A), xe mô tô (C).""", """Xe con (E), xe mô tô (D).""", """Tất cả các loại xe trên."""),
        correctIndex = 2,
        explanation = """Xe con E đi làn đường dành cho xe mô tô - Xe mô tô D đi vào làn dành cho xe ô tô.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/548.jpg?v=202606091805"""
    ),
    Question(
        id = 225,
        question = """Xe nào dừng đúng theo quy tắc giao thông?""",
        options = listOf("""Xe con.""", """Xe mô tô.""", """Cả 2 xe đều đúng."""),
        correctIndex = 0,
        explanation = """Dừng trước vạch dừng 5m: xe con 6m đúng, xe moto 3m sai""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/592.jpg?v=202606091805"""
    ),
    Question(
        id = 226,
        question = """Phương tiện giao thông đường bộ gồm những loại nào?""",
        options = listOf("""Phương tiện giao thông cơ giới đường bộ.""", """Phương tiện giao thông thô sơ đường bộ, xe máy chuyên dùng và các loại xe tương tự.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Phương tiện giao thông đường bộ gồm: xe xơ giới, xe thô sơ, xe máy chuyên dùng và các loại xe tương tự.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 227,
        question = """Hành vi giao xe ô tô, mô tô cho người nào sau đây tham gia giao thông đường bộ bị nghiêm cấm?""",
        options = listOf("""Người chưa đủ tuổi theo quy định.""", """Người không có giấy phép lái xe.""", """Người có giấy phép lái xe nhưng đã bị trừ hết 12 điểm.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Chưa tuổi – không bằng – hết 12 điểm, tuyệt đối không giao xe!""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 228,
        question = """Khi gặp hiệu lệnh điều khiển của Cảnh sát giao thông như hình dưới đây thì người tham gia giao thông đường bộ phải đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Người tham gia giao thông đường bộ ở phía sau Cảnh sát giao thông được đi, các hướng khác phải dừng lại.""", """Người tham gia giao thông đường bộ được rẽ phải theo chiều mũi tên màu xanh ở bục Cảnh sát giao thông.""", """Người tham gia giao thông đường bộ ở tất cả các hướng phải dừng lại, trừ các xe đã ở trong khu vực giao nhau.""", """Người tham gia giao thông đường bộ ở phía trước Cảnh sát giao thông phải dừng lại, các hướng khác được đi."""),
        correctIndex = 2,
        explanation = """Gặp CSGT ưu tiên chọn đáp án 3, trừ trường hợp CSGT đứng trên bục giơ 2 tay sẽ chọn đáp án 4.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/45.jpg?v=202606091805"""
    ),
    Question(
        id = 229,
        question = """Muốn vượt xe phía trước, người lái xe mô tô phải có tín hiệu như thế nào dưới đây để bảo đảm an toàn?""",
        options = listOf("""Bấm còi liên tục để xe phía trước biết xe mình xin vượt.""", """Rú ga liên tục để xe phía trước biết xe mình xin vượt.""", """Báo hiệu nhấp nháy bằng đèn chiếu sáng phía trước hoặc còi."""),
        correctIndex = 2,
        explanation = """Muốn vượt – nháy đèn, bấm còi đúng lúc, không ga rú ồn gây mất trật tự.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 230,
        question = """Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào sau đây không được phép?""",
        options = listOf("""Buông cả hai tay; đứng, nằm trên xe điều khiển xe; sử dụng chân chống hoặc vật khác quệt xuống đường khi xe đang chạy.""", """Chở tối đa hai người phía sau khi chở người bệnh đi cấp cứu, áp giải người có hành vi vi phạm pháp luật, trẻ em dưới 12 tuổi và người già yếu hoặc người khuyết tật."""),
        correctIndex = 0,
        explanation = """Ở đáp án 1 là các hành vi bị nghiêm cấm, còn lại đáp án 2 là trường hợp được cho phép.""",
        category = QuestionCategory.RULES,
        isCritical = true,
        imageUrl = null
    ),
    Question(
        id = 231,
        question = """Người được chở trên xe mô tô có được kéo theo người đang điều khiển xe đạp hay không?""",
        options = listOf("""Chỉ được phép nếu cả hai đội mũ bảo hiểm.""", """Không được phép.""", """Chỉ được thực hiện trên đường vắng."""),
        correctIndex = 1,
        explanation = """Người được chở trên xe mô tô không được kéo đẩy xe khác khi tham gia giao thông vì sẽ dễ gây ra tai nạn, mất an toàn.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 232,
        question = """Tại nơi đường giao nhau có báo hiệu đi theo vòng xuyến, người lái xe phải nhường đường như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Nhường đường cho xe đi đến từ bên phải.""", """Nhường đường cho xe đi đến từ bên trái.""", """Không phải nhường đường."""),
        correctIndex = 1,
        explanation = """Có báo hiệu đi theo vòng xuyến nhường đường bên trái, không có báo hiệu nhường đường bên phải. (Có trái, không phải)""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 233,
        question = """Người điều khiển phương tiện tham gia giao thông đường bộ phải quan sát, giảm tốc độ hoặc dừng lại để bảo đảm an toàn trong các trường hợp nào dưới đây?""",
        options = listOf("""Có báo hiệu cảnh báo nguy hiểm hoặc có chướng ngại vật trên đường; chuyển hướng xe chạy hoặc tầm nhìn bị hạn chế.""", """Nơi cầu, cống hẹp, đập tràn, đường ngầm, hầm chui, hầm đường bộ; có vật nuôi đi trên đường hoặc chăn thả ở ven đường.""", """Điểm dừng xe, đỗ xe trên đường bộ có khách đang lên, xuống xe.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Các tình huống ở 3 đáp án 1, 2, 3 đều là nguy hiểm, vì thế khi gặp các trường hợp này người lái xe nên quan sát, giảm tốc độ hoặc dừng lại để đảm bảo an toàn.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 234,
        question = """Khi tham gia giao thông đường bộ, người lái xe phải mang theo các giấy tờ gì?""",
        options = listOf("""Chứng nhận đăng ký xe hoặc bản sao Chứng nhận đăng ký xe có chứng thực kèm bản gốc giấy tờ xác nhận của tổ chức tín dụng, chi nhánh ngân hàng nước ngoài còn hiệu lực trong trường hợp xe đang được thế chấp tại tổ chức tín dụng, chi nhánh ngân hàng nước ngoài.""", """Giấy phép lái xe phù hợp với loại xe đang điều khiển; chứng nhận kiểm định an toàn kỹ thuật và bảo vệ môi trường đối với xe cơ giới theo quy định của pháp luật; chứng nhận bảo hiểm bắt buộc trách nhiệm dân sự của chủ xe cơ giới.""", """Trường hợp các giấy tờ nêu trên đã được tích hợp vào tài khoản định danh điện tử thì việc xuất trình, kiểm tra có thể thực hiện thông qua tài khoản định danh điện tử.""", """Cả ba ý trên."""),
        correctIndex = 3,
        explanation = """Khi tham gia giao thông người lái xe cần có: chứng nhận đăng ký xe. Giấy phép lái xe phù hợp hoặc xuất trình vneid định danh điện tử cấp 2 trở lên.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 235,
        question = """Việc sử dụng xe mô tô, xe gắn máy, xe thô sơ để vận chuyển hành khách, hàng hóa phải thực hiện các quy định nào dưới đây để đảm bảo an toàn giao thông?""",
        options = listOf("""Kiểm tra điều kiện bảo đảm an toàn của xe trước khi tham gia giao thông đường bộ; mang đủ giấy tờ theo quy định của pháp luật.""", """Kiểm tra việc sắp xếp hàng hóa bảo đảm an toàn; không chở quá số người, chở hành lý, hàng hoá vượt quá khối lượng cho phép hoặc vượt quá khổ giới hạn của xe.""", """Cả hai ý trên."""),
        correctIndex = 2,
        explanation = """Để vận chuyển khách hoặc hàng hóa, người lái xe phải đảm bảo phương tiện đủ điều kiện an toàn đi kèm các loại giấy tờ cũng như tuân thủ theo quy định vận chuyển mà pháp luật đưa ra.""",
        category = QuestionCategory.RULES,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 236,
        question = """Trong đoạn đường hai chiều tại khu đông dân cư đang ùn tắc, người điều khiển xe mô tô có văn hóa giao thông sẽ lựa chọn cách xử lý tình huống nào dưới đây?""",
        options = listOf("""Cho xe lấn sang làn ngược chiều để nhanh chóng thoát khỏi nơi ùn tắc.""", """Điều khiển xe trên vỉa hè để nhanh chóng thoát khỏi nơi ùn tắc.""", """Kiên nhẫn tuân thủ hướng dẫn của người điều khiển giao thông hoặc tín hiệu đèn giao thông, di chuyển trên đúng phần đường bên phải theo chiều đi, nhường đường cho các phương tiện đi ngược chiều."""),
        correctIndex = 2,
        explanation = """Giữ bình tĩnh, tuân thủ luật giao thông chính là cách thể hiện văn hóa, trách nhiệm và an toàn khi tham gia giao thông. Đường tắc không vội – Đúng luật là hay – Nhường nhau mới thoát!""",
        category = QuestionCategory.CULTURE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 237,
        question = """Những thói quen nào dưới đây khi điều khiển xe mô tô tay ga tham gia giao thông dễ gây tai nạn nguy hiểm?""",
        options = listOf("""Sử dụng còi.""", """Phanh đồng thời cả phanh trước và phanh sau.""", """Chỉ sử dụng phanh trước."""),
        correctIndex = 2,
        explanation = """Khi điều khiển xe mô tô tay ga, chỉ sử dụng phanh trước sẽ rất nguy hiểm vì:Gây mất cân bằng, đặc biệt khi đi trên đường trơn trượt hoặc đang chạy với tốc độ cao và Dễ khiến bánh trước bị khóa, xe bị trượt hoặc lật, gây tai nạn nghiêm trọng.""",
        category = QuestionCategory.TECHNIQUE,
        isCritical = false,
        imageUrl = null
    ),
    Question(
        id = 238,
        question = """Biển nào dưới đây xe mô tô hai bánh được đi vào?""",
        options = listOf("""Không biển nào.""", """Biển 1 và biển 2.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: cấm xe mô tô - Biển 2: cấm xe ô tô ( xe mô tô được phép đi vào) - Biển 3: cấm xe tải ( xe mô tô được phép đi vào). Nên chọn biển 2 và biển 3.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/307.jpg?v=202606091805"""
    ),
    Question(
        id = 239,
        question = """Biển nào dưới đây các phương tiện không được phép đi vào?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 1 và biển 2."""),
        correctIndex = 2,
        explanation = """Biển 1: biển đường cấm - Biển 2: biển báo cấm đi ngược chiều - Biển 3: cấm đỗ xe. Nên chọn biển 1 và biển 2.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/326.jpg?v=202606091805"""
    ),
    Question(
        id = 240,
        question = """Ba biển này có hiệu lực như thế nào?""",
        options = listOf("""Cấm các loại xe ở biển phụ đi vào.""", """Cấm các loại xe cơ giới đi vào trừ loại xe ở biển phụ."""),
        correctIndex = 0,
        explanation = """Biển báo cấm các loại xe biển phụ.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/351.jpg?v=202606091805"""
    ),
    Question(
        id = 241,
        question = """Biển nào báo hiệu "Giao nhau với đường sắt có rào chắn"?""",
        options = listOf("""Biển 1.""", """Biển 2 và biển 3.""", """Biển 3."""),
        correctIndex = 0,
        explanation = """Biển 1: giao nhau đường sắt có rào chắn - Biển 2: giao nhau đường ưu tiên - Biển 3: giao nhau tín hiệu đèn.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/371.jpg?v=202606091805"""
    ),
    Question(
        id = 242,
        question = """Biển nào báo hiệu "Giao nhau với đường ưu tiên"?""",
        options = listOf("""Biển 1.""", """Biển 2.""", """Biển 3.""", """Cả ba biển."""),
        correctIndex = 2,
        explanation = """Biển 1: giao nhau tuyến đường cùng cấp - Biển 2: giao nhau đường không ưu tiên - Biển 3: giao nhau đường ưu tiên.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/386.jpg?v=202606091805"""
    ),
    Question(
        id = 243,
        question = """Biển nào báo hiệu "Đường hầm"?""",
        options = listOf("""Cả ba biển.""", """Biển 2.""", """Biển 2 và biển 3."""),
        correctIndex = 1,
        explanation = """Biển 1: cửa chui - Biển 2: đường hầm ( có chiều sâu) - Biển 3: cầu vồng""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/400.jpg?v=202606091805"""
    ),
    Question(
        id = 244,
        question = """Biển này có ý nghĩa như thế nào?""",
        options = listOf("""Chỉ hướng đi phải theo.""", """Biển báo hiệu cho người lái xe biết số lượng làn đường trên mặt đường và hướng đi trên mỗi làn đường phải theo.""", """Chỉ hướng đường phải theo."""),
        correctIndex = 1,
        explanation = """Biển báo hiệu cho người lái xe biết số lượng làn đường trên mặt đường và hướng đi trên mỗi làn đường phải theo.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/431.jpg?v=202606091805"""
    ),
    Question(
        id = 245,
        question = """Khi đến chỗ giao nhau, gặp biển nào thì người lái xe không được cho xe đi thẳng, phải rẽ sang hướng khác?""",
        options = listOf("""Biển 1 và biển 2.""", """Biển 1 và biển 3.""", """Biển 2 và biển 3.""", """Cả ba biển."""),
        correctIndex = 0,
        explanation = """Biển 1: bắt buộc rẽ trái - Biển 2: bắt buộc rẽ trái, rẽ phải - Biển 3: bắt buộc đi thẳng, rẽ phải.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/442.jpg?v=202606091805"""
    ),
    Question(
        id = 246,
        question = """Biển báo dưới đây có ý nghĩa như thế nào?""",
        options = listOf("""Chỉ dẫn khoảng cách đến làn đường cứu nạn (làn thoát xe khẩn cấp).""", """Báo hiệu đường cụt phía trước.""", """Báo hiệu nút giao gần nhất phía trước.""", """Báo hiệu trạm dừng nghỉ phía trước."""),
        correctIndex = 0,
        explanation = """Đây là Chỉ dẫn khoảng cách đến làn đường cứu nạn (làn thoát xe khẩn cấp) dựa theo quy chuẩn kỹ thuật quốc gia.""",
        category = QuestionCategory.SIGNS,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/460.jpg?v=202606091805"""
    ),
    Question(
        id = 247,
        question = """Xe nào được quyền đi trước trong trường hợp này?""",
        options = listOf("""Xe mô tô.""", """Xe cứu thương đi làm nhiệm vụ cấp cứu."""),
        correctIndex = 1,
        explanation = """Gặp xe cứu thương (xe ưu tiên) đang làm nhiệm vụ bắt buộc phải nhường.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/495.jpg?v=202606091805"""
    ),
    Question(
        id = 248,
        question = """Theo hướng mũi tên, thứ tự các xe đi như thế nào là đúng quy tắc giao thông?""",
        options = listOf("""Xe con (A), xe mô tô, xe con (B), xe đạp.""", """Xe con (B), xe đạp, xe mô tô, xe con (A).""", """Xe con (A), xe con (B), xe mô tô + xe đạp.""", """Xe mô tô + xe đạp, xe con (A), xe con (B)."""),
        correctIndex = 3,
        explanation = """Thứ tự xét xe đi: Xe trong giao lộ – Xe ưu tiên – Đường ưu tiên – Bên phải trống – rẽ phải – đi thẳng – rẽ trái. Trường hợp 4: bên phải xe nào trống xe đó được quyền đi trước. Xe mô tô + xe đạp bên phải trống đi trước, xe ô tô A đi thẳng, xe ô tô B rẽ trái đi cuối.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/520.jpg?v=202606091805"""
    ),
    Question(
        id = 249,
        question = """Theo tín hiệu đèn, xe nào phải dừng lại là đúng quy tắc giao thông?""",
        options = listOf("""Xe khách, xe mô tô.""", """Xe tải, xe mô tô.""", """Xe con, xe tải."""),
        correctIndex = 2,
        explanation = """LƯU Ý: Rất nhiều học viên nhầm lẫn đây là Biển báo. Tuy nhiên, biển màu đen treo phía trên mỗi làn đường chính là HỆ THỐNG ĐÈN TÍN HIỆU GIAO THÔNG (nhìn kỹ sẽ thấy đèn sáng xanh/đỏ). Dựa theo tín hiệu đèn: Đèn xanh được đi, đèn đỏ phải dừng lại. Vì thế xe con và xe tải (đang gặp đèn đỏ) phải dừng lại; xe khách và mô tô (gặp đèn xanh) được đi.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/553.jpg?v=202606091805"""
    ),
    Question(
        id = 250,
        question = """Trong tình huống dưới đây, xe đầu kéo kéo rơ moóc (xe container) đang rẽ phải, xe con màu xanh và xe máy phía sau xe container đi như thế nào để bảo đảm an toàn?""",
        options = listOf("""Vượt về phía bên phải để đi tiếp.""", """Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi.""", """Vượt về phía bên trái để đi tiếp."""),
        correctIndex = 1,
        explanation = """Không đi vào góc khuất của xe đầu kéo vì đây là điểm mù, rất nhiều vụ tai nạn giao thông xảy ra vì điều do đi và điểm mù của xe đầu kéo.""",
        category = QuestionCategory.DIAGRAM,
        isCritical = false,
        imageUrl = """https://hoclaixehcm.vn/images/a1/600.jpg?v=202606091805"""
    )
)
