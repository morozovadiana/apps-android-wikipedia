package org.homework.lesson18.h.homework

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.homework.lesson18.h.lesson.NamedScreen
import org.homework.lesson18.h.lesson.OnboardingScreen.pager
import org.homework.lesson18.h.lesson.PagerItem
import org.homework.lesson18.h.lesson.invokeAtIndex
import org.homework.lesson18.h.lesson.invokeByIndex
import org.homework.lesson18.h.lesson.invokeWithText
import org.homework.lesson18.h.lesson.name
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.homework.lesson18.h.lesson.invokeAtIndexAndClass
import org.homework.lesson22.SearchWidget
import org.wikipedia.feed.featured.FeaturedArticleCardView

object ExploreScreen: NamedScreen<ExploreScreen>() {

    override val screenName = "Explore Screen"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Изображение"))

    val searchField = KTextView {
        withText("Search Wikipedia")
        isInstanceOf(MaterialTextView::class.java)
    }

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
            itemType(::SearchItemNew)
        }
    ).name(withParent("Слайдер"))

    val searchWidget by lazy{
        SearchWidget {
            withId(R.id.search_container)
        }
        .name(withParent("Виджет поиска"))
    }

//    fun page(index: Int, fnc: PagerItem.() -> Unit) {
//        pager.invokeByIndex(index, fnc)
//    }

    fun searchBlockByIndex(index: Int, fnc: SearchItemNew.() -> Unit) {
        items.invokeAtIndex(index, fnc)
    }

    fun searchItemByText(text: String, fnc: SearchItemNew.() -> Unit) {
        items.invokeWithText(text, fnc)
    }

    fun customizeBlock(fnc: CustomizeItemNew.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }

    fun topReadBlock(fnc: TopReadItemNew.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }

    fun featureArticle(index: Int, fnc: FeaturedArticleItemNew.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            (index + 1) * 10,
            1,
            FeaturedArticleCardView::class.java,
            "$index : блок Featured Article",
            fnc
        )
    }


}