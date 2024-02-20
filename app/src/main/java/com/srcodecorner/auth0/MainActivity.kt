package com.srcodecorner.auth0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.srcodecorner.auth0.ui.theme.Auth0Theme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Auth0Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}


@Composable
fun LoginField(){
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon()
        Spacer(modifier = Modifier.size(40.dp))  // How to set the modifier
        inputField("User Name")
        inputField("Password")
        Spacer(modifier = Modifier.size(40.dp))  // How to set the modifier
        ButtonComponent("Login")
    }
}
@Composable
fun inputField(lebel : String){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { newtext->
            text= newtext
        },
        label = { Text(lebel)},
        placeholder = { Text(text = lebel) },
        )
}

@Composable
fun Icon(){
    Image(painter = painterResource(id = R.drawable.login_icon),
        contentDescription ="" ,
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun ButtonComponent(value : String){
  Button(onClick = {  }) {
      Text(text = value)
  }
}

@Composable
fun BackgroundImg(){
    var modifier = Modifier.fillMaxSize().background(Color.Green)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Auth0Theme {
      //  Greeting("Android")
        BackgroundImg()
        LoginField()

    }
}