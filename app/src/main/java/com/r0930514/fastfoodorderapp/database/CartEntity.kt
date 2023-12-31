package com.r0930514.fastfoodorderapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,

    // 這裡的 productID 與 specificationID 是為了方便之後的查詢
    @ColumnInfo(name = "product_id")
    val productID: String,
    @ColumnInfo(name = "specification_id")
    val specificationID: String,
    @ColumnInfo(name = "product_count")
    val productCount: Int,

    // 等等網路請求再拿
    @ColumnInfo(name = "specification_name")
    val specificationName: String,
    @ColumnInfo(name = "product_name")
    val productName: String,
    @ColumnInfo(name = "product_price")
    val productPrice: Int,

    @ColumnInfo(name = "image")
    val image: String


)
