package com.example.demo

import android.app.Application
import com.example.demo.component.cache.KVCache
import com.example.demo.domain.WanandroidHttpConfig
import com.example.demo.http.Http

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Http.init(arrayListOf(WanandroidHttpConfig()))
        KVCache.init(this)
    }
}