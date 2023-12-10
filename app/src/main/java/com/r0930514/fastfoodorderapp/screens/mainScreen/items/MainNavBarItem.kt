package com.r0930514.fastfoodorderapp.screens.mainScreen.items

import com.r0930514.fastfoodorderapp.R


//抽象類別 類似enum
sealed class MainNavBarItem(val route:String, val icon: Int, val label:String){
    object Home: MainNavBarItem("Home", R.drawable.home, "首頁")
    object Order: MainNavBarItem("Order", R.drawable.fastfood, "訂餐")
    object Member: MainNavBarItem("Member", R.drawable.person, "會員")


}