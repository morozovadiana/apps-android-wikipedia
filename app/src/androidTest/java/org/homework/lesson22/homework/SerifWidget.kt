package org.homework.lesson22.homework

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KButton
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.homework.lesson22.KWidget
import org.wikipedia.R

class SerifWidget(builder: ViewBuilder.() -> Unit) : KWidget<SerifWidget>(builder) {

    val buttonFontFamilySansSerif by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_sans_serif)
        }.name(withParent("Sans-serif кнопка"))
    }

    val buttonFontFamilySerif by lazy {
        KButton(matcher) {
            withId(R.id.button_font_family_serif)
        }.name(withParent("Serif кнопка"))
    }
}