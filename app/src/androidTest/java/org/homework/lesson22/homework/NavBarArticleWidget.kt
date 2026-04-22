package org.homework.lesson22.homework

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.homework.lesson22.KWidget
import org.wikipedia.R

class NavBarArticleWidget(builder: ViewBuilder.() -> Unit) : KWidget<NavBarArticleWidget>(builder) {

    val save by lazy {
        KTextView(matcher) {
            withId(R.id.page_save)
        }.name(withParent("Сохранить"))
    }

    val language by lazy {
        KTextView(matcher) {
            withId(R.id.page_language)
        }.name(withParent("Языки"))
    }

    val findInArticle by lazy {
        KTextView(matcher) {
            withId(R.id.page_find_in_article)
        }.name(withParent("Поиск по статье"))
    }

    val theme by lazy {
        KTextView(matcher) {
            withId(R.id.page_theme)
        }.name(withParent("Настройка темы"))
    }

    val content by lazy {
        KTextView(matcher) {
            withId(R.id.page_contents)
        }.name(withParent("Контент"))
    }
}