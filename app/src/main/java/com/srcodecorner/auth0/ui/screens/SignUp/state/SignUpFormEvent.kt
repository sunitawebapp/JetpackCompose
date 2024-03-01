package com.srcodecorner.auth0.ui.screens.SignUp.state


sealed class SignUpFormEvent {
    data class UsernameChanged(val username: String) : SignUpFormEvent()
    data class EmailChanged(val email: String) : SignUpFormEvent()
    data class PasswordChanged(val password: String) : SignUpFormEvent()
    data class ComfirmPasswordChanged(val confirmpassword: String) : SignUpFormEvent()

    object Submit : SignUpFormEvent()
}