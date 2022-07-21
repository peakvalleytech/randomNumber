package com.randomapps.randomnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.randomapps.randomnumber.ui.common.component.RandomNumberTopBar
import com.randomapps.randomnumber.ui.nav.NavComponent
import com.randomapps.randomnumber.ui.theme.RandomNumberTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()

        setContent {
            RandomNumberTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(/*border = BorderStroke(3.dp, Color.Cyan),*/ color = Color.Yellow,
                        modifier = Modifier.fillMaxHeight(0.92f)
                    ) {
                        Scaffold(
                            topBar = {
                                RandomNumberTopBar()
                            }
                        ) {
                            NavComponent()
                        }
                    }
                    AndroidView(factory = {
                        AdView(it).apply {
                            setAdSize(AdSize.BANNER)
                            setAdUnitId("ca-app-pub-3142101706002267/5276646677")
                            loadAd(adRequest)
                        }

                    })
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