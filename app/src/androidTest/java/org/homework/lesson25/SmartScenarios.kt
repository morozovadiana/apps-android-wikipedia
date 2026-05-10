package org.homework.lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class SmartScenarios(private val testContext: TestContext<*>) {

    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()
    fun gotIt() = CloseGotIt(testContext).initBehavior()
}

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)

//@Test
//fun test() {
//    run {
//        // предварительный сценарий
//        smartScenarios.closePlayTodayGame()
//    }
//}
