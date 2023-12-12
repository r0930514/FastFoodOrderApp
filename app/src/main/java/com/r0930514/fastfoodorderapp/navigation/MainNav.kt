package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.LoginScreen
import com.r0930514.fastfoodorderapp.screens.PaymentCompleted
import com.r0930514.fastfoodorderapp.screens.TestScreen
import com.r0930514.fastfoodorderapp.screens.detailScreen.DetailScreen
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.MainScaffold
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.ShoppingCart

@Composable
fun MainNav(){
    val navController:NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "BottomNav",

        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(700)
            )
        }

    ){
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
        composable("PaymentCompleted"){
            PaymentCompleted(navController)
        }
        composable("Detail"){
            DetailScreen(navController)
        }


    }
}