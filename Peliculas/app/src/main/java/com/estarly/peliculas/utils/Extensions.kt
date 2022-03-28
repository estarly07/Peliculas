package com.estarly.peliculas.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.Surface
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import com.estarly.peliculas.R
import com.estarly.peliculas.domain.entities.MovieEntity
import com.estarly.peliculas.domain.models.Movie

/**
 * listener para cuando haga scroll
 *@param callback funcion que se va a llamar cuando haga scroll
 */
fun NestedScrollView.listenerScroll(callback: (isUp:Boolean ) -> Unit) {
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
        callback.invoke(scrollY < oldScrollY)
    })
}
/**
 * return true  => Vertical
 *        false => Horizontal
 */
fun Context.getTypeRotation():Boolean =
    when((getSystemService(Context.WINDOW_SERVICE)as WindowManager).defaultDisplay.orientation){
        Surface.ROTATION_0,Surface.ROTATION_180-> true
        else->false
    }

fun String.showToast(context: Context){
    val toast = Toast(context)
    val view = LayoutInflater.from(context).inflate(R.layout.toast,null,false)
    toast.duration = Toast.LENGTH_SHORT
    val text = view.findViewById<TextView>(R.id.msg)
    text.text = this
    toast.view = view
    toast.show()
}

/**
 * return devuelve un objeto movie
 */
fun MovieEntity.movieEntityToMovie():Movie =Movie(
    adult             = this.adult,
    backdrop_path     = this.backdrop_path,
    id                = this.id,
    original_language = this.original_language,
    original_title    = this.original_title,
    overview          = this.overview,
    popularity        = this.popularity,
    poster_path       = this.poster_path,
    release_date      = this.release_date,
    title             = this.title,
    video             = this.video,
    vote_average      = this.vote_average,
    vote_count        = this.vote_count,
)

/**
 * return devuelve un objeto MovieEntity
 */
fun Movie.movieToMovieEntity():MovieEntity = MovieEntity(
    adult             = this.adult,
    backdrop_path     = this.backdrop_path,
    id                = this.id,
    original_language = this.original_language,
    original_title    = this.original_title,
    overview          = this.overview,
    popularity        = this.popularity,
    poster_path       = this.poster_path,
    release_date      = this.release_date,
    title             = this.title,
    video             = this.video,
    vote_average      = this.vote_average,
    vote_count        = this.vote_count,
    )
/**
 * return devuelve una lista de  Movie
 */
fun List<MovieEntity>.movieEntityListToMovieList():List<Movie> {
    var list = mutableListOf<Movie>()
    for (movie in this){
        list.add(movie.movieEntityToMovie())
    }
    return list
}

/**
 * saber si esta conectado a la red
 * return true => con access
 *        false => sin access
 */
fun validateAccessConnection():Boolean{
    val p = Runtime.getRuntime().exec("ping -c 1 www.google.es")
    return p.waitFor()==0
}