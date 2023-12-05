package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.r0930514.fastfoodorderapp.pages.HomePage
import com.r0930514.fastfoodorderapp.pages.MemberPage
import com.r0930514.fastfoodorderapp.pages.OrderPage

@Composable
fun BottomNav(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = BottomNavBarItem.Home.route){
        composable(BottomNavBarItem.Home.route){
            HomePage()

        }
        composable(BottomNavBarItem.Order.route){
            OrderPage()

        }
        composable(BottomNavBarItem.Member.route){
            MemberPage()

        }
    }
}