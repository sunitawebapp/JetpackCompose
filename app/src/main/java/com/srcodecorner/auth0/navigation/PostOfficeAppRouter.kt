package com.srcodecorner.auth0.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screens () {
    object LoginScreen : Screens()
    object RegistrationScreen : Screens()
    object ForgotPasswordScreen : Screens()
    object VerificationScreen : Screens()
    object NewPasswordScreen : Screens()
    object HomeScreen : Screens()

}

sealed class Screen (var route : String) {
    object LoginScreen : Screen("LoginScreen")
    object RegistrationScreen : Screen("RegistrationScreen")
    object ForgotPasswordScreen : Screen("ForgotPasswordScreen")
    object VerificationScreen : Screen("VerificationScreen")
    object NewPasswordScreen : Screen("NewPasswordScreen")
    object HomeScreen : Screen("HomeScreen")

}
object PostOfficeAppRouter {
    var currentScreen : MutableState<Screens> = mutableStateOf(Screens.RegistrationScreen)

    fun navigateTo(destination : Screens){
        currentScreen.value = destination
    }
}