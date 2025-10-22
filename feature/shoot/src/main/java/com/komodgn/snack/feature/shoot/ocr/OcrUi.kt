package com.komodgn.snack.feature.shoot.ocr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.komodgn.snack.core.designsystem.DevicePreview
import com.komodgn.snack.core.designsystem.component.button.SnackButton
import com.komodgn.snack.core.designsystem.component.button.mediumRetroButtonSize
import com.komodgn.snack.core.designsystem.theme.ContentOnDark
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.core.ui.SnackScaffold
import com.komodgn.snack.core.ui.component.RetroDeviceFrame
import com.komodgn.snack.core.ui.component.SnackLoadingIndicator
import com.komodgn.snack.feature.screens.OcrScreen
import com.komodgn.snack.feature.shoot.R
import com.komodgn.snack.feature.shoot.ocr.component.CameraPreview
import com.komodgn.snack.feature.shoot.ocr.component.OcrHeader
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(OcrScreen::class, ActivityRetainedComponent::class)
@Composable
fun OcrUi(
    modifier: Modifier = Modifier,
    state: OcrUiState,
) {
    SnackScaffold(
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        Column {
            OcrHeader(
                modifier =
                    Modifier
                        .padding(innerPadding),
                onBackButtonClick = {
                    state.eventSink(OcrUiEvent.OnBackClick)
                },
            )
            RetroDeviceFrame(
                topAreaContent = {
                    Text(
                        text = "SNACK",
                        style = SnackTheme.typography.heading,
                    )
                },
                screenContent = {
                    CameraPreview(state = state, modifier = modifier)
                },
                buttonAreaContent = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        SnackButton(
                            onClick = { /* Just Design */ },
                            size = mediumRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_mint_button,
                        )
                        SnackButton(
                            onClick = {
                                state.eventSink(OcrUiEvent.OnCameraCaptureStart)
                            },
                            enabled = !state.isLoading,
                            size = mediumRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_pink_button,
                            icon = painterResource(R.drawable.ic_camera),
                            text = "SHOOT",
                        )
                        SnackButton(
                            onClick = { /* Share */ },
                            size = mediumRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_yellow_button,
                        )
                    }
                },
            )

            Text(
                text = state.recognizedText.toString(),
                style = SnackTheme.typography.heading,
                color = ContentOnDark,
            )
        }

        if (state.isLoading) {
            SnackLoadingIndicator()
        }
    }
}

@DevicePreview
@Composable
private fun OcrUiPreview() {
    SnackTheme {
        OcrUi(
            state =
                OcrUiState(
                    isCameraPermissionDialogVisible = false,
                    eventSink = {},
                ),
        )
    }
}
