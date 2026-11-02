package com.example.kotlinmodule2

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

// 10. Корзина: сумма считается из списка, а не накапливается при отрисовке UI.
@Composable
fun ShoppingCartScreen() {
    var products by remember {
        mutableStateOf(listOf(
            Product(0, "Товар #1", 100),
            Product(1, "Товар #2", 150),
            Product(2, "Товар #3", 56)
        ))
    }
    val totalSum = cartTotal(products)
    val context = LocalContext.current

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Корзина магазина", style = MaterialTheme.typography.titleLarge)
        products.forEach { product ->
            Text("${product.name} — ${product.price} рублей")
        }
        Spacer(Modifier.height(10.dp))
        Text("Товаров на сумму: $totalSum рублей")
        Button(onClick = {
            products = addProduct(products, Random.nextInt(0, 100))
            if (cartTotal(products) > 500) {
                Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Добавить товар")
        }
        if (products.isNotEmpty()) {
            Button(onClick = { products = removeLastProduct(products) }) {
                Text("Удалить товар")
            }
        }
    }
}
