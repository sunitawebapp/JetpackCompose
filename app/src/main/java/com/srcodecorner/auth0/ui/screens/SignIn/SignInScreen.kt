package com.srcodecorner.auth0.screens.auth.SignIn

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.NavigationGraph
import com.srcodecorner.auth0.navigation.PostOfficeAppRouter
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.screens.auth.SignIn.viewmodel.SignInViewModel

import com.srcodecorner.auth0.utils.Helper.showToast


@Composable
fun SignInScreen(navController: NavController) {
    val signInViewModel: SignInViewModel = viewModel()

    val context = LocalContext.current.applicationContext

    var signInState by remember {
        signInViewModel.signInState
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        HeadingTextComponent(value = stringResource(id = R.string.welcome_back))
        NormalTextComponent(
            value = stringResource(id = R.string.sign_to_continue),
            TextAlign.Center
        )
        SpacerComponent(60)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.email),
            value = signInState.emailState,
            onValueChange = {
               signInViewModel.signInState.value = signInState.copy(
                   emailState = it
               )

            }, Icons.Default.Email,
           isError = signInState.SignInStateError.emailStateError,
            errorText =signInState.SignInStateError.emailError
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.password),
            value = signInState.passwordState,
            onValueChange = {
                signInViewModel.signInState.value = signInState.copy(passwordState = it)
            }, Icons.Default.Lock,
            isError = signInState.SignInStateError.passwordStateError,
            errorText =""
        )



        SpacerComponent(10)

        TextButton(onClick = { navController.navigate(Screen.ForgotPasswordScreen.route) }) {
            NormalTextComponent(
                value = stringResource(id = R.string.do_forgot_password),
                TextAlign.End
            )
        }
        SpacerComponent(50)
        ButtonComponent(value = stringResource(id = R.string.signin),
            onclick = {
               if (signInViewModel.isValidateUserSignIn()){
                   navController.navigate(Screen.HomeScreen.route)
               }else{
                   Log.d("djikfh", "SignInScreen: "+signInState.SignInStateError.emailStateError)
               }
            }
        )
        //    TextButtonComponent(value = stringResource(id = R.string.have_account_signup))


        TextButton(onClick = { navController.navigate(Screen.RegistrationScreen.route) }) {
            NormalTextComponent(
                value = stringResource(id = R.string.have_account_signup),
                TextAlign.Center
            )
        }
    }

}

@Preview
@Composable
fun SignInScreenPreview() {
    //SignInScreen(navController)
}