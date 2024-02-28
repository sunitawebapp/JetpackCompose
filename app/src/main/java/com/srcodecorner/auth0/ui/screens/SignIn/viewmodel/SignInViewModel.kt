package com.srcodecorner.auth0.screens.auth.SignIn.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState
import com.srcodecorner.auth0.utils.Helper

class SignInViewModel : ViewModel(){
    var signInState  = mutableStateOf(SignInState())

    fun isValidateUserSignIn() : Boolean{
        var emailState = signInState.value.emailState
        var passwordState = signInState.value.passwordState
       return when{
           emailState.isEmpty()->{
               signInState.value.SignInStateError.emailStateError =true
               signInState.value.SignInStateError.emailError ="esrat"

               false
           }
           passwordState.isEmpty()->{
               signInState.value.SignInStateError.copy(passwordError = "")
              false
           }
           else-> {
               true
           }
       }
    }
}