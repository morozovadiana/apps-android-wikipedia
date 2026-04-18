package org.homework.lesson20

import io.github.kakaocup.kakao.common.views.KBaseView
import io.github.kakaocup.kakao.text.TextViewAssertions

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}