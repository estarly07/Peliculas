package com.estarly.peliculas.data.usecases

import android.content.Context
import com.estarly.peliculas.data.bd.dao.MovieDao
import com.estarly.peliculas.data.bd.database.SqliteDb
import com.estarly.peliculas.data.retrofit.MoviesApi
import com.estarly.peliculas.data.retrofit.RetrofitHelper
import com.estarly.peliculas.domain.entities.MovieEntity
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.GlobalUtils
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Call

class UseCase(context: Context) {
    private val movieApi : MoviesApi = RetrofitHelper.getRetrofit().create(MoviesApi::class.java)
    private var movieDao : MovieDao  = SqliteDb.getInstance(context).movieDao()
    fun getMovies(): List<Movie>? {
        val call: Call<Map<String, Any>> = movieApi.getMovies(
            mapOf(
                "api_key"  to GlobalUtils.apiKey,
                "language" to GlobalUtils.language,
                "query"    to "B"
            )
        )
        val type = object : TypeToken<List<Movie>>() {}.type
        val gson = GsonBuilder().create()
        val json = gson.toJson(call.execute().body()?.get("results"))
        return gson.fromJson(json, type)
    }
    fun getMovieLatest(): Movie? {
        val call: Call<Map<String, Any>> = movieApi.getMovieLatest(
            mapOf(
                "api_key"  to GlobalUtils.apiKey,
                "language" to GlobalUtils.language,
                "query"    to "B"
            )
        )
        val type = object : TypeToken<Movie>() {}.type
        val gson = GsonBuilder().create()
        val json = gson.toJson(call.execute().body())
        return gson.fromJson(json, type)
    }
    fun getMovieUpcoming():  List<Movie>? {
        val call: Call<Map<String, Any>> = movieApi.getMovieUpcoming(
            mapOf(
                "api_key"  to GlobalUtils.apiKey,
                "language" to GlobalUtils.language,
                "query"    to "B"
            )
        )
        val type = object : TypeToken<List<Movie>>() {}.type
        val gson = GsonBuilder().create()
        val json = gson.toJson(call.execute().body()?.get("results"))
        return gson.fromJson(json, type)
    }
    fun getMovieSimilar(idMovie: String):  List<Movie>? {
        val call: Call<Map<String, Any>> = movieApi.getMovieSimilar(
            idMovie,
            mapOf(
                "api_key"  to GlobalUtils.apiKey,
                "language" to GlobalUtils.language,
                "query"    to "B"
            )
        )
        val type = object : TypeToken<List<Movie>>() {}.type
        val gson = GsonBuilder().create()
        val json = gson.toJson(call.execute().body()?.get("results"))
        return gson.fromJson(json, type)
    }

    suspend fun getFavoritesMovies () : List<MovieEntity>{
        return movieDao.getMoviesFavorites()
    }
    suspend fun insertMovie (movieEntity: MovieEntity) : Long{
        return movieDao.registerMovie(movieEntity)
    }
    suspend fun deleteMovie (idMovie: Long) {
        return movieDao.deleteMovie(idMovie)
    }
}

