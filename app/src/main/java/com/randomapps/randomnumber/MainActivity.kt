package com.randomapps.randomnumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
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
//        val adView = AdView(this)
//        adView.setAdSize(AdSize.BANNER)
//        adView.setAdUnitId("ca-app-pub-3142101706002267/5276646677")
//        addContentView(adView, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT,
//        ))
//        adView.loadAd(adRequest)
        val adRequest = AdRequest.Builder().build()

        setContent {
            RandomNumberTheme {
                // A surface container using the 'background' color from the theme
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Surface(border = BorderStroke(3.dp, Color.Cyan), color = Color.Yellow, modifier = Modifier.fillMaxHeight(0.95f)) {
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