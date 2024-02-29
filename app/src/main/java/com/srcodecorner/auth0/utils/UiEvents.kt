package com.srcodecorner.auth0.utils

sealed class SignInFormEvent{
    data class EmailChanged(val email: String) : SignInFormEvent()
    data class PasswordChanged(val password: String) : SignInFormEvent()
    data class RepeatedPasswordChanged(
        val repeatedPassword: String
    ) : SignInFormEvent()


    object Submit: SignInFormEvent()
}