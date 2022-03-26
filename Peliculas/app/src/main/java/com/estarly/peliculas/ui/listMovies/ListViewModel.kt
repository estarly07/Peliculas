package com.estarly.peliculas.ui.listMovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.models.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    val useCase             = UseCase()
    var listMovies          = MutableLiveData<List<Movie>>()
    var listMoviesFavorites = MutableLiveData<List<String>>()

    fun getMovies() = GlobalScope.launch(Dispatchers.Default) {
            listMovies.postValue(useCase.getMovies())
        }

    fun getMoviesFavorites() = CoroutineScope(Dispatchers.Main).launch {
            listMoviesFavorites.value = listOf("","")
        }


}