package com.komodgn.snack.feature.home

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class HomeUiState(
    val isLoading : Boolean = false,
    val eventSink: (HomeUiEvent) -> Unit
): CircuitUiState

sealed interface HomeUiEvent : CircuitUiEvent {
    data object OnPowerOnButtonClick : HomeUiEvent
    data object OnPrivacyPolicyButtonClick : HomeUiEvent
}