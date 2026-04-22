package org.homework.lesson22.homework

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.homework.lesson22.KWidget
import org.wikipedia.R

class ReadingFocusModeWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<ReadingFocusModeWidget>(builder) {

    val image by lazy {
        KTextView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Иконка очки"))
    }

    val themeChooserReadingFocusMode by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Свитчер режима чтения"))
    }

    val themeChooserReadingFocusModeDescription by lazy {
        KTextView(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Подзаголовок"))
    }
}