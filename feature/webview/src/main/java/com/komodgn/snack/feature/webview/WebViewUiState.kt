package com.komodgn.snack.feature.webview

import com.slack.circuit.runtime.CircuitUiState

data class WebViewUiState(
    val url: String,
    val eventSink: (WebViewUiEvent) -> Unit,
) : CircuitUiState

sealed interface WebViewUiEvent {
    data object OnBackButtonClick : WebViewUiEvent
}
