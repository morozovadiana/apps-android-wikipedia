package org.homework.lesson18.h.lesson

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matchers.anyOf
import org.homework.lesson21.hasClassOrChildWithClass
import org.homework.lesson21.hasIdOrChildWithId
import kotlin.math.min

// Расширения для KRecyclerView
inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByIndex(index: Int): T {
    return childWith<T> {
        onPosition(index)
    }.name(withParent("$index"))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByText(text: String): T {
    return childWith<T> {
        withMatcher(
            anyOf(
                ViewMatchers.withText(text),
                ViewMatchers.hasDescendant(ViewMatchers.withText(text))
            )
        )
    }.name(withParent(text))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndex(index: Int, fnc: T.() -> Unit) {
    getByIndex<T>(index).fnc()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeWithText(text: String, fnc: T.() -> Unit) {
    getByText<T>(text).fnc()
}


// Разработай расширение для KRecyclerView, позволяющее выполнить код в блоке списка по индексу и классу элемента блока.
// Например есть список блоков, в которых присутствует несколько блоков с чекбоксом - нужно получить второй блок
// с чекбоксом из общего списка, игнорируя все остальные.
// Метод должен принимать индекс желаемого блока, класс View элемента, лимит проверяемых элементов,
// количество элементов для пропуска, название для результирующего блока (по умолчанию в качестве названия использовать
// индекс блока), лямбду с функцией, которую нужно выполнить над блоком.
inline fun <reified T: KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    limit: Int,
    startWith: Int,
    clazz: Class<out View>,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val numberOfElements = this.getSize()
    val lastIndex = min(numberOfElements - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recycler = this
    for (i in firstIndex..lastIndex) {
        childAt<T>(i){
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if( isElementWithClass && counter++ == index) {
                name(recycler.getName().withParent(blockName))
                fnc()
                return
            }
        }
    }
}


// Разработай расширение для KRecyclerView, позволяющее выполнить код в блоке списка по индексу и ID элемента блока.
// Например есть список блоков, в которых присутствует несколько блоков с вложенным элементом ID которого нет
// в других блоках - нужно получить второй блок с таким ID из общего списка, игнорируя все остальные блоки.
//
//За основу возьми расширения KRecyclerView которые писали в уроках по именованию элементов.
//
//Метод должен принимать индекс желаемого блока, ID элемента входящего в состав нужного типа блока,
// лимит проверяемых элементов, количество элементов для пропуска, название для результирующего блока
// (по умолчанию в качестве названия использовать индекс блока), лямбду с функцией, которую нужно выполнить над блоком.
inline fun <reified T: KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    resourceId: Int,
    limit: Int,
    skipQualityElements: Int,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val numberOfElements = this.getSize()
    val lastIndex = min(numberOfElements - 1, limit)
    val firstIndex = min(skipQualityElements, lastIndex)
    var counter = 0
    val recycler = this
    for ( i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val elementWithId = hasIdOrChildWithId(resourceId)
            if(elementWithId && counter++ == index) {
                name(recycler.getName().withParent(blockName))
                fnc()
                return
            }
        }
    }
}