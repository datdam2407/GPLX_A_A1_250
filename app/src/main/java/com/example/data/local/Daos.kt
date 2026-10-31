package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExamResultDao {
    @Query("SELECT * FROM exam_results ORDER BY dateMillis DESC")
    fun getAllResults(): Flow<List<ExamResultEntity>>

    @Query("SELECT * FROM exam_results WHERE id = :id LIMIT 1")
    suspend fun getResultById(id: Long): ExamResultEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: ExamResultEntity): Long

    @Query("DELETE FROM exam_results WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM exam_results")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM exam_results")
    fun getExamCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM exam_results WHERE isPassed = 1")
    fun getPassedExamCount(): Flow<Int>
}

@Dao
interface QuestionProgressDao {
    @Query("SELECT * FROM question_progress")
    fun getAllProgress(): Flow<List<QuestionProgressEntity>>

    @Query("SELECT * FROM question_progress WHERE questionId = :questionId LIMIT 1")
    suspend fun getProgressForQuestion(questionId: Int): QuestionProgressEntity?

    @Query("SELECT * FROM question_progress WHERE wrongCount > 0 ORDER BY lastAnsweredTimestamp DESC")
    fun getWrongQuestionsProgress(): Flow<List<QuestionProgressEntity>>

    @Query("SELECT * FROM question_progress WHERE isBookmarked = 1")
    fun getBookmarkedProgress(): Flow<List<QuestionProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: QuestionProgressEntity)

    @Query("UPDATE question_progress SET isBookmarked = :bookmarked WHERE questionId = :questionId")
    suspend fun updateBookmark(questionId: Int, bookmarked: Boolean)

    @Query("DELETE FROM question_progress")
    suspend fun resetAllProgress()
}
