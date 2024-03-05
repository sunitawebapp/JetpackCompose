package com.srcodecorner.auth0.ui.screens.ForgetPassword


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.ui.screens.NewPasswordScreen.NewPasswordScreen
import com.srcodecorner.auth0.ui.screens.Verification.VerificationScreen
import com.srcodecorner.auth0.screens.auth.ForgetPassword.viewmodel.ForgetPasswordViewModel
import com.srcodecorner.auth0.ui.screens.ForgetPassword.state.ForgetPasswordEvent
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInFormEvent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun ForgetPasswordScreen(navController: NavController,forgetpasswordviewmodel : ForgetPasswordViewModel = hiltViewModel()) {


    var forgetPasswordState by remember {
        forgetpasswordviewmodel.forgetPasswordState
    }
   LaunchedEffect(key1 = ""){
       forgetpasswordviewmodel.forgetPasswordEvent.asSharedFlow().collectLatest {  event->
           when(event){
               is ForgetPasswordEvent.NavigateEvent ->{
                   navController.navigate(event.route)
               }
           }
       }
   }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        HeadingTextComponent(value = stringResource(R.string.forgot_password))
        SpacerComponent(size = 20)



        OutlineTextFieldIconCompent(
            labelValue =  stringResource(R.string.enter_email),
            value = forgetPasswordState.emailState,
            onValueChange = {
                forgetpasswordviewmodel.onEvent(ForgetPasswordEvent.EmailChanged(it))
            }, Icons.Default.Email,
            isError = forgetPasswordState.emailErrorState,
            errorText = ""
        )
        SpacerComponent(size = 50)
        ButtonComponent(value = stringResource(R.string.send)) {
            forgetpasswordviewmodel.onEvent(ForgetPasswordEvent.sendForVerify)
           // navController.navigate(Screen.VerificationScreen.route)
        }
    }
}


@Preview
@Composable
fun ForgetPasswordScreenPreview() {
    // ForgetPasswordScreen()
}