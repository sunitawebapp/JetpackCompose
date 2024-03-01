package com.srcodecorner.auth0.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.srcodecorner.auth0.ui.screens.ForgetPassword.ForgetPasswordScreen
import com.srcodecorner.auth0.ui.screens.Home.HomeScreen
import com.srcodecorner.auth0.ui.screens.NewPasswordScreen.NewPasswordScreen
import com.srcodecorner.auth0.ui.screens.Verification.VerificationScreen
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignUp.SignUpScreen


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            SignInScreen(navController)

            //SignInScreen()
        }
        composable(route = Screen.RegistrationScreen.route) {
            SignUpScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)

        }
        composable(route = Screen.ForgotPasswordScreen.route) {
            ForgetPasswordScreen(navController)
        }
        composable(route = Screen.VerificationScreen.route) {
            VerificationScreen(navController)
        }
        composable(route = Screen.NewPasswordScreen.route) {
            NewPasswordScreen(navController)
        }

    }

}


