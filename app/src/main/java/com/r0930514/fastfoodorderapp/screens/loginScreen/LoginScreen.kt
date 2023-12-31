package com.r0930514.fastfoodorderapp.screens.loginScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r0930514.fastfoodorderapp.dataStore
import com.r0930514.fastfoodorderapp.screens.components.LoadingFloatBtn
import com.r0930514.fastfoodorderapp.screens.loginScreen.componemts.LoginScreenTopBar
import com.r0930514.fastfoodorderapp.viewModels.UserStateViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
        navHostController: NavHostController,
        viewModel: UserStateViewModel = UserStateViewModel(navHostController.context.dataStore),
){

    val iconColor : IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)

    var phoneValue by rememberSaveable { mutableStateOf("") }
    var passwordValue by rememberSaveable { mutableStateOf("") }
    var confirmPasswordValue by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }

    //現在的頁面
    var page by rememberSaveable { mutableStateOf(LoginScreenPages.PHONE) }
    //Coroutine
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        topBar = {
            LoginScreenTopBar(navHostController = navHostController, iconColor = iconColor){
                Text(text = if(page != LoginScreenPages.REGISTER) "登入" else "註冊")
            }
        },
        floatingActionButton = {
            LoadingFloatBtn(
                isLoading = isLoading
            ) {
                coroutineScope.launch {
                    isLoading = true
                    isError = false
                    //判斷目前頁面調整按鈕功能
                    when (page) {
                        LoginScreenPages.PHONE -> {
                            page = try {
                                viewModel.checkUserExist(phoneValue)
                                LoginScreenPages.PASSWORD
                            } catch (e: Exception) {
                                Toast.makeText(navHostController.context, "此帳號不存在", Toast.LENGTH_SHORT).show()
                                LoginScreenPages.REGISTER
                            }
                        }

                        LoginScreenPages.PASSWORD -> {
                            try {
                                viewModel.login(phoneValue, passwordValue)
                                Toast.makeText(navHostController.context, "登入成功", Toast.LENGTH_SHORT).show()
                                navHostController.popBackStack()
                            } catch (e: Exception) {
                                isError = true
                                Toast.makeText(navHostController.context, "登入失敗$e", Toast.LENGTH_SHORT).show()
                            }
                        }

                        LoginScreenPages.REGISTER -> {
                            try {
                                viewModel.register(phoneValue, passwordValue, confirmPasswordValue)
                                Toast.makeText(navHostController.context, "註冊成功，請重新登入", Toast.LENGTH_SHORT).show()
                                navHostController.popBackStack()
                            } catch (e: Exception) {
                                isError = true
                                Toast.makeText(navHostController.context, "註冊失敗$e", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    isLoading = false
                }
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
            when(page){
                LoginScreenPages.PHONE -> PhonePage(
                    phoneValue = phoneValue,
                    onPhoneValueChange =  { it1 -> phoneValue = it1 },
                    isErrorValue = isError,
                )
                LoginScreenPages.PASSWORD -> PasswordPage(
                    passwordValue = passwordValue,
                    onPasswordValueChange =  { it1 -> passwordValue = it1 },
                    isErrorValue = isError,
                )
                LoginScreenPages.REGISTER -> RegisterPage(
                    phoneValue = phoneValue,
                    passwordValue = passwordValue,
                    confirmPasswordValue = confirmPasswordValue,
                    onPhoneValueChange =  { it1 -> phoneValue = it1 },
                    onPasswordValueChange =  { it1 -> passwordValue = it1 },
                    onConfirmPasswordValueChange =  { it1 -> confirmPasswordValue = it1 },
                    isErrorValue = isError,
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

