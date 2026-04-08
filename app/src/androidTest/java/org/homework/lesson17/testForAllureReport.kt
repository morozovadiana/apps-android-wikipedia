package org.homework.lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson08.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class TestForAllureReport: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkTestForAllure() {
        run {
            step("Проверяет, что кнопка skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет, что кнопка continue отображается") {
                OnboardingScreen.continueButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkNegativeCase() {
        run{
            step("Проверяет, что кнопка имеет неверный текст") {
                OnboardingScreen.skipButton.hasText("ggg")
            }
        }
    }

}