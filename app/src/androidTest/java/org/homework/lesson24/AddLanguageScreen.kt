package org.homework.lesson24

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uiTests.Tags

object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen> () {
    override val screenName: String = " Add Language Screen"

    val items by lazy {
        createLazyList({
            hasTestTag(Tags.LANGUAGE_LIST)
        },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            })
    }

    fun languageBlock(text: String, fnc: LanguageItem.() -> Unit) {
        items.invokeWithText(text, fnc)
    }
}

class LanguageItem(semanticNode: SemanticsNode,
semanticsProvider: SemanticsNodeInteractionsProvider? = null) : KLazyListItemNode<LanguageItem> (semanticNode, semanticsProvider) {

    val localName by lazy {
        child<KNode> {
            hasTestTag(Tags.LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("Local name"))
    }

    val canonicName by lazy {
        child<KNode> {
            hasTestTag(Tags.CANONICAL_LANGUAGE)
        }.name(withParent("Local canonic name"))
    }
}