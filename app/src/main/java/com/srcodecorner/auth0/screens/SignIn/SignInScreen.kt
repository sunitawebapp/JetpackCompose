package com.srcodecorner.auth0.screens.auth.SignIn

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    var TAG = "SignInScreen"
    val signInViewModel: SignInViewModel = viewModel()
    var emailState = signInViewModel.emailState.value
    var passwordState = signInViewModel.passwordState.value
    val context = LocalContext.current.applicationContext
    var email by remember { mutableStateOf(emailState) }
    var password by remember { mutableStateOf(passwordState) }

    val uiEventState = signInViewModel.uiEventLiveData.observeAsState()


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
            value = email,
            onValueChange = {
                email = it
                signInViewModel.setemail(it)
            }, Icons.Default.Email
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.password),
            value = password,
            onValueChange = {
                password = it
                signInViewModel.setpassword(it)
            }, Icons.Default.Lock
        )
        SpacerComponent(10)
        NormalTextComponent(value = stringResource(id = R.string.do_forgot_password), TextAlign.End)
        SpacerComponent(50)
        ButtonComponent(value = stringResource(id = R.string.signin),
            onclick = {
                signInViewModel.userSignin(navController)
                uiEventState.value?.let {
                    if (it.isNotEmpty()) {
                        showToast(context, it)
                    } else navController.navigate(Screen.HomeScreen.route)
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