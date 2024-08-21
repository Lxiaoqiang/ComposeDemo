package com.example.demo.data

import com.example.demo.component.cache.KVCacheParcelableExt
import com.example.demo.data.bean.LoginBean

object AppGlobalData {


    var loginData by KVCacheParcelableExt("login_result", LoginBean::class.java)
}