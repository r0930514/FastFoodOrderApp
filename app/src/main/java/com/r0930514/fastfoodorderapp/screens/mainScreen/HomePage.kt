package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CommonAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.HomePageCard
import com.r0930514.fastfoodorderapp.viewModels.NewsViewModel

@Composable
fun HomePage(
    navController: NavHostController,
    lazyListState: LazyListState,
    viewModel: NewsViewModel = viewModel()
) {
    val myData by viewModel.newsList.collectAsState()

    Column {
        CommonAppBar("最新資訊")
        LazyColumn (
            state = lazyListState
        ){
            if (myData.isNotEmpty()) {
                items(myData.size) {
                    HomePageCard(
                        title = myData[it].title,
                        description = myData[it].content,
                        imageURL = "https://api.r0930514.work/debug/static/image/food/${(it+2)*2}.jpg"
                    )
                }
            }else{
                item {
                    LoadingCircle()
                }
            }
        }


    }
}