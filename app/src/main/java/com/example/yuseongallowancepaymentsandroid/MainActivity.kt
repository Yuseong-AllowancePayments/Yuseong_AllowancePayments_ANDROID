package com.example.yuseongallowancepaymentsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a01051355543.navigation.AppNavigationItem
import com.example.yuseongallowancepaymentsandroid.ui.theme.YuseongAllowancePaymentsANDROIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YuseongAllowancePaymentsANDROIDTheme {
                    BaseApp()
            }
        }
    }

    @Composable
    fun BaseApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = AppNavigationItem.APPLY.route) {
            composable(AppNavigationItem.APPLY.route) {
                ApplyScreen(navController = navController)
            }
        }
    }
}