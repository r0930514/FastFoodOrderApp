package com.r0930514.fastfoodorderapp.screens.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
fun PasswordPage(
    passwordValue: String = "TEST",
    onPasswordValueChange: (String) -> Unit = {},
    isErrorValue: Boolean = false,
    modifier: Modifier = Modifier,
) {

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.key),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        EditText(
            value = passwordValue,
            onValueChange =  onPasswordValueChange,
            keyboardType = KeyboardType.Password,
            label = "輸入密碼",
            isError = isErrorValue,
            supportingText = "請輸入你的密碼",
            leadingIcon = Icons.Filled.Lock,
        )
    }

}