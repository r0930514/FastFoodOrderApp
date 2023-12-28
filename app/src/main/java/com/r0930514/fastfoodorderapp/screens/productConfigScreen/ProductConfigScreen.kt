package com.r0930514.fastfoodorderapp.screens.productConfigScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.components.CustomAsyncImage
import com.r0930514.fastfoodorderapp.screens.productConfigScreen.components.ProductConfigAppBar

@Composable
fun ProductConfigScreen(
    navHostController: NavHostController = rememberNavController(),
    productID: String = "0",
    productImage: String = "",
    productName: String = "",
    productPrice: String = "",
    productDescription: String = "",
    productCount: Int = 0,
    isEdit: Boolean = false,
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
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ){
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Black)){
                            Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = null)
                        }
                        Text(
                            text = "$productCount",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Black)) {
                            Icon(imageVector = Icons.Filled.ArrowForward , contentDescription = null)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "$productPrice",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Medium,
                        )
                        FloatingActionButton(
                            onClick = { navHostController.popBackStack() },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.ArrowForward, null)
                        }
                    }
                }
            }
        }
    ){
        Column (
            modifier = Modifier.padding(it)
        ){
            Column (
                Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = productName,
                        fontSize = 30.sp,
                    )
                    Text(text = productPrice, fontSize = 30.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = productDescription, fontSize = 16.sp, lineHeight = 28.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProductConfigScreenPreview(){
    ProductConfigScreen(
        productID = "0",
        productImage = "",
        productName = "Product Name",
        productPrice = "$30",
        productDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ac augue mauris. Aenean pulvinar id velit a congue. In ullamcorper mollis metus sed scelerisque. Curabitur nulla felis, malesuada non ",
        isEdit = false,
    )
}

