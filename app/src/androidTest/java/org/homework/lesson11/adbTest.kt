package org.homework.lesson11


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson08.ExploreScreen
import org.homework.lesson08.OnboardingScreen
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.wikigames.WikiGamesCardView
import org.wikipedia.main.MainActivity
import java.util.Locale

//Написать тесты по уже имеющимся экранам, но с применением методов управления девайсом:

//1 . поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
//2 . выключение экрана, включение и проверка отображения элемента (любого)
//3 . "свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)
//4 . выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry. Включить сеть и нажать Retry, проверить отображение заголовка (может работать некорректно, в этом случае забить на тест)
//5 . поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
//6 . проверить, что сейчас активна MainActivity.
//не забываем про восстановление состояния девайса через after.

class AdbTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOrientation() {
        run("поворот экрана и проверка ориентации") {
            device.uiDevice.setOrientationLandscape()
            Thread.sleep(3000)
            val actual = device.uiDevice.isNaturalOrientation
            Assert.assertEquals(false, actual)
        }
    }

    @Test
    fun checkSwitchOffAndSwichOnScreen() {
        run("выключение экрана, включение и проверка отображения элемента (любого)") {
            device.uiDevice.sleep()
            Thread.sleep(3000)
            device.uiDevice.wakeUp()
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkCollapseDeviceByHomeButton() {
        run("свернуть приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)") {
            device.uiDevice.pressHome()
            repeat(2) {
                device.uiDevice.pressRecentApps()
                Thread.sleep(1000)
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkSwitchOffInternet() {
        before(
            "выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry." +
                    " Включить сеть и нажать Retry, проверить отображение заголовка"
        ) {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<WikipediaGames> {
                isInstanceOf(WikiGamesCardView::class.java)
            } perform {
                step("Переход на экран WikipediaGames") {
                    cardTitle.click()
                }
            }
            WikipediaGamesScreen {
                step("Тап по кнопке Retry") {
                    retryButton.isDisplayed()
                }
                step("Включение wifi и моб данных") {
                    adbServer.performAdb("shell svc data enable")
                    adbServer.performAdb("shell svc wifi enable")
                }
                Thread.sleep(10000)
                step("Повторный клик по кнопке Retry") {
                    retryButton.click()
                }
                step("Проверка отображения кнопки после появления сети") {
                    playGameButton.isDisplayed()
                }
            }
        }
    }

    @Test
    fun checkLanguage() {
        before("поменять язык приложения и проверить текст какой-нибудь кнопки") {
            device.language.switchInApp(locale = Locale.FRENCH)
        }.after {
            device.language.switchInApp(locale = Locale.ENGLISH)
        }.run {
            OnboardingScreen.skipButton.hasText("Sauter")
        }
    }

    @Test
    fun checkMainActivity() {
        run("проверить, что сейчас активна MainActivity.") {
            OnboardingScreen.skipButton.click()
            device.activities.isCurrent(MainActivity::class.java)
        }
    }
}