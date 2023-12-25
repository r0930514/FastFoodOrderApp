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
import androidx.compose.runtime.collectAsState
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
        navHostController: NavHostController,
        viewModel: UserStateViewModel = UserStateViewModel(navHostController.context.dataStore),
){

    val iconColor : IconButtonColors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)

    var phoneValue by rememberSaveable { mutableStateOf("") }
    var passwordValue by rememberSaveable { mutableStateOf("") }
    var isPhoneValid by rememberSaveable { mutableStateOf(false )}
    var isError by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }

    val username by viewModel.userName.collectAsState()

    //現在的頁面
    var page by rememberSaveable { mutableStateOf<LoginScreenPages>(LoginScreenPages.PHONE) }

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
                isLoading = isLoading,
                onClick = {
                    coroutineScope.launch {
                        isLoading = true
                        when(page){
                            LoginScreenPages.PHONE -> {
                                delay(1000)
                                isLoading = false
                                if (phoneValue == "0977144496" ){
                                    isError = false
                                    page = LoginScreenPages.PASSWORD
                                }else if(phoneValue == "0977144497"){
                                    page = LoginScreenPages.REGISTER
                                }else{
                                    isError = true
                                }
                                //viewModel.verifyPhone(phoneValue)
                                //if (viewModel.verifyPhone(phoneValue)){
                                //    isError = false
                                //    page = LoginScreenPages.PASSWORD
                                //}else{
                                //    isError = true
                                //}
                            }
                            LoginScreenPages.PASSWORD -> {
                                delay(1000)
                                isLoading = false
                                if (passwordValue == "12345678"){
                                    isError = false
                                    viewModel.saveUserName(phoneValue)
                                    Toast.makeText(navHostController.context, "登入成功", Toast.LENGTH_SHORT).show()

                                    navHostController.popBackStack()
                                }else{
                                    isError = true
                                }
                            }
                            LoginScreenPages.REGISTER -> {
                                delay(1000)
                                isLoading = false
                                if (phoneValue.length == 10 && passwordValue.length >= 8){
                                    isError = false
                                    Toast.makeText(navHostController.context, "註冊成功", Toast.LENGTH_SHORT).show()
                                }else{
                                    isError = true
                                }
                            }
                        }

                    }

                }
            )
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
                    onPhoneValueChange =  { it1 -> phoneValue = it1 },
                    onPasswordValueChange =  { it1 -> passwordValue = it1 },
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

