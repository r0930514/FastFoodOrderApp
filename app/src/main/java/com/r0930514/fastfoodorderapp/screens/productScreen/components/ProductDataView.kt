package com.r0930514.fastfoodorderapp.screens.productScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.r0930514.fastfoodorderapp.model.Product
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle

@Composable
fun ProductDataView(
    productData: List<Product>,
    productSelectedSpecID: Int,
    onProductSpecIDSelectChange: (Int) -> Unit = {}
) {
    if (productData.isNotEmpty()){
        Column(
            Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = productData[0].productName,
                    fontSize = 30.sp
                )
                Text(text = "$${if (productData.isNotEmpty()) productData[0].productPrice.substring(1).toDouble().toInt() else 0}", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = productData[0].productIllustrate,
                fontSize = 16.sp,
                lineHeight = 28.sp
            )
            LazyColumn(
                Modifier.padding(vertical = 16.dp)
            ){
                if (productData.isNotEmpty()){
                    items(productData[0].productSpecification.size) { i ->
                        RadioBtnGroup(
                            text = productData[0].productSpecification[i].specificationName,
                            selected = productSelectedSpecID == productData[0].productSpecification[i].specificationID.toInt(),
                            onClick = {
                                onProductSpecIDSelectChange(productData[0].productSpecification[i].specificationID.toInt())
                            }
                        )
                    }
                }
            }
        }

    }else{
        LoadingCircle()
    }
}