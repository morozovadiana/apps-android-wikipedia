package org.homework.lesson22.homework

import org.homework.lesson18.h.lesson.NamedScreen
import com.google.android.material.R
import org.homework.lesson18.h.lesson.name

object BottomSheetScreen: NamedScreen<BottomSheetScreen> () {
    override val screenName = "Экран боттомшита"
    override val layoutId = null
    override val viewClass = null

    val readingWidget by lazy {
        ReadingBottomSheetWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Раздел чтения"))
    }
    val readingFocusModeWidget by lazy {
        ReadingFocusModeWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Раздел чтения фокус мод"))
    }

    val chooseThemeWidget by lazy {
        ChooseThemeWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Раздел смены темы"))
    }
}