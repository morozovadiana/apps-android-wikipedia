package org.homework.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.interceptors.watcher.testcase.impl.screenshot.ScreenshotFailStepWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase(
//    kaspressoBuilder = Kaspresso.Builder.advanced {
//        viewBehaviorInterceptors.add(BeforeAfterBehaviourInterceptor())
//    }

//    kaspressoBuilder = Kaspresso.Builder.advanced().apply {
//        viewActionWatcherInterceptors.add(MyViewActionInterceptor())
//        viewAssertionWatcherInterceptors.add(MyViewAssertionIntercepter())
//    }

    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(ScreenshotFailStepWatcherInterceptor(screenshots))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun simpleTest() {
        run{
            step("test") {
                OnboardingScreen.continueButton {
                    isDisplayed()
                    click()
                }
              //  ExploreScreen.items.isDisplayed()
            }
        }
    }
}