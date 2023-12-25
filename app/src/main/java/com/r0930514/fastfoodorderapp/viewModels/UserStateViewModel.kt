package com.r0930514.fastfoodorderapp.viewModels

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserStateViewModel(private val dataStore: DataStore<Preferences>): ViewModel(){
    private val userNameKey = stringPreferencesKey("username")
    private val _userName = MutableStateFlow<String>("")
    val userName: StateFlow<String> get() = _userName
    fun saveUserName(userName: String) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[userNameKey] = userName
            }
        }
    }

    private suspend fun getUserName(){
        dataStore.data.map { preferences ->
            preferences[userNameKey] ?: ""
        }.collect {
            _userName.value = it
        }
    }

    init {
        viewModelScope.launch {
            getUserName()
        }
    }
}