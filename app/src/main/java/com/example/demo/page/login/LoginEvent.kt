package com.example.demo.page.login

sealed interface LoginEvent {

    object LoginSuccess: LoginEvent

    data class LoginFailure(val code: Int, val message: String?): LoginEvent
}
