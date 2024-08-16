package com.example.demo.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demo.AppNavController
import com.example.demo.R
import com.example.demo.constants.RouteUrls
import com.example.demo.data.AppGlobalData
import com.example.demo.ui.theme.AppColorsProvider
import kotlinx.coroutines.delay


@Composable
fun SplashPage() {

    LaunchedEffect(Unit) {
        delay(2000)
        AppNavController.instantce.popBackStack()
        val loginData = AppGlobalData.loginData
        AppNavController.instantce.navigate(if(loginData == null) RouteUrls.LOGIN else RouteUrls.MAIN)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColorsProvider.current.primary),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(190.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cockroach),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(50.dp)
                    .clip(RoundedCornerShape(50)),
                tint = AppColorsProvider.current.primaryVariant
            )
        }
    }
}
