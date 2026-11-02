package com.example.kotlinmodule2

// Небольшие функции с логикой заданий 8 и 10.
fun addWater(current: Int): Int = current + 250

fun updateStreak(currentDays: Int, waterCount: Int): Int =
    if (waterCount >= 1500) currentDays + 1 else 0

data class Product(val id: Int, val name: String, val price: Int)

fun cartTotal(products: List<Product>): Int = products.sumOf { it.price }

fun removeLastProduct(products: List<Product>): List<Product> = products.dropLast(1)

fun addProduct(products: List<Product>, price: Int): List<Product> {
    val newId = (products.maxOfOrNull { it.id } ?: -1) + 1
    return products + Product(newId, "Товар #${newId + 1}", price)
}
