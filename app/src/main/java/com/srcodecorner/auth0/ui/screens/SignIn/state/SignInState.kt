package com.srcodecorner.auth0.ui.screens.SignIn.state

data class SignInState(
    var emailState: String = "",
    var passwordState: String = "",

    var emailStateError: Boolean = false,
    var passwordStateError: Boolean = false,

    var emailError: String = "",

    val isLoginSuccessful: Boolean = false
    /*  var emailError : String = "",
      var passwordError : String = ""*/
/*
           val email: String = "",
           val emailError: String? = null,
           val password: String = "",
           val passwordError: String? = null,
           val repeatedPassword: String = "",
           val repeatedPasswordError: String? = null,
           val acceptedTerms: Boolean = false,
           val termsError: String? = null*/
)

data class SignInStateError(
    var emailStateError: Boolean = false,
    var passwordStateError: Boolean = false,
    var emailError: String = "",
    var passwordError: String = ""

)