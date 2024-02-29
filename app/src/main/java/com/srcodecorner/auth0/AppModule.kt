package com.srcodecorner.auth0

import androidx.navigation.NavController
import com.srcodecorner.auth0.navigation.NavigationRepository
import com.srcodecorner.auth0.navigation.NavigationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideNavigationRepository(navController: NavController): NavigationRepository {
        return NavigationRepositoryImpl(navController)
    }
}