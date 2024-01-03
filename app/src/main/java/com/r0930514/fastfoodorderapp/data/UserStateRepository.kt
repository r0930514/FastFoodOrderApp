package com.r0930514.fastfoodorderapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UserStateRepository(private val dataStore: DataStore<Preferences>) {
    //DATASTORE KEY
    private val _userPhoneKey = stringPreferencesKey("username")
    private val _userTokenKey = stringPreferencesKey("token")
    suspend fun saveUser(userName: String, token: String = "") {
        dataStore.edit { preferences ->
            preferences[_userPhoneKey] = userName
            preferences[_userTokenKey] = token
        }
    }
    suspend fun getUserPhone() = flow{
        dataStore.data.map { preferences ->
            preferences[_userPhoneKey] ?: ""
        }.collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getUserToken() = flow{
        dataStore.data.map { preferences ->
            preferences[_userTokenKey] ?: ""
        }.collect {
            emit(it)
        }
    }.flowOn(Dispatchers.IO)
}