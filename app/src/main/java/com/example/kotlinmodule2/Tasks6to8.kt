package com.example.kotlinmodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 6. Векторный круг: верхний правый угол и растянутая фиолетовая версия.
@Composable
fun Task6Screen() {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("1. Исходный круг в правом верхнем углу")
        Box(Modifier.size(width = 240.dp, height = 120.dp).background(Color.Black)) {
            Image(
                painter = painterResource(R.drawable.circle), contentDescription = "Оранжевый круг",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
        Text("2. Синий фон, растянутый фиолетовый круг")
        Box(
            Modifier.size(width = 240.dp, height = 120.dp).background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.circle), contentDescription = "Фиолетовый круг",
                colorFilter = ColorFilter.tint(Color(0xFF800080)),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

private data class Contact(val name: String, val role: String, val phone: String, val address: String)
private val contacts = listOf(
    Contact("Иван Елисеев", "Сотрудник отдела", "+7 999 111-22-33", "Москва, ул. Примерная, 12"),
    Contact("Анна Соколова", "Менеджер", "+7 999 222-33-44", "Москва, ул. Садовая, 4"),
    Contact("Павел Кузнецов", "Разработчик", "+7 999 333-44-55", "Москва, ул. Центральная, 8")
)

// 7. Column: один контакт, несколько карточек. Row: контакт + картинка.
@Composable
fun Task7Screen() {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Вариант 1 — Column с одним контактом")
        ContactDetails(contacts[0])
        HorizontalDivider()
        Text("Вариант 2 — Column из трёх карточек")
        contacts.forEach { contact ->
            Surface(color = MaterialTheme.colorScheme.surfaceVariant, modifier = Modifier.fillMaxWidth()) {
                ContactDetails(contact)
            }
        }
        HorizontalDivider()
        Text("Вариант 3 — Row, карточка и изображение")
        ContactWithPicture(contacts[0])
    }
}

@Composable
private fun ContactDetails(contact: Contact) {
    Column(Modifier.fillMaxWidth().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Имя: ${contact.name}", textAlign = TextAlign.Center)
        Text("Отчество: —", textAlign = TextAlign.Center)
        Text("Должность: ${contact.role}", textAlign = TextAlign.Center)
        Text("Мобильный телефон: ${contact.phone}", textAlign = TextAlign.Center)
        Text("Адрес: ${contact.address}", textAlign = TextAlign.Center)
    }
}

@Composable
private fun ContactWithPicture(contact: Contact) {
    Row(
        Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceVariant).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Имя: ${contact.name}")
            Text("Должность: ${contact.role}")
            Text("Телефон: ${contact.phone}")
            Text("Адрес: ${contact.address}")
        }
        Image(
            painter = painterResource(android.R.drawable.ic_menu_myplaces),
            contentDescription = "Иконка контакта", modifier = Modifier.size(32.dp)
        )
    }
}

// 8. Состояние счётчика. Задание 9 проверяет этот же экран через UI-тесты.
@Composable
fun WaterTrackerScreen() {
    var waterCount by rememberSaveable { mutableIntStateOf(100) }
    var successDays by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Трекер воды", fontSize = 32.sp, fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(32.dp))
        Text("$waterCount мл", fontSize = 44.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(18.dp))
        Button(onClick = { waterCount = addWater(waterCount) }) { Text("+250 мл") }
        Spacer(Modifier.height(12.dp))
        Button(onClick = {
            successDays = updateStreak(successDays, waterCount)
            waterCount = 0
        }) { Text("Завершить день") }
        Spacer(Modifier.height(18.dp))
        Text("Дней подряд: $successDays")
    }
}
