package org.homework.lesson27

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import kotlin.collections.contains

class HWTestRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val annotation = description?.getAnnotation<Deprecated>(Deprecated::class.java)
                    ?.annotationClass
                if (annotation != null) {
                    throw AssumptionViolatedException("SKIP")
                }
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    Log.i("KASPRESSO", e.message ?: "Empty message")

                }
                Log.i("KASPRESSO", "TEST RULE FINISHED")
            }
        }
    }
}
