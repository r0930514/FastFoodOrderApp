package com.r0930514.fastfoodorderapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CartCompleted(navHostController: NavHostController = rememberNavController()) {
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
        }
    }
}