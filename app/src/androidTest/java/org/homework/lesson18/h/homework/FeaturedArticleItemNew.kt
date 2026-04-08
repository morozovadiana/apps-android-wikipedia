package org.homework.lesson18.h.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.homework.lesson18.h.lesson.name
import org.homework.lesson18.h.lesson.withParent
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView

class FeaturedArticleItemNew (matcher: Matcher<View>): KRecyclerItem<FeaturedArticleItemNew>(matcher) {

    val featureArticleTitle by lazy {
        KTextView(matcher){
            withId(R.id.view_card_header_title)
            isInstanceOf(FeaturedArticleCardView::class.java)
        }.name(withParent("Заголовок"))
    }
    val cardHeaderMenu by lazy {
        KImageView(matcher){
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Меню"))
    }
    val articleImage by lazy {
        KImageView(matcher){
            withId(R.id.articleImage)
        }.name(withParent("Изображение"))
    }
    val articleTitle by lazy {
        KTextView(matcher){
            withId(R.id.articleTitle)
        }.name(withParent("Заголовок статьи"))
    }
    val articleDescription by lazy {
        KTextView(matcher){
            withId(R.id.articleDescription)
        }.name(withParent("Описание"))
    }
    val articleExtract by lazy {
        KTextView(matcher){
            withId(R.id.articleExtract)
        }.name(withParent("Отрывок"))
    }
    val footerActionButton by lazy {
        KButton(matcher){
            withId(R.id.footerActionButton)
        }.name(withParent("Кнопка Footer"))
    }

    val hideThisCard by lazy {
        KView(matcher) {
            withText("Hide this card")
        }.name(withParent("Скрыть карточку"))
    }
}