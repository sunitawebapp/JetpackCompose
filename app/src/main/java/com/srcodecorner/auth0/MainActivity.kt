package com.srcodecorner.auth0

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srcodecorner.auth0.navigation.NavigationGraph
import com.srcodecorner.auth0.ui.theme.Auth0Theme
import com.srcodecorner.auth0.utils.AppModule.provideNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
  /*  val navController = provideNavController()
    NavigationGraph(navController)*/
   // val navController = hiltViewModel<NavControllerViewModel>().navController
   // NavigationGraph(navController)
   // var navController = rememberNavController()

    NavigationGraph()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Auth0Theme {
      //  ScreenMain()

    }

}