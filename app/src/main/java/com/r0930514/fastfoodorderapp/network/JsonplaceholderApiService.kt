package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.data.Album
import retrofit2.Response
import retrofit2.http.GET

interface JsonplaceholderApiService {
    @GET("users/1/albums")
    suspend fun getAlbums(): Response<List<Album>>
}