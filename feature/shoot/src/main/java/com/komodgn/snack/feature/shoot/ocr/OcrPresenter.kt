package com.komodgn.snack.feature.shoot.ocr

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.komodgn.snack.core.ocr.recognizer.OcrRecognizer
import com.komodgn.snack.feature.screens.OcrScreen
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.launch

class OcrPresenter @AssistedInject constructor(
    @Assisted private val navigator: Navigator,
    private val recognizer: OcrRecognizer
) : Presenter<OcrUiState> {

    @Composable
    override fun present(): OcrUiState {
        val scope = rememberCoroutineScope()
        var isCameraPermissionDialogVisible by rememberRetained { mutableStateOf(false) }
        var isLoading by rememberRetained { mutableStateOf(false) }
        var isCapturePending by rememberRetained { mutableStateOf(false) }
        var recognizedText by rememberRetained { mutableStateOf<String?>(null) }

        fun recognizeText(imageUri: Uri) {
            scope.launch {
                try {
                    recognizedText = null
                    isLoading = true
                    recognizer.recognizeText(imageUri)
                        .onSuccess {
                            val text = it.responses
                                .firstOrNull()
                                ?.textAnnotations
                                ?.firstOrNull()
                                ?.description
                            if (text.isNullOrEmpty()) {
                                recognizedText = "TRY AGAIN"
                            } else {
                                recognizedText = text
                            }
                            Log.d("OCR", text.toString())
                        }
                } finally {
                    isLoading = false
                }
            }
        }

        fun handleEvent(event: OcrUiEvent) {
            when(event) {
                is OcrUiEvent.OnBackClick -> {
                    navigator.pop()
                }

                is OcrUiEvent.OnHidePermissionDialog -> {
                    isCameraPermissionDialogVisible = false
                }

                is OcrUiEvent.OnShowPermissionDialog -> {
                    isCameraPermissionDialogVisible = true
                }

                is OcrUiEvent.OnCameraCaptureStart -> {
                    recognizedText = null
                    isCapturePending = true
                    isLoading = true
                }

                is OcrUiEvent.OnCaptureCommandCompleted -> {
                    isCapturePending = false
                }

                is OcrUiEvent.OnImageCaptured -> {
                    recognizeText(event.imageUri)
                }
            }
        }
        
        return OcrUiState(
            isCameraPermissionDialogVisible = isCameraPermissionDialogVisible,
            isLoading = isLoading,
            isCapturePending = isCapturePending,
            recognizedText = recognizedText,
            eventSink = ::handleEvent
        )
    }

    @CircuitInject(OcrScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(navigator: Navigator) : OcrPresenter
    }
}