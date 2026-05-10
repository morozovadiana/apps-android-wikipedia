package org.homework.lesson26

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class TestRunWatcherInterceptorHW : TestRunWatcherInterceptor {
    override fun onTestStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON TEST STARTED 1")

    }
    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON MAIN SECTION STARTED 2")

    }
    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON AFTER SECTION STARTED 3")

    }
    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON BEFORE SECTION FINISHED SUCCESS 4")

    }
    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON MAIN SECTTION FINISHED SUCCESS 5")

    }
    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "ON AFTER SECTION FINISHED SUCCESS 6")

    }
    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.i("KASPRESSO", "ON TEST FINISHED 7")

    }

}