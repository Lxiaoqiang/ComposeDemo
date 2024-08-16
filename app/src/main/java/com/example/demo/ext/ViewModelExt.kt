package com.example.demo.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.exception.AppException
import kotlinx.coroutines.CoroutineScope

/**
 * 异常兜底启动器
 */
fun ViewModel.launchWithCatch(
    customErrorHandler: ((exception: AppException) -> Unit)? = null,
    block: suspend CoroutineScope.() -> Unit,
) = viewModelScope.launchWithCatch(customErrorHandler, block)