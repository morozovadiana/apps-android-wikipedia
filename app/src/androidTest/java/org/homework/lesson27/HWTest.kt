package org.homework.lesson27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class HWTest : TestCase(){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
     val baseRule = HWTestRule()

    @Test
    fun test1(){
        run{
            OnboardingScreen.skipButton.click()
        }
    }

    @Test
    fun test2(){
        run{
            OnboardingScreen.skipButton.click()
        }
    }

    @Test
    @Deprecated("SKIP")
    fun test3(){
        run{
            ExploreScreen.items.click()
        }
    }

    @Test
    fun test4(){
        run{
            OnboardingScreen.skipButton.click()
        }
    }

}