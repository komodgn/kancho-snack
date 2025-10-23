package com.komodgn.snack.feature.webview.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.theme.Black
import com.komodgn.snack.core.designsystem.theme.ContentOnDark
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.feature.webview.R
import com.komodgn.snack.feature.webview.WebViewUiEvent
import com.komodgn.snack.feature.webview.WebViewUiState

@Composable
fun WebViewHeader(
    modifier: Modifier = Modifier,
    state: WebViewUiState,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(Black)
                .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(SnackTheme.spacing.spacing2))
        IconButton(
            onClick = {
                state.eventSink(WebViewUiEvent.OnBackButtonClick)
            },
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "Arrow Back Icon",
                tint = ContentOnDark,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "SNACK",
            style = SnackTheme.typography.heading,
            color = ContentOnDark,
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(SnackTheme.spacing.spacing4))
    }
}

@ComponentPreview
@Composable
private fun WebViewHeader() {
    SnackTheme {
        WebViewHeader(
            state =
                WebViewUiState(
                    url = "www.naver.com",
                    eventSink = {},
                ),
        )
    }
}
