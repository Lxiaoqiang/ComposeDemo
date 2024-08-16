package com.example.demo.page.login

import com.example.demo.data.bean.LoginBean

data class LoginState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val loginBean: LoginBean? = null
)
