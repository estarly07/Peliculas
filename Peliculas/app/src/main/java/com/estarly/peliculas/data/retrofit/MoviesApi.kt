package com.estarly.peliculas.data.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MoviesApi {
    @GET("/3/search/movie")
    fun getMovies(
        @QueryMap params: Map<String, String>,
        ): Call<Map<String, Any>>
    @GET("/3/movie/latest")
    fun getMovieLatest(
        @QueryMap params: Map<String, String>,
        ): Call<Map<String, Any>>
}