package com.r0930514.fastfoodorderapp.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.pages.main.appBars.CAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestPage(navHostController: NavHostController){

    Scaffold (
        topBar = { CAppBar() }
    ){
        Column {
            Text(text = "TEST")
        }
    }
}