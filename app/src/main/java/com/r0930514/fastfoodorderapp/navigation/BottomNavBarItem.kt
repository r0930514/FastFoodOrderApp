package com.r0930514.fastfoodorderapp.navigation

import com.r0930514.fastfoodorderapp.R


//抽象類別 類似enum
sealed class BottomNavBarItem(val route:String, val icon: Int, val label:String){
    object Home: BottomNavBarItem("Home", R.drawable.home, "首頁")
    object Order: BottomNavBarItem("Order", R.drawable.fastfood, "訂餐")
    object Member: BottomNavBarItem("Member", R.drawable.person, "會員")
}