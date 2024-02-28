package com.srcodecorner.auth0.ui.screens.ForgetPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.ui.screens.NewPasswordScreen.NewPasswordScreen
import com.srcodecorner.auth0.ui.screens.Verification.VerificationScreen
import com.srcodecorner.auth0.screens.auth.ForgetPassword.viewmodel.ForgetPasswordViewModel


@Composable
fun ForgetPasswordScreen(navController: NavController) {
    var forgetpasswordviewmodel = ForgetPasswordViewModel()
   var email = forgetpasswordviewmodel.email.value
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
    verticalArrangement = Arrangement.Center) {
        HeadingTextComponent(value = stringResource(R.string.forgot_password))
        SpacerComponent(size = 20)
        OutlineTextFieldIconCompent(labelValue = stringResource(R.string.enter_email),email, onValueChange = {},Icons.Default.Email,false,  errorText ="")
        SpacerComponent(size = 50)
        ButtonComponent(value = stringResource(R.string.send)) {
          navController.navigate(Screen.VerificationScreen.route)
        }
    }
}

@Preview
@Composable
fun ForgetPasswordScreenPreview(){
   // ForgetPasswordScreen()
}