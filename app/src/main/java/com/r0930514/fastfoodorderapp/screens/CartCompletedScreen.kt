package com.r0930514.fastfoodorderapp.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.components.EditText
import com.r0930514.fastfoodorderapp.screens.components.LoadingExtendFloatBtn
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor
import com.r0930514.fastfoodorderapp.viewModels.CartCompletedViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CartCompletedScreen(
    navHostController: NavHostController = rememberNavController(),
    cartCompletedViewModel: CartCompletedViewModel = viewModel(factory = CartCompletedViewModel.Factory)
) {
    val orderList by cartCompletedViewModel.orderList.collectAsState()
    var tableID by rememberSaveable { mutableStateOf("") }
    var isTableIDError by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    val orderTypes = listOf("外帶", "內用")
    val orderApiTypes = listOf("Takeout", "Dine_In")
    val orderTypeIcons = listOf(
        ImageVector.Companion.vectorResource(R.drawable.local_dining),
        ImageVector.Companion.vectorResource(R.drawable.takeout_dining)
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { orderTypes.size }
    )
    var isLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "完成購物", modifier = Modifier.padding(12.dp)) },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack()}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            LoadingExtendFloatBtn(
                isLoading = isLoading,
                title = "結帳"
            ){
                //在外帶頁面
                if (pagerState.currentPage == 0){
                    tableID = ""
                }
                //在內用頁面 且 桌號為空
                if (pagerState.currentPage == 1 && tableID.isEmpty()) {
                    //報錯
                    isTableIDError = true
                    return@LoadingExtendFloatBtn
                }
                coroutineScope.launch {
                    isLoading = true
                    try{
                        cartCompletedViewModel.sendOrder(
                            orderList = orderList,
                            orderType = orderApiTypes[pagerState.currentPage],
                            tableID = tableID
                        )
                    }catch (e: Exception){
                        Toast.makeText(
                            navHostController.context,
                            "發生錯誤，請稍候再試",
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoading = false
                        return@launch
                    }
                    isLoading = false
                    //跳轉到模擬付款完成頁面
                    navHostController.navigate(
                        "Payment/{$tableID}"
                    ){
                        popUpTo("BottomNav"){
                            inclusive = false
                        }
                    }
                }

            }
        }
    ){
        Column (Modifier.padding(it)){
            TabRow(selectedTabIndex = pagerState.currentPage) {
                orderTypes.forEachIndexed { index, item ->
                    Tab(
                        selected = (index == pagerState.currentPage),
                        onClick = {
                            coroutineScope.launch{ pagerState.scrollToPage(index) }
                        },
                        text = {
                            Text(text = item)
                        },
                        icon = {
                            Icon(
                                imageVector = orderTypeIcons[index],
                                contentDescription = null
                            )
                        }
                    )
                }
            }
            HorizontalPager(state = pagerState) { page ->
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    when(page){
                        1 -> {
                            Column (
                                Modifier.fillMaxSize()
                            ){

                                EditText(
                                    value = tableID,
                                    onValueChange = { i -> tableID = i },
                                    label = "桌號",
                                    supportingText = "請輸入桌號，稍候將會有服務人員為您送餐",
                                    leadingIcon = Icons.Filled.LocationOn,
                                    isError = isTableIDError,
                                )
                            }

                        }
                        0 -> {
                            Icon(
                                imageVector = ImageVector.Companion.vectorResource(R.drawable.fastfood),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Text(text = "請點擊結帳按鈕，選擇付款方式")
                        }
                    }
                }

            }
        }
    }
}

