package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun OrderCard(){
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {}
    ){
        Column{
            Image(
                painter = painterResource(id = R.drawable.unknow),
                contentDescription = "照片",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
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