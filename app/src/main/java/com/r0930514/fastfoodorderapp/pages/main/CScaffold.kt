package com.r0930514.fastfoodorderapp.pages.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.pages.main.appBars.CNavBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CScaffold(navController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    Scaffold(
        //topBar = { CAppBar() },
        bottomBar = { CNavBar(selectedItem) {selectedItem = it} }
    ) {
        Box(modifier = Modifier.padding(it.calculateStartPadding(LayoutDirection.Ltr))) {
            when (selectedItem) {
                0 -> HomePage(navController)
                1 -> OrderPage(navController)
                2 -> MemberPage(navController)
            }
        }
    }
}