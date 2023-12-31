package com.r0930514.fastfoodorderapp.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun convertDate(inputDateTimeString: String): String? {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        .withZone(ZoneId.systemDefault())
    val instant = Instant.parse(inputDateTimeString)
    return formatter.format(instant)
}