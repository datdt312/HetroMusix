package com.hope.hetromusix.ui.screen

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.hope.hetromusix.vm.MainViewModel
import com.hope.hetromusix.vm.MainViewModelFactory

@Composable
fun SongScreen() {
    val context = LocalContext.current
    val vmFactory = MainViewModelFactory(application = context.applicationContext as Application)
    val viewModel = LocalViewModelStoreOwner.current?.let { ViewModelProvider(it,vmFactory).get(MainViewModel::class.java) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "SongScreen", fontSize = 50.sp)
    }
}

