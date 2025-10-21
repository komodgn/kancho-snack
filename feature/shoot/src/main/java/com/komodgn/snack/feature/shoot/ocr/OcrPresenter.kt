package com.komodgn.snack.feature.shoot.ocr

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.komodgn.snack.core.ocr.service.OcrService
import com.komodgn.snack.feature.screens.OcrScreen
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class OcrPresenter @AssistedInject constructor(
    @Assisted private val navigator: Navigator,
    private val ocrService: OcrService
) : Presenter<OcrUiState> {

    @Composable
    override fun present(): OcrUiState {
        var isCameraPermissionDialogVisible by rememberRetained { mutableStateOf(false) }

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
            }
        }
        
        return OcrUiState(
            isCameraPermissionDialogVisible = isCameraPermissionDialogVisible,
            eventSink = ::handleEvent
        )
    }

    @CircuitInject(OcrScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(navigator: Navigator) : OcrPresenter
    }
}