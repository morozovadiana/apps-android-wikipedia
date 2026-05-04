package org.homework.lesson24

import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R

object WikipediaLanguage : NamedScreen<WikipediaLanguage>() {

    override val screenName = "Wikipedia Languages"
    override val layoutId = null
    override val viewClass = null


    val languageName by lazy {
        KTextView{
            withId(R.id.wiki_language_title)
        }
    }
    val addLanguage by lazy {
        KTextView{
            withId(R.id.wiki_language_title)
            withText("Add language")
        }.name(withParent("Кнопка добавить язык"))
    }
}