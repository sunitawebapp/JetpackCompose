package com.srcodecorner.auth0.ui.screens.SignIn.state

data class SignInState (
           var emailState : String="",
           var passwordState : String ="",
           var SignInStateError : SignInStateError = SignInStateError(),
           var isSignInSuccessful : Boolean = false
)

data class SignInStateError(
    var emailStateError : Boolean = false,
    var passwordStateError : Boolean = false,
    var emailError : String = "",
    var passwordError : String = ""

)