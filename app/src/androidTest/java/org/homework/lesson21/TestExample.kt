package org.homework.lesson21

import org.homework.lesson18.h.homework.ExploreScreen.featureArticle
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.CommonMenuButton
import org.homework.lesson19.Settings
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.homework.lesson20.equalsWithTrim
import org.homework.lesson20.multiAction
import org.junit.Test


// Напиши сценарий для страницы настроек, в котором нужно выбрать по индексу второй блок с чекбоксом
// (включить чекбокс и проверить что он включен) и выбрать третий блок с иконкой справа и проверить в нём
// соответствие текста тому, который в нём реально присутствует.

class TestExample : BaseTest() {

    @Test
    fun invokeAtIndexAndClassTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            featureArticle(1) { verify.isDisplayed(this) }
        }
    }

    @Test
    fun secondBlockWithCheckbox(){
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(CommonMenuButton.moreButton)
            action.click(CommonMenuButton.settingsButton)
            Settings {
                settingsIdItem(0) {
                    showLinkPreviewSwitch.setChecked(false)
                    showLinkPreviewSwitch.multiAction()
                    verify.isChecked(showLinkPreviewSwitch)
                }
                settingsIdItem(1) {
                    title.equalsWithTrim("Collapse tables")
                }
            }
        }
    }
}