package com.komodgn.snack.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.theme.ContentOnDark
import com.komodgn.snack.core.designsystem.theme.ContentOnLight
import com.komodgn.snack.core.designsystem.theme.SnackTheme

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ContentOnLight)
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(SnackTheme.spacing.spacing4))
        Text(
            "SNACK",
            style = SnackTheme.typography.heading,
            color = ContentOnDark
        )
    }
}

@ComponentPreview
@Composable
private fun HomeHeaderPreview() {
    SnackTheme {
        HomeHeader()
    }
}