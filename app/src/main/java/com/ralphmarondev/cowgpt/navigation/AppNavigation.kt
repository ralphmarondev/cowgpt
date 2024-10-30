package com.ralphmarondev.cowgpt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.cowgpt.features.home.presentation.HomeScreen
import com.ralphmarondev.cowgpt.features.onboarding.presentation.OnBoardingScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.OnBoarding
    ) {
        composable<Routes.OnBoarding> {
            OnBoardingScreen(
                navigateToHome = {
                    navController.navigate(Routes.Home)
                }
            )
        }
        composable<Routes.Home> {
            HomeScreen()
        }
    }
}