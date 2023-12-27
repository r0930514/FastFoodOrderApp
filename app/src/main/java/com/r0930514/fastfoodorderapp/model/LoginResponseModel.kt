package com.r0930514.fastfoodorderapp.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("userphone")
    val userPhone: String,
    @SerializedName("token")
    var token: String? = null
)
