package com.r0930514.fastfoodorderapp.screens.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
fun RegisterPage(
    phoneValue: String = "TEST",
    passwordValue: String = "TEST",
    onPhoneValueChange: (String) -> Unit = {},
    onPasswordValueChange: (String) -> Unit = {},
    isErrorValue: Boolean = false,
    modifier: Modifier = Modifier,
) {
    var confirmPasswordValue by rememberSaveable { mutableStateOf("") }
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
        val modifier = Modifier.padding(vertical = 16.dp, horizontal = 48.dp).fillMaxWidth()
        Column {
            EditText(
                value = phoneValue,
                onValueChange = onPhoneValueChange,
                keyboardType = KeyboardType.Phone,
                label = "輸入電話號碼",
                isError = isErrorValue,
                supportingText = "使用電話號碼註冊一個新帳號",
                leadingIcon = Icons.Filled.Phone,
                modifier = modifier
            )
            EditText(
                value = passwordValue,
                onValueChange = onPasswordValueChange,
                keyboardType = KeyboardType.Password,
                label = "輸入要設定的密碼",
                isError = isErrorValue,
                supportingText = "8個以上字元，大小寫英文字母與數字",
                leadingIcon = Icons.Filled.Lock,
                modifier = modifier
            )
            EditText(
                value = confirmPasswordValue,
                onValueChange = { confirmPasswordValue = it },
                keyboardType = KeyboardType.Password,
                label = "再次輸入密碼",
                isError = isErrorValue,
                supportingText = "請再次輸入密碼",
                leadingIcon = Icons.Filled.Lock,
                modifier = modifier
            )
        }
    }

}