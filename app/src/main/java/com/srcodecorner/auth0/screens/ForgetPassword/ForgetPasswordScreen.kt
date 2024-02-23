package com.srcodecorner.auth0.screens.ForgetPassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.ButtonComponent
import com.srcodecorner.auth0.components.HeadingTextComponent
import com.srcodecorner.auth0.components.TextFieldComponent


@Composable
fun ForgetPasswordScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        HeadingTextComponent(value = stringResource(R.string.forgot_password))
        TextFieldComponent(labelValue = stringResource(R.string.enter_email))
        ButtonComponent(value = stringResource(R.string.send)) {

        }
    }
}

@Preview
@Composable
fun ForgetPasswordScreenPreview(){
    ForgetPasswordScreen()
}