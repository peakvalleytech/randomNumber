package com.randomapps.randomnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randomapps.randomnumber.ui.common.component.RandomNumberTopBar
import com.randomapps.randomnumber.ui.nav.NavComponent
import com.randomapps.randomnumber.ui.screens.generator.GeneratorViewModel
import com.randomapps.randomnumber.ui.theme.RandomNumberTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RandomNumberTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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