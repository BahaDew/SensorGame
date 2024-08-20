package com.example.sensorgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.sensorgame.databinding.ActivityMainBinding
import com.example.sensorgame.navigation.AppNavigationHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::bind)

    @Inject
    lateinit var appNavigationHandler: AppNavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.container.id) as NavHostFragment
        val navController = navHostFragment.navController
        appNavigationHandler
            .buffer
            .onEach {
                it.invoke(navController)
            }
            .launchIn(lifecycleScope)
    }
}