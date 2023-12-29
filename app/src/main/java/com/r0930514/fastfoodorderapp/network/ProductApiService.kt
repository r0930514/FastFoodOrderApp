package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("/debug/products/{id}")
    suspend fun getProduct(@Path("id") id: String): Response<List<Product>>
}