package com.r0930514.fastfoodorderapp.data

import com.r0930514.fastfoodorderapp.database.CartDao
import com.r0930514.fastfoodorderapp.database.CartEntity

class CartRepository(private val cartDao: CartDao) {
    val cartList = cartDao.getAll()
    suspend fun insert(cartEntity: CartEntity) {
        cartDao.insert(cartEntity)
    }
}