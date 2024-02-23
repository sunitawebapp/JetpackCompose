package com.srcodecorner.auth0.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screens (val route: String) {
    object LoginScreen : Screens("LoginScreen")
    object RegistrationScreen : Screens("RegistrationScreen")
    object ForgotPasswordScreen : Screens("ForgotPasswordScreen")
    object VerificationScreen : Screens("VerificationScreen")
    object NewPasswordScreen : Screens("NewPasswordScreen")
    object HomeScreen : Screens("HomeScreen")

}
object PostOfficeAppRouter {
    var currentScreen : MutableState<Screens> = mutableStateOf(Screens.RegistrationScreen)

    fun navigateTo(destination : Screens){
        currentScreen.value = destination
    }
}