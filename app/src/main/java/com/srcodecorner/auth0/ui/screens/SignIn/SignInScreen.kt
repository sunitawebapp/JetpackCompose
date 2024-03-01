package com.srcodecorner.auth0.screens.auth.SignIn

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
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
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInState

import com.srcodecorner.auth0.utils.Helper.showToast
import com.srcodecorner.auth0.ui.screens.SignIn.state.SignInFormEvent



@Composable
fun SignInScreen(navController: NavController) {
    val signInViewModel: SignInViewModel = viewModel()

    var signInState by remember {
        signInViewModel.signInState
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        if (signInState.isLoginSuccessful){
            navController.navigate(Screen.HomeScreen.route)
            {
                popUpTo(Screen.LoginScreen.route) {
                    inclusive = true
                }
            }

        }
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
                signInViewModel.onEvent(SignInFormEvent.EmailChanged(it))
            }, Icons.Default.Email,
            isError = signInState.emailStateError,
            errorText = signInState.emailError
        )


        SpacerComponent(10)

        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.password),
            value = signInState.passwordState,
            onValueChange = {
                signInViewModel.onEvent(SignInFormEvent.PasswordChanged(it))

            }, Icons.Default.Lock,
            isError = signInState.passwordStateError,
            errorText = signInState.emailError
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

                signInViewModel.onEvent(SignInFormEvent.Submit)


            }
        )

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