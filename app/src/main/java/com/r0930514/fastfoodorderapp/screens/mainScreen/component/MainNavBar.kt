package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.r0930514.fastfoodorderapp.screens.mainScreen.items.MainNavBarItem

@Composable
fun CNavBar(selectItem: Int, onSelectedItem: (Int) -> Unit) {
    val items = listOf(MainNavBarItem.Home, MainNavBarItem.Order, MainNavBarItem.Member)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selectItem == index,
                { onSelectedItem(index) },
                {
                    Icon(imageVector = ImageVector.Companion.vectorResource(item.icon), contentDescription = item.label)
                },
                label = { Text(item.label) },
                alwaysShowLabel = false
            )
        }

    }
}


