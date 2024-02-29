package com.srcodecorner.auth0.ui.screens.SignIn.state



sealed class SignInFormEvent {

    data class EmailChanged(val email: String) : SignInFormEvent()
    data class PasswordChanged(val password: String) : SignInFormEvent()


    object Submit: SignInFormEvent()
}