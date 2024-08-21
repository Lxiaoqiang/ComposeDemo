package com.example.demo.page.login

sealed interface LoginIntent {

    data class LoginClick(val username: String, val password: String) : LoginIntent
}
