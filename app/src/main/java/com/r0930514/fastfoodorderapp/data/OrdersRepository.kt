package com.r0930514.fastfoodorderapp.data

import android.util.Log
import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.flow.flow

class OrdersRepository {
    private val api = RetrofitInstance.orderApiService
    fun getOrders(token: String) = flow {
        try {
            val response = api.getOrder(token)
            Log.e("OrdersRepository", "getOrders: ${response.body().toString()}")
            if (!response.isSuccessful) throw Exception("Response is not successful")
            emit(response.body()!!)
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }
}