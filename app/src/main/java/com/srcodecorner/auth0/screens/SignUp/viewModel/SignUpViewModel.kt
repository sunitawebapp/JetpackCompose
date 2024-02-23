package com.srcodecorner.auth0.screens.auth.SignUp.ViewModel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.navigation.Screens

class SignUpViewModel : ViewModel(){


    fun userSignUp(navController: NavController){
        navController.navigate(Screens.HomeScreen.route)
    }

    fun navigateSignIn(navController: NavController){
        navController.navigate(Screens.LoginScreen.route)
    }
}