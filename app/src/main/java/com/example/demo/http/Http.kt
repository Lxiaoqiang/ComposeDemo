package com.example.demo.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

/**
 * 网络请求封装类
 * createTime：7/2/21
 * author：lhq
 * desc:
 * 需要配合[BaseHttpConfig]使用，
 * <p>
 *   使用步骤：
 *   1.在发起网络请求之前调用[init]
 *   2.通过[getService]获取到接口对象，发起网络请求
 *
 *
 */
object Http {

    private val retrofits = HashMap<String, Retrofit>()

    fun <T : BaseHttpConfig> init(configs: ArrayList<T>) {
        for (config in configs) {
            val builder = Retrofit.Builder()
            builder.baseUrl(config.baseUrl())
            config.callAdapterFactory()?.let {
                builder.addCallAdapterFactory(it)
            }
            config.convertFactory()?.let {
                builder.addConverterFactory(it)
            } ?: builder.addConverterFactory(GsonConverterFactory.create())
            config.client(
                getDefaultClientBuilder(
                    config.isEnableHttpLog(),
                    config.isEnableProxy()
                )
            ).let {
                builder.client(it)
            } ?: run {
                builder.client(getDefaultClientBuilder().build())
            }
            config.services().forEach {
                retrofits[it.name] = builder.build()
            }
        }
    }

    fun <T> getService(clazz: Class<T>): T {
        if (retrofits[clazz.name] == null) {
            throw RuntimeException("must call Http#init before method of getService")
        }
        return retrofits[clazz.name]!!.create(clazz)
    }

    /**
     * 获取默认公共配置的OkhttpClientBuilder
     * @param isEnableHttpLog 是否开启http log打印，默认打印
     * @param isEnableProxy 是否可代理抓包，默认可以
     */
    private fun getDefaultClientBuilder(
        isEnableHttpLog: Boolean = true,
        isEnableProxy: Boolean = true
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {

            if (isEnableHttpLog) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
            if (!isEnableProxy) {
                proxy(Proxy.NO_PROXY)
            }
            connectTimeout(5 * 10000, TimeUnit.MILLISECONDS)
            readTimeout(5 * 10000, TimeUnit.MILLISECONDS)
            writeTimeout(5 * 10000, TimeUnit.MILLISECONDS)
        }
    }
}