package com.starglen.zawadimart.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.data.UserDatabase
import com.navigation.ROUT_HOME
import com.navigation.ROUT_ABOUT
import com.navigation.ROUT_ADD_PRODUCT
import com.navigation.ROUT_ASSIGNMENT
import com.navigation.ROUT_DASHBOARD
import com.navigation.ROUT_EDIT_PRODUCT
import com.navigation.ROUT_FORM
import com.navigation.ROUT_FORM1
import com.navigation.ROUT_INTENT
import com.navigation.ROUT_ITEM
import com.navigation.ROUT_LOGIN
import com.navigation.ROUT_PRODUCT_LIST
import com.navigation.ROUT_REGISTER
import com.navigation.ROUT_SERVICE
import com.navigation.ROUT_SPLASH
import com.navigation.ROUT_START
import com.repository.UserRepository
import com.starglen.zawadimart.ui.screens.about.AboutScreen
import com.starglen.zawadimart.ui.screens.assignment.AssignmentScreen
import com.starglen.zawadimart.ui.screens.auth.LoginScreen
import com.starglen.zawadimart.ui.screens.auth.RegisterScreen
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
import com.starglen.zawadimart.ui.theme.screens.products.AddProductScreen
import com.starglen.zawadimart.ui.theme.screens.products.EditProductScreen
import com.starglen.zawadimart.ui.theme.screens.products.ProductListScreen
import com.viewmodel.AuthViewModel
import com.viewmodel.ProductViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ADD_PRODUCT,
    productViewModel: ProductViewModel = viewModel(),
) {
    val context = LocalContext.current

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
        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }



    }

}