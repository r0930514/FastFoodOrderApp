package com.r0930514.fastfoodorderapp.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.r0930514.fastfoodorderapp.data.OrdersRepository
import com.r0930514.fastfoodorderapp.data.UserStateRepository
import com.r0930514.fastfoodorderapp.dataStore
import com.r0930514.fastfoodorderapp.model.OrdersModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(
    private val ordersRepository: OrdersRepository,
    private val userStateRepository: UserStateRepository
): ViewModel() {
    private val _token = MutableStateFlow<String>("")
    private val token: MutableStateFlow<String> = _token

    private val _orderList = MutableStateFlow<List<OrdersModel>>(emptyList())
    val orderList: MutableStateFlow<List<OrdersModel>> = _orderList
    init {
        fetchToken()
        fetchOrderList()
    }
    private fun fetchToken(){
        viewModelScope.launch{
            userStateRepository.getUserToken().collect{
                _token.value = it
            }
        }
    }
    private fun fetchOrderList(){
        viewModelScope.launch {
            try {
                ordersRepository.getOrders(token.value).collect {
                    _orderList.value = listOf(it)
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
                val ordersRepository = OrdersRepository()
                OrdersViewModel(ordersRepository, UserStateRepository(appContext.dataStore))
            }
        }
    }
}