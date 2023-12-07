package com.r0930514.fastfoodorderapp.pages.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.pages.main.appBars.OrderAppBar
import com.r0930514.fastfoodorderapp.pages.main.orderTabs.OrderCards


@Composable
fun OrderPage(navController: NavHostController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val items = listOf("漢堡", "麵食", "小吃", "飲料")

    Column {
        OrderAppBar()
        TabRow(
            selectedTabIndex = selectedTabIndex) {
            items.forEachIndexed { index, item ->
                Tab(
                    selected = (index == selectedTabIndex),
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(text = item)
                    }
                )
            }
        }
        when(selectedTabIndex) {
            0 -> OrderCards()
            1 -> OrderCards()
            2 -> OrderCards()
        }

    }
}