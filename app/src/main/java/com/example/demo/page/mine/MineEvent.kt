package com.example.demo.page.mine

sealed interface MineEvent {

    data class EventLogoutResult(val logoutSuccess: Boolean, val msg: String): MineEvent

    data object EventToSetting: MineEvent

    data object EventToAboutMe: MineEvent

    data object EventToEditBg: MineEvent
}
