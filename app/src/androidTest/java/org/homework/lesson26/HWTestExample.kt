package org.homework.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson08.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import java.util.Locale

class HWTestExample : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced().apply {
        testRunWatcherInterceptors.add(TestRunWatcherInterceptorHW())
    }
) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testExample() {
        before("поменять язык приложения и проверить текст какой-нибудь кнопки") {
            device.language.switchInApp(locale = Locale.FRENCH)
        }.after {
            device.language.switchInApp(locale = Locale.ENGLISH)
        }.run {
            OnboardingScreen.skipButton.hasText("Sauter")
        }
    }
}