package com.example.demo.page.login

sealed interface LoginEvent {

    data class LoginClick(val username: String, val password: String) : LoginEvent

}
