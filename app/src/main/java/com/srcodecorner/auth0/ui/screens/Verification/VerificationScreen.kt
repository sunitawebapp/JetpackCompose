package com.srcodecorner.auth0.ui.screens.Verification

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.srcodecorner.auth0.R
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.Screen
import com.srcodecorner.auth0.ui.screens.ForgetPassword.ForgetPasswordScreen

@Composable
fun VerificationScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        /*   HeadingTextComponent(value = stringResource(id = R.string.verification))
        NormalTextComponent(value = stringResource(id = R.string.enter_verification), TextAlign.Center)
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
          navController.navigate(Screen.NewPasswordScreen.route)
        }*/

        OtpView(  modifier = Modifier
            .padding(20.dp)
           ,
           true)
    }


}

@Composable
fun OtpView(
    modifier: Modifier,

    isError: Boolean = false

) {
    val focusManager = LocalFocusManager.current
    val animateError = remember { Animatable(initialValue = 0.0F) }
    LaunchedEffect(key1 = isError) {
        if (isError) {
            animateError.animateTo(
                targetValue = 0.dp.value

            )
        }
    }

    val textFieldPins = getClearFields(otpSize = OtpSize.FOUR)
   /* BoxWithConstraints(
        modifier = modifier
    ) {*/
        Row( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            textFieldPins.forEachIndexed { index, textField ->
                var textInput by remember {
                    mutableStateOf(textFieldPins[index].value)
                }

                Log.d("", "OtpView: "+index)
              TextField(value = textInput,
                  onValueChange ={  textInput = it.takeLast(1) },
                  Modifier.size(56.dp),
                  keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
              )
            }
        }
   // }
}

fun onTextChange(clearPressed: Boolean){

}

@Composable
internal fun getClearFields(otpSize: OtpSize) = remember {
    when (otpSize) {
        OtpSize.SIX -> listOf(
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
        )
        OtpSize.FOUR -> listOf(
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
        )
    }
}

enum class OtpSize(size : Int){
     SIX(6),
     FOUR(4)
}