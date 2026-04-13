package org.homework.lesson19

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.homework.lesson18.h.lesson.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}