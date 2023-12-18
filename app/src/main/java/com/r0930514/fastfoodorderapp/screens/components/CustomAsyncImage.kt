package com.r0930514.fastfoodorderapp.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.r0930514.fastfoodorderapp.R

@Composable
fun CustomAsyncImage(
    url: String = "",
    modifier: Modifier
){
    SubcomposeAsyncImage(
        model = url,
        contentDescription = null,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center)
                )
            }
        },
        contentScale = ContentScale.Crop,
        error = {
            Image(
                painter = painterResource(id = R.drawable.unknow),
                contentDescription = "ERROR",
                contentScale = ContentScale.Crop,
            )
        },
        modifier = modifier
    )
}