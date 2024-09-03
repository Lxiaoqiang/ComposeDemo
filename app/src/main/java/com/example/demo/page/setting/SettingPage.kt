package com.example.demo.page.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demo.AppNavController
import com.example.demo.ui.theme.AppColorsProvider
import com.example.demo.ui.widget.AppTitleBar
import com.example.demo.ui.widget.AppTitleBarParameter
import com.example.demo.ui.widget.AppTitleBarParameterType


@Composable
fun SettingPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColorsProvider.current.background)
    ) {

        Column {
            AppTitleBar(
                parameter = AppTitleBarParameter(
                    title = AppTitleBarParameterType.TitleText("设置")
                )
            ) {
                AppNavController.instantce.navigateUp()
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
            Text(text = "设置中心", modifier = Modifier)
        }

    }

}
