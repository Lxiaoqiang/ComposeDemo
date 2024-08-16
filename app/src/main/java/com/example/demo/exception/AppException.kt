package com.example.demo.exception

/**
 * 系统默认异常：捕获的异常暂时全部归类到这个code上，包括空指针这些异常，后面用到了可以扩展一下
 */
const val SYSTEM_ERROR_CODE = 1

class AppException(
    var errCode: Int,
    error: String?
) : Exception(error) {
    var errorMsg = error ?: "请求失败，请稍后再试"

    override fun toString(): String {
        return "errorCode: $errCode, errorMsg: $errorMsg"
    }
}