package com.example.demo.page.mine

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.AppGlobalData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MineViewModel: ViewModel() {


    val event = MutableSharedFlow<MineEvent>()


    fun onEvent(e: MineAction) {
        viewModelScope.launch {
            when(e) {
                is MineAction.ActionLogout -> {
                    AppGlobalData.loginData = null
                    event.emit(MineEvent.EventLogoutResult(true, "退出登录成功"))
                }
                is MineAction.ActionToSetting -> {
                    event.emit(MineEvent.EventToSetting)
                }
                is MineAction.ActionToAboutMe -> {
                    event.emit(MineEvent.EventToAboutMe)
                }
                is MineAction.ActionToEditBg -> {
                    event.emit(MineEvent.EventToEditBg)
                }
            }
        }
    }
}