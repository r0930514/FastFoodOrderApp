package com.r0930514.fastfoodorderapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CAppBar
import com.r0930514.fastfoodorderapp.ui.theme.TopDefaultAppBarColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentCompleted(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "付款完成") },
                colors = TopDefaultAppBarColor(),
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Check")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "結束")
                }
            }
        }

    ) {
        Column {
            Column {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally

                )
                {
                    Image(
                        painterResource(id = R.drawable.fastfood),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                    
//                    Icon(
//                        imageVector = ImageVector.Companion.vectorResource(id = R.drawable.fastfood),
//                        contentDescription = null
//                    )
//                    Text(text = "請登入會員")
//                    Button(onClick = { navHostController.navigate("Login") }) {
//                        Text(text = "登入")
//                    }
//                    Button(onClick = { navHostController.navigate("PaymentCompleted") }) {
//                        Text(text = "測試")
//                    }
                }
            }
        }
    }
}

