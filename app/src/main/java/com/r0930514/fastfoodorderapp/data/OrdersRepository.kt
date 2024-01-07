package com.r0930514.fastfoodorderapp.data

import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.flow.flow

class OrdersRepository {
    private val api = RetrofitInstance.orderApiService
    fun getOrders(token: String) = flow {
        try {
            val response = api.getOrder(token)
            if (!response.isSuccessful) throw Exception("Response is not successful")
            emit(response.body()!!)
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }
    fun getAllOrders(token: String) = flow {
        try {
            while (true){
                val response = api.getAllOrder(token)
                if (!response.isSuccessful) throw Exception("Response is not successful")
                emit(response.body()!!)
                kotlinx.coroutines.delay(3000)
            }
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }
    fun doneOrder(token: String, id: String) = flow {
        try {
            val response = api.setOrderDone(token, id)
            if (!response.isSuccessful) throw Exception("Response is not successful")
            emit(response.body()!!)
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }
}