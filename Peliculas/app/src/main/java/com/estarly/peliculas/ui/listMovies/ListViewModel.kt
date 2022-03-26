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
    private val useCase     = UseCase()

    var listMovies          = MutableLiveData<List<Movie>>()
    var listMoviesUpcoming  = MutableLiveData<List<Movie>>()
    var listMoviesFavorites = MutableLiveData<List<String>>()
    val movieLatest         = MutableLiveData<Movie>()

    fun getMovies() = GlobalScope.launch(Dispatchers.IO) {
            listMovies.postValue(
                if(listMovies.value?.isEmpty() == true || listMovies.value == null )
                    useCase.getMovies()
                else listMovies.value)
        }

    fun getMoviesFavorites() = CoroutineScope(Dispatchers.Main).launch {
            listMoviesFavorites.value = listOf("","")
        }
    fun getMovieLatest() = CoroutineScope(Dispatchers.IO).launch {
            movieLatest.postValue(if(movieLatest.value == null) useCase.getMovieLatest()else movieLatest.value)
        }
    fun getMovieUpcoming() = CoroutineScope(Dispatchers.IO).launch {
            listMoviesUpcoming.postValue(
                if(listMoviesUpcoming.value?.isEmpty() == true || listMovies.value == null )
                    useCase.getMovieUpcoming()
                else listMoviesUpcoming.value)
        }


}