package com.srcodecorner.auth0.screens.auth.SignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.PostOfficeAppRouter
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignUp.ViewModel.SignUpViewModel

@Composable
fun SignUpScreen() {

    val signUpViewModel : SignUpViewModel = SignUpViewModel()



















    Column(Modifier.fillMaxSize()) {

        HeadingTextComponent(value = stringResource(R.string.sign_up))
        NormalTextComponent(value = stringResource(R.string.create_your_account))
        TextFieldComponent(labelValue = stringResource(id = R.string.username))
        SpacerComponent(10)
        TextFieldComponent(labelValue = stringResource(id = R.string.email))
        SpacerComponent(10)
        TextFieldComponent(labelValue = stringResource(id = R.string.password))
        SpacerComponent(10)
        TextFieldComponent(labelValue = stringResource(id = R.string.confirm_password))
        SpacerComponent(50)
        ButtonComponent(value = stringResource(id = R.string.sign_up), onclick = {PostOfficeAppRouter.navigateTo(Screens.LoginScreen)})
        SpacerComponent(20)
        NormalTextComponent(value = stringResource(R.string.or))
        SpacerComponent(20)
     //   NormalTextComponent(value = stringResource(R.string.have_account_signin))

        TextButton(onClick = { PostOfficeAppRouter.navigateTo(Screens.LoginScreen) }) {
            NormalTextComponent(value = stringResource(id = R.string.have_account_signin))
        }
    }

}

@Preview
@Composable
fun SignUpScreenPreview(){
    //SignUpScreen()
}