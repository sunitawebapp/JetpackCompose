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
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignIn.viewmodel.SignInViewModel
import com.srcodecorner.auth0.screens.auth.SignUp.ViewModel.SignUpViewModel

@Composable
fun SignUpScreen(navController: NavController) {
    var signUpViewModel : SignUpViewModel= viewModel()


   var signUpState by remember {
      signUpViewModel.signUpState
   }



    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

        HeadingTextComponent(value = stringResource(R.string.sign_up))
        NormalTextComponent(value = stringResource(R.string.create_your_account), TextAlign.Center)
        SpacerComponent(30)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.username),
            value = signUpState.UsernameState,
            onValueChange = {},
            icon = Icons.Default.Person,
            false,
            errorText =""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.email),
            value = signUpState.emailState,
            onValueChange = {},
            icon = Icons.Default.Email,
            false,
            errorText =""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.password),
            value = signUpState.passwordState,
            onValueChange = {},
            icon = Icons.Default.Lock,
            false,
            errorText =""
        )
        SpacerComponent(10)
        OutlineTextFieldIconCompent(
            labelValue = stringResource(id = R.string.confirm_password),
            value = signUpState.confirmPasswordState,
            onValueChange = {},
            icon = Icons.Default.Lock,
            false,
            errorText =""
        )
        SpacerComponent(50)
        ButtonComponent(
            value = stringResource(id = R.string.sign_up),
            onclick = {  })
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