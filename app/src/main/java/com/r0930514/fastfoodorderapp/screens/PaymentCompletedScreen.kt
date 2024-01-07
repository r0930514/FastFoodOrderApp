package com.r0930514.fastfoodorderapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor
import com.r0930514.fastfoodorderapp.viewModels.OrdersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PaymentCompletedScreen(
    navHostController: NavHostController = rememberNavController(),
    orderID: String = "0",
    ordersViewModel: OrdersViewModel = viewModel(factory = OrdersViewModel.Factory)
) {
    val orderList = ordersViewModel.orderList.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "") },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check")
                },
                text = {
                    Text(text = "結束")
                },
                onClick = {
                    navHostController.popBackStack()
                }
            )
        }
    ) { it ->
        Column (
            modifier = Modifier.padding(it)
        ){
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                Image(
                    imageVector = ImageVector.Companion.vectorResource(R.drawable.fastfood),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(96.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(24.dp)
                ){
                    Text(
                        text = "付款完成",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "製餐中請稍候",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.size(60.dp))
                LazyColumn(modifier = Modifier.padding(16.dp), content = {
                    item {
                        PaymentPageList(
                            paymentPageListItem = PaymentPageListItem.WaitingTime,
                            supportText = if( orderList.value.isNotEmpty() ) orderList.value.first().orderID.toString() else "",
                        )
                        Divider()
                        PaymentPageList(
                            paymentPageListItem = PaymentPageListItem.OrderType,
                            supportText = if( orderList.value.isNotEmpty() ) orderList.value.first().orderType else "",
                        )
                        Divider()
                        PaymentPageList(
                            paymentPageListItem = PaymentPageListItem.OrderDetail,
                            supportText = "查看詳細資訊",
                            onClick = {
                                Log.e("OrderDetail", orderList.toString())
                                Log.e("OrderDetail", orderList.value.first().toString())
                                navHostController.navigate("OrderDetail"){
                                    popUpTo("BottomNav"){
                                        inclusive = false
                                    }
                                }
                            },
                            isTrail = true
                        )
                    }
                })
            }
        }
    }
}

@Composable
private fun PaymentPageList(
    paymentPageListItem: PaymentPageListItem,
    supportText: String,
    onClick: () -> Unit = {},
    isTrail: Boolean = false
) {
    ListItem(
        headlineContent = { Text(paymentPageListItem.title) },
        leadingContent = {
            Icon(
                imageVector = ImageVector.vectorResource(paymentPageListItem.icon),
                contentDescription = "null",
            )
        },
        supportingContent = { Text(text = supportText) },
        modifier = Modifier.clickable(onClick = onClick),
        trailingContent = {
            if (isTrail) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "null",
                )
            }
        }
    )
}

sealed class PaymentPageListItem(
    val title: String,
    val icon: Int,
    val onClick: () -> Unit = {}
) {
    object WaitingTime : PaymentPageListItem(
        title = "取餐/訂餐編號",
        icon = R.drawable.key,
    )
    object OrderType : PaymentPageListItem(
        title = "取餐方式",
        icon =  R.drawable.local_dining
    )
    object OrderDetail : PaymentPageListItem(
        title = "交易明細",
        icon = R.drawable.list
    )
}

