package org.homework.lesson12

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson08.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

abstract class CustomTest(
    kaspressoBuilder: Kaspresso.Builder = Kaspresso.Builder.advanced {
        flakySafetyParams = FlakySafetyParams.custom(
            timeoutMs = 30000
        )
    }.apply {
        stepWatcherInterceptors.clear()
     //   stepWatcherInterceptors.add()
    }
) : TestCase(kaspressoBuilder) {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyCustomConfig() {
        run {
            OnboardingScreen.skipButton.hasText("Continue")
        }
    }
}

class ConfigTest : CustomTest(kaspressoBuilder = Kaspresso.Builder.advanced {
    flakySafetyParams = FlakySafetyParams.custom(
        timeoutMs = 30000
    )
})