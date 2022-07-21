package com.randomapps.randomnumber

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.randomapps.randomnumber.ui.screens.generator.GeneratorScreen
import com.randomapps.randomnumber.ui.theme.RandomNumberTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
class GeneratorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.randomapps.randomnumber", appContext.packageName)
    }


    @ExperimentalComposeUiApi
    @Test
    fun clickingFab_should_show_bottomsheet() {
        composeTestRule.setContent {
            RandomNumberTheme {
                MainActivity()
            }
        }
        composeTestRule.onNodeWithContentDescription("Add Generator").performClick()
        Thread.sleep(5000)
    }
}