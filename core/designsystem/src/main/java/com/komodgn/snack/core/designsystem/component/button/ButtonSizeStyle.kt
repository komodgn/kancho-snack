package com.komodgn.snack.core.designsystem.component.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.komodgn.snack.core.designsystem.theme.SnackTheme

@Immutable
data class RetroButtonSize(
    val totalSize: Dp,
    val iconSize: Dp,
    val iconSpacing: Dp,
    val textStyle: TextStyle,
    val contentVerticalOffset: Dp
)

val mediumRetroButtonSize: RetroButtonSize
    @Composable get() = RetroButtonSize(
        totalSize = 90.dp,
        iconSize = 24.dp,
        iconSpacing = SnackTheme.spacing.spacing1,
        textStyle = SnackTheme.typography.bodyMedium,
        contentVerticalOffset = 4.dp
    )

val smallRetroButtonSize: RetroButtonSize
    @Composable get() = RetroButtonSize(
        totalSize = 60.dp,
        iconSize = 18.dp,
        iconSpacing = SnackTheme.spacing.spacing05,
        textStyle = SnackTheme.typography.label,
        contentVerticalOffset = 2.dp
    )
