package com.r0930514.fastfoodorderapp.model

import com.google.gson.annotations.SerializedName

data class OrdersModel(
    @SerializedName("order_id")
    val orderID: Int,
    @SerializedName("member_id")
    val memberID: Int,
    @SerializedName("payment_id")
    val paymentID: Int?,
    @SerializedName("order_date")
    val orderDate: String,
    @SerializedName("order_type")
    val orderType: String,
    @SerializedName("order_status")
    val orderStatus: Boolean,
    @SerializedName("order_detail")
    val orderDetail: List<OrderDetailModel>,
)
data class OrderDetailModel(
    @SerializedName("order_detail_id")
    val orderDetailID: Int,
    @SerializedName("product_id")
    val productID: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("specification_id")
    val specificationID: String,
    @SerializedName("specification_name")
    val specificationName: String,
    @SerializedName("product_count")
    val productCount: Int,
    @SerializedName("product_price")
    val productPrice: Int,
    @SerializedName("total")
    val total: Int,
)
