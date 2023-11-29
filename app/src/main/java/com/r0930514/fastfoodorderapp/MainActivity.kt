package com.r0930514.fastfoodorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.r0930514.fastfoodorderapp.ui.theme.FastFoodOrderAppTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FastFoodOrderAppTheme {
                SmallTopAppBarExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Card(
            modifier = modifier,
            onClick = {}
    ){
        Box(Modifier.fillMaxSize()) {
            Text("Clickable", Modifier.align(Alignment.Center))
        }
    }

}

@Composable
fun GreetingPreview() {
    FastFoodOrderAppTheme {
        Greeting("Android")
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "速食店訂餐App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = { NavigationBarSample() }
    ) { innerPadding ->
        Greeting("TEST",
            modifier = Modifier.padding(innerPadding))
    }
}




@Composable
fun NavigationBarSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("首頁", "訂餐", "會員")
    val icons = listOf<ImageVector>(Icons.Filled.Home, Icons.Filled.PlayArrow, Icons.Filled.Person)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}