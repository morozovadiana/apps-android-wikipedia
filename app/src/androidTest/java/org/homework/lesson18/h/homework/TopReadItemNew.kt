package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson08.TopReadRecyclerItems
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class TopReadItemNew(matcher: Matcher<View>): KRecyclerItem<TopReadItemNew>(matcher) {

    val menu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка меню"))
    }

    val title by lazy{
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val listItems by lazy{
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType (::TopReadRecyclerItems)
            }
        ).name(withParent("Список айтемов"))
    }

    val moreTopReadText by lazy{
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("Текст More Top Read"))
    }
}
