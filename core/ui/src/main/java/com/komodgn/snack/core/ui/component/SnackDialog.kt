package com.komodgn.snack.core.ui.component

import androidx.compose.foundation.background
import com.komodgn.snack.core.designsystem.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.component.button.SnackButton
import com.komodgn.snack.core.designsystem.component.button.smallRetroButtonSize
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.core.designsystem.theme.White

@Composable
fun SnackDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    confirmText: String? = null,
    dismissText: String? = null,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit = {}
) {
    Dialog(
        onDismissRequest = {
            onDismissClick()
        }
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
                .background(White,
                    shape = RoundedCornerShape(SnackTheme.radius.md)
                )
                .padding(
                    top = SnackTheme.spacing.spacing6,
                    start = SnackTheme.spacing.spacing4,
                    end = SnackTheme.spacing.spacing4,
                    bottom = SnackTheme.spacing.spacing4
                    ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = SnackTheme.typography.heading,
                color = SnackTheme.colors.contentPrimary
            )
            Spacer(
                modifier = Modifier.height(SnackTheme.spacing.spacing2)
            )
            Text(
                text = description,
                style = SnackTheme.typography.bodyLarge,
                color = SnackTheme.colors.contentPrimary
            )
            Spacer(
                modifier = Modifier.height(SnackTheme.spacing.spacing4)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                dismissText?.let { text ->
                    SnackButton(
                        modifier = Modifier.weight(1f),
                        text = text,
                        onClick = { onDismissClick },
                        size = smallRetroButtonSize,
                        backgroundDrawableRes = R.drawable.ic_pink_button
                    )
                }
                Spacer(modifier = Modifier.width(SnackTheme.spacing.spacing4))
                confirmText?.let { text ->
                    SnackButton(
                        modifier = Modifier.weight(1f),
                        text = text,
                        onClick = { onConfirmClick },
                        size = smallRetroButtonSize,
                        backgroundDrawableRes = R.drawable.ic_mint_button
                    )
                }
            }
        }
    }
}

@ComponentPreview
@Composable
fun SnackDialogPreview() {
    SnackTheme {
        SnackDialog(
            title = "Dialog title",
            description = "Dialog description",
            onConfirmClick = {},
            onDismissClick = {},
            confirmText = "OK",
            dismissText = "CANCLE"
        )
    }
}