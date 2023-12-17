package com.r0930514.fastfoodorderapp.screens.mainScreen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun MemberPageCard(
    title: String = "登入",
    onClick: () -> Unit = {}
){
    OutlinedCard(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .size(80.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        onClick = onClick
    ) {
        Row (modifier = Modifier.fillMaxWidth()){
            Box (
                modifier = Modifier.size(80.dp),
                ){
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    tint = Color(0xFF6750A4),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().padding(12.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight()
                    )
                }
            }

        }

    }
}