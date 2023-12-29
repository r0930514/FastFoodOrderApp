package com.r0930514.fastfoodorderapp.data

import com.r0930514.fastfoodorderapp.model.Product
import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductRepository {
    private val productApiService = RetrofitInstance.productApiService
    suspend fun getProduct(id: String) = flow{
        val response = productApiService.getProduct(id)
        if(response.isSuccessful){
            emit(response.body())
        }else{
            emit(emptyList<List<Product>>())
        }
    }.flowOn(Dispatchers.IO)
}