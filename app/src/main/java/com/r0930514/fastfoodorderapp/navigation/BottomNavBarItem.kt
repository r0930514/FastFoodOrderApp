package com.r0930514.fastfoodorderapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

//抽象類別 類似enum
sealed class BottomNavBarItem(val route:String, val icon: ImageVector, val label:String){
    object Home: BottomNavBarItem("Home", Icons.Filled.Home, "首頁")
    object Order: BottomNavBarItem("Order", Icons.Filled.PlayArrow, "訂餐")
    object Member: BottomNavBarItem("Member", Icons.Filled.Person, "會員")
}