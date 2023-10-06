package com.example.yuseongallowancepaymentsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yuseongallowancepaymentsandroid.navigation.AppNavigationItem
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
        NavHost(navController = navController, startDestination = AppNavigationItem.Apply.route) {
            composable(AppNavigationItem.Apply.route) {
                ApplyScreen(navController = navController)
            }
            
            composable(AppNavigationItem.Login.route) {
                LoginScreen(navController = navController)
            }

            composable(AppNavigationItem.Application.route) {
                ApplicationFormScreen(navController = navController)
            }

            composable(AppNavigationItem.Excel.route) {
                ExcelScreen(navController = navController)
            }
        }
    }
}