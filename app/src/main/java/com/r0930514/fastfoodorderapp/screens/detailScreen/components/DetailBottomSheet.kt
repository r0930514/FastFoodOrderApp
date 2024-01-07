package com.r0930514.fastfoodorderapp.screens.detailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.model.OrdersModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailBottomSheet(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    orderData: OrdersModel? = null,
    adminDoneOrder: Boolean = false,
    doneOrder: (String) -> Unit = {}
) {
    ModalBottomSheet(onDismissRequest = onDismissRequest) {
        Column (
            Modifier.padding(16.dp)
        ){
            orderData?.let {
                LazyColumn(content = {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "訂單編號", style = MaterialTheme.typography.headlineMedium)
                            Text(
                                text =  orderData.orderType +" "+ orderData.orderID.toString(),
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }
                        Divider(Modifier.padding(vertical = 8.dp))
                    }
                    items(orderData.orderDetail.size) { index ->
                        Row (
                            //左右排列 modifier
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column {
                                Text(
                                    text =
                                        orderData.orderDetail[index].productName +
                                        " $" + orderData.orderDetail[index].productPrice +
                                        " *" + orderData.orderDetail[index].productCount.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(text = orderData.orderDetail[index].specificationName, style = MaterialTheme.typography.bodyMedium)
                            }
                            Text(text = "$" + orderData.orderDetail[index].total.toString())

                        }

                    }
                })
                Divider(Modifier.padding(vertical = 8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text = "總計")
                    Text(text = "$" + orderData.orderDetail.sumOf { item-> item.total }.toString())
                }
                if (adminDoneOrder){
                    Button(
                        onClick = {
                            doneOrder(orderData.orderID.toString())
                            onDismissRequest()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ){
                        Text(text = "完成訂單")
                    }
                }
            }
        }
    }
}