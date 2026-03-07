package org.homework.lesson09

import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.core.IsInstanceOf
import org.homework.lesson08.CustomizeItem
import org.homework.lesson08.ExploreScreen
import org.homework.lesson08.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.main.MainActivity
import org.wikipedia.feed.announcement.AnnouncementCardView

// 1 . Нажимает Skip на экране онбординга
// 2 . Проверяет отображение блока Featured Article экрана Explore
// 3 . Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore
// 4 . Отключает Featured Article
// 5 . Нажимает стрелку назад в верхнем тулбаре
// 6 . Проверяет, что блок Featured Article не отображается на экране Explore (метод doesNotExist())

class FeatureArticleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFeatureAtricleBlockIsDisplayed() {
        run("Проверяет отображение блока Featured Article экрана Explore") {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen.skipButton.click()
            }
            ExploreScreen.items.childWith<FeatureArticleItem> {
                isInstanceOf(FeaturedArticleCardView::class.java)
            } perform {
                step("Проверяет отображение ,блока") {
                    isDisplayed()
                }
            }

            ExploreScreen.items.childWith<CustomizeItem> {
                isInstanceOf(AnnouncementCardView::class.java)
            } perform {
                step("Нажимает на кнопку Customize") {
                    customizeButton.click()
                }
            }

            CustomizeScreen {
                items.childWith<CustomizeRecycler> {
                    withDescendant { withText("Feature article") }
                } perform {
                    step("Отключает Featured Article") {
                        checkbox.isDisplayed()
                        checkbox.click()
                    }
                }

                step("Возвращается на экран Explore по кнопке back в тулбаре") {
                    backButton.click()
                }
            }

            ExploreScreen.items.childWith<FeatureArticleItem> {
                isInstanceOf(FeaturedArticleCardView::class.java)
            }.perform {
                step("Проверяет, что блок Featured Article не отображается на экране Explore") {
                    title.doesNotExist()
                }
            }
        }
    }
}
