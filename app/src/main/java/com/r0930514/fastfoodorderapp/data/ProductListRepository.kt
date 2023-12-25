package com.r0930514.fastfoodorderapp.data

import com.r0930514.fastfoodorderapp.model.Product
import com.r0930514.fastfoodorderapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductListRepository {
    private val productListApiService = RetrofitInstance.productListApiService
    suspend fun getProductList() = flow{
        val response = productListApiService.getProducts()
        if(response.isSuccessful){
            emit(response.body())
        }else{
            emit(emptyList<List<List<Product>>>())
        }
    }.flowOn(Dispatchers.IO)
}