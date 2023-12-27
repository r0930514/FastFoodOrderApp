package com.r0930514.fastfoodorderapp.screens.mainScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.dataStore
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CommonAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.MemberPageCard
import com.r0930514.fastfoodorderapp.screens.mainScreen.items.MemberPageListItem
import com.r0930514.fastfoodorderapp.viewModels.UserStateViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberPage(
    navHostController: NavHostController,
    viewModel: UserStateViewModel = UserStateViewModel(navHostController.context.dataStore),
){
    val username by viewModel.userPhone.collectAsState()
    val userToken by viewModel.userToken.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val listItems = listOf(
        MemberPageListItem.Detail,
        MemberPageListItem.ChangePassword,
        MemberPageListItem.ChangePhone,
        MemberPageListItem.NotificationSetting,
        MemberPageListItem.Test,
    )
    Column {
        CommonAppBar("會員")
        MemberPageCard(
            onClick = {
                if(username=="") navHostController.navigate("Login")
            },
            title = if (username == "") "登入" else username,
        )
        Column(modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            LazyColumn(content = {
                item{
                    listItems.forEach{
                        MemberPageList(it, navHostController)
                        Divider()
                    }
                }
                if (username != ""){
                    item {
                        TextButton(onClick = { coroutineScope.launch { viewModel.logout() } }) {
                            Text(text = "登出")
                        }
                    }
                }
            })

        }
    }
}

@Composable
private fun MemberPageList(
    it: MemberPageListItem,
    navHostController: NavHostController
) {
    ListItem(
        headlineContent = { Text(it.title) },
        leadingContent = {
            Icon(
                imageVector = ImageVector.vectorResource(it.icon),
                contentDescription = "null",
            )
        },
        modifier = Modifier.clickable {
            if (it.route != "") {
                navHostController.navigate(it.route)
            }
        }
    )
}

