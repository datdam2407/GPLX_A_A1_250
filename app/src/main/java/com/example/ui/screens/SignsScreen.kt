package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Signpost
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.datasource.QuestionBank
import com.example.data.model.TrafficSign
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

@Composable
fun SignsScreen() {
    val allSigns = remember { QuestionBank.trafficSigns }
    val categories = remember {
        listOf(
            "Tất cả",
            "BIỂN BÁO CẤM",
            "BIỂN BÁO NGUY HIỂM",
            "BIỂN HIỆU LỆNH",
            "BIỂN CHỈ DẪN",
            "BIỂN PHỤ",
            "VẠCH VÀ TÍN HIỆU",
            "BIỂN BÁO KHÁC"
        )
    }

    var selectedCategory by remember { mutableStateOf("Tất cả") }
    var searchQuery by remember { mutableStateOf("") }

    val filteredSigns = remember(selectedCategory, searchQuery) {
        allSigns.filter { sign ->
            val matchesCategory = (selectedCategory == "Tất cả") || sign.category.equals(selectedCategory, ignoreCase = true)
            val matchesSearch = searchQuery.isBlank() ||
                    sign.name.contains(searchQuery, ignoreCase = true) ||
                    sign.id.contains(searchQuery, ignoreCase = true) ||
                    sign.description.contains(searchQuery, ignoreCase = true) ||
                    sign.category.contains(searchQuery, ignoreCase = true)
            matchesCategory && matchesSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("signs_screen")
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Tìm kiếm trong 185 biển báo & vạch kẻ...", fontSize = 13.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Tìm kiếm",
                    tint = MutedText
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(14.dp),
            singleLine = true
        )

        // Categories scroll row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                val isSelected = selectedCategory == cat
                val count = if (cat == "Tất cả") allSigns.size else allSigns.count { it.category.equals(cat, ignoreCase = true) }
                val shortLabel = when (cat) {
                    "BIỂN BÁO CẤM" -> "Biển cấm"
                    "BIỂN BÁO NGUY HIỂM" -> "Nguy hiểm"
                    "BIỂN HIỆU LỆNH" -> "Hiệu lệnh"
                    "BIỂN CHỈ DẪN" -> "Chỉ dẫn"
                    "BIỂN PHỤ" -> "Biển phụ"
                    "VẠCH VÀ TÍN HIỆU" -> "Vạch kẻ & Đèn"
                    "BIỂN BÁO KHÁC" -> "Biển khác"
                    else -> "Tất cả (${allSigns.size})"
                }
                val label = if (cat == "Tất cả") shortLabel else "$shortLabel ($count)"

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (isSelected) NavyPrimary else PaperSurface)
                        .border(1.dp, if (isSelected) NavyPrimary else LineBorder, RoundedCornerShape(20.dp))
                        .clickable { selectedCategory = cat }
                        .padding(horizontal = 14.dp, vertical = 7.dp)
                ) {
                    Text(
                        text = label,
                        color = if (isSelected) Color.White else NavyPrimary,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hiển thị ${filteredSigns.size} biển báo",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = MutedText
            )
        }

        // Signs list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filteredSigns, key = { it.id }) { sign ->
                val catUpper = sign.category.uppercase()
                val emblemColor = when {
                    catUpper.contains("CẤM") -> FailRed
                    catUpper.contains("NGUY HIỂM") -> Color(0xFFE65100) // Deep Orange/Amber
                    catUpper.contains("HIỆU LỆNH") -> Color(0xFF1565C0) // Deep Blue
                    catUpper.contains("CHỈ DẪN") -> Color(0xFF00796B) // Teal
                    catUpper.contains("VẠCH") || catUpper.contains("TÍN HIỆU") -> Color(0xFF6A1B9A) // Purple
                    catUpper.contains("PHỤ") -> Color(0xFF4E342E) // Brown
                    else -> Color(0xFF37474F) // Blue Grey
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, LineBorder, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(containerColor = PaperSurface),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            // Traffic sign image or placeholder badge
                            if (!sign.imageUrl.isNullOrBlank()) {
                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.White)
                                        .border(1.dp, LineBorder, RoundedCornerShape(12.dp))
                                        .padding(4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    AsyncImage(
                                        model = sign.imageUrl,
                                        contentDescription = sign.name,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Fit
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(emblemColor.copy(alpha = 0.12f))
                                        .border(1.5.dp, emblemColor, RoundedCornerShape(12.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Signpost,
                                        contentDescription = "Biển báo",
                                        tint = emblemColor,
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(emblemColor.copy(alpha = 0.12f))
                                            .padding(horizontal = 8.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = sign.category,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = emblemColor
                                        )
                                    }

                                    Text(
                                        text = "#${sign.order}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MutedText
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = sign.name,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = NavyPrimary,
                                    lineHeight = 19.sp
                                )

                                if (sign.relatedQuestionId != null && sign.relatedQuestionId.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Liên quan: Câu hỏi #${sign.relatedQuestionId}",
                                        fontSize = 11.sp,
                                        color = GoldDark,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }

                        if (sign.description.isNotBlank() && sign.description != sign.name) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFF7F5EE))
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "💡 ${sign.description}",
                                    fontSize = 12.sp,
                                    color = InkText,
                                    lineHeight = 17.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
