package com.hope.hetromusix.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.hope.hetromusix.bean.SongModel
import com.hope.hetromusix.data.ContentProviderLoader
import com.hope.hetromusix.data.SongsRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(
    app: Application,
    private val songsRepository: SongsRepository
) : AndroidViewModel(app) {

    var x = 0

    var listSong: LiveData<List<SongModel>> = liveData {
        emit(songsRepository.fetchSongs())
    }
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val application: Application) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val source = ContentProviderLoader(application.contentResolver)
            MainViewModel(application, SongsRepository(source, Dispatchers.IO)) as T
        } else
            throw IllegalArgumentException("Unknown ViewModel class")
    }
}