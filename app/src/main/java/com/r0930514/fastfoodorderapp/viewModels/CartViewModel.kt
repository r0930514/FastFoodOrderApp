package com.r0930514.fastfoodorderapp.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.r0930514.fastfoodorderapp.data.CartRepository
import com.r0930514.fastfoodorderapp.database.CartDatabase
import com.r0930514.fastfoodorderapp.database.CartEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository): ViewModel() {
    private val _cartList = MutableStateFlow<List<CartEntity>>(emptyList())
    val cartList: MutableStateFlow<List<CartEntity>> = _cartList
    init {
        fetchCartList()
    }
    private fun fetchCartList(){
        viewModelScope.launch {
            try{
                cartRepository.cartList.collect {
                    _cartList.value = it ?: emptyList()
                }
            }catch (e: Exception){
                Log.e("CartViewModel", "fetchCartList: ${e.message}")
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContext = this[APPLICATION_KEY] as Application
                val cartRepository = CartRepository(CartDatabase.getDatabase(appContext).cartDao())
                CartViewModel(cartRepository)
            }
        }
    }
}