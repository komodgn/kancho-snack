package com.komodgn.snack.feature.screens

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeScreen : Screen

@Parcelize
data object OcrScreen : Screen

@Parcelize
data class WebViewScreen(
    val url: String,
) : Screen
