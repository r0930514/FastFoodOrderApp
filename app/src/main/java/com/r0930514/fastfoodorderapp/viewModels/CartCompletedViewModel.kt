package com.r0930514.fastfoodorderapp.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.r0930514.fastfoodorderapp.data.CartRepository
import com.r0930514.fastfoodorderapp.data.UserStateRepository
import com.r0930514.fastfoodorderapp.dataStore
import com.r0930514.fastfoodorderapp.database.CartDatabase
import com.r0930514.fastfoodorderapp.database.CartOrderView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CartCompletedViewModel(
    private val cartRepository: CartRepository,
    private val userStateRepository: UserStateRepository
): ViewModel() {
    private val _orderList = MutableStateFlow<List<CartOrderView>>(emptyList())
    val orderList: MutableStateFlow<List<CartOrderView>> = _orderList
    private val _token = MutableStateFlow<String>("")
    private val token: MutableStateFlow<String> = _token
    private var notifyToken = ""
    init {
        fetchOrderList()
        fetchToken()
        getFirebaseToken()
    }
    private fun fetchOrderList(){
        viewModelScope.launch {
            try {
                cartRepository.orderList.collect {
                    _orderList.value = it
                    //Log.e("CartCompletedViewModel", "fetchOrderList: ${it.toString()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun fetchToken(){
        viewModelScope.launch {
            try {
                userStateRepository.getUserToken().collect {
                    _token.value = it
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    suspend fun sendOrder(orderList: List<CartOrderView>, orderType: String, tableID: String){
        cartRepository.sendOrder(token.value, orderList, orderType, tableID, notifyToken)
    }
    private fun getFirebaseToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            // Get new FCM registration token
            notifyToken = task.result
        })
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContext = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application
                val cartRepository = CartRepository(CartDatabase.getDatabase(appContext).cartDao())
                CartCompletedViewModel(cartRepository, UserStateRepository(appContext.dataStore))
            }
        }
    }
}