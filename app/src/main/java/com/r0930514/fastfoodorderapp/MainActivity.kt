    package com.r0930514.fastfoodorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.components.CAppBar
import com.r0930514.fastfoodorderapp.components.CNavBar
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
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ),
            onClick = {},

    ){
        Box(Modifier.fillMaxSize()) {
            Text("Test", Modifier.align(Alignment.Center))
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SmallTopAppBarExample() {
    Scaffold(
        topBar = { CAppBar() },
        bottomBar = { CNavBar() }
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)){
            Greeting("dd",
                modifier = Modifier.padding(12.dp))
        }

    }
}



