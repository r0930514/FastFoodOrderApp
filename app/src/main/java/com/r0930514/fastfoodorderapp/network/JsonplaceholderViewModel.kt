package com.r0930514.fastfoodorderapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.Album
import com.r0930514.fastfoodorderapp.data.JsonplaceholderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class JsonplaceholderViewModel : ViewModel() {
    private val repository = JsonplaceholderRepository()

    private val _myDataList = MutableStateFlow<List<Album>>(emptyList())
    val myDataList: MutableStateFlow<List<Album>> get() = _myDataList

    fun fetchMyDataList() {
        viewModelScope.launch {
            repository.getAlbumFlow().collect {
                _myDataList.value = it?: emptyList()
            }
        }
    }
    init {
        fetchMyDataList()
    }
}