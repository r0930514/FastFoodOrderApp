package com.r0930514.fastfoodorderapp.pages.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MemberPage(navHostController: NavHostController){
    Column (modifier = Modifier.padding(12.dp)){
        Text(text = "HELLO Member")
        Button(onClick = { navHostController.navigate("Test") }) {
            Text(text = "切換到Test")
        }
    }
}