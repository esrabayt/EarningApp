package com.esrakaya.earningapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        collectState(viewModel.uiState, ::renderView)
        collectEvent(viewModel.uiEvent, ::handleEvent)
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