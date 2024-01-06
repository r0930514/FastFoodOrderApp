package com.r0930514.fastfoodorderapp.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PaymentCompletedScreen(navHostController: NavHostController = rememberNavController()) {
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
    ) {
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
                            supportText = "約 10 分鐘",
                        )
                        Divider()
                        PaymentPageList(
                            paymentPageListItem = PaymentPageListItem.OrderType,
                            supportText = "外帶",
                        )
                        Divider()
                        PaymentPageList(
                            paymentPageListItem = PaymentPageListItem.OrderDetail,
                            supportText = "共 1 項",
                            onClick = {
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
        title = "等候時間",
        icon = R.drawable.time,
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

