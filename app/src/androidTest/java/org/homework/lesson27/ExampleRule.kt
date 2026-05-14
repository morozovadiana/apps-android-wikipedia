package org.homework.lesson27

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ExampleRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "TEST RULE STARTED")
        Log.i("KASPRESSO", description?.displayName ?: "")
//        val annotation =  description?.getAnnotation<AllureId>(AllureId::class.java)
//            ?.value
//        if (annotation !in Configuration.testCases){
//            throw IllegalStateException("Not suitable testCase")
//        }
//        Log.i("KASPRESSO", annotation ?: "")
        return object : Statement(){
            override fun evaluate() {
                val annotation =  description?.getAnnotation<AllureId>(AllureId::class.java)
                    ?.value
                if (annotation !in Configuration.testCases){
                    throw IllegalStateException("Not suitable testCase")
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

object Configuration{
    val testCases = listOf("1","2","3")
}

class SimpleTest() {

    @get:Rule
    val baseRule = ExampleRule()

    @Test
    @AllureId("1")
    fun testTest() {
        Log.i("KASPRESSO", "Log testTest")
        Assert.assertTrue("Fail",false)
    }
}

class MyStatement(
    val base: Statement?,
    val description: Description?)
//) : Statement(){
//    override fun evaluate() {
//        val annotation =  description?.getAnnotation<AllureId>(AllureId::class.java)
//            ?.value
//        if (annotation !in Configuration.testCases){
//            throw IllegalStateException("Not suitable testCase")
//        }
//        try {
//            base?.evaluate()
//        } catch (e: Throwable) {
//            Log.i("KASPRESSO", e.message ?: "Empty message")
//
//        }
//        Log.i("KASPRESSO", "TEST RULE FINISHED")
//    }
//}