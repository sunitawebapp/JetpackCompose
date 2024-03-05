package com.srcodecorner.auth0.screens.auth.ForgetPassword.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.srcodecorner.auth0.navigation.NavigationRepository
import com.srcodecorner.auth0.navigation.NavigationRepositoryImpl
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.ui.screens.ForgetPassword.state.ForgetPasswordEvent
import com.srcodecorner.auth0.ui.screens.ForgetPassword.state.ForgetPasswordState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ForgetPasswordViewModel @Inject constructor() : ViewModel(){
    var forgetPasswordState = mutableStateOf(ForgetPasswordState())
    var forgetPasswordEvent = MutableSharedFlow<ForgetPasswordEvent>()
   private val  _eventFlow = MutableSharedFlow<ForgetPasswordEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


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
        if(isValidate()){
            navigateTo(Screen.VerificationScreen.route)
        }

    }

    fun navigateTo(destination: String) {
     viewModelScope.launch {
         forgetPasswordEvent.emit( ForgetPasswordEvent.NavigateEvent(destination))
     }




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