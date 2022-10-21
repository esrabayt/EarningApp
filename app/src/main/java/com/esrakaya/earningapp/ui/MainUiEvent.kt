package com.esrakaya.earningapp.ui

sealed class MainUiEvent {
    data class ShowErrorMessage(
        val message: String
    ) : MainUiEvent()
}
