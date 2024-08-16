package com.example.demo.bean.response

class BaseResponse<T> @JvmOverloads constructor(
    val data: T? = null,
    val errorCode: Int,
    val errorMsg: String? = null,
    val extra: Any? = null
) {

    fun isSuccess() = errorCode == 0
}