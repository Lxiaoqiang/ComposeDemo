package com.example.demo.page.login

import com.example.demo.data.bean.LoginBean

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val loginBean: LoginBean? = null
)
