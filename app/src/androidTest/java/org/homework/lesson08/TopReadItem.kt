package org.homework.lesson08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>): KRecyclerItem<TopReadItem>(matcher) {

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val listItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType (::TopReadRecyclerItems)
        }
    )

    val moreTopReadText = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }
}
