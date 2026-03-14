package org.homework.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class UiOnboardingTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSkipButton() {
        run {
            OnboardingUiScreen{
                skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun checkDisplayOnboardingScreen() {
        run("Проверка отображения элементов экрана онбординга") {
            OnboardingUiScreen {
                image.isDisplayed()
                title.isDisplayed()
                subtitle.isDisplayed()
            }
        }
    }

    @Test
    fun checkToMoveToTheNextSlide() {
        run("Переход на следующий слайд") {
            OnboardingUiScreen.continueButton.click()
            OnboardingUiScreen.title.containsText("New ways to explore")
        }
    }

    @Test
    fun checkAddingNewLanguages() {
        run("Добавление нового языка") {
            OnboardingUiScreen.addLanguageButton.click()
            WikipediaLanguages.addLanguage.click()
            AddALanguage.espanol.click()
            WikipediaLanguages.listLanguageSpanish.isDisplayed()
        }
    }

    @Test
    fun checkClickSkipButton() {
        run("Нажать на кнопку skip") {
            OnboardingUiScreen.skipButton.click()
        }
    }

}

