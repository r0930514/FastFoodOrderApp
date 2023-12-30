package com.r0930514.fastfoodorderapp.screens.productScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true)
fun RadioBtnGroup(
    text: String = "test",
    onClick: () -> Unit = {},
    selected: Boolean = false
){
    Row (modifier = Modifier.fillMaxWidth().padding(4.dp), verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text)
    }
}