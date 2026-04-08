package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson08.NewsCardViewRecyclerItems
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class NewsItemNew(matcher: Matcher<View>): KRecyclerItem<NewsItemNew>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголоовк"))
    }

    val overFlowMenu by lazy {
        KButton(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("OverFlow меню"))
    }

    val recyclerItems by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },
            itemTypeBuilder = {
                itemType (::NewsCardViewRecyclerItems)
            }
        ).name(withParent("Список"))
    }
}