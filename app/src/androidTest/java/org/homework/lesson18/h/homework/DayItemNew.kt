package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

class DayItemNew(matcher: Matcher<View>): KRecyclerItem<DayItemNew>(matcher) {
    val dateText by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent(" Текст даты"))
    }
}