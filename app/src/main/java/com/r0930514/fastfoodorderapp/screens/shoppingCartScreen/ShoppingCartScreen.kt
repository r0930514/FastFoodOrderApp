package com.r0930514.fastfoodorderapp.screens.shoppingCartScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
    val totalPrice by viewModel.totalPrice.collectAsState()
    Scaffold (
        topBar = { CartAppBar(
            navHostController = navHostController,
            onClick = {
                viewModel.clearCart()
                Toast.makeText(navHostController.context, "已清空購物車", Toast.LENGTH_SHORT).show()
            }
        ) },
        bottomBar = { CartBottomBar( totalPrice ){
            navHostController.navigate("OrderType")
        } }
    ){
        Column (modifier = Modifier.padding(it)){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                items(cartList.size){i ->
                    val item = cartList[i]
                    CartCard(
                        title = item.productName,
                        description = item.specificationName + "*" + item.productCount,
                        price = item.productPrice*item.productCount,
                        onClick = {
                            navHostController.navigate("ProductEdit/${item.id}")
                        },
                        productID = item.productID,
                    )
                }
                if (cartList.isEmpty()) {
                    item {
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
                        ){
                            Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
                            Text(text = "購物車是空的")
                        }
                    }
                } }
            )
        }
    }
}