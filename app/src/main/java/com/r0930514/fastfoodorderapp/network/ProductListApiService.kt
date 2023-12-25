package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductListApiService {
    //獲取產品資料
    @GET("/debug/products/list")
    suspend fun getProducts(): Response<List<List<Product>>>
}