package com.r0930514.fastfoodorderapp.screens.productEditScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.components.CustomAsyncImage
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle
import com.r0930514.fastfoodorderapp.screens.productEditScreen.components.ProductEditAppBar
import com.r0930514.fastfoodorderapp.viewModels.ProductViewModel

@Composable
fun ProductAddScreen(
    navHostController: NavHostController = rememberNavController(),
    productID: String = "0",
){
    val productViewModel = ProductViewModel(productID)
    val productData = productViewModel.productList.collectAsState()
    var productCount by rememberSaveable { mutableIntStateOf(1) }
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
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ){
                        TextButton(
                            onClick = { productCount-- },
                            enabled = productCount != 0
                        )
                        {
                            Icon(imageVector = ImageVector.Companion.vectorResource(R.drawable.horizontal_rule), contentDescription = null)
                        }
                        Text(
                            text = "$productCount",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable { productCount=1 }
                        )
                        TextButton(onClick = { productCount++ } ) {
                            Icon(imageVector = ImageVector.Companion.vectorResource(R.drawable.add) , contentDescription = null)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "$${(if (productData.value.isNotEmpty()) productData.value[0].productPrice.substring(1).toDouble().toInt() else 0) *productCount}",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        FloatingActionButton(
                            onClick = { navHostController.popBackStack() },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.Add, null)
                        }
                    }
                }
            }
        }
    ){
        if (productData.value.isNotEmpty()){
            Column(
                modifier = Modifier.padding(it)
            ) {
                Column(
                    Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = productData.value[0].productName,
                            fontSize = 30.sp
                        )
                        Text(text = "$${if (productData.value.isNotEmpty()) productData.value[0].productPrice.substring(1).toDouble().toInt() else 0}", fontSize = 30.sp)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = productData.value[0].productIllustrate,
                        fontSize = 16.sp,
                        lineHeight = 28.sp
                    )
                }
            }
        }else{
            LoadingCircle()
        }
    }
}


