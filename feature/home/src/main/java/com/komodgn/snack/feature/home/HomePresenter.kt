package com.komodgn.snack.feature.home

import androidx.compose.runtime.Composable
import com.komodgn.snack.core.common.constants.WebViewUrls
import com.komodgn.snack.feature.screens.HomeScreen
import com.komodgn.snack.feature.screens.OcrScreen
import com.komodgn.snack.feature.screens.WebViewScreen
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class HomePresenter
    @AssistedInject
    constructor(
        @Assisted private val navigator: Navigator,
    ) : Presenter<HomeUiState> {
        @Composable
        override fun present(): HomeUiState {
            fun handleEvent(event: HomeUiEvent) {
                when (event) {
                    is HomeUiEvent.OnPowerOnButtonClick -> {
                        navigator.goTo(OcrScreen)
                    }

                    is HomeUiEvent.OnPrivacyPolicyButtonClick -> {
                        val webView = WebViewUrls.PRIVACY_POLICY
                        navigator.goTo(WebViewScreen(webView.url))
                    }
                }
            }

            return HomeUiState(
                eventSink = ::handleEvent,
            )
        }

        @CircuitInject(HomeScreen::class, ActivityRetainedComponent::class)
        @AssistedFactory
        fun interface Factory {
            fun create(navigator: Navigator): HomePresenter
        }
    }
