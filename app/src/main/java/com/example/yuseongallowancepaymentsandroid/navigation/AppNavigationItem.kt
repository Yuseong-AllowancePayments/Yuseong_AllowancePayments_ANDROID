package com.example.yuseongallowancepaymentsandroid.navigation

sealed class AppNavigationItem(val route: String) {

    object Application: AppNavigationItem("application")
    
    object Apply: AppNavigationItem("apply")

    object Login: AppNavigationItem("login")
}