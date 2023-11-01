package com.hope.hetromusix.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import com.hope.hetromusix.R

@Composable
fun MainScreen() {
    Box {

    }
}


data class MainNavItem(
    val screen: Screen,
    @DrawableRes val icon: Int,
    val name: String,
)
@Composable
fun MainBottomNavigation() {
    val screenList = listOf(
        MainNavItem(screen = Screen.Home, icon = R.drawable.ic_home, name ="")
    )

}