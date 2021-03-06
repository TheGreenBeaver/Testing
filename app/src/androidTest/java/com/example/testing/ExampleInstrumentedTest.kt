package com.example.testing

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.testing", appContext.packageName)
    }

    @Test
    fun checkTextUpdate() {
        val newBtnText = "New text for btn"
        onView(withId(R.id.text_input)).perform(typeText(newBtnText))
        onView(withId(R.id.text_changing_btn)).perform(click()).check(matches(withText(newBtnText)))
    }

    @Test
    fun checkRotation() {
        val newBtnText = "This text will disappear"
        onView(withId(R.id.text_input)).perform(typeText(newBtnText))
        onView(withId(R.id.text_changing_btn)).perform(click()).check(matches(withText(newBtnText)))
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        onView(withId(R.id.text_changing_btn)).check(matches(withText(R.string.default_button_text)))
        onView(withId(R.id.text_input)).check(matches(withText(newBtnText)))
    }

}