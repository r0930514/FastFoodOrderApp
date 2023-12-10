package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.HomePageCard
@Composable
fun HomePage(navController: NavHostController) {
    Column {
        CAppBar()
        LazyColumn() {
            items(5) {
                HomePageCard(
                    title = "首頁資訊$it",
                    description = "這是資訊$it",
                )
            }
        }
    }
}

