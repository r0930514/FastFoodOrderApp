package com.r0930514.fastfoodorderapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table")
    suspend fun getAll(): List<CartEntity>
    @Insert
    suspend fun insert(cartEntity: CartEntity)
}