package com.example.kotlinmodule2

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun HalloweenTheme(content: @Composable () -> Unit) {
    val colors = darkColorScheme(
        primary = Color(0xFFF49A45),
        onPrimary = Color(0xFF26162A),
        secondary = Color(0xFFE7B9FF),
        background = Color(0xFF171222),
        surface = Color(0xFF211A2F),
        onSurface = Color(0xFFFFEAD1),
        surfaceVariant = Color(0xFF3A2B46),
        onSurfaceVariant = Color(0xFFE0D0E8),
        outline = Color(0xFF76566F)
    )
    MaterialTheme(colorScheme = colors, content = content)
}
