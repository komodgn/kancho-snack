package com.komodgn.snack.core.designsystem.theme

import androidx.compose.ui.graphics.Color

val Neutral50 = Color(0xFFFAFAFA)
val Neutral100 = Color(0xFFF5F5F5)
val Neutral200 = Color(0xFFE5E5E5)
val Neutral300 = Color(0xFFD4D4D4)
val Neutral400 = Color(0xFFA1A1A1)
val Neutral500 = Color(0xFF737373)
val Neutral600 = Color(0xFF525252)
val Neutral700 = Color(0xFF404040)
val Neutral800 = Color(0xFF262626)
val Neutral900 = Color(0xFF171717)
val Neutral950 = Color(0xFF0A0A0A)

val Yellow50 = Color(0xFFFFF8E0)
val Yellow100 = Color(0xFFFFEDB0)
val Yellow200 = Color(0xFFFFE17C)
val Yellow300 = Color(0xFFFFD743)
val Yellow400 = Color(0xFFFFCC00)
val Yellow500 = Color(0xFFFFC300)
val Yellow600 = Color(0xFFFFB500)
val Yellow700 = Color(0xFFFFA100)
val Yellow800 = Color(0xFFFF8F00)
val Yellow900 = Color(0xFFFF6D00)

val ContentOnDark = Color(0xFFFFFFFF)
val ContentOnLight = Color(0xFF000000)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val RetroPurple = Color(0xFF906BE3)
val RetroMint = Color(0xFF4BCA8B)
val RetroPink = Color(0xFFE64B95)
val RetroLightBg = Color(0xFFD8E2D6) // 외부 배경
val RetroDarkSurface = Color(0xFF141C1A) // 가장 어두운 표면/테두리

val RetroScreenBg = Color(0xFF93D698) // 화면 내부 배경 (옅은 녹색)
val RetroScreenBorder = Color(0xFF3A753D) // 화면 내부 테두리 (진한 녹색)
val RetroHighlight = Color(0xFFFFEA3C) // 노란색 하이라이트/경고

data class SnackColorSchema(
    val basePrimary: Color = ContentOnDark,
    val baseSecondary: Color = Neutral50,
//    val bgPrimary: Color = Green500,
//    val bgPrimaryPressed: Color = Green600,
    val bgSecondary: Color = Neutral100,
    val bgSecondaryPressed: Color = Neutral200,
//    val bgTertiary: Color = Green100,
//    val bgTertiaryPressed: Color = Green200,
    val bgDisabled: Color = Neutral200,
    val contentPrimary: Color = Neutral800,
    val contentSecondary: Color = Neutral500,
    val contentTertiary: Color = Neutral400,
    val contentBrand: Color = RetroPurple,
    val contentDisabled: Color = Neutral400,
    val contentInverse: Color = ContentOnDark,
    val contentError: Color = RetroHighlight,
    val contentInfo: Color = Yellow500,
    val contentSuccess: Color = RetroPurple,
    val contentWarning: Color = Yellow300,
    val borderPrimary: Color = Neutral200,
    val borderSecondary: Color = Neutral100,
    val borderBrand: Color = RetroPurple,
    val borderError: Color = RetroHighlight,
    val dividerSm: Color = Neutral200,
    val dividerMd: Color = Neutral100,
    val retroDevicePrimary: Color = RetroPurple,
    val retroButtonAccent: Color = RetroMint,
    val retroButtonSecondary: Color = RetroPink,
    val retroOuterBackground: Color = RetroLightBg,
    val retroDarkestSurface: Color = RetroDarkSurface,
    val retroScreenBackground: Color = RetroScreenBg,
    val retroScreenBorder: Color = RetroScreenBorder,
    val retroScreenHighlight: Color = RetroHighlight,
)
