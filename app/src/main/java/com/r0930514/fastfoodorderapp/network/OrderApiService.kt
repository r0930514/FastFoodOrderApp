package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.SendOrderModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OrderApiService {
    @POST("/debug/order/add")
    suspend fun sendOrder(
        @Header("Authorization") token: String,
        @Body orderList: SendOrderModel,
    ): Response<Unit>
}