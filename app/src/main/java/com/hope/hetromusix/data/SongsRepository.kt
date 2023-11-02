package com.hope.hetromusix.data

import com.hope.hetromusix.bean.SongModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SongsRepository(val loader: ContentProviderLoader, val dispatcher: CoroutineDispatcher) {

    suspend fun fetchSongs(): List<SongModel> {
        return withContext(dispatcher){
            loader.fetchSongs()
        }
    }
}
