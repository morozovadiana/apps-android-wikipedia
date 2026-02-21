package org.homework.lesson06

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val titleText = KTextView{
        withText("Reading")
    }

    val textSizePercentage = KTextView{
        withId(R.id.text_size_percent)
    }

    val smallTextSize = KTextView{
        withId(R.id.buttonDecreaseTextSize)
    }

    val bigTextSize = KTextView{
        withId(R.id.buttonIncreaseTextSize)
    }

    val seekBar = KSeekBar{
        withId(R.id.text_size_seek_bar)
    }

    val familySansSerifButton = KButton{
        withId(R.id.button_font_family_sans_serif)
    }

    val familySerifButton = KButton{
        withId(R.id.button_font_family_serif)
    }

    val focusIcon = KImageView{
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val focusModeSwitcher = KCheckBox{
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val descriptionFocusModeSwitcher = KTextView{
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val themeTitleText = KTextView{
        withText(R.string.color_theme_select)
    }

    val buttonThemeLight = KButton{
        withId(R.id.button_theme_light)
    }

    val buttonThemeSepia = KButton{
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeDark = KButton{
        withId(R.id.button_theme_dark)
    }

    val buttonThemeBlack = KButton{
        withId(R.id.button_theme_black)
    }

    val hSystemThemeSwitch = KCheckBox{
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val darkModeSwitch = KCheckBox{
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}