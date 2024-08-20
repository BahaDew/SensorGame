package com.example.sensorgame.presenter.screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sensorgame.R
import com.example.sensorgame.databinding.ScreenSplashBinding
import com.example.sensorgame.presenter.viewmodel.SplashViewModel
import com.example.sensorgame.presenter.viewmodel.impl.SplashViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel : SplashViewModel by viewModels<SplashViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() = binding.apply {
        gifView.gifResource = R.mipmap.game_splash_remove_bg
        gifView.play()
        viewModel.openSplash()
    }
}