package com.example.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demo.constants.RouteUrls
import com.example.demo.page.login.LoginPage
import com.example.demo.page.MainPage
import com.example.demo.page.SplashPage
import com.example.demo.page.setting.SettingPage


object AppNavController {

    lateinit var instantce: NavHostController
}

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    startDestination: String = RouteUrls.SPLASH,
    onFinish:() -> Unit
) {
    AppNavController.instantce = navHostController
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(RouteUrls.SPLASH) {
            SplashPage()
        }
        composable(RouteUrls.LOGIN) {
            LoginPage()
        }
        composable(RouteUrls.MAIN) {
            MainPage()
        }
        composable(RouteUrls.SETTING) {
            SettingPage()
        }
    }
}