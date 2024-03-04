package com.srcodecorner.auth0.utils

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.srcodecorner.auth0.navigation.NavigationGraph
import com.srcodecorner.auth0.navigation.NavigationRepository
import com.srcodecorner.auth0.navigation.NavigationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@HiltAndroidApp
class AuthApp : Application()

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavController(@ApplicationContext context: Context): NavController {
        return NavHostController(context)
    }

    @Provides
    @Singleton
    fun provideNavigationRepository(navController: NavController): NavigationRepository {
        return NavigationRepositoryImpl(navController)
    }
}