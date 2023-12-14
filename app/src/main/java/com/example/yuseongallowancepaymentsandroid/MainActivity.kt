package com.example.yuseongallowancepaymentsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yuseongallowancepaymentsandroid.data.api.ApiProvider
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
        ApiProvider.initialize(applicationContext)
    }

    @Composable
    fun BaseApp() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = AppNavigationItem.Apply.route,
        ){
        NavHost(navController = navController, startDestination = AppNavigationItem.Apply.route) {
            composable(AppNavigationItem.Apply.route) {
                ApplyScreen(
                    navController = navController,
                    moveToHonor = { navController.navigate(AppNavigationItem.Honor.route) },
                    moveToPartner = { navController.navigate(AppNavigationItem.Partner.route) },
                    moveToCourtesy = { navController.navigate(AppNavigationItem.Courtesy.route) },
                )
            }

            composable(AppNavigationItem.Login.route) {
                LoginScreen(navController = navController)
            }

            composable(AppNavigationItem.Honor.route) {
                HonorApplicationFormScreen(
                    navController = navController,
                )
            }

            composable(AppNavigationItem.Excel.route) {
                ExcelScreen(navController = navController)
            }

            composable(AppNavigationItem.Partner.route) {
                PartnerApplicationFormScreen(navController = navController)
            }

            composable(AppNavigationItem.Courtesy.route) {
                CourtesyApplicationFormScreen(navController = navController)
            }
        }
    }
}

