package com.komodgn.snack.core.designsystem.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.komodgn.snack.core.designsystem.ComponentPreview
import com.komodgn.snack.core.designsystem.R

val galmuriFamily = FontFamily(
    Font(R.font.galmuri11_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.galmuri_mono11, FontWeight.Normal, FontStyle.Normal)
)

private val defaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

private val baseTextStyle = TextStyle(
    fontFamily = galmuriFamily,
    lineHeightStyle = defaultLineHeightStyle,
    color = Neutral800
)

private fun retroStyle(
    fontSize: Int,
    lineHeight: Int,
    fontWeight: FontWeight
) = baseTextStyle.copy(
    fontSize = fontSize.sp,
    lineHeight = lineHeight.sp,
    fontWeight = fontWeight,
    letterSpacing = 0.sp
)

@Immutable
data class RetroTypography(
    val heading: TextStyle = retroStyle(17, 22, FontWeight.Bold),

    val displayLarge: TextStyle = retroStyle(24, 30, FontWeight.Bold),
    val displayMedium: TextStyle = retroStyle(20, 26, FontWeight.Bold),

    val bodyLarge: TextStyle = retroStyle(15, 20, FontWeight.Normal),
    val bodyMedium: TextStyle = retroStyle(13, 28, FontWeight.Normal),

    val label: TextStyle = retroStyle(12, 16, FontWeight.Normal)
)

@ComponentPreview
@Composable
private fun RetroTypographyPreview() {
    SnackTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = "Header - 헤더",
                style = SnackTheme.typography.heading,
                color = SnackTheme.colors.contentPrimary
            )
            Text(
                text = "displayLarge - 디스플레이",
                style = SnackTheme.typography.displayLarge,
                color = SnackTheme.colors.contentPrimary
            )
            Text(
                text = "displayMedium - 디스플레이",
                style = SnackTheme.typography.displayMedium,
                color = SnackTheme.colors.contentPrimary
            )
            Text(
                text = "bodyLarge - 본문",
                style = SnackTheme.typography.bodyLarge,
                color = SnackTheme.colors.contentPrimary
            )
            Text(
                text = "bodyMedium - 본문",
                style = SnackTheme.typography.bodyMedium,
                color = SnackTheme.colors.contentPrimary
            )
            Text(
                text = "label - 레이블",
                style = SnackTheme.typography.label,
                color = SnackTheme.colors.contentPrimary
            )
        }
    }
}