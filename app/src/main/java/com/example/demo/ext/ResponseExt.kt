package com.example.demo.ext

import com.example.demo.bean.response.BaseResponse
import com.example.demo.exception.AppException
import com.example.demo.exception.SYSTEM_ERROR_CODE
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 服务端返回值处理
 * 转成UIState
 *
 * @return [UIState.Success]
 * @throws [AppException] 如果服务端返回失败，抛出AppException
 */
fun <T> BaseResponse<T>.toUIStateOrThrows() = when {
    isSuccess() -> UIState.onSuccess(data)
    else -> throw AppException(errorCode, errorMsg)
}

fun <T> Throwable.toUIState() = UIState.onError<T>(this.toAppException())

fun <T> BaseResponse<T>.getSucceedResultOrThrows(): T? {
    return if (isSuccess()) data
    else throw AppException(errorCode, errorMsg)
}

fun <T> BaseResponse<T>.getSucceedResultOrNull(): T? {
    return if (isSuccess()) data
    else null
}

fun Throwable.toAppException(): AppException {
    return if (this is AppException) {
        this
    } else {
        val msg = when (this) {
            is SocketTimeoutException -> {
                "请求超时，请稍后再试"
            }
            is ConnectException -> {
                "请检查你的网络连接情况"
            }
            is SocketException -> {
                "网络连接异常，请重试"
            }
            is HttpException -> {
                "服务器异常，请稍后再试"
            }
            is UnknownHostException -> {
                "网络断开，请检查你的网络连接"
            }
            else -> {
                "数据异常，请稍后重试"
            }
        }

        AppException(SYSTEM_ERROR_CODE, msg)
    }
}