package com.example.yuseongallowancepaymentsandroid.navigation

sealed class AppNavigationItem(val route: String) {

    object APPLY: AppNavigationItem("apply")

    object Application: AppNavigationItem("application")
}