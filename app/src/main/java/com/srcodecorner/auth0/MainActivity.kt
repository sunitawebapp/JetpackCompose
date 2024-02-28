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
import com.srcodecorner.auth0.app.PostOfficeApp
import com.srcodecorner.auth0.components.*
import com.srcodecorner.auth0.navigation.NavigationGraph
import com.srcodecorner.auth0.navigation.Screens
import com.srcodecorner.auth0.ui.screens.Home.HomeScreen
import com.srcodecorner.auth0.screens.auth.SignIn.SignInScreen
import com.srcodecorner.auth0.screens.auth.SignUp.SignUpScreen

import com.srcodecorner.auth0.ui.theme.Auth0Theme
//
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
                    ScreenMain()
                }

            }
        }
    }
}


@Composable
fun ScreenMain() {
    NavigationGraph()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Auth0Theme {
        ScreenMain()

    }

}