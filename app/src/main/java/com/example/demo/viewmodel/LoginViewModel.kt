package com.example.demo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.AppGlobalData
import com.example.demo.data.bean.LoginBean
import com.example.demo.domain.repository.Repository
import com.example.demo.ext.UIState
import com.example.demo.ext.toAppException
import com.example.demo.ext.toUIState
import com.example.demo.page.login.LoginIntent
import com.example.demo.page.login.LoginEvent
import com.example.demo.page.login.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val mRepository = Repository()

    var state by mutableStateOf(LoginState())
        private set

    var event = MutableSharedFlow<LoginEvent>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            flow {
                kotlinx.coroutines.delay(2000)
                val loginBean = LoginBean(username, password)
                AppGlobalData.loginData = loginBean
                emit(UIState.onSuccess(loginBean))
            }.flowOn(Dispatchers.IO).onStart {
                emit(UIState.onLoading())
            }.catch {
                emit(it.toUIState())
            }.collect {
                when (it) {
                    is UIState.Success -> {
                        event.emit(LoginEvent.LoginSuccess)
                    }

                    is UIState.Loading -> {
                        state = state.copy(isLoading = true)
                    }

                    is UIState.Error -> {
                        event.emit(LoginEvent.LoginFailure(-1, "登录失败"))
                    }

                    else -> {}
                }

            }
        }
    }

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.LoginClick -> {
                viewModelScope.launch {
                    login(intent.username, intent.password)
                }
            }
        }
    }
}