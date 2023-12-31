package com.r0930514.fastfoodorderapp.screens.productScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.components.CustomAsyncImage
import com.r0930514.fastfoodorderapp.screens.productScreen.components.ProductBottomBar
import com.r0930514.fastfoodorderapp.screens.productScreen.components.ProductDataView
import com.r0930514.fastfoodorderapp.screens.productScreen.components.ProductEditAppBar
import com.r0930514.fastfoodorderapp.viewModels.CartViewModel
import com.r0930514.fastfoodorderapp.viewModels.ProductViewModel

@Composable
fun ProductAddScreen(
    navHostController: NavHostController = rememberNavController(),
    productID: String = "0",
    cartViewModel: CartViewModel = viewModel(factory = CartViewModel.Factory)
){
    val productViewModel = ProductViewModel(productID)
    val productData by productViewModel.productList.collectAsState()
    var productCount by rememberSaveable { mutableIntStateOf(1) }
    var productSelectedSpecID by rememberSaveable { mutableIntStateOf(0) }
    Scaffold (
        topBar = {
            CustomAsyncImage(
                url = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
            )
            ProductEditAppBar(navHostController)
        },
        bottomBar = {
            ProductBottomBar(
                productCount = productCount,
                productData = productData,
                productSelectedSpecID = productSelectedSpecID,
                navHostController = navHostController,
                productCountChange = { i -> productCount = i },
                checkBtnOnClick = { cartEntity ->
                    cartViewModel.insert(cartEntity)
                }
            )
        }
    ){
        Column (Modifier.padding(it)){
            ProductDataView(
                productData = productData,
                productSelectedSpecID = productSelectedSpecID,
                onProductSpecIDSelectChange = { i -> productSelectedSpecID = i }
            )
        }
    }
}


