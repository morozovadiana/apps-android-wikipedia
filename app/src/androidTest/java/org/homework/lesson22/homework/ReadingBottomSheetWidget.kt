package org.homework.lesson22.homework

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.homework.lesson22.KWidget
import org.wikipedia.R

class ReadingBottomSheetWidget(builder: ViewBuilder.() -> Unit) : KWidget<ReadingBottomSheetWidget>(builder) {

    val readingTitle by lazy {
        KTextView(matcher) {
            withId(R.id.textSettingsCategory)
        }.name(withParent("Заголовок Reading"))
    }

    val textSizePercent by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Иконка процента"))
    }

    val buttonDecreaseTextSize by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Иконка уменьшения текста"))
    }

    val textSizeSeekBar by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Ползунок"))
    }

    val buttonIncreaseTextSize by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Иконка увеличения текста"))
    }
}