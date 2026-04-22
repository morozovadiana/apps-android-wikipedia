package org.homework.lesson22

import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.junit.Test

class ExampleTest : BaseTest() {
    @Test
    fun searchWidgetTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget{
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchText, "Search Wikipedia")
                    isDisplayed(voice)
                }
            }
        }
    }
}