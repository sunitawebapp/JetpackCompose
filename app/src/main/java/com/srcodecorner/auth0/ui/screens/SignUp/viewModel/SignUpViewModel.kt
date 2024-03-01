package com.srcodecorner.auth0.screens.auth.SignUp.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState
import com.srcodecorner.auth0.ui.screens.SignUp.state.SignUpFormEvent
import com.srcodecorner.auth0.ui.screens.SignUp.state.SignUpState

class SignUpViewModel : ViewModel() {
    var signUpState = mutableStateOf(SignUpState())

    fun uiEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.UsernameChanged -> {
                signUpState.value = signUpState.value.copy(
                    usernameState = event.username,
                    UsernameStateError = false
                )
            }

            is SignUpFormEvent.EmailChanged -> {
                signUpState.value =
                    signUpState.value.copy(emailState = event.email, emailStateError = false)
            }

            is SignUpFormEvent.PasswordChanged -> {
                signUpState.value = signUpState.value.copy(
                    passwordState = event.password,
                    passwordStateError = false
                )
            }

            is SignUpFormEvent.ComfirmPasswordChanged -> {
                signUpState.value = signUpState.value.copy(
                    confirmPasswordState = event.confirmpassword,
                    confirmPasswordStateError = false
                )
            }
            is SignUpFormEvent.Submit -> {
                userSignUp()
            }
        }
    }

    fun userSignUp() {
        if (isValidateSignUp()) {
            signUpState.value = signUpState.value.copy(isSignUpSuccessful = true)
        }

    }

    fun isValidateSignUp(): Boolean {
        var username = signUpState.value.usernameState
        var email = signUpState.value.emailState
        var password = signUpState.value.passwordState
        var confirmpassword = signUpState.value.confirmPasswordState
        return when {
            username.isEmpty() -> {
                signUpState.value = signUpState.value.copy(UsernameStateError = username.isEmpty())
                false
            }
            email.isEmpty() -> {
                signUpState.value = signUpState.value.copy(emailStateError = email.isEmpty())
                false
            }
            password.isEmpty() -> {
                signUpState.value = signUpState.value.copy(emailStateError = password.isEmpty())
                false
            }
            confirmpassword.isEmpty() -> {
                signUpState.value =
                    signUpState.value.copy(emailStateError = confirmpassword.isEmpty())
                false
            }
            else -> {

                true
            }
        }
    }

}