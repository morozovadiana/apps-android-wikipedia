package org.homework.lesson20.Homework

import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.CommonMenuButton
import org.homework.lesson19.Settings
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.homework.lesson20.equalsWithTrim
import org.homework.lesson20.multiAction
import org.junit.Test

// Воспроизведи код урока в отдельных классах как положено. Напиши тестовый сценарий:

class Test : BaseTest() {

    @Test
    fun checkMultiScenario(){
        run {
            //Пропускаешь онбординг методом multiAction()
            OnboardingScreen {
                skipButton.multiAction()
            }
            //Переходишь на экран поиска
            ExploreScreen {
                searchItemByText("Search Wikipedia") {
                    action.click(this)
                }
            }
            //Кликаешь по полю поиска
            SearchPage {
                action.click(searchField)
            //Выполняешь к полю поиска метод multiAction() и проверяешь что оно заполнилось соответствующим значением
                searchField.multiAction()
                searchField.equalsWithTrim("On")
            }
            //Переходишь назад через физическую кнопку back
            repeat(2) {
                device.uiDevice.pressBack()
            }
            CommonMenuButton {
                //Открываешь меню More
                action.click(moreButton)
                //Переходишь в пункт Settings
                action.click(settingsButton)
            }
            //Включаешь свитчер "Download only over Wi-Fi" методом multiAction()
            Settings.settingsItem("Download only over Wi-Fi") {
                showLinkPreviewSwitch.setChecked(false)
                showLinkPreviewSwitch.multiAction()
                //Проверяешь что свитчер включен
                verify.isChecked(showLinkPreviewSwitch)
            }
        }
    }
}