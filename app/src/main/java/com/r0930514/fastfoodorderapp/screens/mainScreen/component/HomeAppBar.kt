package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CAppBar() {
        CenterAlignedTopAppBar(
            title = { Text(text = "速食店訂餐App") },
            colors = TopDefaultAppBarColor()
        )
}

@Preview
@Composable
fun CAppBarPreview(){
    CAppBar()
}