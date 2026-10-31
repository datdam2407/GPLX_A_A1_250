package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Timer
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Question
import com.example.ui.theme.FailRed
import com.example.ui.theme.FailRedLight
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldLight
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface

@Composable
fun ExamIntroScreen(
    onStartExam: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .testTag("exam_intro_screen"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(Color(0xFFEAE5D9)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Timer,
                contentDescription = "Thi thử",
                tint = NavyPrimary,
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "MÔ PHỎNG KỲ THI",
            color = GoldAccent,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Sẵn sàng thử sức?",
            color = NavyPrimary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Đề thi gồm 25 câu hỏi trắc nghiệm được rút ngẫu nhiên theo cấu trúc chuẩn sát hạch Giấy phép lái xe A1 của Bộ GTVT.",
            color = MutedText,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Info cards row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(PaperSurface)
                .border(1.dp, LineBorder, RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ExamParamItem(title = "Câu hỏi", value = "25")
            ExamParamItem(title = "Thời gian", value = "19'")
            ExamParamItem(title = "Ngưỡng đạt", value = "21/25")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFFF9E6))
                .border(1.dp, Color(0xFFFFD54F), RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Text(
                text = "⚠️ Chú ý: Làm sai dù chỉ 01 CÂU ĐIỂM LIỆT sẽ bị TRƯỢT NGAY LẬP TỨC kể cả khi đạt trên 21 câu đúng.",
                color = Color(0xFF8A5300),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 17.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = onStartExam,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .testTag("btn_start_exam"),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bắt đầu làm bài thi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Bắt đầu",
                    tint = GoldLight
                )
            }
        }
    }
}

@Composable
private fun ExamParamItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            color = NavyPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            color = MutedText,
            fontSize = 11.sp
        )
    }
}

@Composable
fun ExamPlayScreen(
    questions: List<Question>,
    currentIndex: Int,
    answers: Map<Int, Int>,
    markedQuestions: Set<Int>,
    secondsRemaining: Int,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPrevQuestion: () -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onToggleMark: () -> Unit,
    onSubmitExam: () -> Unit,
    onCancelExam: () -> Unit
) {
    var showSubmitConfirmDialog by remember { mutableStateOf(false) }
    var showCancelConfirmDialog by remember { mutableStateOf(false) }

    val currentQuestion = questions.getOrNull(currentIndex)
    val isMarked = markedQuestions.contains(currentIndex)
    val chosenOption = answers[currentIndex]

    val minutes = secondsRemaining / 60
    val seconds = secondsRemaining % 60
    val timerText = String.format("%02d:%02d", minutes, seconds)
    val isTimeWarning = secondsRemaining <= 120 // less than 2 minutes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("exam_play_screen")
    ) {
        // Exam top bar with timer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(NavyPrimary)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "ĐỀ THI SÁT HẠCH",
                    color = GoldLight,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp
                )
                Text(
                    text = "Câu ${currentIndex + 1} / ${questions.size}",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isTimeWarning) FailRed else Color(0xFF1E2E48))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = timerText,
                    color = if (isTimeWarning) Color.White else GoldLight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }

        // Question content & options
        if (currentQuestion != null) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, LineBorder, RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(containerColor = PaperSurface),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            if (currentQuestion.isCritical) {
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(FailRedLight)
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Dangerous,
                                        contentDescription = "Điểm liệt",
                                        tint = FailRed,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "CÂU ĐIỂM LIỆT",
                                        color = FailRed,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }

                            Text(
                                text = currentQuestion.question,
                                color = InkText,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = 23.sp
                            )

                            if (!currentQuestion.imageUrl.isNullOrBlank()) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.White)
                                        .border(1.dp, LineBorder, RoundedCornerShape(12.dp))
                                        .padding(6.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    coil.compose.AsyncImage(
                                        model = currentQuestion.imageUrl,
                                        contentDescription = "Hình minh họa câu hỏi",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .heightIn(max = 200.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                }
                            }
                        }
                    }
                }

                // Options list
                items(currentQuestion.options.size) { optIdx ->
                    val optionText = currentQuestion.options[optIdx]
                    val isSelected = chosenOption == optIdx

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("exam_option_$optIdx")
                            .clip(RoundedCornerShape(14.dp))
                            .background(if (isSelected) Color(0xFFFBF6EB) else Color.White)
                            .border(
                                1.5.dp,
                                if (isSelected) GoldAccent else LineBorder,
                                RoundedCornerShape(14.dp)
                            )
                            .clickable { onSelectAnswer(optIdx) }
                            .padding(14.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val letter = ('A'.code + optIdx).toChar()
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(CircleShape)
                                    .background(if (isSelected) NavyPrimary else Color(0xFFEEEAE1)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$letter",
                                    color = if (isSelected) Color.White else InkText,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = optionText,
                                color = InkText,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                // Question Map Grid (5x5 = 25 questions)
                item {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Danh sách câu hỏi (${answers.size}/25 đã chọn)",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MutedText
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.height(210.dp)
                    ) {
                        items(questions.size) { idx ->
                            val isCurrent = idx == currentIndex
                            val isAnswered = answers.containsKey(idx)
                            val isMarkedQuestion = markedQuestions.contains(idx)

                            Box(
                                modifier = Modifier
                                    .testTag("exam_grid_item_$idx")
                                    .height(38.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        when {
                                            isCurrent -> NavyPrimary
                                            isAnswered -> Color(0xFFE2EAF8)
                                            else -> Color(0xFFEAE5D9)
                                        }
                                    )
                                    .border(
                                        width = if (isMarkedQuestion) 2.dp else if (isAnswered) 1.dp else 0.5.dp,
                                        color = if (isMarkedQuestion) GoldAccent else LineBorder,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable { onJumpToQuestion(idx) },
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        color = if (isCurrent) Color.White else NavyPrimary,
                                        fontSize = 12.sp,
                                        fontWeight = if (isCurrent || isAnswered) FontWeight.Bold else FontWeight.Normal
                                    )
                                    if (isMarkedQuestion) {
                                        Text(
                                            text = "★",
                                            color = GoldAccent,
                                            fontSize = 9.sp,
                                            modifier = Modifier.padding(start = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Bottom Controls: Nav buttons & Submit
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PaperSurface)
                .border(1.dp, LineBorder)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = onPrevQuestion,
                        enabled = currentIndex > 0,
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("btn_exam_prev"),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("← Trước", fontSize = 12.sp)
                    }

                    OutlinedButton(
                        onClick = onToggleMark,
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("btn_exam_mark"),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = if (isMarked) GoldAccent else NavyPrimary
                        )
                    ) {
                        Icon(
                            imageVector = if (isMarked) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = "Đánh dấu",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(if (isMarked) "Bỏ dấu" else "Đánh dấu", fontSize = 12.sp)
                    }

                    Button(
                        onClick = onNextQuestion,
                        enabled = currentIndex < questions.size - 1,
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("btn_exam_next"),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
                    ) {
                        Text("Tiếp →", fontSize = 12.sp)
                    }
                }

                Button(
                    onClick = { showSubmitConfirmDialog = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .testTag("btn_exam_submit"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GoldAccent)
                ) {
                    Text(
                        text = "Nộp bài thi",
                        color = NavyPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

    // Submit confirmation dialog
    if (showSubmitConfirmDialog) {
        val unansweredCount = questions.size - answers.size
        AlertDialog(
            onDismissRequest = { showSubmitConfirmDialog = false },
            title = {
                Text(
                    text = "Xác nhận nộp bài thi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Column {
                    if (unansweredCount > 0) {
                        Text(
                            text = "Bạn vẫn còn $unansweredCount câu chưa trả lời. Bạn có chắc chắn muốn nộp bài thi ngay bây giờ?",
                            fontSize = 14.sp,
                            color = InkText,
                            lineHeight = 20.sp
                        )
                    } else {
                        Text(
                            text = "Bạn đã hoàn thành đủ 25/25 câu hỏi. Nhấn Nộp bài để chấm điểm tự động.",
                            fontSize = 14.sp,
                            color = InkText
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmDialog = false
                        onSubmitExam()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
                ) {
                    Text("Nộp bài")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmDialog = false }) {
                    Text("Làm tiếp")
                }
            }
        )
    }
}
