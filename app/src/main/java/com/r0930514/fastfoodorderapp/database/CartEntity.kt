package com.r0930514.fastfoodorderapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "product_id")
    val productID: String,
    @ColumnInfo(name = "specification_id")
    val specificationID: String,
    @ColumnInfo(name = "product_count")
    val productCount: Int,

    @ColumnInfo(name = "specification_name")
    val specificationName: String,
    @ColumnInfo(name = "product_name")
    val productName: String,
    @ColumnInfo(name = "product_price")
    val productPrice: Int,

    @ColumnInfo(name = "image")
    val image: String
)
