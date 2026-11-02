package com.example.kotlinmodule2

import android.graphics.Bitmap
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import java.io.File

// Запускает настоящие экраны и сохраняет снимки для отчёта.
class ReportScreenshotsTest {
    @get:Rule val rule = createAndroidComposeRule<MainActivity>()

    private fun openTask(number: Int) {
        rule.onNodeWithText("Задание $number").performScrollTo().performClick()
    }

    private fun backToMenu() {
        rule.onNodeWithText("← К заданиям").performClick()
    }

    private fun screenshot(name: String) {
        rule.waitForIdle()
        android.os.SystemClock.sleep(500) // Даём эмулятору вывести готовый кадр.
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val folder = File(instrumentation.targetContext.filesDir, "report_screenshots")
        folder.mkdirs()
        val bitmap = instrumentation.uiAutomation.takeScreenshot()
        File(folder, "$name.png").outputStream().use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }
        bitmap.recycle()
    }

    @Test
    fun checkScreensAndSaveReportImages() {
        openTask(1)
        rule.onNodeWithText("Привет, Артём!").assertExists()
        rule.onNodeWithText("Имя не задано").assertExists()
        screenshot("1.1")
        backToMenu()

        openTask(2)
        rule.onNodeWithText("HelloPreviewPortrait — вертикальный экран").assertExists()
        backToMenu()

        openTask(3)
        rule.onNodeWithText("Вариант 3").assertExists()
        screenshot("3.1")
        backToMenu()

        openTask(4)
        screenshot("4.1")
        rule.onNodeWithText("Нажми на меня").performClick()
        rule.onNodeWithText("Нажато!").assertExists()
        backToMenu()

        openTask(5)
        rule.onNodeWithText("АС").assertExists()
        screenshot("5.1")
        backToMenu()

        openTask(6)
        rule.onNodeWithContentDescription("Фиолетовый круг").assertExists()
        screenshot("6.1")
        backToMenu()

        openTask(7)
        screenshot("7.1")
        rule.onNodeWithContentDescription("Иконка контакта").performScrollTo()
        rule.onNode(hasScrollAction()).performTouchInput { swipeUp() }
        screenshot("7.2")
        backToMenu()

        openTask(8)
        repeat(6) { rule.onNodeWithText("+250 мл").performClick() }
        rule.onNodeWithText("1600 мл").assertExists()
        screenshot("8.1")
        rule.onNodeWithText("Завершить день").performClick()
        rule.onNodeWithText("0 мл").assertExists()
        rule.onNodeWithText("Дней подряд: 1").assertExists()
        screenshot("8.2")
        backToMenu()

        openTask(9)
        rule.onNodeWithText("Трекер воды").assertExists()
        backToMenu()

        openTask(10)
        rule.onNodeWithText("Товаров на сумму: 306 рублей").assertExists()
        screenshot("10.1")
        var added = 0
        fun total(): Int {
            val text = rule.onNode(hasText("Товаров на сумму:", substring = true))
                .fetchSemanticsNode().config[SemanticsProperties.Text].first().text
            return text.substringAfter(": ").substringBefore(" ").toInt()
        }
        while (total() <= 500) {
            rule.onNodeWithText("Добавить товар").performScrollTo().performClick()
            added++
            check(added < 100) { "Сумма корзины не достигла порога" }
        }
        screenshot("10.2")
        repeat(3 + added) {
            rule.onNodeWithText("Удалить товар").performScrollTo().performClick()
        }
        rule.onNodeWithText("Товаров на сумму: 0 рублей").assertExists()
        rule.onNodeWithText("Удалить товар").assertDoesNotExist()
        android.os.SystemClock.sleep(2500) // Ждём исчезновения предыдущего Toast.
        screenshot("10.3")
    }
}
