package com.baubap.ds.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.baubap.ds.R

private val LatoLatin = FontFamily(
    Font(R.font.lato_latin_300_normal, FontWeight.Light),
    Font(R.font.lato_latin_400_normal, FontWeight.Normal),
    Font(R.font.lato_latin_700_normal, FontWeight.Bold),
)

private val Raleway = FontFamily(
    Font(R.font.raleway_latin_400_normal, FontWeight.Normal),
    Font(R.font.raleway_latin_700_normal, FontWeight.Bold),
)

object Fonts {
    /**
     * Bold, 32, 36
     */
    val LargeTitle = TextStyle(
        fontFamily = Raleway,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Title = TextStyle(
        fontFamily = Raleway,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Body1 = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Body2 = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Body3 = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Body4 = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val Caption = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val CaptionMedium = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp,
        fontFeatureSettings = "pnum, lnum",
    )

    val CaptionBold = TextStyle(
        fontFamily = LatoLatin,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.sp,
        fontFeatureSettings = "pnum, lnum",
    )
}

val AppTypography = Typography(
    displayLarge = Fonts.LargeTitle,
    displayMedium = Fonts.LargeTitle,
    displaySmall = Fonts.Title,
    headlineLarge = Fonts.Title,
    headlineMedium = Fonts.Title,
    headlineSmall = Fonts.Title,
    titleLarge = Fonts.Title,
    titleMedium = Fonts.Title,
    titleSmall = Fonts.Title,
    bodyLarge = Fonts.Body1,
    bodyMedium = Fonts.Body2,
    bodySmall = Fonts.Body3,
    labelLarge = Fonts.CaptionBold,
    labelMedium = Fonts.CaptionMedium,
    labelSmall = Fonts.Caption,
)
