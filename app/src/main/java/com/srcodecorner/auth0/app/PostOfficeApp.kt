package com.srcodecorner.auth0.app

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import com.srcodecorner.auth0.navigation.PostOfficeAppRouter
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignUp.SignUpScreen

//
@Composable
fun PostOfficeApp(){
    Crossfade(targetState =PostOfficeAppRouter.currentScreen ) { currentState->
        when(currentState.value){
            is Screens.LoginScreen -> {
                //SignInScreen( )
            }
            is Screens.RegistrationScreen -> {
               // SignUpScreen( )
            }
        }
    }
}