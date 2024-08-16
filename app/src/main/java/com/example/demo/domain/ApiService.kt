package com.example.demo.domain

import com.example.demo.bean.response.BannerBean
import com.example.demo.bean.response.BaseResponse
import com.example.demo.http.Http
import retrofit2.http.GET

interface ApiService {

    companion object {

        val INSTANCE = Http.getService(ApiService::class.java)
    }


    @GET("banner/json")
    suspend fun requestBanner(): BaseResponse<ArrayList<BannerBean>?>
}