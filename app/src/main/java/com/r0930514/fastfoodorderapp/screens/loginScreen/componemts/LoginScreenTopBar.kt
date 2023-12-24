package com.r0930514.fastfoodorderapp.screens.loginScreen.componemts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LoginScreenTopBar(
    navHostController: NavHostController,
    iconColor: IconButtonColors,
    title: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = title,
        colors = TopDefaultAppBarColor(),
        actions = {
            IconButton(onClick = {
                navHostController.popBackStack()
            }, colors = iconColor) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "關閉")
            }
        }
    )
}