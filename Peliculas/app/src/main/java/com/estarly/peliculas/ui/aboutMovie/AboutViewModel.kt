package com.estarly.peliculas.ui.aboutMovie

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.entities.MovieEntity
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.movieToMovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class AboutViewModel : ViewModel() {
    private lateinit var useCase  :UseCase
    var listMoviesSimilar = MutableLiveData<List<Movie>>()

    fun getMoviesSimilar(context: Context, idMovie:String) = GlobalScope.launch(Dispatchers.IO) {
        useCase = UseCase(context)
        if(listMoviesSimilar.value?.isEmpty() == true || listMoviesSimilar.value == null ) {
            try {
                val resp = useCase.getMovieSimilar(idMovie)/*listOf<Movie>()*/
                listMoviesSimilar.postValue(resp)
            }catch (e: IOException){
                e.printStackTrace()
                listMoviesSimilar.postValue(listOf())
            }

        }

    }

    fun insertMovie(movie: Movie) = GlobalScope.launch(Dispatchers.Main) {
        useCase.insertMovie(movie.movieToMovieEntity())

    }
    fun getMovie(idMovie: Long,context: Context) : Boolean {
        useCase = UseCase(context)
        return  useCase.getMovie(idMovie)!=null
    }

    fun deleteMovie(movie: Movie) = GlobalScope.launch(Dispatchers.Main) {
        useCase.deleteMovie(movie.id)
    }
}