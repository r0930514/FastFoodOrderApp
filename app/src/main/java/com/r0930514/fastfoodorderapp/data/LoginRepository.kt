package com.r0930514.fastfoodorderapp.data

import android.util.Log
import com.r0930514.fastfoodorderapp.model.LoginResponseModel
import com.r0930514.fastfoodorderapp.network.RetrofitInstance

class LoginRepository {
    private val loginApiService = RetrofitInstance.loginApiService
    suspend fun login(username: String, password: String): LoginResponseModel {
        Log.e("LoginRepository", "Login")
        try {
            val response = loginApiService.login(username, password)
            if (response.isSuccessful) {
                val token = response.headers()["Authorization"]
                return response.body()!!.apply {
                    this.token = token!!
                }
            }else{
                throw Exception("Response is not successful")
            }
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }

    suspend fun register(username: String, password: String){
        Log.e("LoginRepository", "Register")
        try {
            val response = loginApiService.register(username, password, username)
            if (!response.isSuccessful) throw Exception("Response is not successful")
        }catch (e: Exception){
            throw Exception(e.toString())
        }
    }

    suspend fun isTokenValid(token: String): Boolean{
        Log.e("LoginRepository", "getTokenState")
        return try {
            val response = loginApiService.isTokenValid(token)
            if (response.isSuccessful) {
                true
            }else{
                throw Exception("Response is not successful")
            }
        }catch (e: Exception){
            Log.e("LoginRepository", e.toString())
            false
        }
    }

    suspend fun isPhoneExist(phone: String){
        Log.e("LoginRepository", "checkPhoneExist")
        try {
            val response = loginApiService.isPhoneExist(phone)
            if (!response.isSuccessful) throw Exception("Response is not successful")
        }catch (e: Exception){
            Log.e("LoginRepository", e.toString())
            throw e
        }
    }
}