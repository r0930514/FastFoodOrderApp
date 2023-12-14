package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.r0930514.fastfoodorderapp.screens.components.CustomAsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageCard(
    title: String = "未命名",
    description: String = "-",
    onClick: () -> Unit = {},
    imageURL: String = ""
){
    Column (
        modifier = Modifier.padding(24.dp))
    {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClick,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ){
            Column{
                CustomAsyncImage(
                    url = imageURL,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp
                    )
                    Text(
                        text = description,
                        fontSize = 14.sp
                    )
                }
            }

        }
    }
}