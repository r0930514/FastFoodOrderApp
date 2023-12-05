package com.r0930514.fastfoodorderapp.pages.main.appBars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.r0930514.fastfoodorderapp.navigation.BottomNavBarItem

@Composable
fun CNavBar(selectItem: Int, onSelectedItem: (Int) -> Unit) {
    val items = listOf(BottomNavBarItem.Home, BottomNavBarItem.Order, BottomNavBarItem.Member)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectItem == index,
                onClick = { onSelectedItem(index) }
            )
        }

    }
}


