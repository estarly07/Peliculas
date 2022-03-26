package com.estarly.peliculas.data.retrofit
import com.estarly.peliculas.utils.GlobalUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(GlobalUtils.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}