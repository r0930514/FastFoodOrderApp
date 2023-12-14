package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.network.JsonplaceholderViewModel
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.HomePageCard
@Composable
fun HomePage(
    navController: NavHostController,
    viewModel: JsonplaceholderViewModel = viewModel()
) {
    val myData by viewModel.myDataList.collectAsState()
    Column {
        CAppBar()
        LazyColumn {
            items(myData.size) {
                HomePageCard(
                    title = myData[it].title,
                    description = it.toString(),
                    imageURL = "https://api.r0930514.work/debug/static/image/food/${it*2}.jpg"
                )
            }
        }


    }
}

