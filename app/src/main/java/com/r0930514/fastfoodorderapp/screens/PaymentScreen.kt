package com.r0930514.fastfoodorderapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PaymentScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "付款", modifier = Modifier.padding(12.dp)) },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack()}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navHostController.navigate("PaymentCompleted")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = null
                    )
                },
                text = { Text(text = "完成") }
            )
        }
    ){
        Column (Modifier.padding(it)){

        }
    }
}