package com.r0930514.fastfoodorderapp.screens.shoppingCartScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.CartAppBar
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.CartBottomBar
import com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components.CartCard
import com.r0930514.fastfoodorderapp.viewModels.CartViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart(
    navHostController: NavHostController,
    viewModel: CartViewModel = viewModel(factory = CartViewModel.Factory)
) {
    val cartList by viewModel.cartList.collectAsState()
    Scaffold (
        topBar = { CartAppBar(navHostController) },
        bottomBar = { CartBottomBar() }
    ){ it ->
        Column (modifier = Modifier.padding(it)){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                items(cartList.size){i ->
                    CartCard(
                        title = cartList[i].name,
                        description = "大 / 不要酸黃瓜",
                        price = cartList[i].price,
                        onClick = {
                            navHostController.navigate("ProductEdit/${cartList[i].id}")
                        }
                    )
                }

            })
        }
    }
}