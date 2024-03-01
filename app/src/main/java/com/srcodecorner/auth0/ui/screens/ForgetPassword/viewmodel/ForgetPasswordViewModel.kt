package com.srcodecorner.auth0.screens.auth.ForgetPassword.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.srcodecorner.auth0.navigation.NavigationRepositoryImpl
import com.srcodecorner.auth0.ui.screens.ForgetPassword.state.ForgetPasswordEvent
import com.srcodecorner.auth0.ui.screens.ForgetPassword.state.ForgetPasswordState



class ForgetPasswordViewModel  : ViewModel(){
    var forgetPasswordState = mutableStateOf(ForgetPasswordState())

    fun onEvent(event: ForgetPasswordEvent){
        when(event){
             is  ForgetPasswordEvent.EmailChanged->{
                 forgetPasswordState.value = forgetPasswordState.value.copy(emailState = event.email,emailErrorState = false)
            }
            is ForgetPasswordEvent.sendForVerify ->{
                sendVerify()
            }
        }
    }

    fun sendVerify(){
        isValidate()
    }

    fun isValidate() : Boolean{
        var email = forgetPasswordState.value.emailState
        return when{
            email.isEmpty() ->{
                forgetPasswordState.value = forgetPasswordState.value.copy(emailErrorState = true)
                false
            }else->{
                true
            }
        }
    }
}