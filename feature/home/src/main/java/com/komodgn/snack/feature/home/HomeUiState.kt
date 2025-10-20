package com.komodgn.snack.feature.home

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class HomeUiState(
    val eventSink: (HomeUiEvent) -> Unit
): CircuitUiState

sealed interface HomeUiEvent : CircuitUiEvent {
    data object OnPowerButtonClick : HomeUiEvent
}