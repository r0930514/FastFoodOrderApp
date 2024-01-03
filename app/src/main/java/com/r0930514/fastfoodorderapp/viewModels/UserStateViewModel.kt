package com.r0930514.fastfoodorderapp.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.r0930514.fastfoodorderapp.data.LoginRepository
import com.r0930514.fastfoodorderapp.data.UserStateRepository
import com.r0930514.fastfoodorderapp.dataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UserStateViewModel(
    private val userStateRepository: UserStateRepository,
    private val loginRepository: LoginRepository
    ): ViewModel()
{

    private val _userPhone = MutableStateFlow("")
    private val _userToken = MutableStateFlow("")
    val userPhone: StateFlow<String> get() = _userPhone
    val userToken: StateFlow<String> get() = _userToken
    init {
        getUserToken()
        getUserPhone()
    }

    private fun saveUser(userName: String, token: String = ""){
        Log.e("LoginRepository", token)
        viewModelScope.launch {
            userStateRepository.saveUser(userName, token)
        }
    }
    private fun getUserPhone(){
        viewModelScope.launch {
            userStateRepository.getUserPhone().collect {
                _userPhone.value = it
            }
        }
    }

    private fun getUserToken(){
        viewModelScope.launch{
            userStateRepository.getUserToken().collect {
                _userToken.value = it
                checkTokenValid(it)
            }
        }

    }
    private fun checkTokenValid(token: String) {
        viewModelScope.launch {
            if (loginRepository.isTokenValid(token)) {
                Log.e("LoginRepository", "Token is valid")
            } else {
                Log.e("LoginRepository", "Token is invalid")
            }
        }
    }
    suspend fun checkUserExist(phone: String) {
        loginRepository.isPhoneExist(phone)
    }

    //登入與註冊、登出
    suspend fun login(phone: String, password: String){
        val result = loginRepository.login(phone, password)
        result.token?.let { saveUser(result.userPhone, it) }
    }
    suspend fun register(userPhone: String, password: String, confirmPassword: String){
        if (password != confirmPassword) {
            throw Exception("密碼不一致")
        }
        loginRepository.register(userPhone, password)
    }
    fun logout(){
        saveUser("", "")
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContext = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application
                val loginRepository = LoginRepository()
                UserStateViewModel(UserStateRepository(appContext.dataStore), loginRepository)
            }
        }
    }
}