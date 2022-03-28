package com.estarly.peliculas.ui.listMovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.GlobalUtils
import com.estarly.peliculas.utils.movieEntityListToMovieList
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private var useCase: UseCase
) : ViewModel() {

    var listMovies          = MutableLiveData<List<Movie>>()
    var listMoviesUpcoming  = MutableLiveData<List<Movie>>()
    var listMoviesFavorites = MutableLiveData<List<Movie>>()
    val movieLatest         = MutableLiveData<Movie?>()

    /**
     * Obterner peliculas populares
     */
    fun getMovies() = CoroutineScope(Dispatchers.IO).launch {
        if (listMovies.value?.isEmpty() == true || listMovies.value == null) {
                try {
                    val resp = useCase.getMovies()
                    listMovies.postValue(resp)
                }catch (e: IOException){
                    Log.e(GlobalUtils.error, "getMovies ${e.printStackTrace()}", )
                    val type = object : TypeToken<List<Movie>>() {}.type
                    val gson = GsonBuilder().create()
                    listMovies.postValue(gson.fromJson(GlobalUtils.movies,type))
                }

            }
        }

    /**
     * Obtener las peliculas guardadas como favoritas por el usuario
     */
    fun getMoviesFavorites() = CoroutineScope(Dispatchers.IO).launch {
            listMoviesFavorites.postValue(useCase.getFavoritesMovies().movieEntityListToMovieList())
        }

    /**
     * Obtener la ultima pelicula que tiene el api
     */
    fun getMovieLatest() = CoroutineScope(Dispatchers.IO).launch {
            if(movieLatest.value == null){
                try {
                    val resp = useCase.getMovieLatest()
                    movieLatest.postValue(resp)
                }catch (e: IOException){
                    Log.e(GlobalUtils.error, "movieLatest${e.printStackTrace()}", )
                    movieLatest.postValue(null)
                }

            }
        }

    /**
     * Obtener proximas peliculas
     */
    fun getMovieUpcoming() = CoroutineScope(Dispatchers.IO).launch {
            if(listMoviesUpcoming.value?.isEmpty() == true || listMovies.value == null ){
                try {
                    val resp = useCase.getMovieUpcoming()
                    listMoviesUpcoming.postValue(resp)
                }catch (e: IOException){
                    Log.e(GlobalUtils.error, "getMovieUpcoming ${e.printStackTrace()}", )
                    listMoviesUpcoming.postValue(listOf())
                }

            }
        }


}