package com.hope.hetromusix.ui.screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hope.hetromusix.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        MainPager(navController = navController)
    }
}

sealed class MainScreen(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val nameId: Int,
) {
    object Home : MainScreen(
        route = "home_screen",
        iconId = R.drawable.ic_home,
        nameId = R.string.for_you
    )

    object Song : MainScreen(
        route = "song_screen",
        iconId = R.drawable.ic_audiotrack,
        nameId = R.string.songs
    )

    object Album : MainScreen(
        route = "album_screen",
        iconId = R.drawable.ic_album,
        nameId = R.string.albums
    )

    object Artist : MainScreen(
        route = "artist_screen",
        iconId = R.drawable.ic_artist,
        nameId = R.string.artists
    )

    object Playlist : MainScreen(
        route = "playlist_screen",
        iconId = R.drawable.ic_queue_music,
        nameId = R.string.playlists
    )
}

@Composable
fun MainPager(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainScreen.Home.route) {
        composable(route = MainScreen.Home.route) {
            HomeScreen()
        }
        composable(route = MainScreen.Song.route) {
            SongScreen()
        }
        composable(route = MainScreen.Album.route) {
            AlbumScreen()
        }
        composable(route = MainScreen.Artist.route) {
            ArtistScreen()
        }
        composable(route = MainScreen.Playlist.route) {
            PlaylistScreen()
        }

    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        MainScreen.Home,
        MainScreen.Song,
        MainScreen.Album,
        MainScreen.Artist,
        MainScreen.Playlist,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddBottomBarItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddBottomBarItem(
    screen: MainScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route)
        }, icon = {
            Icon(painter = painterResource(id = screen.iconId), contentDescription = null)
        }, label = {
            Text(text = stringResource(id = screen.nameId))
        })
}