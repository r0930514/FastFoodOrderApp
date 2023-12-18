package com.r0930514.fastfoodorderapp.screens.productConfigScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.components.CustomAsyncImage
import com.r0930514.fastfoodorderapp.screens.productConfigScreen.components.ProductConfigAppBar

@Composable
@Preview(showBackground = true)
fun ProductConfigScreen(
    navHostController: NavHostController = rememberNavController(),
    productID: String = "0"
){
    Scaffold (
        topBar = {
            CustomAsyncImage(
                url = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
            )
            ProductConfigAppBar(navHostController)
        },
        bottomBar = {
            BottomAppBar {
                Text(text = "FF")
            }
        }
    ){
        Column (
            modifier = Modifier.padding(it)
        ){
            Column (
                Modifier.padding(8.dp)
            ){
                Text(text = productID)
            }
        }
    }
}

