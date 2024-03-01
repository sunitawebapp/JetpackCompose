package com.srcodecorner.auth0.ui.screens.ForgetPassword.state

import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInFormEvent

sealed class ForgetPasswordEvent {
    data class EmailChanged(var email: String) : ForgetPasswordEvent()

    object sendForVerify : ForgetPasswordEvent()
}