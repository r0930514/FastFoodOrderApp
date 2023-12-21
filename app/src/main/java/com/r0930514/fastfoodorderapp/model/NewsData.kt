package com.r0930514.fastfoodorderapp.model

import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("news_id")
    val id: Int,
    @SerializedName("news_title")
    val title: String,
    @SerializedName("news_content")
    val content: String,
    @SerializedName("news_image_id")
    val imageID: String
)
