package com.srcodecorner.auth0.navigation

import androidx.navigation.NavController

class NavigationRepositoryImpl(var navController: NavController) : NavigationRepository {
    override fun navigateTo(destination: String) {
        // Implement navigation logic here if required
        navController.navigate(destination)
    }
}