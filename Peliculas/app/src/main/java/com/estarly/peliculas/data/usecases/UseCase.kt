package com.estarly.peliculas.data.usecases

import com.estarly.peliculas.data.retrofit.MoviesApi
import com.estarly.peliculas.data.retrofit.RetrofitHelper
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.GlobalUtils
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Call

class UseCase {
    private val movieApi: MoviesApi = RetrofitHelper.getRetrofit().create(MoviesApi::class.java)

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
}