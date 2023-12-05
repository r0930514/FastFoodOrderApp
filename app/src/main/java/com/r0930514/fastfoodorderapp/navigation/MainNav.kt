package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.pages.TestPage
import com.r0930514.fastfoodorderapp.pages.main.CScaffold

@Composable
fun MainNav(){
    val navController:NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "BottomNav"){
        composable(route = "BottomNav"){
            CScaffold(navController)
        }
        composable("Test"){
            TestPage(navHostController = navController)
        }
    }
}