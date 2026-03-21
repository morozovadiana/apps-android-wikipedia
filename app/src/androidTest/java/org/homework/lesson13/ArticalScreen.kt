package org.homework.lesson13


import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticalScreen : KScreen<ArticalScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webview = KWebView{
        withId(R.id.page_web_view)
    }

    val closeButton = KButton{
        withId(R.id.closeButton)
    }

    val number = KTextView{
        withId(R.id.reference_id)
    }

    val referenceText = KTextView{
        withId(R.id.reference_text)
    }

    val linkPreviewTitle = KTextView{
        withId(R.id.link_preview_title)
    }

    val linkPreviewExtract = KTextView{
        withId(R.id.link_preview_extract)
    }
    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }

}

