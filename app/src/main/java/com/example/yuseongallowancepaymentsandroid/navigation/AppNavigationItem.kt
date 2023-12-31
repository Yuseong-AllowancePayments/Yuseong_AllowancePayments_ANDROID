package com.example.yuseongallowancepaymentsandroid.navigation

sealed class AppNavigationItem(val route: String) {

    object Application : AppNavigationItem("application")

    object Apply : AppNavigationItem("apply")

    object Login : AppNavigationItem("login")

    object Excel : AppNavigationItem("excel")
    object Honor : AppNavigationItem("honor")
    object Partner : AppNavigationItem("partner")
    object Courtesy : AppNavigationItem("courtesy")
}