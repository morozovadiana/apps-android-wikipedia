package org.homework.lesson22.homework

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.homework.lesson22.KWidget
import org.wikipedia.R

class ChooseThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ChooseThemeWidget>(builder) {

    val themeTitle by lazy {
        KTextView(matcher) {
            withText("Theme")
        }.name(withParent("Заголовок Theme"))
    }

    val buttonThemeLight by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_light)
        }.name(withParent("Светлая тема"))
    }

    val buttonThemeSepia by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_sepia)
        }.name(withParent("Сепия тема"))
    }

    val buttonThemeDark by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Темная тема"))
    }

    val buttonThemeBlack by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Черная тема"))
    }

    val themeChooserMatchSystemThemeSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Чекбокс системной темы"))
    }

    val themeChooserDarkModeDimImages by lazy {
        KTextView(matcher) {
            withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("Чекбокс темной темы"))
    }
}