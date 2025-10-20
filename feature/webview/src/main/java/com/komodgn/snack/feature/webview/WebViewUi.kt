package com.komodgn.snack.feature.webview

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.komodgn.snack.core.designsystem.DevicePreview
import com.komodgn.snack.core.ui.SnackScaffold
import com.komodgn.snack.feature.screens.WebViewScreen
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(WebViewScreen::class, ActivityRetainedComponent::class)
@Composable
fun WebViewUi(
    modifier: Modifier = Modifier,
    state: WebViewUiState
) {
    SnackScaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        @SuppressLint("SetJavaScriptEnabled")
        AndroidView(
            modifier = Modifier.padding(innerPadding),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.apply {
                        javaScriptEnabled = true
                        // 뷰포트 메타 태그 허용
                        useWideViewPort = true
                        // 화면에 맞게 최적화
                        loadWithOverviewMode = true
                    }
                    loadUrl(state.url)
                }
            },
        )
    }
}

@DevicePreview
@Composable
private fun WebViewPreview() {
    WebViewUi(
        state = WebViewUiState(
            url = "https://sites.google.com/view/snack-privacypolicy"
        )
    )
}