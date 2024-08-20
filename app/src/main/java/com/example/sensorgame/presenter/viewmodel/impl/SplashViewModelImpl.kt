package com.example.sensorgame.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sensorgame.navigation.AppNavigator
import com.example.sensorgame.presenter.screen.SplashScreenDirections
import com.example.sensorgame.presenter.viewmodel.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel(), SplashViewModel {

    override fun openSplash() {
        viewModelScope.launch {
            delay(3000)
            appNavigator.navigateTo(SplashScreenDirections.actionSplashScreenToMenuScreen())
        }
    }

}