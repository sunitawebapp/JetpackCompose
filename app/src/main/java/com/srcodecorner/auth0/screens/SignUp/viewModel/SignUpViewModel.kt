package com.srcodecorner.auth0.screens.auth.SignUp.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.navigation.Screens

class SignUpViewModel : ViewModel(){
    var name = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")

    fun userSignUp(navController: NavController){
       // navController.navigate(Screens.HomeScreen.route)
    }

    fun navigateSignIn(navController: NavController){
       // navController.navigate(Screens.LoginScreen.route)
    }
}