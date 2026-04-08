package org.homework.lesson18.h.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class SearchItemNew(matcher: Matcher<View>): KRecyclerItem<SearchItemNew>(matcher) {
    val icon by lazy {
        KImageView(matcher) {
            withIndex(0) {
                isInstanceOf(AppCompatImageView::class.java)
            }
        }.name(withParent("Иконка"))
    }


    val searchText by lazy {
        KTextView(matcher) {
            withText(R.string.search_hint)
        }.name(withParent("Поле ввода текста"))
    }

    val voiceButton by lazy{
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Кнопка голосового ввода"))
    }
}