package com.example.demo.domain

import com.example.demo.constants.API
import com.example.demo.http.BaseHttpConfig

class WanandroidHttpConfig : BaseHttpConfig() {
    override fun baseUrl(): String {
        return API.BASE_URL
    }

    override fun services(): ArrayList<Class<*>> {
        return arrayListOf(ApiService::class.java)
    }

    override fun isEnableHttpLog(): Boolean {
        return true
    }

    override fun isEnableProxy(): Boolean {
        return true
    }
}