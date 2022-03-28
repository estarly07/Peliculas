package com.estarly.peliculas.ui.aboutMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.movieToMovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private var useCase: UseCase
): ViewModel() {
    var listMoviesSimilar = MutableLiveData<List<Movie>>()

    fun getMoviesSimilar(idMovie:String) = GlobalScope.launch(Dispatchers.IO) {
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
    fun getMovie(idMovie: Long) : Boolean {
        return  useCase.getMovie(idMovie)!=null
    }

    fun deleteMovie(movie: Movie) = GlobalScope.launch(Dispatchers.Main) {
        useCase.deleteMovie(movie.id)
    }
}