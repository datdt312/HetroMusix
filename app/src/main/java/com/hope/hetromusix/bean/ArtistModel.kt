package com.hope.hetromusix.bean

data class ArtistModel(
    val name: String = "",
    val listSong: List<SongModel> = listOf(),
)
