package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.OrderAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.OrderCard
import com.r0930514.fastfoodorderapp.viewModels.ProductListViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderPage(
    navController: NavHostController,
) {
    //
    val productListViewModel: ProductListViewModel = viewModel(LocalViewModelStoreOwner.current!!)
    val productList = productListViewModel.productList.collectAsState()
    val items = listOf("主打套餐", "漢堡", "炸雞", "捲餅", "沙拉", "小吃", "飲料")
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )

    Column {
        OrderAppBar()
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage) {
            items.forEachIndexed { index, item ->
                Tab(
                    selected = (index == pagerState.currentPage),
                    onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index, 0f)
                        }
                    },
                    text = {
                        Text(text = item)
                    }
                )
            }
        }
        if (productList.value.isEmpty()) {
            LoadingCircle()
        } else {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Top,
            ) {page ->
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(productList.value[page].size) {gridIndex ->
                            OrderCard(
                                id = productList.value[page][gridIndex].productID,
                                title = productList.value[page][gridIndex].productName,
                                price = productList.value[page][gridIndex].productPrice,
                                navHostController = navController
                            )
                        }

                    }
            }
        }

    }
}