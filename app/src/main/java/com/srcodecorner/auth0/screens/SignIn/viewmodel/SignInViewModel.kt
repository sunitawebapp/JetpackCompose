package com.srcodecorner.auth0.screens.auth.SignIn.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.srcodecorner.auth0.NavGraph
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.navigation.Screens

class SignInViewModel : ViewModel(){
    val TAG= javaClass.simpleName
    var emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")

    //User click on Login Button
    fun userSignin(navController : NavController){
      navController.navigate(Screens.HomeScreen.route)
    }


    //navigate sign up
    fun navigateSignUp(navController : NavController){
         navController.navigate(Screens.RegistrationScreen.route)
    }

    fun isValidate(): Boolean{
        if(emailState.value.equals("")){
            Log.d(TAG, "isValidate: ")
        }
        return false
    }
}