package org.homework.lesson23

import io.github.kakaocup.kakao.web.KWebView
import org.homework.lesson18.h.lesson.NamedScreen
import org.wikipedia.R

object ArticleScreen: NamedScreen<ArticleScreen>() {

    override val screenName = "Экран статьи"
    override val layoutId = null
    override val viewClass = null

    private val webview by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

//    val title by lazy {
//        KWebViewElement (
//            webview,
//            "//h1"
//        )
//    }

    val title by lazy {
        webview.withXpath("//h1")
            .name(withParent("Заголовок статьи"))
    }

    val references by lazy {
        webview.withXpath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }


    val referencesList by lazy {
        KWebViewList (webview, "//ol")
            .name(withParent("Список"))
    }

    fun referenceItem (index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}

