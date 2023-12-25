package com.r0930514.fastfoodorderapp.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.r0930514.fastfoodorderapp.R

@Composable
fun NetworkError(
    modifier: Modifier = Modifier.fillMaxSize()
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.cloud_off), contentDescription = null)
    }
}