package com.r0930514.fastfoodorderapp.screens.mainScreen

import android.widget.Toast
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CommonAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.MemberPageCard
import com.r0930514.fastfoodorderapp.screens.mainScreen.items.MemberPageListItem
import com.r0930514.fastfoodorderapp.viewModels.UserStateViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberPage(
    navHostController: NavHostController,
    viewModel: UserStateViewModel = viewModel(factory = UserStateViewModel.Factory)
){
    val username by viewModel.userPhone.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val listItems = listOf(
        MemberPageListItem.Detail,
        MemberPageListItem.ChangePassword
//        MemberPageListItem.ChangePhone,
//        MemberPageListItem.NotificationSetting,
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
                        MemberPageList(
                            it,
                            modifier = Modifier.clickable {
                                if (it.route != "") navHostController.navigate(it.route)
                            }
                        )
                        Divider()
                    }
                }
                if (username != ""){
                    item {
                        MemberPageList(
                            MemberPageListItem.Logout,
                            modifier = Modifier.clickable {
                                Toast.makeText(navHostController.context, "登出成功", Toast.LENGTH_SHORT).show()
                                coroutineScope.launch { viewModel.logout() }
                            }
                        )
                        Divider()
                    }
                }
            })

        }
    }
}

@Composable
private fun MemberPageList(
    item: MemberPageListItem,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = { Text(item.title) },
        leadingContent = {
            Icon(
                imageVector = ImageVector.vectorResource(item.icon),
                contentDescription = "null",
            )
        },
        modifier = modifier
    )
}

