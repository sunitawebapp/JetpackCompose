package com.srcodecorner.auth0.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.srcodecorner.auth0.screens.Home.HomeScreen
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignUp.SignUpScreen


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ){
        composable(route = Screen.LoginScreen.route) {
            SignInScreen(navController)
            //SignInScreen()
        }
        composable(route = Screen.RegistrationScreen.route) {
            SignUpScreen()
        }
        composable(route = Screen.HomeScreen.route) {
         //   HomeScreen()
        }

    }

}

@Preview
@Composable
fun PreviewOfNavigationGraph(){
    NavigationGraph()
}
