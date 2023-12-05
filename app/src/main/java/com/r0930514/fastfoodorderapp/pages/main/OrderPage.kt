package com.r0930514.fastfoodorderapp.pages.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.pages.main.appBars.OrderAppBar

@Composable
fun OrderPage(navController: NavHostController) {
    Column {
        OrderAppBar()
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "Hello Order")
        }
    }
}