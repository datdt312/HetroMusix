package com.hope.hetromusix.ui.screen

sealed class Screen(val route: String) {
    object Main : Screen(route = "main_screen")

}