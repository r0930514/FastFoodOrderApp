package com.r0930514.fastfoodorderapp.screens.mainScreen.items

import com.r0930514.fastfoodorderapp.R

sealed class MemberPageListItem(
    val icon: Int,
    val title: String,
    val route: String = ""
){
    object Detail: MemberPageListItem(R.drawable.list, "交易明細", "OrderDetail")
    object ChangePassword: MemberPageListItem(R.drawable.key, "變更密碼")
    //object ChangePhone: MemberPageListItem(R.drawable.phone, "變更電話號碼")
    //object NotificationSetting: MemberPageListItem(R.drawable.notifications, "通知設定")
    object AdminOrderDetail: MemberPageListItem(R.drawable.list, "店家訂單明細", "AdminOrderDetail")
    object Logout: MemberPageListItem(R.drawable.logout, "登出")
}

