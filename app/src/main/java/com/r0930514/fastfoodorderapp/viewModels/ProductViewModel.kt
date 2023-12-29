package com.r0930514.fastfoodorderapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.ProductRepository
import com.r0930514.fastfoodorderapp.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(id: String): ViewModel() {
    private val repository = ProductRepository()
    private val _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList = _productList
    private fun getProduct(id: String){
        viewModelScope.launch {
            try{
                repository.getProduct(id).collect {
                    _productList.value = (it ?: emptyList()) as List<Product>
                }
            }catch (e: Exception){
                Log.e("ProductViewModel: getProduct:",  e.message.toString())
            }
        }
    }

    init {
        getProduct(id)
    }
}