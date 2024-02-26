package com.srcodecorner.auth0.screens.auth.SignIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun SignInScreen(navController: NavController) {

   val signInViewModel : SignInViewModel = viewModel()
    var emailState = signInViewModel.emailState.value
    var passwordState = signInViewModel.passwordState.value

















    Column(modifier = Modifier.fillMaxSize()) {
        HeadingTextComponent(value = stringResource(id = R.string.welcome_back))
        TextFieldComponent(labelValue = stringResource(id = R.string.username))
        TextFieldComponent(labelValue = stringResource(id = R.string.password))
        ButtonComponent(value = stringResource(id = R.string.signin),
            onclick = {
                navController.navigate(Screen.RegistrationScreen.route)
            }
         )
    //    TextButtonComponent(value = stringResource(id = R.string.have_account_signup))

        TextButton(onClick = { PostOfficeAppRouter.navigateTo(Screens.RegistrationScreen) }) {
            NormalTextComponent(value = stringResource(id = R.string.have_account_signup))
        }
    }

}
@Preview
@Composable
fun SignInScreenPreview(){
    //SignInScreen(navController)
}