package com.esrakaya.earningapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.esrakaya.earningapp.R
import com.esrakaya.earningapp.databinding.ActivityMainBinding
import com.esrakaya.earningapp.ui.MainUiEvent.ShowErrorMessage
import com.esrakaya.earningapp.utils.collectEvent
import com.esrakaya.earningapp.utils.collectState
import com.esrakaya.earningapp.utils.showError
import com.esrakaya.earningapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        collectState(viewModel.uiState, ::renderView)
        collectEvent(viewModel.uiEvent, ::handleEvent)
        initView()
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    private fun initView() = with(binding) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)
    }

    private fun renderView(uiState: MainUiState) = with(binding) {
        progressLayout.isVisible = uiState.isLoading
    }

    private fun handleEvent(uiEvent: MainUiEvent) {
        when (uiEvent) {
            is ShowErrorMessage -> showError(uiEvent.message)
        }
    }
}