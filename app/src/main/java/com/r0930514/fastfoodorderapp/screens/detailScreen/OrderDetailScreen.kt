package com.r0930514.fastfoodorderapp.screens.detailScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.detailScreen.components.DetailBottomSheet
import com.r0930514.fastfoodorderapp.screens.detailScreen.components.DetailCard
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor
import com.r0930514.fastfoodorderapp.util.convertDate
import com.r0930514.fastfoodorderapp.viewModels.OrdersViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailScreen(
    navHostController: NavHostController,
    ordersViewModel: OrdersViewModel = viewModel(factory = OrdersViewModel.Factory)
){
    val ordersList by ordersViewModel.orderList.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    var clickItemID by rememberSaveable { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "交易明細") },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            Log.e("OrderDetailScreen", ordersList.toString())
                            //navHostController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "關閉", )
                    }
                }
            )
        }
    ){
        if (showBottomSheet){
            DetailBottomSheet(
                orderData = ordersList[clickItemID],
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            )
        }
        Column (modifier = Modifier.padding(it)){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(ordersList.size){i ->
                        DetailCard(
                            title = convertDate(ordersList[i].orderDate)!! + " " +ordersList[i].orderType,
                            description = "${ordersList[i].orderDetail.size}項商品",
                            price = ordersList[i].orderDetail.sumOf { item-> item.total.substring(1).toDouble().toInt() }.toString(),
                            onClick = {
                                clickItemID = i
                                showBottomSheet = true
                            }
                        )
                    }
                }
            )
        }
    }
}
