package org.homework.lesson19

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.invokeWithText
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

object Settings : NamedScreen<Settings>() {

    override val screenName = "Settings Page"
    override val layoutId = null
    override val viewClass = null


//    val recycler by lazy {
//        KButton {
//            withId(R.id.recyclerView)
//        }.name(withParent("Кнопка more"))
//    }

    val recyclerSettings by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::RecyclerSettingsItem)
            }
        ).name(withParent("Список Настроек"))
    }

    fun settingsItem(text: String, fnc: RecyclerSettingsItem.() -> Unit) {
        recyclerSettings.invokeWithText(text, fnc)
    }
}

    class RecyclerSettingsItem(matcher: Matcher<View>): KRecyclerItem<RecyclerSettingsItem>(matcher) {

        val showLinkPreviewSwitch by lazy {
            KCheckBox(matcher) {
                withId(R.id.switchWidget)
            }.name(withParent("Переключатель настройки show link preview"))
        }

    }