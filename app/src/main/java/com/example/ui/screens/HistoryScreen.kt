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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.data.local.ExamResultEntity
import com.example.ui.theme.FailRed
import com.example.ui.theme.FailRedLight
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.InkText
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface
import com.example.ui.theme.PassGreen
import com.example.ui.theme.PassGreenLight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoryScreen(
    examResults: List<ExamResultEntity>,
    onViewExam: (ExamResultEntity) -> Unit,
    onDeleteExam: (Long) -> Unit,
    onClearAllHistory: () -> Unit,
    onStartExam: () -> Unit
) {
    var showClearDialog by remember { mutableStateOf(false) }
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy · HH:mm", Locale.getDefault()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("history_screen")
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Lịch sử thi thử",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = NavyPrimary
                )
                Text(
                    text = "Đã lưu ${examResults.size} lượt thi thử",
                    fontSize = 12.sp,
                    color = MutedText
                )
            }

            if (examResults.isNotEmpty()) {
                IconButton(
                    onClick = { showClearDialog = true },
                    modifier = Modifier.testTag("btn_clear_history")
                ) {
                    Icon(
                        imageVector = Icons.Default.DeleteSweep,
                        contentDescription = "Xóa tất cả",
                        tint = FailRed
                    )
                }
            }
        }

        if (examResults.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "Trống",
                        tint = MutedText,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Chưa có lượt thi thử nào",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = NavyPrimary
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Hãy làm bài thi thử để hệ thống tự động chấm điểm và lưu lịch sử rèn luyện nhé!",
                        fontSize = 13.sp,
                        color = MutedText,
                        textAlign = TextAlign.Center,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = onStartExam,
                        colors = ButtonDefaults.buttonColors(containerColor = NavyPrimary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Bắt đầu thi thử ngay")
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(examResults, key = { it.id }) { result ->
                    val isPassed = result.isPassed
                    val isCriticalFail = result.failedDueToCritical
                    val dateStr = dateFormat.format(Date(result.dateMillis))
                    val minutes = result.timeSpentSeconds / 60
                    val seconds = result.timeSpentSeconds % 60

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("history_item_${result.id}")
                            .border(1.dp, LineBorder, RoundedCornerShape(14.dp))
                            .clickable { onViewExam(result) },
                        colors = CardDefaults.cardColors(containerColor = PaperSurface),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (isPassed) PassGreenLight else FailRedLight),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "${result.score}",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 18.sp,
                                        color = if (isPassed) PassGreen else FailRed
                                    )
                                    Text(
                                        text = "/25",
                                        fontSize = 10.sp,
                                        color = MutedText
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = result.examTitle,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = NavyPrimary
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(
                                                when {
                                                    isPassed -> PassGreen
                                                    isCriticalFail -> FailRed
                                                    else -> Color(0xFF888888)
                                                }
                                            )
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = when {
                                                isPassed -> "ĐẠT"
                                                isCriticalFail -> "RỚT LIỆT"
                                                else -> "CHƯA ĐẠT"
                                            },
                                            color = Color.White,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = dateStr,
                                        fontSize = 11.sp,
                                        color = MutedText
                                    )
                                    Text(
                                        text = " · ",
                                        fontSize = 11.sp,
                                        color = MutedText
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Timer,
                                        contentDescription = "Thời gian",
                                        tint = MutedText,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(
                                        text = String.format("%02d:%02d", minutes, seconds),
                                        fontSize = 11.sp,
                                        color = MutedText
                                    )
                                }
                            }

                            IconButton(
                                onClick = { onDeleteExam(result.id) },
                                modifier = Modifier.size(36.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Xóa bài thi",
                                    tint = Color(0xFFAAAAAA),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (showClearDialog) {
        AlertDialog(
            onDismissRequest = { showClearDialog = false },
            title = { Text("Xác nhận xóa", fontWeight = FontWeight.Bold) },
            text = { Text("Bạn có chắc chắn muốn xóa toàn bộ lịch sử thi thử không? Dữ liệu đã xóa không thể khôi phục.") },
            confirmButton = {
                Button(
                    onClick = {
                        showClearDialog = false
                        onClearAllHistory()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = FailRed)
                ) {
                    Text("Xóa hết")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearDialog = false }) {
                    Text("Hủy")
                }
            }
        )
    }
}
