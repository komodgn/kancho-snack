package com.komodgn.snack.feature.webview

import com.slack.circuit.runtime.CircuitUiState

data class WebViewUiState(
    val url: String
) : CircuitUiState