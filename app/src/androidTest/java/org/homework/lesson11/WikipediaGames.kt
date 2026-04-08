package org.homework.lesson11

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikipediaGames (matcher: Matcher<View>): KRecyclerItem<WikipediaGames>(matcher) {
    val cardTitle = KTextView{
        withId(R.id.viewWikiGamesCardTitle)
    }
}
