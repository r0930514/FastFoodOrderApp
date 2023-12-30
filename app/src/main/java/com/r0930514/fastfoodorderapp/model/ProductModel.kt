package com.r0930514.fastfoodorderapp.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("product_id")
    val productID: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("image_URL")
    val imageURL: String,
    @SerializedName("making_time")
    val makingTime: String,
    @SerializedName("product_price")
    val productPrice: String,
    @SerializedName("product_illustrate")
    val productIllustrate: String, //產品說明
    @SerializedName("product_class")
    val productClass: String,
    @SerializedName("product_specification")
    val productSpecification: List<ProductSpecification> = emptyList(),
)

data class ProductSpecification(
    val specificationID: String,
    val specificationName: String,
)

