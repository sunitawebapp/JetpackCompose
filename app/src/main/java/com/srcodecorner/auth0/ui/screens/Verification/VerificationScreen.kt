package com.srcodecorner.auth0.ui.screens.Verification

import android.util.Log
import android.view.KeyEvent.ACTION_DOWN
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent

@Composable
fun VerificationScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        val maxChar = 1
        var text1 by remember { mutableStateOf("") }
        var text2 by remember { mutableStateOf("") }
        var text3 by remember { mutableStateOf("") }
        var text4 by remember { mutableStateOf("") }

        TextField(
            value = text1,
            onValueChange = { if (it.length <= maxChar) text1 = it },
            Modifier
                .border(BorderStroke(1.dp, Color.Red), RectangleShape)
                .size(50.dp)
                .width(1.dp),
            placeholder = { Text(text = "") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        TextField(
            value = text2,
            onValueChange = { if (it.length <= maxChar) text2 = it },
            Modifier
                .border(BorderStroke(1.dp, Color.Red), RectangleShape)
                .size(50.dp)
                .width(1.dp),
            placeholder = { Text(text = "") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        TextField(
            value = text3,
            onValueChange = { if (it.length <= maxChar) text3 = it },
            Modifier
                .border(BorderStroke(1.dp, Color.Red), RectangleShape)
                .size(50.dp)
                .width(1.dp),
            placeholder = { Text(text = "") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )




    }
}
