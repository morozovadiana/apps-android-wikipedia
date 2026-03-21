package org.homework.lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson08.ExploreScreen
import org.homework.lesson08.OnboardingScreen
import org.homework.lesson09.FeaturedArticleItem
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.main.MainActivity

// Переход в произвольную статью
//Проскроллить до элемента с id "References"
//Проверяем текст в элементе с id "References" (это уникальный элемент с постоянным текстом в английской локали)
//Написать xpath до пятой ссылки в тексте как на первой картинке
//Нажать на этот элемент
//Описать экран для всплывающего окна
//Во всплывающем окне (вторая картинка) проверить на соответствие текст заголовка и номер в строке (5.)
//Кнопкой back закрыть всплывающее окно
//Найти вторую ссылку с CSS классом mw-redirect и нажать на неё
//Описать всплывающий экран и нажать на нём кнопку Read article
//Перейти по этой кнопке в новую статью
//Проскроллить до элемента с id "References"

class WebViewTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.items.childWith<FeaturedArticleItem> {
                isInstanceOf(FeaturedArticleCardView::class.java)
            } perform {
                step("Переход в произвольную статью") {
                    click()
                    Thread.sleep(1000)
                }
            }
            ArticalScreen {
                step("Закрыть всплывающее диалоговое окно") {
                    closeButton.click()
                }
                webview {
                    withElement(Locator.ID, "References") {
                        step(
                            "//Проскроллить до элемента с id \"References\""
                        ) {
                            scroll()
                        }
                        step(
                            "проверяем текст в элементе с id \\\"References\\\" "
                        ) {
                            hasText("References")
                        }
                    }
                    withElement(Locator.XPATH, "//sup[contains(@class,'mw-ref')]//span[text()=5]") {
                        step(
                            "Написать xpath до пятой ссылки в тексте как на первой картинке "
                        ) {
                            scroll()
                        }
                        step("нажать на этот элемент") {
                            click()
                        }
                    }
                }
                step(
                    "Описать экран для всплывающего окна" +
                            "Во всплывающем окне проверить на соответствие текст заголовка и номер в строке (5.)"
                ) {
                    number.hasText("5.")
                    referenceText.isDisplayed()
                }
                step("Кнопкой back закрыть всплывающее окно") {
                    pressBack()
                }
                webview {
                    withElement(Locator.XPATH, "//*[@id=\"pcs\"]/section[1]/p[4]/a[24]") {
                        step("Найти вторую ссылку с CSS классом mw-redirect и нажать на неё") {
                            scroll()
                            click()
                        }
                    }
                }
                step("Описать всплывающий экран и нажать на нём кнопку Read article") {
                    linkPreviewTitle.isDisplayed()
                    linkPreviewExtract.isDisplayed()
                    readArticleButton.click()
                }
                step("Перейти по этой кнопке в новую статью") {
                    webview {
                        withElement(Locator.ID, "References") {
                            step(
                                "Проскроллить до элемента с id \"References\""
                            ) {
                                scroll()
                                Thread.sleep(1000)
                            }
                        }
                    }
                }


            }
        }
    }


}