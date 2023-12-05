package com.r0930514.fastfoodorderapp.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.r0930514.fastfoodorderapp.navigation.BottomNavBarItem

@Composable
fun CNavBar(navHostController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(BottomNavBarItem.Home, BottomNavBarItem.Order, BottomNavBarItem.Member)
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute?.route == item.route,
                onClick = {
                    selectedItem = index
                    navHostController.navigate(item.route){
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            inclusive = false
                            saveState = false
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                },
            )
        }

    }
}


