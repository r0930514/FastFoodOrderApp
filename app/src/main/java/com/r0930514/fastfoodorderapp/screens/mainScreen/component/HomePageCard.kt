package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageCard(
    title: String = "未命名",
    description: String = "-",
    painter: Painter = painterResource(id = R.drawable.unknow),
    onClick: () -> Unit = {}
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
                Image(
                    painter = painter,
                    contentDescription = title,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }
}