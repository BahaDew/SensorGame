package com.example.sensorgame.di

import com.example.sensorgame.navigation.AppNavigationDispatcher
import com.example.sensorgame.navigation.AppNavigationHandler
import com.example.sensorgame.navigation.AppNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindAppNavigator(impl : AppNavigationDispatcher) : AppNavigator

    @[Binds Singleton]
    fun bindAppNavigationHandler(impl: AppNavigationDispatcher) : AppNavigationHandler
}