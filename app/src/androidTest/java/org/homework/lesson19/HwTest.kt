package org.homework.lesson19

import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.junit.Test

// Воспроизвести код унификации шагов в своём проекте википедии.

//Написать сценарии с помощью шагов:

//Переход на Explore -> Top Read -> проверить отображение картинки в третьем блоке
//Переход на Explore -> нижнее меню More -> settings -> выключить Show link previews ->
// проверить что тогл выключен.
//Скриншот прохождения каждого теста в аллюр на странице просмотра теста, чтобы было видно все шаги
// сохранить рядом с тестами.


class HwTest : BaseTest(){

    @Test
    fun checkTopReadImageIsDisplayed() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                verify.isDisplayed(this)
                topReadBlockByIndex(2){
                    verify.isDisplayed(imageView)
                }
            }
        }
    }

    @Test
    fun checkSwitchOffShowLinkPreviewInSettings() {
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(CommonMenuButton.moreButton)
            action.click(CommonMenuButton.settingsButton)
            Settings.settingsItem("Show link previews") {
                showLinkPreviewSwitch.setChecked(true)
                action.click(showLinkPreviewSwitch)
                verify.isNotChecked(showLinkPreviewSwitch)
            }

        }
    }
}