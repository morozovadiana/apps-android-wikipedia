package org.homework.lesson18.h.homework

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R

object Settings : NamedScreen<Settings>() {

    override val screenName = "Settings Page"
    override val layoutId = null
    override val viewClass = null

    val settings = KImageView{
        withParent{
            withId(R.id.main_drawer_settings_container)
        }
        withText("Settings")
        isInstanceOf(AppCompatImageView::class.java)
    }.name(withParent("Settings"))


    val showLinkPreviewChekbox = KSwitch{
        withId(R.id.switchWidget)
    }
        .name(withParent("show link previw widget"))
}