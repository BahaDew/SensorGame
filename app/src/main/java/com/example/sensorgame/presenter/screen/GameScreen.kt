package com.example.sensorgame.presenter.screen

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.*
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sensorgame.R
import com.example.sensorgame.databinding.ScreenGameBinding
import com.example.sensorgame.presenter.viewmodel.GameViewModel
import com.example.sensorgame.presenter.viewmodel.impl.GameViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val navArgs by navArgs<GameScreenArgs>()
    private val sensorManager by lazy { requireActivity().getSystemService(SENSOR_SERVICE) as SensorManager }
    private val sensor by lazy { sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initFlow()
    }

    private fun initView() = binding.apply {
        viewModel.openGameScreen(navArgs.gameState)
    }

    private fun initFlow() = binding.apply {
        viewModel.ballGifRes
            .onEach {
                ball.gifResource = it
                ball.play()
            }.flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)
    }

    private val listener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.apply {
                binding.apply {
                    ball.x -= 5 * values[0]
                    ball.y += 5 * values[1]

                    if (ball.x < root.x) ball.x = root.x
                    if (ball.x + ball.width > root.x + root.width) ball.x =
                        root.x + root.width - ball.width
                    if (ball.y < root.y) ball.y = root.y
                    if (ball.y + ball.height > root.y + root.height) ball.y =
                        root.y + root.height - ball.height
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        }

    }

    override fun onStart() {
        super.onStart()
        sensorManager.registerListener(listener, sensor, SENSOR_DELAY_GAME)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(listener)
    }

}