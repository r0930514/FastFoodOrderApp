package com.r0930514.fastfoodorderapp.database

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import com.google.gson.annotations.SerializedName

@DatabaseView(
    value = "SELECT product_id, specification_id, product_count FROM cart_table",
    viewName = "cart_order_view"
)
data class CartOrderView(
    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    val productID: String,
    @ColumnInfo(name = "specification_id")
    @SerializedName("specification_id")
    val specificationID: String,
    @ColumnInfo(name = "product_count")
    @SerializedName("count")
    val productCount: Int,
)
