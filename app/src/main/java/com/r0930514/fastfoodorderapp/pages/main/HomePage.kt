package com.r0930514.fastfoodorderapp.pages.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.pages.main.appBars.CAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController) {
    Column {
        CAppBar()
        LazyColumn() {
            items(5) {
                HomePageCard()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomePageCard(){
    Column (
        modifier = Modifier.padding(24.dp)){

        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            onClick = {}
        ){
            Column{
                Image(
                    painter = painterResource(id = R.drawable.unknow),
                    contentDescription = "照片",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "營運公告",
                        fontSize = 16.sp,

                        )
                    Text(text = "測試", fontSize = 14.sp)
                }
            }

        }
    }
}