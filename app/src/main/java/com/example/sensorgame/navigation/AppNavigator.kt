package com.example.sensorgame.navigation

import androidx.navigation.NavDirections

interface AppNavigator {

    suspend fun navigateTo(directions: NavDirections)

    suspend fun popBackStack()
}