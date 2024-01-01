package com.r0930514.fastfoodorderapp.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.r0930514.fastfoodorderapp.data.CartRepository
import com.r0930514.fastfoodorderapp.database.CartDatabase
import com.r0930514.fastfoodorderapp.database.CartOrderView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CartCompletedViewModel(
    private val cartRepository: CartRepository
): ViewModel() {
    private val _orderList = MutableStateFlow<List<CartOrderView>>(emptyList())
    val orderList: MutableStateFlow<List<CartOrderView>> = _orderList
    init {
        fetchOrderList()
    }
    private fun fetchOrderList(){
        viewModelScope.launch {
            try {
                cartRepository.orderList.collect {
                    _orderList.value = it
                    Log.e("CartCompletedViewModel", "fetchOrderList: ${it.toString()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContext = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application
                val cartRepository = CartRepository(CartDatabase.getDatabase(appContext).cartDao())
                CartCompletedViewModel(cartRepository)
            }
        }
    }
}