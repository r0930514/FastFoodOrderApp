package com.r0930514.fastfoodorderapp.data

import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository {
    private val newsApiService = RetrofitInstance.newsApiService
    suspend fun getNews() = flow {
        val response = newsApiService.getNews()
        if (response.isSuccessful) {
            emit(response.body())
        } else {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)

}