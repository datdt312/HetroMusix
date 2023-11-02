package com.hope.hetromusix.bean

data class SongModel(
    val id: Long = 0L,
    val path: String = "",
    val albumId: Long = 0L,
    val artistId: Long = 0L,
    val name: String = "",
    val length: Long = -1L,
    val lastModified: Long = -1L,
    val format: String = "",
    val duration: Long = -1L,
    val bitrate: String = "",
    val samplingRate: String = "",
    val thumb: String = ""
)
