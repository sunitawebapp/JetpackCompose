package com.srcodecorner.auth0.screens.auth.SignUp.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState
import com.srcodecorner.auth0.ui.screens.SignUp.state.SignUpState

class SignUpViewModel : ViewModel(){


    var signUpState = mutableStateOf(SignUpState())

    fun uiEvent(){

    }

    fun userSignUp(){

    }

    fun navigateSignIn(){

    }
}