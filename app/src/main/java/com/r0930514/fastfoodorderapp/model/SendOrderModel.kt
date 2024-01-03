package com.r0930514.fastfoodorderapp.model

import com.google.gson.annotations.SerializedName
import com.r0930514.fastfoodorderapp.database.CartOrderView

data class SendOrderModel(
    @SerializedName("orders")
    val orderList: List<CartOrderView>,
    @SerializedName("type")
    val orderType: SendOrderTypeModel,
)

data class SendOrderTypeModel(
    @SerializedName("type")
    val orderType: String,
    @SerializedName("table_id")
    val tableID: String,
)
