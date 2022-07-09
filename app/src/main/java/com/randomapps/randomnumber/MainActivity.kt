package com.randomapps.randomnumber

import android.os.Bundle
import android.view.Surface
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.ads.MobileAds
import com.randomapps.randomnumber.ui.common.component.RandomNumberTopBar
import com.randomapps.randomnumber.ui.nav.NavComponent
import com.randomapps.randomnumber.ui.screens.generator.GeneratorViewModel
import com.randomapps.randomnumber.ui.theme.RandomNumberTheme
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}
        setContent {
            RandomNumberTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Yellow) {
                    Scaffold(
                        topBar = {
                            RandomNumberTopBar()
                        }
                    ) {
                        NavComponent()
                    }
                }
            }
        }

        val crashButton = android.widget.Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RandomNumberTheme {
        Greeting("Android")
    }
}