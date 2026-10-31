package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.Screen
import com.example.ui.theme.GoldAccent
import com.example.ui.theme.LineBorder
import com.example.ui.theme.MutedText
import com.example.ui.theme.NavyPrimary
import com.example.ui.theme.PaperSurface

@Composable
fun AppBottomBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(PaperSurface)
            .border(width = 1.dp, color = LineBorder)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Trang chủ",
                isSelected = currentScreen == Screen.HOME,
                testTag = "nav_home",
                onClick = { onNavigate(Screen.HOME) }
            )
            BottomNavItem(
                icon = Icons.Default.MenuBook,
                label = "Học tập",
                isSelected = currentScreen == Screen.LEARNING,
                testTag = "nav_learning",
                onClick = { onNavigate(Screen.LEARNING) }
            )
            BottomNavItem(
                icon = Icons.Default.Timer,
                label = "Thi thử",
                isSelected = currentScreen == Screen.EXAM_INTRO || currentScreen == Screen.EXAM_PLAYING || currentScreen == Screen.EXAM_RESULT,
                testTag = "nav_exam",
                onClick = { onNavigate(Screen.EXAM_INTRO) }
            )
            BottomNavItem(
                icon = Icons.Default.BarChart,
                label = "Thống kê",
                isSelected = currentScreen == Screen.STATS,
                testTag = "nav_stats",
                onClick = { onNavigate(Screen.STATS) }
            )
        }
    }
}

@Composable
private fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    testTag: String,
    onClick: () -> Unit
) {
    val tintColor = if (isSelected) NavyPrimary else MutedText
    val bgModifier = if (isSelected) {
        Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFEAE5D9))
    } else {
        Modifier
    }

    Column(
        modifier = Modifier
            .testTag(testTag)
            .then(bgModifier)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = tintColor,
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = label,
            color = tintColor,
            fontSize = 10.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
