package com.example.data.repository

import com.example.data.datasource.QuestionBank
import com.example.data.local.ExamResultDao
import com.example.data.local.ExamResultEntity
import com.example.data.local.QuestionProgressDao
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.Question
import com.example.data.model.QuestionCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class ExamRepository(
    private val examResultDao: ExamResultDao,
    private val questionProgressDao: QuestionProgressDao
) {
    val allQuestions: List<Question> = QuestionBank.allQuestions
    val criticalQuestions: List<Question> = QuestionBank.criticalQuestions
    val allExamResults: Flow<List<ExamResultEntity>> = examResultDao.getAllResults()
    val allProgress: Flow<List<QuestionProgressEntity>> = questionProgressDao.getAllProgress()
    val wrongQuestionsProgress: Flow<List<QuestionProgressEntity>> = questionProgressDao.getWrongQuestionsProgress()
    val bookmarkedProgress: Flow<List<QuestionProgressEntity>> = questionProgressDao.getBookmarkedProgress()

    fun getQuestionsByCategory(category: QuestionCategory): List<Question> {
        return QuestionBank.getQuestionsByCategory(category)
    }

    fun getQuestionById(id: Int): Question? {
        return allQuestions.find { it.id == id }
    }

    fun createExam(testNumber: Int? = null): List<Question> {
        return QuestionBank.generateExamQuestions(testNumber)
    }

    suspend fun saveExamResult(
        examTitle: String,
        score: Int,
        totalQuestions: Int,
        isPassed: Boolean,
        failedDueToCritical: Boolean,
        timeSpentSeconds: Int,
        answersMap: Map<Int, Int> // questionId -> selectedIndex
    ): Long {
        val jsonAnswers = answersMap.entries.joinToString(",") { "${it.key}:${it.value}" }
        val entity = ExamResultEntity(
            examTitle = examTitle,
            score = score,
            totalQuestions = totalQuestions,
            isPassed = isPassed,
            failedDueToCritical = failedDueToCritical,
            timeSpentSeconds = timeSpentSeconds,
            userAnswersJson = jsonAnswers
        )
        val id = examResultDao.insertResult(entity)

        // Automatically update QuestionProgress for each answered question
        answersMap.forEach { (qId, selectedIdx) ->
            val question = getQuestionById(qId) ?: return@forEach
            val isCorrect = selectedIdx == question.correctIndex
            recordAnswer(qId, selectedIdx, isCorrect)
        }

        return id
    }

    suspend fun recordAnswer(questionId: Int, selectedIndex: Int, isCorrect: Boolean) {
        val existing = questionProgressDao.getProgressForQuestion(questionId)
        val updated = if (existing != null) {
            existing.copy(
                wrongCount = if (isCorrect) existing.wrongCount else existing.wrongCount + 1,
                correctCount = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                lastSelectedOption = selectedIndex,
                lastAnsweredTimestamp = System.currentTimeMillis()
            )
        } else {
            QuestionProgressEntity(
                questionId = questionId,
                isBookmarked = false,
                wrongCount = if (isCorrect) 0 else 1,
                correctCount = if (isCorrect) 1 else 0,
                lastSelectedOption = selectedIndex,
                lastAnsweredTimestamp = System.currentTimeMillis()
            )
        }
        questionProgressDao.upsertProgress(updated)
    }

    suspend fun toggleBookmark(questionId: Int) {
        val existing = questionProgressDao.getProgressForQuestion(questionId)
        if (existing != null) {
            questionProgressDao.updateBookmark(questionId, !existing.isBookmarked)
        } else {
            questionProgressDao.upsertProgress(
                QuestionProgressEntity(
                    questionId = questionId,
                    isBookmarked = true
                )
            )
        }
    }

    suspend fun deleteExamResult(id: Long) {
        examResultDao.deleteById(id)
    }

    suspend fun clearAllHistory() {
        examResultDao.deleteAll()
    }

    suspend fun resetAllProgress() {
        questionProgressDao.resetAllProgress()
    }
}
