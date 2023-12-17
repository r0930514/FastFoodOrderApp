package com.r0930514.fastfoodorderapp.network

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.Album
import com.r0930514.fastfoodorderapp.data.JsonplaceholderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JsonplaceholderViewModel : ViewModel() {
    private val repository = JsonplaceholderRepository()

    private val _myDataList = MutableStateFlow<List<Album>>(emptyList())
    val myDataList: StateFlow<List<Album>> = _myDataList

    fun fetchMyDataList() {
        Log.i("Run Fetch", "執行請求")
        viewModelScope.launch {
            try{
                repository.getAlbumFlow().collect {
                    _myDataList.value = it ?: emptyList()
                }
            }catch (e: Exception){
                Log.e("ERROR", "$e")
            }
        }
    }
    init {
        fetchMyDataList()
    }
}