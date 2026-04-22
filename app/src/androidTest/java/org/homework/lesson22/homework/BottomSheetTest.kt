package org.homework.lesson22.homework

import org.homework.lesson18.h.homework.ExploreScreen.featureArticle
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.junit.Test

class BottomSheetTest : BaseTest() {


    @Test
    fun checkSwitchTextSize() {
        run {
            action.click(OnboardingScreen.skipButton)
            featureArticle(1) {
                verify.isDisplayed(this)
                action.click(this)
            }
            action.click(FeatureArticleScreen.closeButton)
            // открывает настройки темы
            FeatureArticleScreen.navBarWidget {
                action.click(theme)
            }
            //нажимает на кнопку увеличения шрифта
            BottomSheetScreen.readingWidget {
                verify.isDisplayed(this)
                action.click(buttonIncreaseTextSize)
                //проверяет что отображается 110%
                verify.hasText(textSizePercent, "110%")
                //дважды нажимает на кнопку уменьшения шрифта
                action.click(buttonDecreaseTextSize)
                action.click(buttonDecreaseTextSize)
                verify.hasText(textSizePercent, "90%")
            }
        }
    }

    @Test
    fun checkSwitchTheme() {
        run {
            action.click(OnboardingScreen.skipButton)
            featureArticle(1) {
                verify.isDisplayed(this)
                action.click(this)
            }
            action.click(FeatureArticleScreen.closeButton)
            // открывает настройки темы
            FeatureArticleScreen.navBarWidget {
                action.click(theme)
            }
            BottomSheetScreen.chooseThemeWidget{
                //выключает переключатель Match system theme
                themeChooserMatchSystemThemeSwitch.setChecked(true)
                themeChooserMatchSystemThemeSwitch.click()
                //проверяет, что кнопки включения тёмных тем в состоянии enabled
                verify {
                    buttonThemeDark.isEnabled()
                    buttonThemeBlack.isEnabled()
                }
                //включает переключатель Match system theme
                themeChooserMatchSystemThemeSwitch.click()
                //проверяет, что кнопки включения тёмных тем НЕ в состоянии enabled
                verify {
                    buttonThemeDark.isDisabled()
                    buttonThemeBlack.isDisplayed()
                }
            }
        }
    }
}