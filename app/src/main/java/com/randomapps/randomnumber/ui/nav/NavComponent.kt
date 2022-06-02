package com.randomapps.randomnumber.ui.nav

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.randomapps.randomnumber.ui.screens.generator.GeneratorScreen
import com.randomapps.randomnumber.ui.screens.generator.GeneratorViewModel

@ExperimentalComposeUiApi
@Composable
fun NavComponent() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Generator.route) {
        composable(Screen.Generator.route) {
             GeneratorScreen()
        }
        composable(Screen.Settings.route) {
            Text("Settings")
        }
    }
}