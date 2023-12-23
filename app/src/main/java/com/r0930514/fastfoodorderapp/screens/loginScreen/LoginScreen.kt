package com.r0930514.fastfoodorderapp.screens.loginScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.R
import com.r0930514.fastfoodorderapp.screens.components.LoadingCircle
import com.r0930514.fastfoodorderapp.screens.loginScreen.componemts.LoginEditText
import com.r0930514.fastfoodorderapp.screens.loginScreen.componemts.LoginScreenTopBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navHostController: NavHostController){

    val iconColor : IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
    var phoneValue by rememberSaveable { mutableStateOf("") }
    var passwordValue by rememberSaveable { mutableStateOf("") }
    var isPhoneValid by rememberSaveable { mutableStateOf(false )}
    var isErrorValue by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var floatBtnIcon: @Composable () -> Unit by remember { mutableStateOf({ FloatBtnContent.ArrowForward.content() }) }


    Scaffold (
        topBar = {
            LoginScreenTopBar(navHostController = navHostController, iconColor = iconColor)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    floatBtnIcon = { FloatBtnContent.Loading.content() }
                    delay(1000)
                    if (phoneValue.length == 10){
                        isPhoneValid = true
                        isErrorValue = false
                    }else{
                        isErrorValue = true
                        Toast.makeText(navHostController.context, "請輸入正確的電話號碼", Toast.LENGTH_SHORT).show()
                    }
                    floatBtnIcon = { FloatBtnContent.ArrowForward.content() }
                }
            }) {
                floatBtnIcon()
            }
        }
        
        )
    {
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        )
        {
            Icon(
                imageVector = ImageVector.Companion.vectorResource(R.drawable.fastfood),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            if (!isPhoneValid){
                LoginEditText(
                    value = phoneValue,
                    onValueChange =  { v ->
                        phoneValue = v
                    },
                    keyboardType = KeyboardType.Phone,
                    label = "輸入電話號碼",
                    isError = isErrorValue,
                    supportingText = "系統將會自動判定是否註冊",
                    leadingIcon = Icons.Filled.Phone,
                )
            }else{
                LoginEditText(
                    value = passwordValue,
                    onValueChange =  { v ->
                        passwordValue = v
                    },
                    keyboardType = KeyboardType.Password,
                    label = "輸入密碼",
                    isError = isErrorValue,
                    supportingText = "請輸入密碼",
                    leadingIcon = Icons.Filled.Phone,
                )
            }

        }

    }   
}



@Composable
@Preview
fun LoginScreenPreview(){
    val navHostController = rememberNavController()
    LoginScreen(navHostController = navHostController)
}

sealed class FloatBtnContent(
    val content: @Composable () -> Unit
){
    object ArrowForward: FloatBtnContent({ Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null) })
    object Loading: FloatBtnContent({ LoadingCircle(modifier = Modifier.size(24.dp)) })
}