package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.network.DriverViewModel
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.HomePageCard
@Composable
fun HomePage(
    navController: NavHostController,
    viewModel: DriverViewModel = viewModel()
) {
    val data by viewModel.drivers.collectAsState(initial = emptyList())
    Column {
        CAppBar()
        LazyColumn {
            items(5) {
                HomePageCard(
                    title = "首頁資訊$it",
                    description = "這是資訊$it",
                )
            }
        }
    }
}

