package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class WikipediaGamesNew (matcher: Matcher<View>): KRecyclerItem<WikipediaGamesNew>(matcher) {
    val cardTitle by lazy {
        KTextView{
            withId(R.id.viewWikiGamesCardTitle)
        }.name(withParent("Заголовок"))
    }
}