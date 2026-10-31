package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.QuestionBank
import com.example.data.local.AppDatabase
import com.example.data.local.ExamResultEntity
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.Question
import com.example.data.model.QuestionCategory
import com.example.data.repository.ExamRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Screen {
    HOME,
    LEARNING,
    EXAM_INTRO,
    EXAM_PLAYING,
    EXAM_RESULT,
    HISTORY,
    WRONG_QUESTIONS,
    SIGNS,
    TIPS,
    STATS
}

data class ExamReviewItem(
    val question: Question,
    val selectedIndex: Int?,
    val isCorrect: Boolean,
    val isCritical: Boolean
)

data class MainUiState(
    val currentScreen: Screen = Screen.HOME,
    val selectedCategory: QuestionCategory = QuestionCategory.ALL,
    // Learning mode state
    val learningQuestions: List<Question> = emptyList(),
    val learningIndex: Int = 0,
    val learningSelectedAnswer: Int? = null,
    val learningIsChecked: Boolean = false,
    // Exam mode state
    val examQuestions: List<Question> = emptyList(),
    val currentExamIndex: Int = 0,
    val examAnswers: Map<Int, Int> = emptyMap(), // question index -> chosen option
    val markedExamQuestions: Set<Int> = emptySet(), // question index marked for review
    val examSecondsRemaining: Int = 19 * 60, // 19 minutes
    val isExamRunning: Boolean = false,
    // Last submitted exam result
    val lastResultEntity: ExamResultEntity? = null,
    val lastReviewItems: List<ExamReviewItem> = emptyList(),
    // Viewing a specific past exam from history
    val viewingHistoryExam: ExamResultEntity? = null,
    val historyReviewItems: List<ExamReviewItem> = emptyList(),
    // Toast / Feedback message
    val snackbarMessage: String? = null
)

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    val repository = ExamRepository(db.examResultDao(), db.questionProgressDao())

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    // Database reactive streams
    val examResults: StateFlow<List<ExamResultEntity>> = repository.allExamResults
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val questionProgress: StateFlow<List<QuestionProgressEntity>> = repository.allProgress
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private var timerJob: Job? = null

    init {
        // Initialize learning questions with all 250 questions
        val initialQuestions = repository.allQuestions
        _uiState.update {
            it.copy(learningQuestions = initialQuestions)
        }
    }

    fun navigateTo(screen: Screen) {
        _uiState.update { it.copy(currentScreen = screen) }
    }

    fun showSnackbar(message: String) {
        _uiState.update { it.copy(snackbarMessage = message) }
    }

    fun clearSnackbar() {
        _uiState.update { it.copy(snackbarMessage = null) }
    }

    // --- LEARNING MODE LOGIC ---
    fun setLearningCategory(category: QuestionCategory) {
        val questions = when (category) {
            QuestionCategory.ALL -> repository.allQuestions
            QuestionCategory.CRITICAL -> repository.criticalQuestions
            else -> repository.getQuestionsByCategory(category)
        }
        _uiState.update {
            it.copy(
                selectedCategory = category,
                learningQuestions = questions,
                learningIndex = 0,
                learningSelectedAnswer = null,
                learningIsChecked = false
            )
        }
    }

    fun startWrongQuestionsPractice(wrongQuestionIds: List<Int>) {
        val questions = repository.allQuestions.filter { wrongQuestionIds.contains(it.id) }
        if (questions.isEmpty()) {
            showSnackbar("Bạn chưa có câu trả lời sai nào!")
            return
        }
        _uiState.update {
            it.copy(
                currentScreen = Screen.LEARNING,
                selectedCategory = QuestionCategory.ALL,
                learningQuestions = questions,
                learningIndex = 0,
                learningSelectedAnswer = null,
                learningIsChecked = false
            )
        }
    }

    fun selectLearningAnswer(index: Int) {
        if (_uiState.value.learningIsChecked) return
        _uiState.update { it.copy(learningSelectedAnswer = index) }
    }

    fun checkLearningAnswer() {
        val state = _uiState.value
        val currentQ = state.learningQuestions.getOrNull(state.learningIndex) ?: return
        val selected = state.learningSelectedAnswer
        if (selected == null) {
            showSnackbar("Vui lòng chọn một đáp án trước!")
            return
        }

        val isCorrect = selected == currentQ.correctIndex
        _uiState.update { it.copy(learningIsChecked = true) }

        viewModelScope.launch {
            repository.recordAnswer(currentQ.id, selected, isCorrect)
        }
    }

    fun nextLearningQuestion() {
        val state = _uiState.value
        if (state.learningIndex < state.learningQuestions.size - 1) {
            _uiState.update {
                it.copy(
                    learningIndex = it.learningIndex + 1,
                    learningSelectedAnswer = null,
                    learningIsChecked = false
                )
            }
        } else {
            showSnackbar("Bạn đã hoàn thành câu hỏi cuối cùng của danh mục này!")
        }
    }

    fun prevLearningQuestion() {
        val state = _uiState.value
        if (state.learningIndex > 0) {
            _uiState.update {
                it.copy(
                    learningIndex = it.learningIndex - 1,
                    learningSelectedAnswer = null,
                    learningIsChecked = false
                )
            }
        }
    }

    fun jumpToLearningQuestion(index: Int) {
        val state = _uiState.value
        if (index in state.learningQuestions.indices) {
            _uiState.update {
                it.copy(
                    learningIndex = index,
                    learningSelectedAnswer = null,
                    learningIsChecked = false
                )
            }
        }
    }

    fun toggleBookmark(questionId: Int) {
        viewModelScope.launch {
            repository.toggleBookmark(questionId)
        }
    }

    // --- EXAM MODE LOGIC ---
    fun startExam(examTitle: String = "Đề thi thử ngẫu nhiên") {
        timerJob?.cancel()
        val questions = repository.createExam()
        _uiState.update {
            it.copy(
                currentScreen = Screen.EXAM_PLAYING,
                examQuestions = questions,
                currentExamIndex = 0,
                examAnswers = emptyMap(),
                markedExamQuestions = emptySet(),
                examSecondsRemaining = 19 * 60,
                isExamRunning = true
            )
        }

        // Start 19 minutes countdown timer
        timerJob = viewModelScope.launch {
            while (_uiState.value.examSecondsRemaining > 0 && _uiState.value.isExamRunning) {
                delay(1000)
                _uiState.update {
                    val nextSec = it.examSecondsRemaining - 1
                    it.copy(examSecondsRemaining = nextSec)
                }
            }
            if (_uiState.value.isExamRunning) {
                submitExam("Hết giờ làm bài!")
            }
        }
    }

    fun selectExamAnswer(optionIndex: Int) {
        val state = _uiState.value
        if (!state.isExamRunning) return
        val currentIdx = state.currentExamIndex
        _uiState.update {
            it.copy(examAnswers = it.examAnswers + (currentIdx to optionIndex))
        }
    }

    fun toggleMarkExamQuestion() {
        val currentIdx = _uiState.value.currentExamIndex
        _uiState.update {
            val marked = it.markedExamQuestions.toMutableSet()
            if (marked.contains(currentIdx)) marked.remove(currentIdx) else marked.add(currentIdx)
            it.copy(markedExamQuestions = marked)
        }
    }

    fun nextExamQuestion() {
        val state = _uiState.value
        if (state.currentExamIndex < state.examQuestions.size - 1) {
            _uiState.update { it.copy(currentExamIndex = it.currentExamIndex + 1) }
        }
    }

    fun prevExamQuestion() {
        val state = _uiState.value
        if (state.currentExamIndex > 0) {
            _uiState.update { it.copy(currentExamIndex = it.currentExamIndex - 1) }
        }
    }

    fun jumpToExamQuestion(index: Int) {
        val state = _uiState.value
        if (index in state.examQuestions.indices) {
            _uiState.update { it.copy(currentExamIndex = index) }
        }
    }

    fun submitExam(reason: String? = null) {
        timerJob?.cancel()
        val state = _uiState.value
        val questions = state.examQuestions
        val answers = state.examAnswers

        var correctCount = 0
        var failedDueToCritical = false
        val reviewList = mutableListOf<ExamReviewItem>()
        val answersMapForDb = mutableMapOf<Int, Int>()

        questions.forEachIndexed { idx, q ->
            val userChoice = answers[idx]
            val isCorrect = userChoice != null && userChoice == q.correctIndex
            if (isCorrect) {
                correctCount++
            } else if (q.isCritical) {
                failedDueToCritical = true
            }
            reviewList.add(
                ExamReviewItem(
                    question = q,
                    selectedIndex = userChoice,
                    isCorrect = isCorrect,
                    isCritical = q.isCritical
                )
            )
            if (userChoice != null) {
                answersMapForDb[q.id] = userChoice
            }
        }

        // Pass condition for Vietnamese A1 driver test:
        // Score >= 21/25 AND no critical question answered incorrectly
        val isPassed = (correctCount >= 21) && !failedDueToCritical
        val timeSpent = (19 * 60) - state.examSecondsRemaining

        viewModelScope.launch {
            val resultId = repository.saveExamResult(
                examTitle = "Bài thi thử A1",
                score = correctCount,
                totalQuestions = 25,
                isPassed = isPassed,
                failedDueToCritical = failedDueToCritical,
                timeSpentSeconds = timeSpent,
                answersMap = answersMapForDb
            )

            val savedEntity = ExamResultEntity(
                id = resultId,
                examTitle = "Bài thi thử A1",
                score = correctCount,
                totalQuestions = 25,
                isPassed = isPassed,
                failedDueToCritical = failedDueToCritical,
                timeSpentSeconds = timeSpent,
                userAnswersJson = answersMapForDb.entries.joinToString(",") { "${it.key}:${it.value}" }
            )

            _uiState.update {
                it.copy(
                    isExamRunning = false,
                    currentScreen = Screen.EXAM_RESULT,
                    lastResultEntity = savedEntity,
                    lastReviewItems = reviewList
                )
            }

            if (reason != null) {
                showSnackbar(reason)
            }
        }
    }

    fun cancelExam() {
        timerJob?.cancel()
        _uiState.update {
            it.copy(
                isExamRunning = false,
                currentScreen = Screen.EXAM_INTRO,
                examAnswers = emptyMap(),
                markedExamQuestions = emptySet()
            )
        }
    }

    // View past exam from History
    fun viewPastExam(exam: ExamResultEntity) {
        val pairs = if (exam.userAnswersJson.isNotBlank()) {
            exam.userAnswersJson.split(",").mapNotNull {
                val parts = it.split(":")
                if (parts.size == 2) {
                    val qId = parts[0].toIntOrNull()
                    val ans = parts[1].toIntOrNull()
                    if (qId != null && ans != null) qId to ans else null
                } else null
            }.toMap()
        } else emptyMap()

        // Reconstruct review items
        val reviewItems = pairs.mapNotNull { (qId, selectedIdx) ->
            val q = repository.getQuestionById(qId) ?: return@mapNotNull null
            ExamReviewItem(
                question = q,
                selectedIndex = selectedIdx,
                isCorrect = selectedIdx == q.correctIndex,
                isCritical = q.isCritical
            )
        }

        _uiState.update {
            it.copy(
                currentScreen = Screen.EXAM_RESULT,
                lastResultEntity = exam,
                lastReviewItems = reviewItems
            )
        }
    }

    fun deleteHistoryExam(id: Long) {
        viewModelScope.launch {
            repository.deleteExamResult(id)
            showSnackbar("Đã xóa bài thi khỏi lịch sử!")
        }
    }

    fun clearAllHistory() {
        viewModelScope.launch {
            repository.clearAllHistory()
            showSnackbar("Đã xóa toàn bộ lịch sử thi thử!")
        }
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
            showSnackbar("Đã đặt lại toàn bộ tiến độ ôn luyện!")
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
