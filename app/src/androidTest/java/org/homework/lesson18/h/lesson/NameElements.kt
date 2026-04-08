package org.homework.lesson18.h.lesson

import com.kaspersky.kaspresso.screens.KScreen

class NameHierarchy(private val name: String, private val parent: NameHierarchy? = null) {

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, this)
    }

    override fun toString(): String {
        return (parent?.let { "$it : " } ?: "") + name
    }
}

abstract class NamedScreen <T : NamedScreen<T>> : KScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}