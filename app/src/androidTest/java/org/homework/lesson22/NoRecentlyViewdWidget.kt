package org.homework.lesson22

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class NoRecentlyViewdWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<NoRecentlyViewdWidget>(builder) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.history_empty_image)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KImageView(matcher) {
            withId(R.id.history_empty_title)
        }.name(withParent("Заголовок"))
    }

    val text by lazy {
        KImageView(matcher) {
            withId(R.id.history_empty_message)
        }.name(withParent("Текст"))
    }
}