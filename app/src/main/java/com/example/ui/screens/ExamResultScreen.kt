package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.SentimentVeryDissatisfied
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.ExamResultEntity
import com.example.ui.ExamReviewItem
import com.example.ui.Screen
import com.example.ui.theme.FailRed
import com.example.ui.theme.FailRedLight
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.GoldLight
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface
import com.example.ui.theme.PassGreen
import com.example.ui.theme.PassGreenLight

@Composable
fun ExamResultScreen(
    result: ExamResultEntity?,
    reviewItems: List<ExamReviewItem>,
    onRetakeExam: () -> Unit,
    onGoHome: () -> Unit
) {
    if (result == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Không tìm thấy kết quả bài thi.")
        }
        return
    }

    val isPassed = result.isPassed
    val isCriticalFailed = result.failedDueToCritical
    val minutes = result.timeSpentSeconds / 60
    val seconds = result.timeSpentSeconds % 60
    val timeFormatted = String.format("%02d phút %02d giây", minutes, seconds)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("exam_result_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Result Card Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(if (isPassed) NavyPrimary else Color(0xFF2C1819))
                    .padding(22.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = if (isPassed) Icons.Default.EmojiEvents else Icons.Default.SentimentVeryDissatisfied,
                        contentDescription = "Kết quả",
                        tint = if (isPassed) GoldLight else FailRed,
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "KẾT QUẢ BÀI THI",
                        color = GoldLight,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${result.score}/${result.totalQuestions}",
                        color = Color.White,
                        fontSize = 44.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(if (isPassed) PassGreen else FailRed)
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = if (isPassed) "ĐẠT YÊU CẦU" else "CHƯA ĐẠT",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            letterSpacing = 1.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isPassed) {
                            "Chúc mừng bạn! Bạn đủ điều kiện đỗ phần thi lý thuyết."
                        } else if (isCriticalFailed) {
                            "Rất tiếc! Bạn bị trượt do trả lời sai câu hỏi điểm liệt."
                        } else {
                            "Bạn cần đạt tối thiểu 21/25 câu để vượt qua kỳ thi."
                        },
                        color = Color(0xFFDDDCD5),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Critical Failure Alert Warning
        if (isCriticalFailed) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(FailRedLight)
                        .border(1.5.dp, FailRed, RoundedCornerShape(14.dp))
                        .padding(14.dp)
                ) {
                    Row(verticalAlignment = Alignment.Top) {
                        Icon(
                            imageVector = Icons.Default.Dangerous,
                            contentDescription = "Cảnh báo điểm liệt",
                            tint = FailRed,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "TRƯỢT DO SAI CÂU ĐIỂM LIỆT",
                                color = FailRed,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "Theo quy chế sát hạch của Bộ GTVT, thí sinh làm sai bất kỳ câu hỏi điểm liệt nào sẽ bị ĐÁNH TRƯỢT NGAY LẬP TỨC dù đạt điểm tuyệt đối ở các câu còn lại. Hãy đặc biệt chú ý ôn kỹ 20 câu điểm liệt nhé!",
                                color = InkText,
                                fontSize = 12.sp,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }
            }
        }

        // Stats summary row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ResultStatCard(
                    title = "Câu đúng",
                    value = "${result.score}",
                    valueColor = PassGreen,
                    modifier = Modifier.weight(1f)
                )
                ResultStatCard(
                    title = "Câu sai",
                    value = "${result.totalQuestions - result.score}",
                    valueColor = FailRed,
                    modifier = Modifier.weight(1f)
                )
                ResultStatCard(
                    title = "Thời gian",
                    value = String.format("%02d:%02d", minutes, seconds),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Action buttons
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onGoHome,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("btn_result_home"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Về trang chủ", fontWeight = FontWeight.SemiBold)
                }

                Button(
                    onClick = onRetakeExam,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("btn_result_retake"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
                ) {
                    Text("Thi đề khác →", fontWeight = FontWeight.Bold)
                }
            }
        }

        // Review list header
        item {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Xem lại chi tiết bài làm (${reviewItems.size} câu)",
                color = NavyPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Review Items
        itemsIndexed(reviewItems) { idx, item ->
            val isCorrect = item.isCorrect
            val userOption = item.selectedIndex
            val q = item.question

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        if (item.isCritical && !isCorrect) FailRed else LineBorder,
                        RoundedCornerShape(16.dp)
                    ),
                colors = CardDefaults.cardColors(containerColor = PaperSurface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Câu ${idx + 1}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = NavyPrimary
                            )
                            if (item.isCritical) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(FailRedLight)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "ĐIỂM LIỆT",
                                        color = FailRed,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isCorrect) PassGreenLight else FailRedLight)
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = if (isCorrect) "ĐÚNG" else "SAI",
                                color = if (isCorrect) PassGreen else FailRed,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = q.question,
                        color = InkText,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium
                    )

                    if (!q.imageUrl.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .border(1.dp, LineBorder, RoundedCornerShape(10.dp))
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            coil.compose.AsyncImage(
                                model = q.imageUrl,
                                contentDescription = "Hình minh họa",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(max = 180.dp),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Options list with clear markings
                    q.options.forEachIndexed { optIdx, optText ->
                        val isUserChoice = userOption == optIdx
                        val isAnswerCorrect = optIdx == q.correctIndex

                        val (optBg, optBorder, optTextCol) = when {
                            isAnswerCorrect -> Triple(PassGreenLight, PassGreen, PassGreen)
                            isUserChoice && !isAnswerCorrect -> Triple(FailRedLight, FailRed, FailRed)
                            else -> Triple(Color(0xFFFAFAF7), LineBorder, InkText)
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(optBg)
                                .border(1.dp, optBorder, RoundedCornerShape(10.dp))
                                .padding(10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                val letter = ('A'.code + optIdx).toChar()
                                Text(
                                    text = "$letter.",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = optTextCol
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = optText,
                                    fontSize = 12.sp,
                                    color = InkText,
                                    lineHeight = 17.sp,
                                    modifier = Modifier.weight(1f)
                                )
                                if (isAnswerCorrect) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Đáp án đúng",
                                        tint = PassGreen,
                                        modifier = Modifier.size(16.dp)
                                    )
                                } else if (isUserChoice) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Lựa chọn sai",
                                        tint = FailRed,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Explanation
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF1EEE6))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "💡 Giải thích: ${q.explanation}",
                            fontSize = 11.sp,
                            color = InkText,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ResultStatCard(
    title: String,
    value: String,
    valueColor: Color = NavyPrimary,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(PaperSurface)
            .border(1.dp, LineBorder, RoundedCornerShape(14.dp))
            .padding(vertical = 10.dp, horizontal = 8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = value,
                color = valueColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                color = MutedText,
                fontSize = 10.sp
            )
        }
    }
}
