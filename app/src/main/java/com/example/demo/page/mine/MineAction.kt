package com.example.demo.page.mine

sealed interface MineAction {

    data object ActionLogout: MineAction

    data object ActionToSetting: MineAction

    data object ActionToAboutMe: MineAction

    data object ActionToEditBg: MineAction

}