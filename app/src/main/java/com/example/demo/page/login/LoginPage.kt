package com.example.demo.page.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demo.AppNavController
import com.example.demo.R
import com.example.demo.component.showToast
import com.example.demo.constants.RouteUrls
import com.example.demo.ui.theme.AppColorsProvider
import com.example.demo.ui.widget.CommonEditText
import com.example.demo.ui.widget.LoadingView
import com.example.demo.viewmodel.LoginViewModel

@Composable
fun LoginPage() {
    val loginViewModel: LoginViewModel = viewModel()

    LaunchedEffect(Unit) {
        loginViewModel.event.collect {
            when(it) {
                is LoginEvent.LoginSuccess -> {
                    AppNavController.instantce.popBackStack()
                    AppNavController.instantce.navigate(RouteUrls.MAIN)
                }
                is LoginEvent.LoginFailure -> {
                    showToast(it.message ?: "")
                }
            }
        }
    }

    LoginPage(loginViewModel) {
        loginViewModel.onIntent(it)
    }
}

@Composable
internal fun LoginPage(
    viewModel: LoginViewModel,
    loginIntent: (LoginIntent) -> Unit
) {


    var username = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColorsProvider.current.background),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 60.dp)
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = R.string.str_username),
                    style = TextStyle(
                        color = AppColorsProvider.current.firstText,
                        fontSize = 18.sp
                    )
                )
                Box(
                    modifier = Modifier.padding(start = 15.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    CommonEditText(
                        modifier = Modifier.fillMaxSize(),
                        hint = "请输入用户名",
                        trailingIcon = {
                            Box(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clear),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        },
                        hintTextStyle = TextStyle(
                            color = AppColorsProvider.current.secondText,
                            fontSize = 16.sp
                        ),
                        onTextChange = {
                            username.value = this
                        }
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 5.dp),
                        thickness = 1.dp,
                        color = AppColorsProvider.current.divider
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 60.dp)
                    .padding(top = 20.dp)
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = R.string.str_password),
                    style = TextStyle(
                        color = AppColorsProvider.current.firstText,
                        fontSize = 18.sp
                    )
                )
                Box(
                    modifier = Modifier.padding(start = 15.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    CommonEditText(
                        modifier = Modifier.fillMaxSize(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        onTextChange = {
                            password.value = this
                        },
                        hint = "请输入密码",
                        trailingIcon = {
                            Box(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.clear),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        },
                        hintTextStyle = TextStyle(
                            color = AppColorsProvider.current.secondText,
                            fontSize = 16.sp
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 5.dp),
                        thickness = 1.dp,
                        color = AppColorsProvider.current.divider
                    )
                }
            }
            Button(
                enabled = !(username.value.isNullOrEmpty() || password.value.isNullOrEmpty()),
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    contentColor = AppColorsProvider.current.primary,
                    containerColor = AppColorsProvider.current.primary
                ),
                onClick = {
                    loginIntent(LoginIntent.LoginClick(username.value, password.value))
                }
            ) {
                Text(
                    text = "登录",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = AppColorsProvider.current.firstText
                    )
                )
            }
        }
        if (viewModel.state.isLoading) {
            LoadingView(modifier = Modifier.align(Alignment.Center))
        }
    }

}