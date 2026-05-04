package org.homework.lesson19

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.homework.lesson18.h.lesson.getName
import org.homework.lesson23.KWebViewElement
import org.homework.lesson24.getName

class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' выключен",
            element
        )
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Проверяет, что элемент \${(element as BaseActions).getName()}' выключен",
                    element
        )
    }
    fun isChecked(element: CheckableAssertions) {
        steps.isChecked(
            "Проверяет, что элемент \${(element as BaseActions).getName()}' включен",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается '${element.getName()}'",
            element
        )
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, expected: String) {
        steps.assertTrimmedTextIsEquals(
            "Verify trimmed text is equals '${(element as NodeActions).getName()}'",
            element,
            expected
        )
    }

    }