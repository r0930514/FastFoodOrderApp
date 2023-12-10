package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.LoginScreen
import com.r0930514.fastfoodorderapp.screens.ShoppingCart
import com.r0930514.fastfoodorderapp.screens.TestScreen
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.MainScaffold

@Composable
fun MainNav(){
    val navController:NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "BottomNav"){
        composable("BottomNav"){
            MainScaffold(navController)
        }
        composable("ShoppingCart"){
            ShoppingCart(navController)
        }
        composable("Test"){
            TestScreen(navController)
        }
        composable("Login"){
            LoginScreen(navController)
        }
    }
}