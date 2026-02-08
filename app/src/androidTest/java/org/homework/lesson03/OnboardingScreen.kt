package org.homework.lesson03

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.R
import org.wikipedia.views.AppTextView


val logoImageView = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered)

val firstTextView = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2)

val secondTextView = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)
val optionLabel = listOf(
    AppTextView::class.java,
    R.id.option_label)

val addingLanguageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)
val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)
val pageIndicator = listOf(
    TabLayout::class.java,
    R.id.view_onboarding_page_indicator)

val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)
val secondOnboardingPicture = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered)

val secondPageTextTitle = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_explore_title)

val secondaryPageTextView = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_explore_text)
