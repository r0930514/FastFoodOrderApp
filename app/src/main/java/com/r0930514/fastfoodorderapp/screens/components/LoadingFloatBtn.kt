package com.r0930514.fastfoodorderapp.screens.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true)
fun LoadingFloatBtn(
    isLoading: Boolean = true,
    onClick: () -> Unit = {},
) {
    FloatingActionButton(onClick = onClick) {
        if (isLoading){
            LoadingCircle(modifier = Modifier.size(24.dp))
        }else{
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
        }
    }
}
