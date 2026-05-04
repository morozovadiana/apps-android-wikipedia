package org.homework.lesson23

import androidx.compose.ui.test.hasText
import org.homework.lesson18.h.homework.ExploreScreen
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.BaseTest
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.homework.lesson22.homework.FeatureArticleScreen
import org.junit.Test

class Test : BaseTest() {

    @Test
    fun checkWebView() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                topReadBlockByIndex(0) {
                    action.click(this)
                }
            }
            Thread.sleep(3000)
            action.click(FeatureArticleScreen.closeButton)

//            ArticleScreen{
//                title.performWebViewAction {
//                    scroll()
//                }
//            }
            ArticleScreen {
                verify.isDisplayed(title)
//          кликает по заголовку References в конце статьи
                references.performWebViewAction {
                    scroll()
                    click()
                    Thread.sleep(3000)
                }
//          берёт второй блок
                referenceItem(2){
//                  проверяет что текст в индексе блока равен [2]
                    performWebViewAction {
                        scroll()
                    }
                    hasText("[2]")
                }
            }
        }
    }
}