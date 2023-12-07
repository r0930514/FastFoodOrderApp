package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.OrderAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.OrderCard
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderPage(navController: NavHostController) {
    val items = listOf("漢堡", "麵食", "小吃", "飲料")
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )

    Column {
        OrderAppBar()
        TabRow(
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
        HorizontalPager(state = pagerState) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(2*(it+1)) {
                        OrderCard()
                    }
                }
            )
        }
    }
}