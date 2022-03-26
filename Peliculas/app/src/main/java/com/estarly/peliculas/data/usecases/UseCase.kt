package com.estarly.peliculas.data.usecases

import com.estarly.peliculas.data.retrofit.MoviesApi
import com.estarly.peliculas.data.retrofit.RetrofitHelper
import com.estarly.peliculas.domain.models.Movie
import com.estarly.peliculas.utils.GlobalUtils
import retrofit2.Call

class UseCase {
    private val movieApi: MoviesApi = RetrofitHelper.getRetrofit().create(MoviesApi::class.java)

     fun getMovies(): List<Movie>? {
        val call: Call<Map<String , Any>> = movieApi.getMovies(
            mapOf(
                "api_key"  to GlobalUtils.apiKey,
                "language" to GlobalUtils.language,
                "query"    to "B"
            )
        )
        return call.execute().body()?.get("results") as List<Movie>?
    }
}