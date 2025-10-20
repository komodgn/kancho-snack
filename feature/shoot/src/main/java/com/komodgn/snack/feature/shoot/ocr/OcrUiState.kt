package com.komodgn.snack.feature.shoot.ocr

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class OcrUiState(
    val isCameraPermissionDialogVisible: Boolean = false,
    val eventSink: (OcrUiEvent) -> Unit
) : CircuitUiState

sealed interface OcrUiEvent : CircuitUiEvent {
    data object OnBackClick : OcrUiEvent
    data object OnShowPermissionDialog : OcrUiEvent
    data object OnHidePermissionDialog : OcrUiEvent
}