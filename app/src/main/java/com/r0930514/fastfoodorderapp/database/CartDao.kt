package com.r0930514.fastfoodorderapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table")
    fun getAll(): Flow<List<CartEntity>>
    @Insert
    suspend fun insert(cartEntity: CartEntity)
}