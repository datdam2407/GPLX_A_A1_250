package com.example

import com.example.data.datasource.QuestionBank
import com.example.data.model.QuestionCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
  @Test
  fun questionBank_contains250Questions() {
    val allQuestions = QuestionBank.allQuestions
    assertEquals(250, allQuestions.size)
  }

  @Test
  fun questionBank_containsExactly20CriticalQuestions() {
    val criticals = QuestionBank.criticalQuestions
    assertEquals("Should contain exactly 20 critical questions", 20, criticals.size)
  }

  @Test
  fun questionBank_categoriesDistribution() {
    val rules = QuestionBank.getQuestionsByCategory(QuestionCategory.RULES)
    val culture = QuestionBank.getQuestionsByCategory(QuestionCategory.CULTURE)
    val technique = QuestionBank.getQuestionsByCategory(QuestionCategory.TECHNIQUE)
    val signs = QuestionBank.getQuestionsByCategory(QuestionCategory.SIGNS)
    val diagrams = QuestionBank.getQuestionsByCategory(QuestionCategory.DIAGRAM)

    assertEquals(100, rules.size)
    assertEquals(10, culture.size)
    assertEquals(15, technique.size)
    assertEquals(90, signs.size)
    assertEquals(35, diagrams.size)
  }

  @Test
  fun questionBank_generates25QuestionExam() {
    val exam = QuestionBank.generateExamQuestions()
    assertEquals(25, exam.size)
    val hasCritical = exam.any { it.isCritical }
    assertTrue("Exam should include critical questions", hasCritical)
  }

  @Test
  fun trafficSigns_contains185Signs() {
    val signs = QuestionBank.trafficSigns
    assertEquals(185, signs.size)
  }
}
