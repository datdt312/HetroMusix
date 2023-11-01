package com.hope.hetromusix.ui.one

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hope.hetromusix.R
import com.hope.hetromusix.bean.SongModel

@Composable
fun OneSong() {
    Row {

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Preview
@Composable
fun SongThumb(song: SongModel) {
    GlideImage(
        model = painterResource(id = R.drawable.app_icon), contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10))
    )
}