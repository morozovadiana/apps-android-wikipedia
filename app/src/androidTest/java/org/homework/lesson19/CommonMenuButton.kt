package org.homework.lesson19

import io.github.kakaocup.kakao.text.KButton
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R

object CommonMenuButton : NamedScreen<CommonMenuButton>() {
    override val screenName = "Нижнее меню"
    override val layoutId = null
    override val viewClass = null

    val moreButton by lazy {
        KButton{
            withId(R.id.nav_tab_more)
        }.name(withParent(" кнопка More"))
    }
//отдельно
    val settingsButton by lazy {
        KButton{
            withId(R.id.main_drawer_settings_container)
        }.name(withParent(" settings контейнер"))
    }
}