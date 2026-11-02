package com.example.kotlinmodule2

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// 9. Три инструментальных UI-теста экрана задания 8.
@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {
    @get:Rule val rule = createComposeRule()

    @Test
    fun addWaterButtonAdds250() {
        rule.setContent { WaterTrackerScreen() }
        rule.onNodeWithText("+250 мл").assertExists().performClick()
        rule.onNodeWithText("350 мл").assertExists()
    }

    @Test
    fun finishDayResetsCounter() {
        rule.setContent { WaterTrackerScreen() }
        rule.onNodeWithText("Завершить день").assertExists().performClick()
        rule.onNodeWithText("0 мл").assertExists()
    }

    @Test
    fun daysCountIncreasesAndResets() {
        rule.setContent { WaterTrackerScreen() }
        repeat(6) { rule.onNodeWithText("+250 мл").performClick() }
        rule.onNodeWithText("Завершить день").performClick()
        rule.onNodeWithText("Дней подряд: 1").assertExists()
        rule.onNodeWithText("Завершить день").performClick()
        rule.onNodeWithText("Дней подряд: 0").assertExists()
    }
}
