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
    @SerializedName("spec")
    val productSpecification: List<ProductSpecification> = emptyList(),
)

data class ProductSpecification(
    @SerializedName("specification_id")
    val specificationID: String,
    @SerializedName("specification_name")
    val specificationName: String,
)


