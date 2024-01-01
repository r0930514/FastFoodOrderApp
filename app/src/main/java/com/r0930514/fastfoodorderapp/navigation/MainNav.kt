package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.CartCompletedScreen
import com.r0930514.fastfoodorderapp.screens.PaymentCompletedScreen
import com.r0930514.fastfoodorderapp.screens.PaymentScreen
import com.r0930514.fastfoodorderapp.screens.TestScreen
import com.r0930514.fastfoodorderapp.screens.detailScreen.OrderDetailScreen
import com.r0930514.fastfoodorderapp.screens.loginScreen.LoginScreen
import com.r0930514.fastfoodorderapp.screens.mainScreen.MainScaffold
import com.r0930514.fastfoodorderapp.screens.productScreen.ProductAddScreen
import com.r0930514.fastfoodorderapp.screens.productScreen.ProductEditScreen
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
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(300)
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
            PaymentCompletedScreen(navController)
        }
        composable("OrderDetail"){
            OrderDetailScreen(navController)
        }
        composable("ProductEdit/{OrderDetailID}"){
            it.arguments?.getString("OrderDetailID")
                ?.let { it1 -> ProductEditScreen(navController, it1) }
        }
        composable("ProductAdd/{ProductID}"){
            it.arguments?.getString("ProductID")
                ?.let { it1 -> ProductAddScreen(navController, it1) }
        }
        //選擇用餐方式
        composable("OrderType"){
            CartCompletedScreen(navController)
        }
        //前往付款
        composable("Payment/{TableID}"){
            it.arguments?.getString("TableID")
                ?.let { tableID -> PaymentScreen(navController, tableID) }
        }
        //付款完成
        composable("PaymentCompleted"){
            PaymentCompletedScreen(navController)
        }
    }
}