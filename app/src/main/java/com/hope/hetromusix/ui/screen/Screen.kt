package com.hope.hetromusix.ui.screen

sealed class Screen(val route: String) {
    object Main : Screen(route = "main_screen")
    object Home : Screen(route = "home_screen")
    object Song : Screen(route = "song_screen")
    object Album : Screen(route = "album_screen")
    object Artist : Screen(route = "artist_screen")
    object Playlist : Screen(route = "playlist_screen")
}