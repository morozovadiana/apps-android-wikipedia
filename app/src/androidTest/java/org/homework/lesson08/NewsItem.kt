package org.homework.lesson08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItem(matcher: Matcher<View>): KRecyclerItem<NewsItem>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val overFlowMenu = KButton(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val recyclerItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType (::NewsCardViewRecyclerItems)
        }
    )
}