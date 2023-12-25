package com.r0930514.fastfoodorderapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r0930514.fastfoodorderapp.data.NewsRepository
import com.r0930514.fastfoodorderapp.model.NewsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel(){
    private val repository = NewsRepository()
    private val _newsList = MutableStateFlow<List<NewsModel>>(emptyList())
    val newsList: StateFlow<List<NewsModel>> = _newsList

    private fun fetchNewsList(){
        viewModelScope.launch {
            try{
                repository.getNews().collect {
                    _newsList.value = it ?: emptyList()
                }
            }catch (e: Exception){
                throw e
            }
        }
    }
    init {
        fetchNewsList()
        Log.e("NewsViewModel", "init: ")
    }
}