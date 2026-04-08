package org.homework.lesson18.h.lesson

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class SimpleTest: TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            OnboardingScreen {
                page(2) {
                    step("Проверяет отображение элемента '${image.getName()}'") {
                        image.isDisplayed()
                    }
                }
                step("Нажимает на '${skipButton.getName()}'") {
                    skipButton.click()
                }
            }
        }
    }
}