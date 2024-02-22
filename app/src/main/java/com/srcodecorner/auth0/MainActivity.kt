package com.srcodecorner.auth0

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.srcodecorner.auth0.ui.components.*
import com.srcodecorner.auth0.ui.theme.Auth0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Auth0Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(20.dp)
                ) {
                    DefaultPreview()
                }

            }
        }
    }
}


@Composable
fun RegistrationScreen() {
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
        //ButtonComponent(value = stringResource(id = R.string.sign_up))
        SpacerComponent(20)
        NormalTextComponent(value = stringResource(R.string.or))
        SpacerComponent(20)
        NormalTextComponent(value = stringResource(R.string.have_account_signin))
    }

}


@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        HeadingTextComponent(value = stringResource(id = R.string.welcome_back))
        TextFieldComponent(labelValue = stringResource(id = R.string.username))
        TextFieldComponent(labelValue = stringResource(id = R.string.password))
        ButtonComponent(value = stringResource(id = R.string.signin),
            onclick = { navController.navigate(Screens.Registration.route) })
    }

}


@Composable
fun ForgotPasswordScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        HeadingTextComponent(value = stringResource(R.string.forgot_password))
        TextFieldComponent(labelValue = stringResource(R.string.enter_email))
        ButtonComponent(value = stringResource(R.string.send)) {

        }
    }

}


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

@Composable
fun NewPasswordScreen(){
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
fun TextFieldBorder() {
    val maxChar = 1
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {if (it.length <= maxChar)  text = it },
        Modifier
            .border(BorderStroke(1.dp, Color.Red), RectangleShape)
            .size(50.dp)
            .width(1.dp),
        placeholder ={Text(text = "X")} ,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(textAlign = TextAlign.Center)
    )
}


@Composable
fun BoxComponent() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(RectangleShape)
            .background(Color.White)
            .border(2.dp, Color.Red)
    )
}


@Composable
fun SplashScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

    }
}


@Composable
fun ScreenMain() {
    val navcontroller = rememberNavController()
    NavGraph(navcontroller)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Screens.Login.route
    ) {
        composable(route = Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.Registration.route) {
            RegistrationScreen()
        }

    }
}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Auth0Theme {
        //  Greeting("Android")

        //  LoginScreen()
        // RegistrationScreen()
        //SplashScreen()
        // ScreenMain()
        //ForgotPasswordScreen()
        VerificationScreen()
        // BoxComponent()
      //  NewPasswordScreen()
    }

}