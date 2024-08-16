package com.example.demo.http

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter

abstract class BaseHttpConfig {

    /**
     * 域名
     */
    abstract fun baseUrl(): String

    /**
     * OkhttpClient，返回空会使用默认配置，默认配置请查看[Http]
     */
    open fun client(defaultClientBuilder: OkHttpClient.Builder): OkHttpClient {
        return defaultClientBuilder.build()
    }

    /**
     * CallAdapter.Factory
     */
    open fun callAdapterFactory(): CallAdapter.Factory? {
        return null
    }

    /**
     * Converter.Factory，返回空会使用默认配置，默认配置请查看[Http]
     */
    open fun convertFactory(): Converter.Factory? {
        return null
    }

    /**
     * 基于[baseUrl]下的所有Service需要在此注册
     */
    abstract fun services(): ArrayList<Class<*>>

    /**
     * 是否开启http日志打印
     */
    abstract fun isEnableHttpLog(): Boolean

    /**
     * 是否可配置代理抓包
     */
    abstract fun isEnableProxy(): Boolean
}