package com.r0930514.fastfoodorderapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    private val baseUrl = "https://ergast.com/api/"
    private val api by lazy{
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val f1ApiService: F1ApiService by lazy {
        api.create(F1ApiService::class.java)
    }
}