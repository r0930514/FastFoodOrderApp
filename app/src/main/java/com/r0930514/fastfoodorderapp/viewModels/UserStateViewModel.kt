package com.r0930514.fastfoodorderapp.viewModels

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class UserStateViewModel(private val dataStore: DataStore<Preferences>): ViewModel(){
    private val loginRepository = LoginRepository()
    private val _userPhoneKey = stringPreferencesKey("username")
    private val _userTokenKey = stringPreferencesKey("token")
    private val _userPhone = MutableStateFlow("")
    private val _userToken = MutableStateFlow("")
    val userPhone: StateFlow<String> get() = _userPhone
    val userToken: StateFlow<String> get() = _userToken
    private suspend fun saveUser(userName: String, token: String = ""){
        Log.e("LoginRepository", token)
        dataStore.edit { preferences ->
            preferences[_userPhoneKey] = userName
            preferences[_userTokenKey] = token
        }
    }
    private fun getUserPhone(){
        viewModelScope.launch {
            dataStore.data.map { preferences ->
                preferences[_userPhoneKey] ?: ""
            }.collect {
                _userPhone.value = it
            }
        }
    }

    private fun getUserToken(){
        viewModelScope.launch{
            dataStore.data.map { preferences ->
                preferences[_userTokenKey] ?: ""
            }.collect {
                _userToken.value = it
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
    suspend fun logout(){
        saveUser("", "")
    }
    init {
        getUserToken()
        getUserPhone()
    }
}