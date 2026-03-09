package org.homework.lesson10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alfa"

    val image = UiView{
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }
    val title = UiTextView{
        withId(
            this@OnboardingUiScreen.packageName, "primaryTextView")
    }
    val subtitle = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }
    val languageList = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "English")
    }

    val addLanguageButton = UiButton{
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    val skip = UiButton{
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val tabs = UiView{
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }

    val continueButton = UiButton{
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

}

object WikipediaLanguages: UiScreen<WikipediaLanguages>() {
    override val packageName: String = "org.wikipedia.alpha"

    val listLanguageEnglish = UiTextView{
        withText("English")
    }
    val listLanguageSpanish = UiTextView{
        withText("Español")
    }
    val addLanguage = UiTextView{
        withId(this@WikipediaLanguages.packageName, "Add language")
    }
}

object AddALanguage: UiScreen<AddALanguage>() {
    override val packageName: String = "org.wikipedia.alfa"

    val espanol = UiTextView{
        withText("Español")
    }
}