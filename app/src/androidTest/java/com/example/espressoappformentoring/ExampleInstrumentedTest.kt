package com.example.espressoappformentoring

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @JvmField
    @Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.espressoappformentoring", appContext.packageName)
    }

    @Test
    fun portraitOrientationTest() {
        onView(withId(R.id.button_first)).perform(click())

        onView(withId(R.id.textForButton)).check(matches(withText("")))
        onView(withId(R.id.textForButton)).perform(typeText("TextNew"))
        onView(withId(R.id.textForButton)).check(matches(withText("TextNew")))

        onView(withId(R.id.textChange)).check(matches(withText("Unedited")))
        onView(withId(R.id.textChange)).perform(click())
        onView(withId(R.id.textChange)).check(matches(withText("TextNew")))
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        //onView(withId(R.id.textChange)).check(matches(withText("Unedited")))
        onView(withId(R.id.textForButton)).check(matches(withText("")))
    }





}