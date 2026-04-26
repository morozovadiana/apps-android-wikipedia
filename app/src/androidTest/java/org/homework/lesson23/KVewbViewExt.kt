package org.homework.lesson23

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXpath(xPath: String): KWebViewElement {
    return KWebViewElement(
        webView = this,
        xPath
    )
}