package com.srcodecorner.auth0.ui.screens.SignUp.state

data class SignUpState (
    var UsernameState : String="",
    var emailState : String="",
    var passwordState : String ="",
    var confirmPasswordState : String ="",

    var UsernameStateError : Boolean = false,
    var emailStateError : Boolean = false,
    var passwordStateError : Boolean = false,
    var confirmPasswordStateError : Boolean = false,

    var emailError : String = "",

    val isSignUpSuccessful: Boolean = false
    )