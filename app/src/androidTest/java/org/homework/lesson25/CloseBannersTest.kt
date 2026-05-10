package org.homework.lesson25

import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.ext.action
import org.junit.Test

class CloseBannersTest : BaseTest() {

    @Test
    fun checkCloseBannersTest() {
        run{
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                action.click(title)
                topReadBlockByIndex(0) {
                    action.click(textNumber)

                }
            }
        }
    }
}