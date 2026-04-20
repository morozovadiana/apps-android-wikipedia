package org.homework.lesson19

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.invokeAtIndexAndId
import org.homework.lesson18.h.lesson.invokeWithText
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R

object Settings : NamedScreen<Settings>() {

    override val screenName = "Settings Page"
    override val layoutId = null
    override val viewClass = null

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

    fun settingsIdItem(index: Int, fnc: RecyclerSettingsItem.() -> Unit){
        recyclerSettings.invokeAtIndexAndId(
            index,
            R.id.switchWidget,
            10,
            0,
            "$index : блок",
            fnc
        )
    }
}

    class RecyclerSettingsItem(matcher: Matcher<View>): KRecyclerItem<RecyclerSettingsItem>(matcher) {


        val title by lazy {
            KTextView(matcher){
                withId(R.id.title)
            }.name(withParent("Заголовок"))
        }

        val showLinkPreviewSwitch by lazy {
            KCheckBox(matcher) {
                withId(R.id.switchWidget)
            }.name(withParent("Переключатель настройки show link preview"))
        }
    }