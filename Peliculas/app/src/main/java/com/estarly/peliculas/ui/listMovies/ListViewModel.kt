package com.estarly.peliculas.ui.listMovies

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.movieEntityListToMovieList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private lateinit var useCase : UseCase

    var listMovies          = MutableLiveData<List<Movie>>()
    var listMoviesUpcoming  = MutableLiveData<List<Movie>>()
    var listMoviesFavorites = MutableLiveData<List<Movie>>()
    val movieLatest         = MutableLiveData<Movie>()
    fun initUsecase(context: Context) {
        useCase = UseCase(context)
    }

    fun getMovies() = GlobalScope.launch(Dispatchers.IO) {
            listMovies.postValue(
                if(listMovies.value?.isEmpty() == true || listMovies.value == null )
                    useCase.getMovies()
                else listMovies.value)
        }

    fun getMoviesFavorites() = CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(2000)
            listMoviesFavorites.postValue(useCase.getFavoritesMovies().movieEntityListToMovieList())
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