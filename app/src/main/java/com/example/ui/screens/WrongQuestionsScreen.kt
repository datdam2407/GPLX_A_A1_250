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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.data.datasource.QuestionBank
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.Question
import com.example.ui.theme.FailRed
import com.example.ui.theme.FailRedLight
import com.example.ui.theme.GoldDark
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface
import com.example.ui.theme.PassGreen

@Composable
fun WrongQuestionsScreen(
    progressList: List<QuestionProgressEntity>,
    onStartPractice: (List<Int>) -> Unit
) {
    val wrongProgress = progressList.filter { it.wrongCount > 0 }
    val wrongQuestions = wrongProgress.mapNotNull { prog ->
        QuestionBank.allQuestions.find { it.id == prog.questionId }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("wrong_questions_screen")
    ) {
        if (wrongQuestions.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Chưa có câu sai",
                        tint = PassGreen,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Không có câu trả lời sai!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyPrimary
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Tuyệt vời! Hiện tại bạn chưa có câu hỏi nào bị làm sai trong quá trình học và thi thử.",
                        fontSize = 13.sp,
                        color = MutedText,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            // Header with start practice button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PaperSurface)
                    .border(1.dp, LineBorder)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Danh sách câu làm sai",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = NavyPrimary
                        )
                        Text(
                            text = "${wrongQuestions.size} câu cần củng cố kiến thức",
                            fontSize = 12.sp,
                            color = FailRed
                        )
                    }

                    Button(
                        onClick = { onStartPractice(wrongQuestions.map { it.id }) },
                        colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("btn_practice_wrong")
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Luyện ngay",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Luyện ngay", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(wrongQuestions, key = { it.id }) { q ->
                    val prog = wrongProgress.find { it.questionId == q.id }
                    val wrongTimes = prog?.wrongCount ?: 1

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, LineBorder, RoundedCornerShape(14.dp)),
                        colors = CardDefaults.cardColors(containerColor = PaperSurface),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Câu ${q.id}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = NavyPrimary
                                    )
                                    if (q.isCritical) {
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

                                Text(
                                    text = "Sai $wrongTimes lần",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = FailRed
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = q.question,
                                fontSize = 14.sp,
                                color = InkText,
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
                                        contentDescription = "Hình minh họa câu hỏi",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .heightIn(max = 180.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Highlight correct answer
                            val correctOptionText = q.options.getOrNull(q.correctIndex) ?: ""
                            val correctLetter = ('A'.code + q.correctIndex).toChar()

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFEFF8F1))
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = "✓ Đáp án đúng: $correctLetter. $correctOptionText",
                                    color = PassGreen,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "💡 ${q.explanation}",
                                fontSize = 11.sp,
                                color = MutedText,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
