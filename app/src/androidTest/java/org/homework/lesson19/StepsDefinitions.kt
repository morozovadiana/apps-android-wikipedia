package org.homework.lesson19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.homework.lesson23.KWebViewElement
import org.homework.lesson24.assertTrimmedTextIsEquals
import org.homework.lesson24.clickIfEnabled
import org.homework.lesson25.CloseGotIt
import org.homework.lesson25.ClosePlayTodayGame
import org.homework.lesson25.PassInterferingScreens

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    fun isDisabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisabled()
        }
    }

    fun isNotChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isNotChecked()
        }
    }

    fun isChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isChecked()
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
            }
        }
    }

    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }
    }

    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, expected: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(expected)
        }
    }
    private val passInterferingScreens = PassInterferingScreens(
        listOf(
            ClosePlayTodayGame(testContext),
            CloseGotIt(testContext)
        )
    )

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            try {
                fnc()
            } catch (_: Throwable) {
                passInterferingScreens.execute()
                fnc()
            }
        }
    }
}