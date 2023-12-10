package com.r0930514.fastfoodorderapp.screens.shoppingCartScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CartCard(){
    OutlinedCard(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        onClick = { /*TODO*/ }
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.unknow),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop

            )
            Text(text = "s")
        }
    }
}