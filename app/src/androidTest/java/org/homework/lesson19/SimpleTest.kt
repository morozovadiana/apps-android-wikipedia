package org.homework.lesson19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity


class TestForAllureReport: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun example() {
        run {
//            val steps = StepDefinitions(this)
//            val action = Actions(steps)
//            val verify = Verify(steps)
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }
}