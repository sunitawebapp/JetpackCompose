package com.srcodecorner.auth0.screens.NewPasswordScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.ButtonComponent
import com.srcodecorner.auth0.components.HeadingTextComponent
import com.srcodecorner.auth0.components.SpacerComponent
import com.srcodecorner.auth0.components.TextFieldComponent

@Composable
fun NewPasswordScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        HeadingTextComponent(value = stringResource(id = R.string.new_password))
        SpacerComponent(20)
        TextFieldComponent(labelValue = stringResource(id = R.string.new_password))
        SpacerComponent(20)
        TextFieldComponent(labelValue = stringResource(id = R.string.confirm_password))
        SpacerComponent(20)
        ButtonComponent(value = stringResource(id = R.string.send)) {

        }
    }

}
@Composable
fun NewPasswordScreenPreview(){
    NewPasswordScreen()
}