package com.r0930514.fastfoodorderapp.screens.mainScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.dataStore
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CNavBar
import com.r0930514.fastfoodorderapp.viewModels.UserStateViewModel

@Composable
fun MainScaffold(navController: NavHostController) {
    val userStateViewModel = UserStateViewModel(navController.context.dataStore)
    val username by userStateViewModel.userPhone.collectAsState()
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    val scrollState = rememberLazyListState()
    Scaffold(
        bottomBar = { CNavBar(selectedItem) {selectedItem = it} },
        floatingActionButton = {
            if (selectedItem == 1){
                ExtendedFloatingActionButton(
                    onClick = {
                              if(username=="") {
                                  Toast.makeText(navController.context, "請先登入", Toast.LENGTH_SHORT).show()
                                  navController.navigate("Login")
                              } else navController.navigate("ShoppingCart")
                    },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.shopping_cart),
                            contentDescription = null
                        )
                    },
                    text = { Text(text = "購物車") })
            }
        }
    ) {
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            when (selectedItem) {
                0 -> HomePage(navController, scrollState)
                1 -> OrderPage(navController)
                2 -> MemberPage(navController)
            }
        }
    }
}

