package com.example.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.bean.response.BannerBean
import com.example.demo.domain.repository.Repository
import com.example.demo.ext.UIState
import com.example.demo.ext.launchWithCatch

class HomeViewModel: ViewModel() {

    private val repository = Repository()


    val bannerData = MutableLiveData<UIState<ArrayList<BannerBean>?>>()


    fun requestBanner() = launchWithCatch {
        repository.requestBanner().collect {
            bannerData.value = it
        }
    }
}