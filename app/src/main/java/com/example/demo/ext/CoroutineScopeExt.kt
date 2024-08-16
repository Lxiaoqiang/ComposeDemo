package com.example.demo.ext

import com.example.demo.exception.AppException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * 异常兜底启动器
 */
fun CoroutineScope.launchWithCatch(
    customErrorHandler: ((exception: AppException) -> Unit)? = null,
    block: suspend CoroutineScope.() -> Unit,
): Job {
    val h = CoroutineExceptionHandler { _, e ->
//        if (BuildConfig.DEBUG) e.printStackTrace()
        customErrorHandler?.invoke(e.toAppException())
    }
    return launch(h, block = block)
}

/**
 * 定时器，先回调一次再delay
 */
fun countDownCoroutines(
    total: Int,
    scope: CoroutineScope,
    onTick: (Int) -> Unit,
    onStart: (() -> Unit)? = null,
    onFinish: (() -> Unit)? = null,
): Job {
    return flow {
        for (i in 0 until total) {
            emit(i)
            delay(1000)
        }
    }.flowOn(Dispatchers.Main)
        .onStart { onStart?.invoke() }
        .onCompletion { onFinish?.invoke() }
        .onEach { onTick.invoke(it) }
        .launchIn(scope)
}

/**
 * 定时器，先delay一次再回调
 */
fun countDownCoroutinesDelay(
    total: Int,
    scope: CoroutineScope,
    onTick: (Int) -> Unit,
    tickTime: Long = 1000,
    onStart: (() -> Unit)? = null,
    onFinish: (() -> Unit)? = null,
): Job {
    return flow {
        for (i in 0 until total) {
            delay(tickTime)
            emit(i)
        }
    }.flowOn(Dispatchers.Main)
        .onStart { onStart?.invoke() }
        .onCompletion { onFinish?.invoke() }
        .onEach { onTick.invoke(it) }
        .launchIn(scope)
}