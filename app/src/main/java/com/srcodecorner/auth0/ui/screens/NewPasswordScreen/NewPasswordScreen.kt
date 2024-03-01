package com.srcodecorner.auth0.ui.screens.NewPasswordScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.ButtonComponent
import com.srcodecorner.auth0.components.HeadingTextComponent
import com.srcodecorner.auth0.components.SpacerComponent
import com.srcodecorner.auth0.components.TextFieldComponent
import com.srcodecorner.auth0.ui.screens.NewPasswordScreen.viewmodel.NewPasswordViewModel

@Composable
fun NewPasswordScreen(navController: NavController) {
    var newPasswordViewModel = NewPasswordViewModel()
    var newPassword = newPasswordViewModel.newPassword.value
    var conformPassword = newPasswordViewModel.conformPassword.value
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        HeadingTextComponent(value = stringResource(id = R.string.new_password))
        SpacerComponent(20)
        TextFieldComponent(
            labelValue = stringResource(id = R.string.new_password),
            newPassword,
            onValueChange = {})
        SpacerComponent(20)
        TextFieldComponent(
            labelValue = stringResource(id = R.string.confirm_password),
            conformPassword,
            onValueChange = {})
        SpacerComponent(20)
        ButtonComponent(value = stringResource(id = R.string.send)) {

        }
    }

}

@Composable
fun NewPasswordScreenPreview() {
    //  NewPasswordScreen()
}