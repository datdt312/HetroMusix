package com.hope.hetromusix.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun AlbumScreen() {
    Box(
        modifier = Modifier.size(12.dp).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "AlbumScreen", fontSize = 50.sp)
    }
}

@Composable
fun AlbumSong() {
    
}