package com.r0930514.fastfoodorderapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table")
    fun getAll(): Flow<List<CartEntity>>

    //getOrderList
    @Query("SELECT * FROM cart_order_view")
    fun getOrderList(): Flow<List<CartOrderView>>

    @Insert
    suspend fun insert(cartEntity: CartEntity)
    @Query("SELECT * FROM cart_table WHERE id = :orderDetailID")
    suspend fun getItem(orderDetailID: String): CartEntity

    @Delete
    suspend fun delete(cartEntity: CartEntity)
    @Update
    suspend fun update(cartEntity: CartEntity)

    //計算總價
    @Query("SELECT SUM(product_price * product_count) as total_price FROM cart_table")
    fun getTotalPrice(): Flow<Int>
    //清空購物車
    @Query("DELETE FROM cart_table")
    suspend fun clearCart()
}