package com.estarly.peliculas.utils

import android.content.Context
import android.view.Surface
import android.view.WindowManager
import androidx.core.widget.NestedScrollView
import com.estarly.peliculas.domain.entities.MovieEntity
import com.estarly.peliculas.domain.models.Movie

fun NestedScrollView.listenerScroll(callback: (isUp:Boolean ) -> Unit) {
    this.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
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
