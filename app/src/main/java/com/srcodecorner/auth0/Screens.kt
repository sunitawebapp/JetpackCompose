package com.srcodecorner.auth0

sealed class Screens (val route: String) {
    object Login : Screens("LoginScreen")
    object Registration : Screens("RegistrationScreen")
    object ForgotPassword : Screens("ForgotPasswordScreen")
    object VerificationScreen : Screens("VerificationScreen")
    object NewPasswordScreen : Screens("NewPasswordScreen")

}