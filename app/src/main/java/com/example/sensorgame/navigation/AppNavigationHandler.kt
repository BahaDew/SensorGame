package com.example.sensorgame.navigation

import kotlinx.coroutines.flow.Flow


interface AppNavigationHandler {

    val buffer: Flow<AppNavigation>
}