package com.r0930514.fastfoodorderapp.screens.productScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun ProductEditScreen(
    navHostController: NavHostController = rememberNavController(),
    orderDetailID: String = "0",
    cartViewModel: CartViewModel = viewModel(factory = CartViewModel.Factory),
){
    val cartItem by cartViewModel.getItem(orderDetailID).collectAsState(null)
    val productID: String? = cartItem?.productID
    val productViewModel = productID?.let { ProductViewModel(it) }
    val productList = productID?.let { productViewModel?.productList?.collectAsState() }

    var productCount: Int? by remember { mutableStateOf(null) }
    var productSelectedSpecID: String? by remember { mutableStateOf(null) }

    Scaffold (
        topBar = {
            CustomAsyncImage(
                url = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
            )
            ProductEditAppBar(navHostController, true){
                cartItem?.let { cartViewModel.delete(it) }
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            productList?.let{
                ProductBottomBar(
                    productCount = productCount?:cartItem!!.productCount,
                    productData = productList.value,
                    productSelectedSpecID = productSelectedSpecID?.toInt()
                        ?:cartItem!!.specificationID.toInt(),
                    navHostController = navHostController,
                    productCountChange = { i -> productCount = i },
                    checkBtnOnClick = { cartEntity ->
                        cartViewModel.update(cartEntity)
                    },
                    cartItemID = cartItem!!.id
                )
            }
        }
    ){

        Column (
            modifier = Modifier.padding(it)
        ){
            productList?.let {item ->
                ProductDataView(
                    productData = item.value,
                    productSelectedSpecID = productSelectedSpecID?.toInt()
                        ?:cartItem!!.specificationID.toInt(),
                    onProductSpecIDSelectChange =
                    { i ->
                        productSelectedSpecID = i.toString()
                    }
                )
            }
        }
    }
}


