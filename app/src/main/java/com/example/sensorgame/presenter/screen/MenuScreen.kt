package com.example.sensorgame.presenter.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sensorgame.R
import com.example.sensorgame.databinding.ScreenMenuBinding
import com.example.sensorgame.presenter.viewmodel.MenuViewModel
import com.example.sensorgame.presenter.viewmodel.impl.MenuViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuScreen : Fragment(R.layout.screen_menu) {
    private val viewModel : MenuViewModel by viewModels<MenuViewModelImpl>()
    private val binding by viewBinding(ScreenMenuBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() = binding.apply {
        btnEasy.setOnClickListener { viewModel.onClickEasy() }
        btnMedium.setOnClickListener { viewModel.onClickMedium() }
        btnHard.setOnClickListener { viewModel.onClickHard() }
    }
}