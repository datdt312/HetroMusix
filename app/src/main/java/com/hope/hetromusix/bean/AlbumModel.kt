package com.hope.hetromusix.bean

data class AlbumModel(
    val name: String = "",
    val artist: String = "",
    val listSong: List<SongModel> = listOf(),
    val thumb: String = ""
)
