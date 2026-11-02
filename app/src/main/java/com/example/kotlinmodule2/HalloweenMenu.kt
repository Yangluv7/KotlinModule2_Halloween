package com.example.kotlinmodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Оформление вынесено отдельно: логика учебных заданий остаётся прежней.
@Composable
fun HalloweenMenu(onTaskClick: (Int) -> Unit) {
    val orange = Color(0xFFF49A45)
    val cream = Color(0xFFFFEAD1)
    val names = listOf("Приветствие", "Три превью", "Текст и стили", "Кнопка", "Инициалы",
        "Векторный круг", "Контакты", "Трекер воды", "UI-тесты", "Корзина")

    Box(Modifier.fillMaxSize().background(Color(0xFF171222))) {
        Image(painterResource(R.drawable.halloween_background), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier.fillMaxSize().safeDrawingPadding()
                .verticalScroll(rememberScrollState()).padding(horizontal = 22.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("KOTLIN  /  МОДУЛЬ 02", color = orange, fontSize = 12.sp,
                fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
            Spacer(Modifier.height(8.dp))
            Text("Ночь кода", color = cream, fontSize = 38.sp, fontWeight = FontWeight.Bold)
            Text("Десять заданий. Немного магии.", color = Color(0xFFBDB0CA), fontSize = 14.sp)
            Spacer(Modifier.height(12.dp))
            (0..4).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    (1..2).forEach { column ->
                        val number = row * 2 + column
                        Button(
                            onClick = { onTaskClick(number) },
                            modifier = Modifier.weight(1f).height(76.dp),
                            shape = RoundedCornerShape(18.dp),
                            contentPadding = PaddingValues(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = orange, contentColor = Color(0xFF26162A))
                        ) {
                            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Задание $number", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                Text(names[number - 1], fontSize = 11.sp)
                            }
                            Image(painterResource(R.drawable.pumpkin), contentDescription = null,
                                modifier = Modifier.size(27.dp))
                        }
                    }
                }
            }
            Text("09 — тесты трекера воды", color = Color(0xFFBDB0CA), fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp))
            Spacer(Modifier.height(52.dp))
            Text("СОБРАНО С ДУХОМ ХЭЛЛОУИНА", color = orange.copy(alpha = 0.8f),
                fontSize = 10.sp, letterSpacing = 1.5.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
