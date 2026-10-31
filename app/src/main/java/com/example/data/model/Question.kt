package com.example.data.model

enum class QuestionCategory(val title: String, val shortTitle: String) {
    ALL("Tất cả câu hỏi", "Tất cả"),
    CRITICAL("20 Câu điểm liệt", "Điểm liệt"),
    RULES("Khái niệm và quy tắc", "Quy tắc"),
    CULTURE("Văn hóa giao thông", "Văn hóa"),
    TECHNIQUE("Kỹ thuật lái xe", "Kỹ thuật"),
    SIGNS("Biển báo đường bộ", "Biển báo"),
    DIAGRAM("Sa hình giao thông", "Sa hình");

    companion object {
        fun fromRaw(categoryStr: String): QuestionCategory {
            return when {
                categoryStr.contains("khái niệm", ignoreCase = true) || categoryStr.contains("quy tắc", ignoreCase = true) -> RULES
                categoryStr.contains("văn hóa", ignoreCase = true) -> CULTURE
                categoryStr.contains("kỹ thuật", ignoreCase = true) -> TECHNIQUE
                categoryStr.contains("biển báo", ignoreCase = true) -> SIGNS
                categoryStr.contains("sa hình", ignoreCase = true) -> DIAGRAM
                else -> RULES
            }
        }
    }
}

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val category: QuestionCategory,
    val isCritical: Boolean = false,
    val tip: String? = null,
    val imageUrl: String? = null
)

data class TrafficSign(
    val id: String,
    val order: Int = 0,
    val name: String,
    val category: String,
    val description: String,
    val imageUrl: String? = null,
    val relatedQuestionId: String? = null
)

data class StudyTip(
    val title: String,
    val category: String,
    val content: String,
    val example: String
)
