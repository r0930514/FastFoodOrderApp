package com.r0930514.fastfoodorderapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestPage(navHostController: NavHostController){

    Scaffold (
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {}, icon = {})
            }
        }
    ){
        TopAppBar(title = { Text(text = "HG") })
        Column (modifier = Modifier.padding(it)){
            Text(text = "HELLO Test")
        }
    }
}