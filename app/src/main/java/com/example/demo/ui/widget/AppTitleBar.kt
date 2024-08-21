package com.example.demo.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.R
import com.example.demo.ui.theme.AppColorsProvider


@Composable
fun AppTitleBar(
    leftIcon: Painter = painterResource(id = R.drawable.icon_back),
    backgroundColor: Color = AppColorsProvider.current.primary,
    modifier: Modifier = Modifier,
    parameter: AppTitleBarParameter = AppTitleBarParameter(),
    click: ((AppTitleBarClickType) -> Unit)? = null
) {

    val param = remember {
        parameter
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor)
    ) {

        Icon(
            painter = leftIcon,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .padding(start = 20.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    if (click != null) {
                        click(AppTitleBarClickType.CLICK_LEFT)
                    }
                }
        )

        if (param.title?.text?.isNotEmpty() == true) {
            Text(
                text = param.title.text,
                style = TextStyle(color = param.title.textColor, fontSize = param.title.textSize),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        when(param.menu?.menu) {
            is MenuParameter.MenuIcon -> {
                val menu = param.menu.menu as MenuParameter.MenuIcon
                Icon(
                    painter = menu.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(50.dp)
                        .padding(end = 10.dp)
                        .align(Alignment.CenterEnd)
                        .clickable {
                            if (click != null) {
                                click(AppTitleBarClickType.CLICK_RIGHT)
                            }
                        }
                )
            }
            is MenuParameter.MenuText -> {
                val menu = param.menu.menu as MenuParameter.MenuText
                if (menu.text?.isNotEmpty() == true) {
                    Text(
                        text = menu.text,
                        style = TextStyle(color = menu.textColor, fontSize = menu.textSize),
                        modifier = Modifier.padding(end = 10.dp)
                            .align(Alignment.CenterEnd)
                            .clickable {
                                if (click != null) {
                                    click(AppTitleBarClickType.CLICK_RIGHT)
                                }
                            }
                    )
                }
            }
            null -> return@Box
        }
    }
}

enum class AppTitleBarClickType {
    CLICK_LEFT,
    CLICK_RIGHT
}

data class AppTitleBarParameter(
    val title: AppTitleBarParameterType.TitleText? = null,
    val menu: AppTitleBarParameterType.Menu? = null
)

sealed interface AppTitleBarParameterType {

    data class TitleText(val text: String? = null, val textSize: TextUnit = 18.sp, val textColor: Color = Color.Black) : AppTitleBarParameterType

    data class Menu(val menu: MenuParameter) : AppTitleBarParameterType
}

sealed interface MenuParameter {

    data class MenuIcon(val icon: Painter) : MenuParameter

    data class MenuText(val text: String?, val textSize: TextUnit = 14.sp, val textColor: Color = Color.Black) : MenuParameter
}