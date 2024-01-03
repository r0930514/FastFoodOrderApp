package com.r0930514.fastfoodorderapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PaymentScreen(
    navHostController: NavHostController = rememberNavController(),
    tableID: String = ""
) {
    var isPay by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = isPay, block = {
        delay(2000)
        isPay = true
        navHostController.navigate("PaymentCompleted"){
            popUpTo("BottomNav"){
                inclusive = false
            }
        }
    })
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "付款", modifier = Modifier.padding(12.dp)) },
                colors = TopDefaultAppBarColor(),
            )
        },
    ){
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            if (!isPay) {
                LoadingCircle(modifier = Modifier.padding(12.dp))
                Text(text = "模擬付款需求，請稍候")
            }
        }
    }
}