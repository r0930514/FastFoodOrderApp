package com.r0930514.fastfoodorderapp.screens.shoppingCartScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.CartCard
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart(navHostController: NavHostController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "購物車") },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "關閉", )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = ImageVector.Companion.vectorResource(id = R.drawable.remove_shopping_cart),
                            contentDescription = "清空購物車"
                        )
                    }
                }
            )
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