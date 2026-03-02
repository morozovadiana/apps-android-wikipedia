package org.homework.lesson08

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadRecyclerItems(matcher: Matcher<View>): KRecyclerItem<TopReadRecyclerItems>(matcher) {
    val textNumber = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val listCardTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val listCardSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val graphView = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val numberOfViews = KView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val imageView = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}