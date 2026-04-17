package org.homework.lesson08

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class TopReadRecyclerItems(matcher: Matcher<View>): KRecyclerItem<TopReadRecyclerItems>(matcher) {
    val textNumber = KTextView(matcher) {
        withId(R.id.numberView)
    }.name(withParent("Текстовый номер"))

    val listCardTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }.name(withParent("Заголовок"))

    val listCardSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }.name(withParent("Подзаголовок"))

    val graphView = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }.name(withParent("График"))

    val numberOfViews = KView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }.name(withParent("Количество просмотров"))

    val imageView by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent(" Image"))
    }
}