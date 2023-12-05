package com.r0930514.fastfoodorderapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.navigation.BottomNav


@Composable
fun CScaffold(navController: NavHostController) {
    val bottomNavHostController = rememberNavController()
    Scaffold(
        topBar = { CAppBar() },
        bottomBar = { CNavBar(bottomNavHostController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNav(navHostController = bottomNavHostController)
        }
    }
}