package com.esrakaya.earningapp.ui.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class EarningListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(EarningListUiState())
    val uiState: StateFlow<EarningListUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<EarningListUiEvent>()
    val uiEvent: SharedFlow<EarningListUiEvent> = _uiEvent.asSharedFlow()

}