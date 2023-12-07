package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberPage(navHostController: NavHostController){
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = "會員") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            )
        )
        Column(modifier = Modifier.padding(12.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "請登入會員")
            Button(onClick = { navHostController.navigate("Login") }) {
                Text(text = "登入")
            }
        }
    }
}