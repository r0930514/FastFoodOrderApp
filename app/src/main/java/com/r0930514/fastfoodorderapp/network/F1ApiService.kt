package com.r0930514.fastfoodorderapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface F1ApiService {
    @GET("f1/{year}/drivers.json")
    suspend fun getDriverByYear(@Path("year") year:Int): Response<API>
}