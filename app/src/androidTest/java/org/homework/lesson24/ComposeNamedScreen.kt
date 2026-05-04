package org.homework.lesson24

import io.github.kakaocup.compose.node.element.ComposeScreen
import org.homework.lesson18.h.lesson.NameHierarchy

abstract class ComposeNamedScreen<T : ComposeScreen<T>> : ComposeScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}