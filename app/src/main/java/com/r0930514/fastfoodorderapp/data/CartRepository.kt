package com.r0930514.fastfoodorderapp.data

import android.util.Log
import com.r0930514.fastfoodorderapp.database.CartDao
import com.r0930514.fastfoodorderapp.database.CartEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CartRepository(private val cartDao: CartDao) {
    val cartList = cartDao.getAll()
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

    suspend fun delete(cartEntity: CartEntity){
        cartDao.delete(cartEntity)
    }
}