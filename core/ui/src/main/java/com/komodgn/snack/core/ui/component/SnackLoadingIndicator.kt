package com.komodgn.snack.core.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import kotlinx.coroutines.delay

@Composable
fun SnackLoadingIndicator(
    modifier: Modifier = Modifier,
    delayMills: Long = 1000L,
) {
    val showLoadingIcon by produceState(initialValue = false, key1 = delayMills) {
        delay(delayMills)
        value = true
    }

    if (showLoadingIcon) {
        Box(
            modifier =
                modifier
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = SnackTheme.colors.contentPrimary)
        }
    }
}

@ComponentPreview
@Composable
private fun SnackLoadingIndicatorPreview() {
    SnackTheme {
        SnackLoadingIndicator()
    }
}
