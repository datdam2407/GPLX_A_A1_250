package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam_results")
data class ExamResultEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val examTitle: String,
    val dateMillis: Long = System.currentTimeMillis(),
    val score: Int,
    val totalQuestions: Int = 25,
    val isPassed: Boolean,
    val failedDueToCritical: Boolean,
    val timeSpentSeconds: Int,
    val userAnswersJson: String // Serialized format: "qId:answerIdx,qId:answerIdx"
)

@Entity(tableName = "question_progress")
data class QuestionProgressEntity(
    @PrimaryKey
    val questionId: Int,
    val isBookmarked: Boolean = false,
    val wrongCount: Int = 0,
    val correctCount: Int = 0,
    val lastSelectedOption: Int? = null,
    val lastAnsweredTimestamp: Long = 0
)
