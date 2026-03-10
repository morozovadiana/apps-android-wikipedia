package org.homework.lesson08


import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.homework.lesson09.FeaturedArticleItem
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

// Продолжаем описывать экран Explore
//Описать блок Customize, блок даты, блок Top Read (с вложенным ресайклером), блок In the news
// (с вложенным ресайклером).
//Классы описаний блоков должны быть в отдельных файлах.
//Описанные блоки добавить в типы блоков ресайклера экрана Explore.

object ExploreScreen: KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView (
        builder = {
            withId(R.id.feed_view)
                  },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::DayItem)
            itemType(::TopReadItem)
            itemType(::NewsItem)
            itemType(::FeaturedArticleItem)
        }
    )
}
