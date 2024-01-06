package com.r0930514.fastfoodorderapp.screens.detailScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun DetailCard(
    title: String = "日期與類型",
    description: String = "項目計數",
    painter: Painter = painterResource(id = R.drawable.unknow),
    price: String = "0",
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
                    Text(text = title)
                    Text(text = description)
                }
                Row {
                    Text(
                        text = "$${price}",
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentSize(),
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.unfold_more),
                        contentDescription = null,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            }

        }
    }
}