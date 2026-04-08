package org.homework.lesson18.h.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.OnboardingScreen.pager
import org.homework.lesson18.h.lesson.PagerItem
import org.homework.lesson18.h.lesson.invokeByIndex
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen: NamedScreen<ExploreScreen>() {

    override val screenName = "Explore Screen"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Изображение"))

    val retryButton = KButton {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Кнопка Retry"))

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItemNew)
            itemType(::CustomizeItemNew)
            itemType(::DayItemNew)
            itemType(::TopReadItemNew)
            itemType(::NewsItemNew)
            itemType(::FeaturedArticleItemNew)
            itemType(::WikipediaGamesNew)
        }
    ).name(withParent("Слайдер"))

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}