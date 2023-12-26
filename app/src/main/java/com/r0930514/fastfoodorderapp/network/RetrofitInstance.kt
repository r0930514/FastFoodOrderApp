package com.r0930514.fastfoodorderapp.network

import retrofit2.Retrofit

object RetrofitInstance {
    private const val baseUrl = "https://api.r0930514.work/debug/"
    private val api by lazy{
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }


    val newsApiService: NewsApiService by lazy {
        api.create(NewsApiService::class.java)
    }
    val productListApiService: ProductListApiService by lazy {
        api.create(ProductListApiService::class.java)
    }

}