package com.r0930514.fastfoodorderapp.screens.productScreen.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.database.CartEntity
import com.r0930514.fastfoodorderapp.model.Product

@Composable
fun ProductBottomBar(
    productCount: Int,
    productData: List<Product>,
    productSelectedSpecID: Int,
    navHostController: NavHostController,
    productCountChange: (Int) -> Unit = {},
    checkBtnOnClick: (CartEntity) -> Unit = {},
    cartItemID: Int? = null,
){
    var productCountValue by rememberSaveable{ mutableIntStateOf(productCount) }
    BottomAppBar {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ){
                TextButton(
                    onClick = {
                        productCountValue--
                        productCountChange(productCountValue)
                    },
                    enabled = productCount != 0
                )
                {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.horizontal_rule), contentDescription = null)
                }
                Text(
                    text = "$productCount",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        productCountValue = 1
                        productCountChange(productCountValue)
                    }
                )
                TextButton(onClick = {
                    productCountValue++
                    productCountChange(productCountValue)
                })
                {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.add), contentDescription = null)
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "$${(if (productData.isNotEmpty()) productData[0].productPrice.substring(1).toDouble().toInt() else 0) *productCount}",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                )
                FloatingActionButton(
                    onClick = {
                        if (productData.isEmpty()) return@FloatingActionButton
                        if (productSelectedSpecID != 0 && productCount != 0){
                            checkBtnOnClick(
                                CartEntity(
                                    id = cartItemID,
                                    productName = productData[0].productName,
                                    productPrice = productData[0].productPrice.substring(1)
                                        .toDouble().toInt(),
                                    specificationID = productSelectedSpecID.toString(),
                                    productCount = productCount,
                                    specificationName = productData[0].productSpecification.find { it.specificationID.toInt() == productSelectedSpecID }?.specificationName!!,
                                    productID = productData[0].productID.toString(),
                                    image = productData[0].imageURL,
                                )
                            )
                            navHostController.popBackStack()
                        }else{
                            Toast.makeText(navHostController.context, "請選擇規格與數量!!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    cartItemID?.let {
                        Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                    } ?: Icon(Icons.Filled.Add, null)
                }
            }
        }
    }
}