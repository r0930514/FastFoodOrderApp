package com.r0930514.fastfoodorderapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.database.CartDatabase
import com.r0930514.fastfoodorderapp.database.CartEntity
import kotlinx.coroutines.launch

class CartViewModel(private val cartDatabase: CartDatabase): ViewModel() {
    init {
        viewModelScope.launch {
            cartDatabase.cartDao().insert(CartEntity(null, "test", 1, 1, "test"))
            Log.e("CartViewModel", "init:${cartDatabase.cartDao().getAll()}")
        }
    }
}