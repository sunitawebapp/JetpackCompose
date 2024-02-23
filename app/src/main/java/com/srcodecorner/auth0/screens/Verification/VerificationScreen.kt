package com.srcodecorner.auth0.screens.Verification

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.screens.ForgetPassword.ForgetPasswordScreen

@Composable
fun VerificationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        HeadingTextComponent(value = stringResource(id = R.string.verification))
        NormalTextComponent(value = stringResource(id = R.string.enter_verification))
        SpacerComponent(20)
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            TextFieldBorder()
            TextFieldBorder()
            TextFieldBorder()
            TextFieldBorder()
        }
        SpacerComponent(20)
        ButtonComponent(value = stringResource(id = R.string.send)) {

        }
    }
}

@Preview
@Composable
fun VerificationScreenPreview(){
    VerificationScreen()
}