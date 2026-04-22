package org.homework.lesson22

import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R

class SearchScreen() : NamedScreen<SearchScreen> () {
    override val screenName = "Экран поиска"
    override val layoutId = null
    override val viewClass = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val noRecentlyWidget by lazy {
        NoRecentlyViewdWidget {
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустой истории поискеа"))
    }
}