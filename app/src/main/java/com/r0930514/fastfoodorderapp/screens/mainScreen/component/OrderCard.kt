package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderCard(
    id: Int = 0,
    title: String = "營運公告",
    price: String = "$40",
    navHostController: NavHostController
){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { navHostController.navigate("ProductAdd/${id}") },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ){
        Column{
            Image(
                painter = painterResource(id = R.drawable.unknow),
                contentDescription = "照片",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,

                    )
                Text(
                    text = price,
                    fontSize = 14.sp
                )
            }
        }

    }
}