package com.komodgn.snack.core.designsystem.component.button

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.R
import com.komodgn.snack.core.designsystem.theme.SnackTheme
import com.komodgn.snack.core.designsystem.theme.SnackTheme.colors

@Composable
fun SnackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundDrawableRes: Int,
    size: RetroButtonSize = mediumRetroButtonSize,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: Painter? = null,
    text: String? = null,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val targetContentColor = if (enabled) colors.contentPrimary else colors.contentDisabled

    val initialOffset = 0.dp

    val targetOffset = if (isPressed && enabled) {
        initialOffset + size.contentVerticalOffset
    } else {
        initialOffset
    }

    val animatedOffset by animateDpAsState(
        targetValue = targetOffset,
        label = "ButtonVerticalOffsetAnimation"
    )

    Box(
        modifier = modifier
            .size(size.totalSize)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = backgroundDrawableRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .offset(y = animatedOffset),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(size.iconSize),
                    tint = targetContentColor,
                )
            }
            if (text != null) {
                Text(
                    text = text,
                    style = size.textStyle,
                    color = targetContentColor,
                )
            }
        }
    }
}

@ComponentPreview
@Composable
private fun SnackButtonPreview() {
    SnackTheme {
        val shootIcon = painterResource(R.drawable.ic_photo_camera)
        val dummyBackground = R.drawable.ic_mint_button

        Box(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .padding(SnackTheme.spacing.spacing2)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SnackButton(
                    onClick = { },
                    size = mediumRetroButtonSize,
                    backgroundDrawableRes = dummyBackground,
                    icon = shootIcon,
                    text = "GALLERY",
                )
                SnackButton(
                    onClick = { },
                    size = smallRetroButtonSize,
                    backgroundDrawableRes = dummyBackground,
                    icon = shootIcon,
                    text = "SMALL",
                )
                SnackButton(
                    onClick = { },
                    size = smallRetroButtonSize,
                    backgroundDrawableRes = dummyBackground,
                    icon = shootIcon,
                    text = "SMALL",
                    enabled = false,
                )
                SnackButton(
                    onClick = { },
                    size = smallRetroButtonSize,
                    backgroundDrawableRes = dummyBackground,
                    text = "SMALL",
                )
                SnackButton(
                    onClick = { },
                    size = smallRetroButtonSize,
                    backgroundDrawableRes = dummyBackground,
                    icon = shootIcon,
                )
            }
        }
    }
}
