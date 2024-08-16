package com.example.demo.domain.repository

import androidx.lifecycle.viewModelScope
import com.example.demo.data.AppGlobalData
import com.example.demo.data.bean.LoginBean
import com.example.demo.domain.ApiService
import com.example.demo.ext.UIState
import com.example.demo.ext.launchWithCatch
import com.example.demo.ext.toAppException
import com.example.demo.ext.toUIState
import com.example.demo.ext.toUIStateOrThrows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class Repository {



    fun requestBanner() = flow {
        val resp = ApiService.INSTANCE.requestBanner()
        emit(resp.toUIStateOrThrows())
    }.flowOn(Dispatchers.IO).onStart {
        emit(UIState.onLoading())
    }.catch {
        emit(it.toUIState())
    }



    fun login(username: String, password: String) = flow {
        kotlinx.coroutines.delay(3000)
        val loginBean = LoginBean(username, password)
        AppGlobalData.loginData = loginBean
        emit(UIState.onSuccess(loginBean))
    }.flowOn(Dispatchers.IO).onStart {
        emit(UIState.onLoading())
    }.catch {
        emit(UIState.onError(it.toAppException()))
    }
}