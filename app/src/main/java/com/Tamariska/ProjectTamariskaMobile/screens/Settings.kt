package com.Tamariska.ProjectTamariskaMobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon as Icon1
import androidx.compose.material3.Text as Text

@Composable
fun Settings(number: String?) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFF7FFE5), Color(0xFFCEDEBD)),
        startY = 0f,
        endY = 1000f
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF262B26))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon1(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color(0xFFF7FFE5),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Settings",
                color = Color(0xFFF7FFE5),
                fontSize = 20.sp
            )
        }
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(text = "This is settings screens, the number is $number", color = Color.Black)
        }
    }
}