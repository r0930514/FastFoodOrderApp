package com.r0930514.fastfoodorderapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navHostController: NavHostController){

    val iconColor : IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)

    var phoneValue by rememberSaveable { mutableStateOf("") }
    var passwordValue by rememberSaveable { mutableStateOf("") }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "登入畫面") },
                actions = {
                    IconButton(onClick = {
                        navHostController.popBackStack()
                    }, colors = iconColor) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "關閉")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
            }
        }
        
        )
    {
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        )
        {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.fastfood),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Spacer(modifier = Modifier.size(24.dp))
            TextField(
                value = phoneValue,
                onValueChange = { v -> phoneValue = v },
                label = { Text(text = "登入") },
                singleLine = true,
                modifier = Modifier.padding(12.dp),
                leadingIcon = { Icon(imageVector = Icons.Filled.Phone, contentDescription = null) }
            )
            TextField(
                value = passwordValue,
                onValueChange = { v -> passwordValue = v },
                label = { Text(text = "密碼")},
                singleLine = true,
                modifier = Modifier.padding(12.dp),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null) },
            )
        }
    }   
}