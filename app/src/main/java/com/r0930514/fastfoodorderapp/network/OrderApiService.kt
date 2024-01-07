package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.OrdersModel
import com.r0930514.fastfoodorderapp.model.SendOrderModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrderApiService {
    @POST("/debug/order/add")
    suspend fun sendOrder(
        @Header("Authorization") token: String,
        @Body orderList: SendOrderModel,
    ): Response<Unit>
    @GET("/debug/order")
    suspend fun getOrder(
        @Header("Authorization") token: String,
    ): Response<List<OrdersModel>>

    // For admin
    @GET("/debug/order/all")
    suspend fun getAllOrder(
        @Header("Authorization") token: String,
    ): Response<List<OrdersModel>>

    @PUT("/debug/order/done/{id}")
    suspend fun setOrderDone(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Response<Unit>
}