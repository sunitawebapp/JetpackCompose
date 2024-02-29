package com.srcodecorner.auth0.ui.screens.SignUp.state



sealed class SignUpFormEvent {
    data class UsernameChanged(val email: String) : SignUpFormEvent()
    data class EmailChanged(val email: String) : SignUpFormEvent()
    data class PasswordChanged(val password: String) : SignUpFormEvent()
    data class comfirmPasswordChanged(val password: String) : SignUpFormEvent()

    object Submit: SignUpFormEvent()
}