package com.example.sensorgame.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sensorgame.navigation.AppNavigator
import com.example.sensorgame.presenter.screen.MenuScreenDirections
import com.example.sensorgame.presenter.viewmodel.MenuViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModelImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel(), MenuViewModel {

    override fun onClickEasy() {
        menuToGameScreen(0)
    }

    override fun onClickMedium() {
        menuToGameScreen(1)
    }

    override fun onClickHard() {
        menuToGameScreen(2)
    }

    private fun menuToGameScreen(gameState: Int) {
        viewModelScope.launch {
            appNavigator.navigateTo(MenuScreenDirections.actionMenuScreenToGameScreen(gameState = gameState))
        }
    }
}