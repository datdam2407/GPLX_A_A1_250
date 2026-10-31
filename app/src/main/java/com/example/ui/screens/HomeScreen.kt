package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Signpost
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.QuestionCategory
import com.example.ui.Screen
import com.example.ui.theme.FailRed
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldLight
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyDark
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface

@Composable
fun HomeScreen(
    progressList: List<QuestionProgressEntity>,
    onNavigate: (Screen) -> Unit,
    onSelectCategory: (QuestionCategory) -> Unit,
    onStartWrongPractice: (List<Int>) -> Unit
) {
    val totalQuestions = 250
    val learnedCount = progressList.count { it.correctCount > 0 || it.wrongCount > 0 }
    val masteredCount = progressList.count { it.correctCount > 0 && it.wrongCount == 0 }
    val wrongQuestions = progressList.filter { it.wrongCount > 0 }
    val wrongCount = wrongQuestions.size

    val totalCorrectAttempts = progressList.sumOf { it.correctCount }
    val totalWrongAttempts = progressList.sumOf { it.wrongCount }
    val totalAttempts = totalCorrectAttempts + totalWrongAttempts
    val accuracy = if (totalAttempts > 0) {
        ((totalCorrectAttempts.toFloat() / totalAttempts) * 100).toInt()
    } else 0

    val progressPercent = if (totalQuestions > 0) {
        ((learnedCount.toFloat() / totalQuestions) * 100).toInt()
    } else 0

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("home_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Section
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(NavyPrimary)
                    .padding(22.dp)
            ) {
                Column {
                    Text(
                        text = "LỘ TRÌNH CỦA BẠN",
                        color = GoldAccent,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Vững lý thuyết.\nTự tin cầm lái.",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 32.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Mỗi ngày một chút — tiến gần hơn đến bằng lái A1.",
                        color = Color(0xFFC1C7D0),
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "$progressPercent%",
                                color = GoldLight,
                                fontSize = 34.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "Hoàn thành bộ câu hỏi",
                                color = Color(0xFFB9BEC8),
                                fontSize = 11.sp
                            )
                        }

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(68.dp)
                        ) {
                            CircularProgressIndicator(
                                progress = { (progressPercent / 100f).coerceIn(0f, 1f) },
                                modifier = Modifier.size(68.dp),
                                color = GoldAccent,
                                trackColor = Color(0xFF2B3A52),
                                strokeWidth = 5.dp
                            )
                            Text(
                                text = "$learnedCount/$totalQuestions",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Stats row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatCard(
                    title = "Đã thuộc",
                    value = "$masteredCount",
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "Cần ôn lại",
                    value = "$wrongCount",
                    valueColor = if (wrongCount > 0) FailRed else NavyPrimary,
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "Chính xác",
                    value = "$accuracy%",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Primary Action Button
        item {
            Button(
                onClick = { onNavigate(Screen.LEARNING) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("btn_continue_learning"),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NavyPrimary,
                    contentColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Tiếp tục học lý thuyết",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Tiếp tục",
                        tint = GoldLight
                    )
                }
            }
        }

        // Shortcuts Section
        item {
            Text(
                text = "Học tập & Rèn luyện",
                color = NavyPrimary,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ShortcutCard(
                        icon = Icons.Default.MenuBook,
                        title = "250 câu hỏi",
                        subtitle = "Ôn luyện theo chủ đề",
                        testTag = "shortcut_250_questions",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onSelectCategory(QuestionCategory.ALL)
                            onNavigate(Screen.LEARNING)
                        }
                    )
                    ShortcutCard(
                        icon = Icons.Default.Timer,
                        title = "Thi thử A1",
                        subtitle = "25 câu · 19 phút",
                        testTag = "shortcut_mock_exam",
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigate(Screen.EXAM_INTRO) }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ShortcutCard(
                        icon = Icons.Default.Dangerous,
                        title = "20 câu điểm liệt",
                        subtitle = "Sai là trượt ngay!",
                        iconTint = FailRed,
                        testTag = "shortcut_critical",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onSelectCategory(QuestionCategory.CRITICAL)
                            onNavigate(Screen.LEARNING)
                        }
                    )
                    ShortcutCard(
                        icon = Icons.Default.Cancel,
                        title = "Câu làm sai",
                        subtitle = if (wrongCount > 0) "$wrongCount câu cần sửa" else "Chưa có câu sai",
                        testTag = "shortcut_wrong_questions",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            if (wrongCount > 0) {
                                onStartWrongPractice(wrongQuestions.map { it.questionId })
                            } else {
                                onNavigate(Screen.WRONG_QUESTIONS)
                            }
                        }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ShortcutCard(
                        icon = Icons.Default.Signpost,
                        title = "Tất cả biển báo",
                        subtitle = "185 biển báo & vạch kẻ",
                        testTag = "shortcut_signs",
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigate(Screen.SIGNS) }
                    )
                    ShortcutCard(
                        icon = Icons.Default.AutoAwesome,
                        title = "Mẹo thi 100% đậu",
                        subtitle = "Ghi nhớ thần tốc",
                        iconTint = GoldAccent,
                        testTag = "shortcut_tips",
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigate(Screen.TIPS) }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ShortcutCard(
                        icon = Icons.Default.History,
                        title = "Lịch sử thi thử",
                        subtitle = "Xem lại điểm & bài làm",
                        testTag = "shortcut_history",
                        modifier = Modifier.weight(1f),
                        onClick = { onNavigate(Screen.HISTORY) }
                    )
                    ShortcutCard(
                        icon = Icons.Default.MenuBook,
                        title = "Sa hình & Kỹ thuật",
                        subtitle = "Quy tắc nhường đường",
                        testTag = "shortcut_diagrams",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onSelectCategory(QuestionCategory.DIAGRAM)
                            onNavigate(Screen.LEARNING)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun StatCard(
    title: String,
    value: String,
    valueColor: Color = NavyPrimary,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(PaperSurface)
            .border(1.dp, LineBorder, RoundedCornerShape(16.dp))
            .padding(vertical = 12.dp, horizontal = 10.dp)
    ) {
        Column {
            Text(
                text = value,
                color = valueColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = title,
                color = MutedText,
                fontSize = 11.sp
            )
        }
    }
}

@Composable
private fun ShortcutCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    testTag: String,
    iconTint: Color = GoldAccent,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .testTag(testTag)
            .clip(RoundedCornerShape(16.dp))
            .background(PaperSurface)
            .border(1.dp, LineBorder, RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(14.dp)
    ) {
        Column {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = iconTint,
                modifier = Modifier.size(26.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                color = NavyPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = subtitle,
                color = MutedText,
                fontSize = 11.sp,
                lineHeight = 14.sp
            )
        }
    }
}
