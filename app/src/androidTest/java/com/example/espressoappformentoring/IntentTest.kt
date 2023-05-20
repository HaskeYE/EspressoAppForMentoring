package com.example.espressoappformentoring

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Rule
import org.junit.Test

class IntentTest {
    @Rule
    @JvmField
    val mainActivityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun switchActivityTest() {
        //Переход из активности 1 в активность 2.
        Espresso.onView(ViewMatchers.withId(R.id.switchActivityButton)).perform(ViewActions.click())
        //Проверяем, что мы находимся в активности 2.
        Intents.intended(IntentMatchers.hasComponent(SecondActivity::class.java.name))
        Espresso.onView(ViewMatchers.withId(R.id.secondActText))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello second activity")))

        //системная кнопка назад
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())

        Espresso.onView(ViewMatchers.withId(R.id.textview_first))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello first fragment")))
    }
}