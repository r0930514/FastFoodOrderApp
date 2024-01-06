package com.r0930514.fastfoodorderapp.data

import android.util.Log
import com.r0930514.fastfoodorderapp.database.CartDao
import com.r0930514.fastfoodorderapp.database.CartEntity
import com.r0930514.fastfoodorderapp.database.CartOrderView
import com.r0930514.fastfoodorderapp.model.SendOrderModel
import com.r0930514.fastfoodorderapp.model.SendOrderTypeModel
import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CartRepository(private val cartDao: CartDao) {
    private val orderApiService = RetrofitInstance.orderApiService
    val cartList = cartDao.getAll()
    val totalPrice = cartDao.getTotalPrice()
    val orderList = cartDao.getOrderList()
    suspend fun insert(cartEntity: CartEntity) {
        cartDao.insert(cartEntity)
    }
    fun getItem(orderDetailID: String): Flow<CartEntity> = flow{
        try{
            emit(cartDao.getItem(orderDetailID))
        }catch (e: Exception){
            Log.e("CartViewModel", "getItem: ${e.message}")
        }

    }.flowOn(Dispatchers.IO)

    suspend fun sendOrder(token: String, orderList: List<CartOrderView>, orderType: String, tableID: String, notifyToken: String){
        try {
            val data = SendOrderModel(orderList, SendOrderTypeModel(orderType, tableID ), notifyToken)
            Log.e("repository", "sendOrder: ${data.toString()}")
            val response = orderApiService.sendOrder(token, data)
            if (!response.isSuccessful) throw Exception("Response is not successful")
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }


    suspend fun delete(cartEntity: CartEntity){
        cartDao.delete(cartEntity)
    }
    suspend fun clearCart(){
        cartDao.clearCart()
    }
    suspend fun update(cartEntity: CartEntity){
        cartDao.update(cartEntity)
    }
}