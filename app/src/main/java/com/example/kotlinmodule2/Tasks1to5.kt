package com.example.kotlinmodule2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 1. Nullable-параметр: если имя отсутствует — выводим специальную надпись.
@Composable
fun Hello(name: String?) {
    Text(text = name?.let { "Привет, $it!" } ?: "Имя не задано")
}

@Composable
fun Task1Screen() {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Вариант 1: передано имя")
        Hello("Артём")
        Text("Вариант 2: передано null")
        Hello(null)
    }
}

// 2. Три разных макета предпросмотра: portrait, landscape, round.
@Preview(name = "portrait", showSystemUi = true, widthDp = 390, heightDp = 820,
    device = "spec:width=390dp,height=820dp,orientation=portrait,dpi=420")
@Composable
fun HelloPreviewPortrait() {
    Surface { Hello("Артём") }
}

@Preview(name = "landscape", showSystemUi = true, widthDp = 820, heightDp = 390,
    device = "spec:width=390dp,height=820dp,orientation=landscape,dpi=420")
@Composable
fun HelloPreviewLandscape() {
    Surface { Hello("Артём") }
}

@Preview(
    name = "round", showSystemUi = true, showBackground = false,
    widthDp = 200, heightDp = 200,
    backgroundColor = 0xFFFFFF00,
    device = "spec:width=200dp,height=200dp,dpi=420,isRound=true"
)
@Composable
fun HelloPreviewRound() {
    Box(Modifier.fillMaxSize().background(Color.Yellow, CircleShape), contentAlignment = Alignment.Center) {
        Hello("Артём")
    }
}

@Composable
fun Task2Screen() {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Три макета предпросмотра находятся в Tasks1to5.kt:")
        Text("HelloPreviewPortrait — вертикальный экран")
        Text("HelloPreviewLandscape — горизонтальный экран")
        Text("HelloPreviewRound — круглый экран 200×200 dp с жёлтым фоном")
        Text("Откройте Split/Design для просмотра всех трёх вариантов.")
    }
}

// 3. Три вида одного и того же текста из strings.xml.
@Composable
fun Task3Screen() {
    val message = stringResource(R.string.compose_description)
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)) {
        Text("Вариант 1")
        Text(message, color = Color.Green, fontSize = 16.sp,
            fontStyle = FontStyle.Italic, textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Text("Вариант 2")
        Text(message, maxLines = 1, overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth())
        Text("Вариант 3")
        Text(message, color = Color.Black, fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
            modifier = Modifier.fillMaxWidth().background(Color.Green))
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Preview() { MaterialTheme { Task3Screen() } }

// 4. Широкая светло-серая кнопка, 16 dp радиус, рамка 2 dp, тень 4 dp.
@Composable
fun Task4Screen() {
    var clicked by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Button(
            onClick = { clicked = !clicked },
            modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(if (clicked) "Нажато!" else "Нажми на меня")
        }
    }
}

// 5. Серый контейнер высотой 100 dp, круг по центру с инициалами.
@Composable
fun Task5Screen() {
    Box(
        modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.padding(vertical = 16.dp).fillMaxHeight()
                .aspectRatio(1f).background(Color(0xFFFF5722), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("АС", color = Color.Black)
        }
    }
}
