package org.homework.lesson28

import android.util.Log
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig
import io.qameta.allure.kotlin.Description as AllureDescription


class HWTestRuleAnnotaion : TestRule {
    var testData: String = ""
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val annotation = description?.getAnnotation(AllureDescription::class.java)
                    ?.value
                if (annotation == "valid") {
                    testData = BuildConfig.VALID_SEARCH_QUERY
                } else {
                    testData = BuildConfig.INVALID_SEARCH_QUERY
                }
                base?.evaluate()
            }
        }
    }
}
