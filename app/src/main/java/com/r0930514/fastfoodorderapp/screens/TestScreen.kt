package com.r0930514.fastfoodorderapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen(navHostController: NavHostController){

    Scaffold (
        topBar = { CAppBar() }
    ){
        Column {
            Text(text = "TEST123123")
        }
    }
}