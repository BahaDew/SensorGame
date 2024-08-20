package com.example.sensorgame.presenter.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface GameViewModel {
    val ballGifRes : StateFlow<Int>

    fun openGameScreen(gameState: Int)
}