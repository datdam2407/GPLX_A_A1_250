package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.data.local.QuestionProgressEntity
import com.example.data.model.Question
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
fun LearningScreen(
    questions: List<Question>,
    currentIndex: Int,
    selectedAnswer: Int?,
    isChecked: Boolean,
    selectedCategory: QuestionCategory,
    progressList: List<QuestionProgressEntity>,
    onSelectCategory: (QuestionCategory) -> Unit,
    onSelectAnswer: (Int) -> Unit,
    onCheckAnswer: () -> Unit,
    onNextQuestion: () -> Unit,
    onPrevQuestion: () -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onToggleBookmark: (Int) -> Unit
) {
    var showJumpDialog by remember { mutableStateOf(false) }

    val currentQuestion = questions.getOrNull(currentIndex)
    val currentProgress = currentQuestion?.let { q ->
        progressList.find { it.questionId == q.id }
    }
    val isBookmarked = currentProgress?.isBookmarked == true

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("learning_screen")
    ) {
        // Categories horizontal filter
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            QuestionCategory.entries.forEach { cat ->
                val isSelected = selectedCategory == cat
                val bgColor = if (isSelected) NavyPrimary else PaperSurface
                val textColor = if (isSelected) Color.White else NavyPrimary
                val borderColor = if (isSelected) NavyPrimary else LineBorder

                Box(
                    modifier = Modifier
                        .testTag("category_pill_${cat.name}")
                        .clip(RoundedCornerShape(20.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                        .clickable { onSelectCategory(cat) }
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = cat.shortTitle,
                        color = textColor,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                }
            }
        }

        // Header: Question counter & Quick jump button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Câu ${currentIndex + 1}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    color = NavyPrimary
                )
                Text(
                    text = " / ${questions.size}",
                    fontSize = 14.sp,
                    color = MutedText
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { currentQuestion?.let { onToggleBookmark(it.id) } },
                    modifier = Modifier.testTag("btn_bookmark")
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Lưu câu hỏi",
                        tint = if (isBookmarked) GoldAccent else MutedText
                    )
                }

                OutlinedButton(
                    onClick = { showJumpDialog = true },
                    modifier = Modifier
                        .height(36.dp)
                        .testTag("btn_jump_dialog"),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FormatListNumbered,
                        contentDescription = "Danh sách câu",
                        modifier = Modifier.size(16.dp),
                        tint = NavyPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Chọn câu",
                        fontSize = 12.sp,
                        color = NavyPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        // Question Details
        if (currentQuestion != null) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, LineBorder, RoundedCornerShape(18.dp)),
                        colors = CardDefaults.cardColors(containerColor = PaperSurface),
                        shape = RoundedCornerShape(18.dp)
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            // Critical badge or Category tag
                            if (currentQuestion.isCritical) {
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(FailRedLight)
                                        .border(1.dp, FailRed, RoundedCornerShape(8.dp))
                                        .padding(horizontal = 10.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Dangerous,
                                        contentDescription = "Điểm liệt",
                                        tint = FailRed,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "CÂU ĐIỂM LIỆT (BẮT BUỘC ĐÚNG)",
                                        color = FailRed,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            } else {
                                Text(
                                    text = currentQuestion.category.title.uppercase(),
                                    color = GoldDark,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }

                            // Question Text
                            Text(
                                text = currentQuestion.question,
                                color = InkText,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = 24.sp
                            )

                            if (!currentQuestion.imageUrl.isNullOrBlank()) {
                                Spacer(modifier = Modifier.height(12.dp))
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
                                            .heightIn(max = 220.dp),
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
                    val isSelected = selectedAnswer == optIdx
                    val isCorrectOption = optIdx == currentQuestion.correctIndex

                    val (cardBg, cardBorder) = when {
                        isChecked && isCorrectOption -> PassGreenLight to PassGreen
                        isChecked && isSelected && !isCorrectOption -> FailRedLight to FailRed
                        isSelected -> Color(0xFFFBF6EB) to GoldAccent
                        else -> Color.White to LineBorder
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("option_$optIdx")
                            .clip(RoundedCornerShape(14.dp))
                            .background(cardBg)
                            .border(1.dp, cardBorder, RoundedCornerShape(14.dp))
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
                                    .background(
                                        when {
                                            isChecked && isCorrectOption -> PassGreen
                                            isChecked && isSelected && !isCorrectOption -> FailRed
                                            isSelected -> NavyPrimary
                                            else -> Color(0xFFEEEAE1)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$letter",
                                    color = if (isSelected || (isChecked && isCorrectOption)) Color.White else InkText,
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

                // Explanation & Tip Box
                if (isChecked) {
                    item {
                        val isUserCorrect = selectedAnswer == currentQuestion.correctIndex
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(if (isUserCorrect) PassGreenLight else Color(0xFFF1EEE6))
                                .border(
                                    1.dp,
                                    if (isUserCorrect) PassGreen else LineBorder,
                                    RoundedCornerShape(14.dp)
                                )
                                .padding(14.dp)
                        ) {
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Giải thích",
                                        tint = if (isUserCorrect) PassGreen else FailRed,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isUserCorrect) "Chính xác!" else "Chưa chính xác!",
                                        fontWeight = FontWeight.Bold,
                                        color = if (isUserCorrect) PassGreen else FailRed,
                                        fontSize = 14.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = currentQuestion.explanation,
                                    color = InkText,
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp
                                )

                                if (currentQuestion.tip != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(verticalAlignment = Alignment.Top) {
                                        Icon(
                                            imageVector = Icons.Default.Lightbulb,
                                            contentDescription = "Mẹo",
                                            tint = GoldAccent,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "Mẹo ghi nhớ: ${currentQuestion.tip}",
                                            color = GoldDark,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Bottom Action Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PaperSurface)
                .border(1.dp, LineBorder)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onPrevQuestion,
                    enabled = currentIndex > 0,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("btn_prev_question"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("← Câu trước", fontWeight = FontWeight.SemiBold)
                }

                if (!isChecked) {
                    Button(
                        onClick = onCheckAnswer,
                        modifier = Modifier
                            .weight(1.5f)
                            .height(48.dp)
                            .testTag("btn_check_answer"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
                    ) {
                        Text("Kiểm tra đáp án", fontWeight = FontWeight.Bold)
                    }
                } else {
                    Button(
                        onClick = onNextQuestion,
                        modifier = Modifier
                            .weight(1.5f)
                            .height(48.dp)
                            .testTag("btn_next_question"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary)
                    ) {
                        Text("Câu tiếp theo →", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }

    // Jump to Question Dialog
    if (showJumpDialog) {
        AlertDialog(
            onDismissRequest = { showJumpDialog = false },
            title = {
                Text(
                    text = "Chọn câu hỏi (Tổng: ${questions.size})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            },
            text = {
                Box(modifier = Modifier.height(300.dp)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(questions.size) { idx ->
                            val isCurrent = idx == currentIndex
                            val q = questions[idx]
                            val qProg = progressList.find { it.questionId == q.id }
                            val isAnswered = qProg != null && (qProg.correctCount > 0 || qProg.wrongCount > 0)

                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        when {
                                            isCurrent -> NavyPrimary
                                            q.isCritical -> FailRedLight
                                            isAnswered -> PassGreenLight
                                            else -> Color(0xFFEAE5D9)
                                        }
                                    )
                                    .border(
                                        1.dp,
                                        if (q.isCritical) FailRed else LineBorder,
                                        RoundedCornerShape(8.dp)
                                    )
                                    .clickable {
                                        onJumpToQuestion(idx)
                                        showJumpDialog = false
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${idx + 1}",
                                    color = if (isCurrent) Color.White else if (q.isCritical) FailRed else InkText,
                                    fontSize = 13.sp,
                                    fontWeight = if (isCurrent || q.isCritical) FontWeight.Bold else FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showJumpDialog = false }) {
                    Text("Đóng")
                }
            }
        )
    }
}
