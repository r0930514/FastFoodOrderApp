package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.HomePage
import com.r0930514.fastfoodorderapp.screens.mainScreen.MemberPage
import com.r0930514.fastfoodorderapp.screens.mainScreen.OrderPage


@Composable
fun MainScaffold(navController: NavHostController) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = { CNavBar(selectedItem) {selectedItem = it} }
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            when (selectedItem) {
                0 -> HomePage(navController)
                1 -> OrderPage(navController)
                2 -> MemberPage(navController)
            }
        }
    }
}

