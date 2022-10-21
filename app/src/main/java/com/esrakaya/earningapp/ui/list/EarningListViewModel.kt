package com.esrakaya.earningapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esrakaya.earningapp.domain.usecase.FetchEarningList
import com.esrakaya.earningapp.domain.usecase.ShowError
import com.esrakaya.earningapp.domain.usecase.ShowLoading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EarningListViewModel @Inject constructor(
    private val showLoading: ShowLoading,
    private val showError: ShowError,
    private val fetchEarningList: FetchEarningList
) : ViewModel() {

    private val _uiState = MutableStateFlow(EarningListUiState())
    val uiState: StateFlow<EarningListUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<EarningListUiEvent>()
    val uiEvent: SharedFlow<EarningListUiEvent> = _uiEvent.asSharedFlow()

    init {
        fetch()
    }

    private fun fetch() {
        viewModelScope.launch {
            showLoading(isLoading = true)

            runCatching { fetchEarningList() }
                .onSuccess { _uiState.update { earning -> earning.copy(earningModel = it) } }
                .onFailure { showError(it) }
                .also { showLoading(isLoading = false) }
        }
    }
}