package org.homework.lesson22.homework

import io.github.kakaocup.kakao.text.KButton
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R

object FeatureArticleScreen: NamedScreen<FeatureArticleScreen>() {
    override val screenName = "Feature Article статья"
    override val layoutId = null
    override val viewClass = null

    val navBarWidget by lazy {
        NavBarArticleWidget {
            withId(R.id.page_actions_tab_container)
        }.name(withParent("Виджет навбара"))
    }

    val closeButton by lazy {
        KButton {
            withId(R.id.closeButton)
        }
    }
}
