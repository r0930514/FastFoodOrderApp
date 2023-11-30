package com.r0930514.fastfoodorderapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

//抽象類別 類似enum
sealed class CNavBarItem(val route:String, val icon:ImageVector, val label:String){
    object Home:CNavBarItem("Home", Icons.Filled.Home, "首頁")
    object Order:CNavBarItem("Order", Icons.Filled.PlayArrow, "訂餐")
    object Member:CNavBarItem("Member", Icons.Filled.Person, "會員")
}

@Composable
fun CNavBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(CNavBarItem.Home, CNavBarItem.Order, CNavBarItem.Member)
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }

    }
}

@Preview
@Composable
fun CNavbarPreview(){
    CNavBar()
}