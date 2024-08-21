package com.example.demo.page.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demo.AppNavController
import com.example.demo.R
import com.example.demo.component.showToast
import com.example.demo.constants.RouteUrls
import com.example.demo.ui.theme.AppColorsProvider


@Composable
fun MinePage() {

    val viewModel: MineViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when(it) {
                is MineEvent.EventLogoutResult -> {
                    AppNavController.instantce.popBackStack()
                    AppNavController.instantce.navigate(RouteUrls.LOGIN)
                    showToast(it.msg)
                }
                is MineEvent.EventToEditBg -> {

                }
                is MineEvent.EventToSetting -> {
                    AppNavController.instantce.navigate(RouteUrls.SETTING)
                }
                is MineEvent.EventToAboutMe -> {

                }
            }
        }
    }
    MineScreen() { action ->
        viewModel.onEvent(action)
    }
}

@Composable
internal fun MineScreen(
    action: (MineAction) -> Unit
) {

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(AppColorsProvider.current.background)
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier.verticalScroll(scrollState, true)
        ) {
            MineItem(icon = painterResource(id = R.drawable.icon_setting), text = "切换背景") {
                action(MineAction.ActionToEditBg)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            MineItem(icon = painterResource(id = R.drawable.icon_setting), text = "设置") {
                action(MineAction.ActionToSetting)

            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            MineItem(icon = painterResource(id = R.drawable.icon_about_me), text = "关于我们") {
                action(MineAction.ActionToAboutMe)

            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    contentColor = AppColorsProvider.current.primary,
                    containerColor = AppColorsProvider.current.primary
                ),
                onClick = {
                    action(MineAction.ActionLogout)
                }
            ) {
                Text(text = "退出登录")
            }
        }
    }
}

@Composable
internal fun MineItem(
    icon: Painter,
    text: String,
    itemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 20.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(AppColorsProvider.current.card)
            .clickable {
                itemClick()
            }
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(22.dp),
                tint = AppColorsProvider.current.secondIcon
            )

            Text(
                text = text,
                style = TextStyle(
                    color = AppColorsProvider.current.secondText,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(start = 15.dp)
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.icon_arrow_right),
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            tint = Color.Black
        )
    }
}
