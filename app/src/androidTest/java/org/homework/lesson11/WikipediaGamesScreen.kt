package org.homework.lesson11

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object WikipediaGamesScreen: KScreen<WikipediaGamesScreen>() {
    override val layoutId = null
    override val viewClass = null

    val retryButton = KButton{
        withId(R.id.view_wiki_error_button)
    }

    val playGameButton = KButton{
        withId(R.id.playGameButton)
    }

}