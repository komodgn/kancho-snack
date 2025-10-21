package com.komodgn.snack.feature.shoot.ocr

import android.net.Uri
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class OcrUiState(
    val isCameraPermissionDialogVisible: Boolean = false,
    val isLoading: Boolean = false,
    val isCapturePending: Boolean = false,
    val recognizedText: String? = null,
    val eventSink: (OcrUiEvent) -> Unit
) : CircuitUiState

sealed interface OcrUiEvent : CircuitUiEvent {
    data object OnBackClick : OcrUiEvent
    data object OnShowPermissionDialog : OcrUiEvent
    data object OnHidePermissionDialog : OcrUiEvent
    data object OnCameraCaptureStart : OcrUiEvent
    data object OnCaptureCommandCompleted: OcrUiEvent
    data class OnImageCaptured(val imageUri: Uri) : OcrUiEvent
}