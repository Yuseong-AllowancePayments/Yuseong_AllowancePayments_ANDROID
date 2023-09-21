package com.example.a01051355543.navigation

sealed class AppNavigationItem(val route: String) {

    object APPLY: AppNavigationItem("apply")
}