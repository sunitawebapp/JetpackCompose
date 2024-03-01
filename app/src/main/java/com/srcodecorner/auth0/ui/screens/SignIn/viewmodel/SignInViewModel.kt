package com.srcodecorner.auth0.screens.auth.SignIn.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInFormEvent


class SignInViewModel : ViewModel() {
    var signInState = mutableStateOf(SignInState())


    fun onEvent(event: SignInFormEvent) {
        when (event) {
            is SignInFormEvent.EmailChanged -> {
                signInState.value = signInState.value.copy(
                    emailState = event.email,
                    emailStateError = false
                )
            }
            is SignInFormEvent.PasswordChanged -> {
                signInState.value = signInState.value.copy(
                    passwordState = event.password,
                    passwordStateError = false
                )
            }

            is SignInFormEvent.Submit -> {
                userSignIn()
            }
        }
    }

    fun userSignIn() {
        if (isValidateUserSignIn()) {
            // navigateToDestination()
            signInState.value = signInState.value.copy(isLoginSuccessful = true)
        }
    }

    fun navigateToDestination() {

    }

    fun isValidateUserSignIn(): Boolean {
        var emailState = signInState.value.emailState
        var passwordState = signInState.value.passwordState

        return when {
            emailState.isEmpty() -> {
                signInState.value = signInState.value.copy(emailStateError = emailState.isEmpty())
                false
            }
            passwordState.isEmpty() -> {
                signInState.value =
                    signInState.value.copy(passwordStateError = passwordState.isEmpty())
                false
            }
            else -> {
                true
            }
        }
    }

}