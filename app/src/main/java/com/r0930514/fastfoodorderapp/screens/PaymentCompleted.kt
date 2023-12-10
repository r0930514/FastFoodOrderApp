package com.r0930514.fastfoodorderapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentCompleted(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "付款完成") },
                colors = TopDefaultAppBarColor(),
                navigationIcon = { IconButton(onClick = {
                    navHostController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }},
            )


        },


        )
    {
        Column {
            Column {

                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "請登入會員")
                    Button(onClick = { navHostController.navigate("Login") }) {
                        Text(text = "登入")
                    }
                    Button(onClick = { navHostController.navigate("PaymentCompleted") }) {
                        Text(text = "測試")
                    }
                }
            }

        }
    }
}