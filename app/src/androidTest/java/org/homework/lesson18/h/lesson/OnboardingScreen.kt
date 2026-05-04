package org.homework.lesson18.h.lesson

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.homework.lesson18.h.homework.ExploreScreen.items
import org.homework.lesson18.h.homework.SearchItemNew
import org.homework.lesson18.h.homework.TopReadItemNew
import org.homework.lesson18.h.lesson.OnboardingScreen.pager
import org.wikipedia.R

object OnboardingScreen : NamedScreen<OnboardingScreen>() {

    override val screenName = "Экран онбординга"
    override val layoutId = null
    override val viewClass = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }.name(withParent("Кнопка Skip"))

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }.name(withParent("Кнопка Continue"))

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    ).name(withParent("Слайдер"))

    // В OnboardinScreen можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }

    val addLanguageButton by lazy {
        KButton {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }

    val listLanguages by lazy {
        KViewPager2(
            builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
        ).name(withParent("Список языков"))
    }
    fun pageLanguages(index: Int, fnc: LanguageItem.() -> Unit) {
        listLanguages.invokeByIndex(index, fnc)
    }
}

class LanguageItem(matcher: Matcher<View>) : KViewPagerItem<LanguageItem>(matcher) {

    val languageName by lazy {
        KTextView{
            withId(R.id.option_label)
        }
    }
}




