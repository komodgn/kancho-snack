package com.komodgn.snack.feature.shoot.ocr.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.theme.Black
import com.komodgn.snack.core.designsystem.theme.ContentOnDark
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.feature.shoot.R

@Composable
fun OcrHeader(
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Black)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(SnackTheme.spacing.spacing4))
        IconButton(
            onClick = { onBackButtonClick() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "Arrow Back Icon",
                tint = ContentOnDark
            )
        }
    }
}

@ComponentPreview
@Composable
private fun OcrHeader() {
    SnackTheme {
        OcrHeader(
            onBackButtonClick = {}
        )
    }
}