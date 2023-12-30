package com.r0930514.fastfoodorderapp.screens.productScreen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProductEditAppBar(
    navHostController: NavHostController,
    isEdit: Boolean = false,
    deleteBtnOnClick: () -> Unit = {},
    ) {
    CenterAlignedTopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    navHostController.popBackStack()
                }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "關閉")
            }
        },
        actions = {
            if (isEdit){
                IconButton(onClick = deleteBtnOnClick) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "刪除"
                    )
                }
            }
        }
    )
}