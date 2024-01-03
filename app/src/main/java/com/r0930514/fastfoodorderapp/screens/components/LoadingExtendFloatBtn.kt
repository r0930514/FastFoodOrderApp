package com.r0930514.fastfoodorderapp.screens.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true)
fun LoadingExtendFloatBtn(
    isLoading: Boolean = true,
    title: String = "",
    onClick: () -> Unit = {},
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {
            if (!isLoading) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }else{
                LoadingCircle(Modifier.size(24.dp))
            }
        },
        text = { Text(text = title) }
    )
}
