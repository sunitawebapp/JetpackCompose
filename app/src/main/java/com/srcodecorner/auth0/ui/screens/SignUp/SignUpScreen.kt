package com.srcodecorner.auth0.screens.auth.SignUp

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.PostOfficeAppRouter
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignIn.viewmodel.SignInViewModel
import com.srcodecorner.auth0.screens.auth.SignUp.ViewModel.SignUpViewModel
import com.srcodecorner.auth0.ui.screens.SignUp.state.SignUpFormEvent

@Composable
fun SignUpScreen(navController: NavController) {
    var signUpViewModel: SignUpViewModel = viewModel()


    var signUpState by remember {
        signUpViewModel.signUpState
    }



    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

        if (signUpState.isSignUpSuccessful) {
            navController.navigate(Screen.HomeScreen.route) {
                popUpTo(Screen.LoginScreen.route) {
                    inclusive = true
                }
            }
        }

        HeadingTextComponent(value = stringResource(R.string.sign_up))
        NormalTextComponent(value = stringResource(R.string.create_your_account), TextAlign.Center)
        SpacerComponent(30)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.username),
            value = signUpState.usernameState,
            onValueChange = {
                signUpViewModel.uiEvent(SignUpFormEvent.UsernameChanged(it))
            },
            icon = Icons.Default.Person,
            isError = signUpState.UsernameStateError,
            errorText = ""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.email),
            value = signUpState.emailState,
            onValueChange = {
                signUpViewModel.uiEvent(SignUpFormEvent.EmailChanged(it))
            },
            icon = Icons.Default.Email,
            isError = signUpState.emailStateError,
            errorText = ""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.password),
            value = signUpState.passwordState,
            onValueChange = {
                signUpViewModel.uiEvent(SignUpFormEvent.PasswordChanged(it))
            },
            icon = Icons.Default.Lock,
            isError = signUpState.passwordStateError,
            errorText = ""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.confirm_password),
            value = signUpState.confirmPasswordState,
            onValueChange = {
                signUpViewModel.uiEvent(SignUpFormEvent.ComfirmPasswordChanged(it))
            },
            icon = Icons.Default.Lock,
            isError = signUpState.confirmPasswordStateError,
            errorText = ""
        )
        SpacerComponent(50)
        ButtonComponent(
            value = stringResource(id = R.string.sign_up),
            onclick = { signUpViewModel.uiEvent(SignUpFormEvent.Submit) })
        SpacerComponent(20)
        NormalTextComponent(value = stringResource(R.string.or), TextAlign.Center)
        SpacerComponent(20)
        //   NormalTextComponent(value = stringResource(R.string.have_account_signin))

        TextButton(onClick = { PostOfficeAppRouter.navigateTo(Screens.LoginScreen) }) {
            NormalTextComponent(
                value = stringResource(id = R.string.have_account_signin),
                TextAlign.Center
            )
        }
    }

}

@Preview
@Composable
fun SignUpScreenPreview() {
    //SignUpScreen()
}