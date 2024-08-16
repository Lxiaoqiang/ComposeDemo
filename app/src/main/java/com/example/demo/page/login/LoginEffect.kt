package com.example.demo.page.login

sealed interface LoginEffect {

    data class LoginClick(val username: String, val password: String) : LoginEffect
}
