package com.r0930514.fastfoodorderapp.screens.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.components.EditText

@Composable
@Preview(showSystemUi = true)
fun PhonePage(
    phoneValue: String = "TEST",
    onPhoneValueChange: (String) -> Unit = {},
    isErrorValue: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.fastfood),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        EditText(
            value = phoneValue,
            onValueChange =  onPhoneValueChange,
            keyboardType = KeyboardType.Phone,
            label = "輸入電話號碼",
            isError = isErrorValue,
            supportingText = "系統將會自動判定是否註冊",
            leadingIcon = Icons.Filled.Phone,
        )
    }

}