package com.komodgn.snack.feature.home

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
import com.komodgn.snack.core.designsystem.component.button.smallRetroButtonSize
import com.komodgn.snack.core.designsystem.theme.Neutral200
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.core.ui.SnackScaffold
import com.komodgn.snack.core.ui.component.RetroDeviceFrame
import com.komodgn.snack.feature.home.component.HomeHeader
import com.komodgn.snack.feature.screens.HomeScreen
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(HomeScreen::class, ActivityRetainedComponent::class)
@Composable
internal fun HomeUi(
    modifier: Modifier = Modifier,
    state: HomeUiState
) {
    SnackScaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column {
            HomeHeader(
                modifier = Modifier
                    .padding(innerPadding)
            )
            RetroDeviceFrame(
                topAreaContent = {
                    Text(
                        text = "SNACK",
                        style = SnackTheme.typography.heading
                    )
                },
                screenContent = {
                    Text(
                        color = Neutral200,
                        text = "CAMERA PREVIEW",
                        style = SnackTheme.typography.bodyLarge
                    )
                },
                buttonAreaContent = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SnackButton(
                            onClick = { },
                            size = smallRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_mint_button,
                        )
                        SnackButton(
                            onClick = {
                                state.eventSink(HomeUiEvent.OnPowerButtonClick)
                            },
                            size = mediumRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_mint_button,
                            icon = painterResource(R.drawable.ic_power_setting),
                            text = "ON",
                        )
                        SnackButton(
                            onClick = { },
                            size = smallRetroButtonSize,
                            backgroundDrawableRes = com.komodgn.snack.core.designsystem.R.drawable.ic_pink_button,
                        )
                    }
                }
            )
        }
    }
}

@DevicePreview
@Composable
fun HomeUiPreview() {
    SnackTheme {
        HomeUi(
            state = HomeUiState(
                eventSink = {}
            )
        )
    }
}