package org.homework.lesson08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayItem(matcher: Matcher<View>): KRecyclerItem<DayItem>(matcher) {
    val dateText = KTextView(matcher) {
        withId(R.id.day_header_text)
    }
}