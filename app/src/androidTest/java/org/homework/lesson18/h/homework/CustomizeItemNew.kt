package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class CustomizeItemNew(matcher: Matcher<View>): KRecyclerItem<CustomizeItemNew>(matcher) {
    val image by lazy{
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent(" Картинка"))
    }

    val text by lazy{
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }

    val customizeButton by lazy{
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent(" Кнопка Customize"))
    }

    val gotItButton by lazy{
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка got it"))
    }

    val wikiGamesImageView by lazy {
        KImageView(matcher) {
            withId(R.id.viewWikiGamesCardImage)
        }.name(withParent(" Картинка Wiki Games"))
    }
}
