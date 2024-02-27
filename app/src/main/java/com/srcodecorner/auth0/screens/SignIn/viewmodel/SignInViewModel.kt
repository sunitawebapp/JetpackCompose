package com.srcodecorner.auth0.screens.auth.SignIn.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.utils.Helper

class SignInViewModel : ViewModel(){
    var uiEventLiveData : MutableLiveData<String> = MutableLiveData()

     val emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")

    fun setemail(email: String){
        emailState.value =  email
    }
    fun setpassword(password: String){
        passwordState.value =  password
    }

    //User click on Login Button
    fun userSignin(navController : NavController){
        if (isValidate()){

        }

    }


    fun isValidate(): Boolean{
       if(emailState.value.isEmpty()) updateData("Enter Email Address")
       else if(!Helper.checkEmail(emailState.value)) updateData("Please enter vaild email address")
       else if(passwordState.value.isEmpty()) updateData("Enter Password")
       else {
           updateData("")
           return true
       }
        return false
    }
    // Function to update data
    fun updateData(newData: String) {
        uiEventLiveData.value = newData
    }



}