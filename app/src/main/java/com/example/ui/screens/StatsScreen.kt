package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.datasource.QuestionBank
import com.example.data.local.ExamResultEntity
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.QuestionCategory
import com.example.ui.theme.FailRed
import com.example.ui.theme.FailRedLight
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldDark
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface
import com.example.ui.theme.PassGreen
import com.example.ui.theme.PassGreenLight

@Composable
fun StatsScreen(
    progressList: List<QuestionProgressEntity>,
    examResults: List<ExamResultEntity>,
    onResetProgress: () -> Unit
) {
    var showResetDialog by remember { mutableStateOf(false) }

    val totalQuestions = 250
    val learnedCount = progressList.count { it.correctCount > 0 || it.wrongCount > 0 }
    val totalCorrectAttempts = progressList.sumOf { it.correctCount }
    val totalWrongAttempts = progressList.sumOf { it.wrongCount }
    val totalAttempts = totalCorrectAttempts + totalWrongAttempts
    val accuracy = if (totalAttempts > 0) {
        ((totalCorrectAttempts.toFloat() / totalAttempts) * 100).toInt()
    } else 0

    val passedExamsCount = examResults.count { it.isPassed }
    val passRate = if (examResults.isNotEmpty()) {
        ((passedExamsCount.toFloat() / examResults.size) * 100).toInt()
    } else 0

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("stats_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column {
                Text(
                    text = "TỔNG QUAN HỌC TẬP",
                    color = GoldAccent,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Thống kê của bạn",
                    color = NavyPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // 3 Key Stats
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatCardItem("Đã luyện", "$learnedCount / $totalQuestions", modifier = Modifier.weight(1f))
                StatCardItem("Chính xác", "$accuracy%", modifier = Modifier.weight(1f))
                StatCardItem("Thi thử", "${examResults.size} lượt", modifier = Modifier.weight(1f))
            }
        }

        // Category progress breakdown
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, LineBorder, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = PaperSurface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Tiến độ theo chủ đề",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyPrimary
                    )
                    Spacer(modifier = Modifier.height(14.dp))

                    val categories = listOf(
                        QuestionCategory.RULES to "Khái niệm và quy tắc giao thông",
                        QuestionCategory.CRITICAL to "20 Câu điểm liệt bắt buộc",
                        QuestionCategory.CULTURE to "Văn hóa & đạo đức lái xe",
                        QuestionCategory.TECHNIQUE to "Kỹ thuật lái xe mô tô",
                        QuestionCategory.SIGNS to "Hệ thống biển báo đường bộ",
                        QuestionCategory.DIAGRAM to "Giải các thế sa hình"
                    )

                    categories.forEach { (cat, title) ->
                        val questionsInCat = QuestionBank.getQuestionsByCategory(cat)
                        val catQuestionIds = questionsInCat.map { it.id }.toSet()
                        val learnedInCat = progressList.count { catQuestionIds.contains(it.questionId) && (it.correctCount > 0 || it.wrongCount > 0) }
                        val percent = if (questionsInCat.isNotEmpty()) {
                            ((learnedInCat.toFloat() / questionsInCat.size) * 100).toInt()
                        } else 0

                        Column(modifier = Modifier.padding(vertical = 6.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = title,
                                    fontSize = 12.sp,
                                    color = InkText,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "$percent% ($learnedInCat/${questionsInCat.size})",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = GoldDark
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            // Custom progress bar
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color(0xFFEEE9DF))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(fraction = (percent / 100f).coerceIn(0f, 1f))
                                        .height(8.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(if (cat == QuestionCategory.CRITICAL) FailRed else GoldAccent)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Recent Exam History Preview
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, LineBorder, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = PaperSurface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Kết quả thi thử gần đây",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = NavyPrimary
                        )
                        Text(
                            text = "Tỷ lệ đỗ: $passRate%",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PassGreen
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    if (examResults.isEmpty()) {
                        Text(
                            text = "Chưa có lượt thi thử nào.",
                            fontSize = 12.sp,
                            color = MutedText,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    } else {
                        examResults.take(4).forEach { exam ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                                    .border(0.dp, Color.Transparent),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = exam.examTitle,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = InkText
                                    )
                                    Text(
                                        text = if (exam.isPassed) "ĐẠT YÊU CẦU" else if (exam.failedDueToCritical) "TRƯỢT ĐIỂM LIỆT" else "CHƯA ĐẠT",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (exam.isPassed) PassGreen else FailRed
                                    )
                                }

                                Text(
                                    text = "${exam.score}/25",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (exam.isPassed) PassGreen else FailRed
                                )
                            }
                        }
                    }
                }
            }
        }

        // Reset data button
        item {
            OutlinedButton(
                onClick = { showResetDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("btn_reset_stats"),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.RestartAlt,
                    contentDescription = "Đặt lại",
                    tint = FailRed,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Đặt lại tiến độ học tập",
                    color = FailRed,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = { Text("Đặt lại tiến độ", fontWeight = FontWeight.Bold) },
            text = { Text("Bạn có muốn xóa tiến độ làm bài để bắt đầu ôn luyện lại từ đầu?") },
            confirmButton = {
                Button(
                    onClick = {
                        showResetDialog = false
                        onResetProgress()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = FailRed)
                ) {
                    Text("Đặt lại")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text("Hủy")
                }
            }
        )
    }
}

@Composable
private fun StatCardItem(title: String, value: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(PaperSurface)
            .border(1.dp, LineBorder, RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = value,
                color = NavyPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = title,
                color = MutedText,
                fontSize = 10.sp
            )
        }
    }
}
