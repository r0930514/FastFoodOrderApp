package com.r0930514.fastfoodorderapp.data

import android.util.Log
import com.r0930514.fastfoodorderapp.network.JsonTestRetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

data class Album(
    val userId: Int,
    val id: Int,
    val title: String
)

class JsonplaceholderRepository {
    private val api = JsonTestRetrofitInstance.jsonplaceholderApiService
    suspend fun getAlbumFlow() = flow {
        val response: Response<List<Album>> = api.getAlbums()
        if (response.isSuccessful) {
            Log.e("F", "F")
            emit(response.body())
        } else {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}   