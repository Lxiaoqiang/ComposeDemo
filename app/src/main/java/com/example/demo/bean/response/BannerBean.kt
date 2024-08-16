package com.example.demo.bean.response

data class BannerBean(
    val desc: String? = null,
    val id: Long,
    val imagePath: String? = null,
    val isVisible: Int,
    val order: Int,
    val title: String? = null,
    val url: String? = null
)
