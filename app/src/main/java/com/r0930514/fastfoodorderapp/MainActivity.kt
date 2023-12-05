package com.r0930514.fastfoodorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.r0930514.fastfoodorderapp.navigation.MainNav
import com.r0930514.fastfoodorderapp.ui.theme.FastFoodOrderAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FastFoodOrderAppTheme {
                MainNav()
            }
        }
    }
}




