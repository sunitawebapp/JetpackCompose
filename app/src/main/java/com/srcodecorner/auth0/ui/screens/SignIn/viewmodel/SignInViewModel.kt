package com.srcodecorner.auth0.screens.auth.SignIn.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.srcodecorner.auth0.ui.screens.SignIn.ValidateEmail
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInStateError
import com.srcodecorner.auth0.utils.Helper
import com.srcodecorner.auth0.utils.SignInFormEvent
import kotlinx.coroutines.launch


class SignInViewModel : ViewModel(){
    var signInState  by mutableStateOf(SignInState())

    private val validateEmail: ValidateEmail = ValidateEmail()

    fun onEvent(event: SignInFormEvent) {
        when(event) {
            is SignInFormEvent.EmailChanged -> {
                signInState = signInState.copy(emailState = event.email)
            }
            is SignInFormEvent.PasswordChanged -> {
                signInState = signInState.copy(passwordState = event.password)
            }

            is SignInFormEvent.Submit -> {
                submitData()
            }
        }
    }
    private fun submitData(){
   // isValidateUserSignIn()
    val emailResult = validateEmail.execute(signInState.emailState)

          //  signInState = signInState.copy(SignInStateError = SignInStateError(emailError = emailResult.errorMessage!!))
        //    signInState = signInState.SignInStateError.emailError =
    val hasError = listOf(
        emailResult,

    ).any { !it.successful }

    if(hasError) {
        signInState.SignInStateError.emailError = emailResult.errorMessage!!
        return
    }


/*    if(hasError) {
        state = state.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            repeatedPasswordError = repeatedPasswordResult.errorMessage,
            termsError = termsResult.errorMessage
        )
        return
    }
    viewModelScope.launch {
        validationEventChannel.send(ValidationEvent.Success)
    }*/
  //  signInState.SignInStateError.emailError =emailResult.errorMessage!!

}
    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }

    fun isValidateUserSignIn() : Boolean{
        var emailState = signInState.emailState
        var passwordState = signInState.passwordState
       return when{
           emailState.isEmpty()->{

               signInState.SignInStateError.emailStateError =true
               signInState.SignInStateError.emailError ="Please enter email"

               false
           }
           passwordState.isEmpty()->{
               signInState.SignInStateError.copy(passwordStateError = true)
               signInState.SignInStateError.copy(passwordError = "pxdfg")
              false
           }
           else-> {
               true
           }
       }
    }
}