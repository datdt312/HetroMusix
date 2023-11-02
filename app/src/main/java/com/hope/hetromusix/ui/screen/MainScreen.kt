package com.hope.hetromusix.ui.screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.hope.hetromusix.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val screens = listOf(
        MainScreen.Home,
        MainScreen.Song,
        MainScreen.Album,
        MainScreen.Artist,
        MainScreen.Playlist,
    )
    val pagerState = rememberPagerState(
        initialPage = MainScreen.Home.index,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        screens.size
    }
    Scaffold(
        bottomBar = {
            BottomBar(pagerState = pagerState)
        }
    ) {
        MainPager(pagerState = pagerState)
    }
}

sealed class MainScreen(
    val index: Int,
    @DrawableRes val iconId: Int,
    @StringRes val nameId: Int,
) {
    object Home : MainScreen(
        index = 0,
        iconId = R.drawable.ic_home,
        nameId = R.string.for_you
    )

    object Song : MainScreen(
        index = 1,
        iconId = R.drawable.ic_audiotrack,
        nameId = R.string.songs
    )

    object Album : MainScreen(
        index = 2,
        iconId = R.drawable.ic_album,
        nameId = R.string.albums
    )

    object Artist : MainScreen(
        index = 3,
        iconId = R.drawable.ic_artist,
        nameId = R.string.artists
    )

    object Playlist : MainScreen(
        index = 4,
        iconId = R.drawable.ic_queue_music,
        nameId = R.string.playlists
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPager(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            MainScreen.Home.index -> HomeScreen()
            MainScreen.Song.index -> SongScreen()
            MainScreen.Album.index -> AlbumScreen()
            MainScreen.Artist.index -> ArtistScreen()
            MainScreen.Playlist.index -> PlaylistScreen()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(pagerState: PagerState) {
    val screens = listOf(
        MainScreen.Home,
        MainScreen.Song,
        MainScreen.Album,
        MainScreen.Artist,
        MainScreen.Playlist,
    )
    NavigationBar {
        screens.forEach { screen ->
            AddBottomBarItem(
                screen = screen,
                pagerState = pagerState
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RowScope.AddBottomBarItem(
    screen: MainScreen,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()
    NavigationBarItem(
        selected = pagerState.currentPage == screen.index,
        onClick = {
            scope.launch {
                pagerState.animateScrollToPage(screen.index)
            }
        }, icon = {
            Icon(painter = painterResource(id = screen.iconId), contentDescription = null)
        }, label = {
            Text(text = stringResource(id = screen.nameId))
        })
}