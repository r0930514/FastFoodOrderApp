package com.r0930514.fastfoodorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.components.CAppBar
import com.r0930514.fastfoodorderapp.components.CNavBar
import com.r0930514.fastfoodorderapp.components.CNavBarItem
import com.r0930514.fastfoodorderapp.pages.HomePage
import com.r0930514.fastfoodorderapp.pages.MemberPage
import com.r0930514.fastfoodorderapp.pages.OrderPage
import com.r0930514.fastfoodorderapp.ui.theme.FastFoodOrderAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FastFoodOrderAppTheme {
                CScaffold()
            }
        }
    }
}


@Preview
@Composable
fun CScaffold() {
    val navController:NavHostController = rememberNavController()
    Scaffold(
        topBar = { CAppBar() },
        bottomBar = { CNavBar(navController) }
    ) { innerPadding ->
        Nav(Modifier.padding(innerPadding), navController)
    }
}

@Composable
fun Nav(modifier: Modifier, navController: NavHostController){
    NavHost(navController = navController, startDestination = CNavBarItem.Home.route, modifier = modifier){
        composable(CNavBarItem.Home.route){
            HomePage()
        }
        composable(CNavBarItem.Order.route){
            OrderPage()
        }
        composable(CNavBarItem.Member.route){
            MemberPage()
        }
    }
}

