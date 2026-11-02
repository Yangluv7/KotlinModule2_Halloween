package com.example.kotlinmodule2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HalloweenTheme { Module2App() } }
    }
}

@Composable
fun Module2App() {
    var task by rememberSaveable { mutableIntStateOf(0) }
    Surface(modifier = Modifier.fillMaxSize()) {
        if (task == 0) {
            HalloweenMenu(onTaskClick = { task = it })
        } else {
            Box(Modifier.fillMaxSize()) {
                Image(painterResource(R.drawable.halloween_background), contentDescription = null,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                Column(Modifier.fillMaxSize().safeDrawingPadding()) {
                    Row(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        TextButton(onClick = { task = 0 }) { Text("← К заданиям") }
                        Text("Задание $task", fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f).padding(start = 12.dp))
                        Image(painterResource(R.drawable.pumpkin), contentDescription = null,
                            modifier = Modifier.size(36.dp))
                    }
                    Surface(
                        modifier = Modifier.weight(1f).fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, bottom = 24.dp),
                        shape = RoundedCornerShape(24.dp),
                        color = Color(0xEE211A2F),
                        border = BorderStroke(1.dp, Color(0xFF5B3D54))
                    ) {
                        Box(Modifier.fillMaxSize()) {
                            when (task) {
                        1 -> Task1Screen()
                        2 -> Task2Screen()
                        3 -> Task3Screen()
                        4 -> Task4Screen()
                        5 -> Task5Screen()
                        6 -> Task6Screen()
                        7 -> Task7Screen()
                        8, 9 -> WaterTrackerScreen()
                        10 -> ShoppingCartScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
