package com.r0930514.fastfoodorderapp.screens.shoppingCartScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.CartCard
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.ShoppingCartAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart(navHostController: NavHostController){
    Scaffold (
        topBar = {
            ShoppingCartAppBar(navHostController)
        }
    ){
        Column (modifier = Modifier.padding(it)){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                items(25){
                    CartCard(
                        title = "第${it}個大漢堡",
                        description = "大 / 不要酸黃瓜",
                        price = it*50
                    )
                }
            })
        }
    }
}