package org.homework.lesson19

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.homework.lesson18.h.lesson.getName
import org.homework.lesson24.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("Нажимает на '${element.getName()}'", element)
    }
}