package com.r0930514.fastfoodorderapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.ProductListRepository
import com.r0930514.fastfoodorderapp.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductListViewModel: ViewModel() {
    private val repository = ProductListRepository()
    private val _productList = MutableStateFlow<List<List<Product>>>(emptyList())
    val productList = _productList

    private suspend fun fetchProductList(){
        try{
            repository.getProductList().collect {
                _productList.value = (it ?: emptyList<List<List<Product>>>()) as List<List<Product>>
            }
        }catch (e: Exception){
            Log.e("ProductListViewModel", "fetchProductList: ${e.message}")
        }
    }
    init {
        viewModelScope.launch {
            fetchProductList()
        }
    }


}