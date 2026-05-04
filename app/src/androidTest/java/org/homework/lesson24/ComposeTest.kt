package org.homework.lesson24

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.homework.lesson18.h.lesson.OnboardingScreen
import org.homework.lesson19.ext.action
import org.homework.lesson19.ext.verify
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ComposeTest : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
    .apply { ComposeConfig.Builder.default(this) {} }
) {

    @get:Rule
    val testRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test() {
        run {
            OnboardingScreen {
                page(0) {
                    action.click(addLanguageButton)
                }
            }
            action.click(WikipediaLanguage.addLanguage)
            AddLanguageScreen {
                languageBlock("Deutsch") {
                verify.assertTrimmedTextIsEquals(localName, "Deutsch")
                verify.assertTrimmedTextIsEquals(canonicName, "German")
                action.clickIfEnabled(localName)
            }
        }
            device.uiDevice.pressBack()
            OnboardingScreen{
                page(0) {
                    pageLanguages(1){
                        verify.isDisplayed(languageName)
                        hasText("Deutsch")
                    }
                }
            }
        }
    }
}