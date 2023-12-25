package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {
    //獲取新聞資料
    @GET("/debug/news")
    suspend fun getNews(): Response<List<NewsModel>>

}