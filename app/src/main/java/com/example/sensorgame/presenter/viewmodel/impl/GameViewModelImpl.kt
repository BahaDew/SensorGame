package com.example.sensorgame.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import com.example.sensorgame.R
import com.example.sensorgame.navigation.AppNavigator
import com.example.sensorgame.presenter.viewmodel.GameViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel(), GameViewModel {
    override val ballGifRes = MutableStateFlow(R.mipmap.ball_easy_remove_bg)

    override fun openGameScreen(gameState: Int) {
        when(gameState) {
            0 -> {
                ballGifRes.value = R.mipmap.ball_easy_remove_bg
            }
            1 -> {
                ballGifRes.value = R.mipmap.ball_medium_remove_bg
            }
            2 -> {
                ballGifRes.value = R.mipmap.ball_hard_remove_bg
            }
        }
    }
}