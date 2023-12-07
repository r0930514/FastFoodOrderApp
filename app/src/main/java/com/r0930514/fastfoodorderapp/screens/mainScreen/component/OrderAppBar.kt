package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderAppBar(){
    val iconColor :IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
    CenterAlignedTopAppBar(
        title = { Text(text = "選擇餐點", modifier = Modifier.padding(12.dp)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        actions = {
            IconButton(onClick = { }, colors = iconColor) {
                Icon(imageVector = Icons.Rounded.Favorite, contentDescription = "Search")
            }
            IconButton(onClick = { }, colors = iconColor) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
        }
    )
}