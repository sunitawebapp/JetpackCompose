package com.srcodecorner.auth0.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import javax.inject.Inject

class NavigationRepositoryImpl @Inject constructor(private val navController: NavController) : NavigationRepository {
    init {
        Log.d("NavController", "NavController injected: ${navController}")
    }

    override fun navigateTo(destination: String) {
        Log.d("Navigation", "Attempting navigation to: $destination")
       // navController?.navigate(destination)
    }
}