package com.r0930514.fastfoodorderapp.util

fun getNowTime(): String {
    val time = System.currentTimeMillis()
    val date = java.util.Date(time)
    val format = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return format.format(date)
}
