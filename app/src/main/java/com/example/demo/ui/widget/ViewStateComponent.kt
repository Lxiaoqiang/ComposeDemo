package com.example.demo.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.R
import com.example.demo.exception.AppException
import com.example.demo.ext.UIState
import com.example.demo.ui.theme.AppColorsProvider


@Composable
fun <T> ViewStateComponent(
    uiState: UIState<T>?,
    loadData: ((clickState: ClickState) -> Unit)? = null,
    loadingComponent: @Composable (() -> Unit)? = null,
    errorComponent: @Composable ((e: AppException) -> Unit)? = null,
    emptyComponent: @Composable (() -> Unit)? = null,
    successComponent: @Composable ((data: T?) -> Unit)? = null
) {


    when (uiState) {
        is UIState.Success -> {
            if (uiState.data == null) {
                if (errorComponent != null) {
                    emptyComponent?.invoke()
                } else {
                    ViewCommonStateComponent(clickState = ClickState.EMPTY, click = loadData)
                }
            } else {
                successComponent?.invoke(uiState.data)
            }
        }

        is UIState.Loading -> {
        }

        is UIState.Error -> {
            if (errorComponent != null) {
                errorComponent.invoke(uiState.error)
            } else {
                ViewCommonStateComponent(clickState = ClickState.ERROR, emptyMsg = uiState.error.errorMsg, click = loadData)
            }
        }

        else -> {}
    }
}


@Composable
fun ViewCommonStateComponent(
    emptyIcon: Painter = painterResource(id = R.drawable.error),
    emptyMsg: String = "发生错误了~",
    clickState: ClickState? = null,
    click: ((clickState: ClickState) -> Unit)? = null
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(AppColorsProvider.current.background)
            .clickable {
                click?.invoke(clickState ?: ClickState.EMPTY)
            }
    ) {
        Image(
            modifier = Modifier.size(88.dp),
            painter = emptyIcon,
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = emptyMsg,
            style = TextStyle(
                fontSize = 16.sp,
                color = AppColorsProvider.current.secondText
            )
        )
    }
}

enum class ClickState {
    ERROR,
    EMPTY
}