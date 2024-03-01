package com.srcodecorner.auth0.ui.screens.NewPasswordScreen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NewPasswordViewModel : ViewModel() {
    var newPassword = mutableStateOf("")
    var conformPassword = mutableStateOf("")

}