package com.komodgn.snack.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalBorder = staticCompositionLocalOf { Border() }
private val LocalColorSchema = staticCompositionLocalOf { SnackColorSchema() }
private val LocalRadius = staticCompositionLocalOf { Radius() }
private val LocalSpacing = staticCompositionLocalOf { SnackSpacing() }
private val LocalTypography = staticCompositionLocalOf { RetroTypography() }

@Composable
fun SnackTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        content = content,
    )
}

object SnackTheme {
    val border: Border
        @Composable
        @ReadOnlyComposable
        get() = LocalBorder.current

    val colors: SnackColorSchema
        @Composable
        @ReadOnlyComposable
        get() = LocalColorSchema.current

    val radius: Radius
        @Composable
        @ReadOnlyComposable
        get() = LocalRadius.current

    val spacing: SnackSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current

    val typography: RetroTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
