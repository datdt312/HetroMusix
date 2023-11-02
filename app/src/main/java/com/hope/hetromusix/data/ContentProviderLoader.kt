package com.hope.hetromusix.data

import android.content.ContentResolver
import android.provider.MediaStore
import androidx.core.database.getLongOrNull
import androidx.core.database.getStringOrNull
import com.hope.hetromusix.bean.SongModel
import kotlinx.coroutines.runBlocking

class ContentProviderLoader(val contentResolver: ContentResolver) {
    //https://jossypaul.medium.com/loading-data-from-contentprovider-using-coroutines-and-livedata-34aa5e79b8ba
    fun fetchSongs(): List<SongModel> {
        val result: MutableList<SongModel> = mutableListOf()

        val cursor = contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null, null, null, null
        )
        cursor?.let {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                result.add(
                    SongModel(
                        id = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                            ?: -1L,
                        path = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)) ?: "",
                        albumId = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))
                            ?: -1L,
                        artistId = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID))
                            ?: -1L,
                        name = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)) ?: "",
                        length = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE)) ?: -1L,
                        lastModified = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED)) ?: -1L,
//                        format = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.)) ?: "",
                        duration = cursor.getLongOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)) ?: -1L,
//                        samplingRate = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.)) ?: "",
//                        thumb = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.)) ?: "",
                        bitrate = cursor.getStringOrNull(cursor.getColumnIndex(MediaStore.Audio.Media.BITRATE))
                            ?: ""
                    )
                )
                //add the item
                cursor.moveToNext()
            }
            cursor.close()
        }

        return result.toList()
    }
}