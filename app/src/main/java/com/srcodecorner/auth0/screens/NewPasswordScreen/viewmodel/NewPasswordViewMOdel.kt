package com.srcodecorner.auth0.screens.NewPasswordScreen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NewPasswordViewModel : ViewModel(){
    var newPassword = mutableStateOf("")
    var conformPassword = mutableStateOf("")

}