package org.homework.lesson19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity


open class BaseTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)
}