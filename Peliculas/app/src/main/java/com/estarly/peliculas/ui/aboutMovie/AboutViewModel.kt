package com.estarly.peliculas.ui.aboutMovie

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estarly.peliculas.data.usecases.UseCase
import com.estarly.peliculas.domain.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AboutViewModel : ViewModel() {
    private lateinit var useCase  :UseCase
    var listMoviesSimilar = MutableLiveData<List<Movie>>()


    fun getMoviesSimilar(context: Context, idMovie:String) = GlobalScope.launch(Dispatchers.IO) {
        useCase = UseCase(context)
        listMoviesSimilar.postValue(
            if(listMoviesSimilar.value?.isEmpty() == true || listMoviesSimilar.value == null )
                useCase.getMovieSimilar(idMovie)
            else listMoviesSimilar.value)
    }

}