package com.example.yuseongallowancepaymentsandroid.navigation

sealed class AppNavigationItem(val route: String) {

    object Apply: AppNavigationItem("apply")

    object Login: AppNavigationItem("login")
}