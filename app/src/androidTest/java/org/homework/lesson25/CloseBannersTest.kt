package org.homework.lesson25

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.homework.ExploreScreen.featureArticle
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.homework.lesson22.homework.BottomSheetScreen
import org.homework.lesson22.homework.FeatureArticleScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class CloseBannersTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkCloseBannersTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            featureArticle(1) {
                action.click(this)
            }
            FeatureArticleScreen.navBarWidget {
                action.click(theme)
            }
            BottomSheetScreen.readingWidget {
                verify.isDisplayed(this)
            }
        }
    }
}