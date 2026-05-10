package org.homework.lesson26

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewActionWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor

class BeforeAfterBehaviourInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.i("KASPRESSO", "BEFORE ACTION")
        val result = action()
        Log.i("KASPRESSO", "AFTER ACTION")
        return result
        throw AssertionError()
    }

}

class MyViewActionInterceptor: ViewActionWatcherInterceptor {
    override fun intercept(viewAction: ViewAction, view: View) {
        Log.i("KASPRESSO", "Description: ${viewAction.description}")
    }

}

class MyViewAssertionIntercepter: ViewAssertionWatcherInterceptor {
    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.i("KASPRESSO", "Before Assertion")
        if(exception != null) {
            Log.e("KASPRESSO", "Assertion: ${exception.message}")
        }
    }
}

class TestTimeInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val beforeTime = System.currentTimeMillis()
        val result = action()
        val afterTime = System.currentTimeMillis()
        Log.i("KASPRESSO", "Time: ${afterTime - beforeTime}")
        return result

    }

}