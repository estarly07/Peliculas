package com.wposs.peliculas.ui.listMovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    var listMovies          = MutableLiveData<List<String>>()
    var listMoviesFavorites = MutableLiveData<List<String>>()

    fun getMovies() = CoroutineScope(Dispatchers.Main).launch {
            listMovies.value = listOf("","")
        }

    fun getMoviesFavorites() = CoroutineScope(Dispatchers.Main).launch {
            listMoviesFavorites.value = listOf("","")
        }


}