package com.starglen.zawadimart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.navigation.ROUT_HOME
import com.navigation.ROUT_ABOUT
import com.navigation.ROUT_ASSIGNMENT
import com.navigation.ROUT_DASHBOARD
import com.navigation.ROUT_FORM
import com.navigation.ROUT_FORM1
import com.navigation.ROUT_INTENT
import com.navigation.ROUT_ITEM
import com.navigation.ROUT_SERVICE
import com.navigation.ROUT_SPLASH
import com.navigation.ROUT_START
import com.starglen.zawadimart.ui.screens.about.AboutScreen
import com.starglen.zawadimart.ui.screens.assignment.AssignmentScreen
import com.starglen.zawadimart.ui.screens.dashboard.DashboardScreen
import com.starglen.zawadimart.ui.screens.form1.Form1Screen
import com.starglen.zawadimart.ui.screens.formscreen.FormScreen
import com.starglen.zawadimart.ui.screens.home.HomeScreen
import com.starglen.zawadimart.ui.screens.intent.IntentScreen
import com.starglen.zawadimart.ui.screens.items.ItemsScreen
import com.starglen.zawadimart.ui.screens.service.ServiceScreen
import com.starglen.zawadimart.ui.screens.splash.SplashScreen
import com.starglen.zawadimart.ui.screens.splash.SplashScreenPreview
import com.starglen.zawadimart.ui.screens.start.StartScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_FORM
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemsScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_ASSIGNMENT) {
            AssignmentScreen(navController)
        }
        composable(ROUT_FORM) {
            FormScreen(navController)
        }
        composable(ROUT_FORM1) {
            Form1Screen(navController)
        }

    }
}