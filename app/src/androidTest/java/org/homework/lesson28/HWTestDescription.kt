package org.homework.lesson28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.Description
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.ext.action
import org.homework.lesson20.Homework.SearchPage
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.main.MainActivity

class HWTestDescription : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val baseRule = HWTestRuleAnnotaion()

    private fun checkValidSearchQuery() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                searchItemByText("Search Wikipedia") {
                    action.click(this)
                }
            }
            //Кликаешь по полю поиска
            SearchPage {
                action.click(searchField)
                //Выполняешь к полю поиска метод multiAction() и проверяешь что оно заполнилось соответствующим значением
                searchField.typeText(baseRule.testData)
                searchField.hasText(BuildConfig.VALID_SEARCH_QUERY)
            }
        }
    }

    private fun checkInvalidSearchQuery() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                searchItemByText("Search Wikipedia") {
                    action.click(this)
                }
            }
            //Кликаешь по полю поиска
            SearchPage {
                action.click(searchField)
                //Выполняешь к полю поиска метод multiAction() и проверяешь что оно заполнилось соответствующим значением
                searchField.typeText(baseRule.testData)
                searchField.hasText(BuildConfig.INVALID_SEARCH_QUERY)
            }
        }
    }

    @Test
    @Description("fgfg")
    fun test1() {
        checkInvalidSearchQuery()
    }

    @Test
    @Description("valid")  // должен упасть
    fun test2() {
        checkInvalidSearchQuery()
    }

    @Test
    @Description("valid")
    fun test3() {
        checkValidSearchQuery()
    }

    @Test
    @Description("fgfg")   // должен упасть
    fun test4() {
        checkValidSearchQuery()
    }
}

