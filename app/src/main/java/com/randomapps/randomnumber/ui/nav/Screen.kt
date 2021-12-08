package com.randomapps.randomnumber.ui.nav

sealed class Screen(val route : String) {
    object Generator : Screen("generator")
    object Settings : Screen("settings")
}