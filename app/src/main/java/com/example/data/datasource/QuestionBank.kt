package com.example.data.datasource

import com.example.data.model.Question
import com.example.data.model.QuestionCategory
import com.example.data.model.StudyTip
import com.example.data.model.TrafficSign

object QuestionBank {

    // Complete official 250 questions from questions_a1.json
    val allQuestions: List<Question> = officialQuestionsList

    val criticalQuestions: List<Question> by lazy {
        allQuestions.filter { it.isCritical }
    }

    fun getQuestionsByCategory(category: QuestionCategory): List<Question> {
        return when (category) {
            QuestionCategory.ALL -> allQuestions
            QuestionCategory.CRITICAL -> criticalQuestions
            else -> allQuestions.filter { it.category == category }
        }
    }

    // Generates a standard 25-question test exam
    fun generateExamQuestions(testNumber: Int? = null): List<Question> {
        val criticalPool = allQuestions.filter { it.isCritical }.shuffled()
        val rulesPool = allQuestions.filter { it.category == QuestionCategory.RULES && !it.isCritical }.shuffled()
        val signsPool = allQuestions.filter { it.category == QuestionCategory.SIGNS }.shuffled()
        val diagramPool = allQuestions.filter { it.category == QuestionCategory.DIAGRAM }.shuffled()
        val cultureTechPool = allQuestions.filter { 
            (it.category == QuestionCategory.CULTURE || it.category == QuestionCategory.TECHNIQUE) && !it.isCritical 
        }.shuffled()

        // 2 critical questions + 12 rules + 2 culture/tech + 5 signs + 4 diagrams = 25 questions
        val exam = mutableListOf<Question>()
        exam.addAll(criticalPool.take(2))
        exam.addAll(rulesPool.take(12))
        exam.addAll(cultureTechPool.take(2))
        exam.addAll(signsPool.take(5))
        exam.addAll(diagramPool.take(4))

        return exam.shuffled()
    }

    val trafficSigns: List<TrafficSign> = officialTrafficSignsList

    val studyTips = listOf(
        StudyTip(
            title = "Mẹo các câu 'Bị nghiêm cấm'",
            category = "Mẹo lý thuyết từ khóa",
            content = "Trong bộ đề 250 câu hỏi A1, gặp các câu hỏi có đáp án chứa cụm từ 'Bị nghiêm cấm' hoặc 'Không được phép' thì 99% đó là đáp án chính xác.",
            example = "Ví dụ: Đua xe trái phép? -> Bị nghiêm cấm. Uống rượu bia lái xe? -> Bị nghiêm cấm."
        ),
        StudyTip(
            title = "Mẹo thứ tự xe ưu tiên",
            category = "Mẹo sa hình & Quy tắc",
            content = "Nhớ thần chú: HỎA -> QUÂN -> THƯƠNG -> HỘ.\n1. Xe chữa cháy (Cứu hỏa)\n2. Xe quân sự, xe công an đi làm nhiệm vụ\n3. Xe cứu thương đang cấp cứu\n4. Xe hộ đê, thiên tai, dịch bệnh.",
            example = "Gặp xe công an và xe cứu thương cùng đến ngã tư -> Xe công an đi trước."
        ),
        StudyTip(
            title = "Mẹo giải thế Sa hình chuẩn 100%",
            category = "Mẹo sa hình",
            content = "Áp dụng theo thứ tự 5 bước:\nBước 1: Xe đã lọt vào ngã tư (Chớm vào giao lộ) -> Đi trước nhất.\nBước 2: Xe ưu tiên (Hỏa - Quân - Thương - Hộ).\nBước 3: Đường ưu tiên (Xem biển tam giác vàng / hình thoi).\nBước 4: Quyền tay phải không vướng (Bên phải ngã tư trống).\nBước 5: Hướng rẽ: Rẽ phải -> Đi thẳng -> Rẽ trái.",
            example = "Thần chú: 'Nhất chớm, nhì ưu, tam đường, tứ hướng'."
        ),
        StudyTip(
            title = "Mẹo tốc độ xe máy & xe gắn máy",
            category = "Mẹo tốc độ",
            content = "- Xe gắn máy (dưới 50cc), xe máy điện: Tối đa 40 km/h trên mọi cung đường.\n- Xe mô tô hai bánh (từ 50cc trở lên) trong khu đông dân cư:\n  + Đường đôi (có dải phân cách giữa): 60 km/h.\n  + Đường hai chiều (không có dải phân cách): 50 km/h.",
            example = "Đường đôi trong phố: 60 km/h. Đường không dải phân cách: 50 km/h."
        ),
        StudyTip(
            title = "Mẹo tuổi tham gia giao thông",
            category = "Mẹo độ tuổi",
            content = "- Đủ 16 tuổi: Được lái xe gắn máy dưới 50 cm3.\n- Đủ 18 tuổi: Được thi bằng lái A1, A2 (lái xe mô tô từ 50 cm3 trở lên và ô tô B1, B2).\n- Nhớ nguyên tắc: Các câu hỏi về độ tuổi thi bằng lái xe máy luôn là 18 tuổi.",
            example = "Tuổi thi bằng lái A1? -> 18 tuổi."
        ),
        StudyTip(
            title = "Mẹo biển báo: Cấm nhỏ thì cấm to, cấm to không cấm nhỏ",
            category = "Mẹo biển báo",
            content = "- Cấm xe con thì cấm luôn xe tải, xe khách.\n- Cấm xe tải thì KHÔNG cấm xe con, xe mô tô.\n- Biển cấm ô tô KHÔNG cấm xe mô tô hai bánh.",
            example = "Gặp biển cấm ô tô con: Mô tô 2 bánh vẫn được đi vào bình thường."
        )
    )
}
