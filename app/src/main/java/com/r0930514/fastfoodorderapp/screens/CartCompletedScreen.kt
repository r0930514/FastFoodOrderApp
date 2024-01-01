package com.r0930514.fastfoodorderapp.screens

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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
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
    val orderTypes = listOf("外帶", "內用")
    val orderTypeIcons = listOf(
        ImageVector.Companion.vectorResource(R.drawable.local_dining),
        ImageVector.Companion.vectorResource(R.drawable.takeout_dining)
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { orderTypes.size }
    )
    val iconColor : IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
    val scope = rememberCoroutineScope()
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
            ExtendedFloatingActionButton(
                onClick = {
                    if (pagerState.currentPage == 0){
                        tableID = ""
                        navHostController.navigate(
                            "Payment/{$tableID}"
                        )

                    }else {
                        if (tableID.isNotEmpty()) {
                            navHostController.navigate(
                                "Payment/{$tableID}"
                            )
                        }else{
                            isTableIDError = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null
                    )
                },
                text = { Text(text = "結帳") }
            )
        }
    ){
        Column (Modifier.padding(it)){
            TabRow(selectedTabIndex = pagerState.currentPage) {
                orderTypes.forEachIndexed { index, item ->
                    Tab(
                        selected = (index == pagerState.currentPage),
                        onClick = {
                            scope.launch{ pagerState.scrollToPage(index) }
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
