package com.r0930514.fastfoodorderapp.network

import com.r0930514.fastfoodorderapp.model.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApiService {
    @POST("/debug/user/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("userphone") userPhone: String,
        @Field("password") password: String
    ): Response<LoginResponseModel>

    @GET("/debug/user/isLoggedIn")
    suspend fun isTokenValid(
        @Header("Authorization") token: String
    ): Response<Unit>

    @POST("/debug/user/isPhoneExist")
    @FormUrlEncoded
    suspend fun isPhoneExist(
        @Field("userphone") userPhone: String
    ): Response<Unit>

    @POST("/debug/user/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("userphone") userPhone: String,
        @Field("password") password: String,
        @Field("username") name: String
    ): Response<Unit>
}