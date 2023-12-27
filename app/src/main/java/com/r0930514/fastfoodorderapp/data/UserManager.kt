package com.r0930514.fastfoodorderapp.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object UserManager{
    private val _userPhone = MutableStateFlow("")
    private val _userToken = MutableStateFlow("")
    val userPhone: StateFlow<String> get() = _userPhone
    val userToken: StateFlow<String> get() = _userToken

}