package com.r0930514.fastfoodorderapp.screens.loginScreen.componemts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun LoginEditText(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(48.dp)
        .fillMaxWidth(),
    keyboardType: KeyboardType = KeyboardType.Phone,
    label: String,
    isError: Boolean = false,
    supportingText: String,
    leadingIcon: ImageVector = Icons.Filled.Phone
) {
    OutlinedTextField(
        value = value,
        onValueChange =  { onValueChange(it) },
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        supportingText = { Text(text = supportingText) },
        modifier = modifier,
        leadingIcon = { Icon(
            imageVector = leadingIcon,
            contentDescription = null
        )},
        isError = isError
    )
}