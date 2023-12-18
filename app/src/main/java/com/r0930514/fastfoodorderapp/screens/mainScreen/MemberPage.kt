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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.CommonAppBar
import com.r0930514.fastfoodorderapp.screens.mainScreen.component.MemberPageCard
import com.r0930514.fastfoodorderapp.screens.mainScreen.items.MemberPageListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberPage(navHostController: NavHostController){
    val listItems = listOf<MemberPageListItem>(
        MemberPageListItem.Detail,
        MemberPageListItem.ChangePassword,
        MemberPageListItem.ChangePhone,
        MemberPageListItem.NotificationSetting,
        MemberPageListItem.Test,
        MemberPageListItem.Test1
    )
    Column {
        CommonAppBar("會員")
        MemberPageCard(onClick = {
            navHostController.navigate("Login")
        })
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

