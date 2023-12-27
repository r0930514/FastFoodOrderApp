package com.r0930514.fastfoodorderapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.datastore.preferences.preferencesDataStore
import com.r0930514.fastfoodorderapp.navigation.MainNav
import com.r0930514.fastfoodorderapp.ui.theme.FastFoodOrderAppTheme
import com.r0930514.fastfoodorderapp.viewModels.ProductListViewModel

val Context.dataStore by preferencesDataStore(name = "user_preferences")

class MainActivity : ComponentActivity() {
    val productListViewModel: ProductListViewModel by viewModels()
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






