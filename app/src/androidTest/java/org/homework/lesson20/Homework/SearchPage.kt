package org.homework.lesson20.Homework

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.NamedScreen
//import org.wikipedia.R
import androidx.appcompat.R
import io.github.kakaocup.kakao.edit.KEditText

object SearchPage: NamedScreen<SearchPage>() {

    override val screenName = "Search Page"
    override val layoutId = null
    override val viewClass = null

    val searchField = KEditText{
        withId(R.id.search_src_text)
    }

    val searchText = KTextView{
        withText("On")
    }
}