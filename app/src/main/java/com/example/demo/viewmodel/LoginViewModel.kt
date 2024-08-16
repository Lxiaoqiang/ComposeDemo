package com.example.demo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.AppGlobalData
import com.example.demo.data.bean.LoginBean
import com.example.demo.domain.repository.Repository
import com.example.demo.ext.UIState
import com.example.demo.ext.launchWithCatch
import com.example.demo.ext.toAppException
import com.example.demo.ext.toUIState
import com.example.demo.page.login.LoginEffect
import com.example.demo.page.login.LoginEvent
import com.example.demo.page.login.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val mRepository = Repository()

    var state = MutableSharedFlow<LoginState>()
        private set

    var username = mutableStateOf("")
    var password = mutableStateOf("")

    var effect = MutableSharedFlow<LoginEffect>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            flow {
                kotlinx.coroutines.delay(3000)
                val loginBean = LoginBean(username, password)
                AppGlobalData.loginData = loginBean
                emit(LoginState(false, null, loginBean))
            }.flowOn(Dispatchers.IO)
                .onStart {
                    emit(LoginState(true, null, null))
                }.catch {
                    emit(LoginState(false, it.toAppException().errorMsg, null))
                }.collect {
                    state.emit(it)
                }

        }
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.LoginClick -> {
                viewModelScope.launch {
                    effect.emit(LoginEffect.LoginClick(event.username, event.password))
                }
            }
        }
    }
}