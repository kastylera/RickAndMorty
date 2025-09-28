package com.example.rickandmorty.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.R

data class RickAndMortyTypography(
    val small: TextStyle,
    val caption: TextStyle,
    val body: TextStyle,
    val subHeader: TextStyle,
    val title: TextStyle,
    val barItem: TextStyle,
    val linkHeader: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val text14: TextStyle,
    val text16: TextStyle
)

val interFont = FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_bold, weight = FontWeight.Bold),
)

val cartoonFont = FontFamily(
    Font(R.font.comic_neue_regular, weight = FontWeight.Normal),
    Font(R.font.comic_neue_bold, weight = FontWeight.Bold),
)

fun rickAndMortyTypography(color: Color) = RickAndMortyTypography(
    small = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = interFont,
        fontWeight = FontWeight.Medium,
        color = color
    ),
    title = TextStyle(
        fontSize = 22.sp,
        lineHeight = 30.sp,
        fontFamily = cartoonFont,
        fontWeight = FontWeight.Bold,
        color = color
    ),
    body = TextStyle(
        fontSize = 15.sp,
        lineHeight = 22.sp,
        fontFamily = interFont,
        fontWeight = FontWeight.Normal,
        color = color
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontFamily = interFont,
        fontWeight = FontWeight.Light,
        color = color
    ),
    subHeader = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontFamily = cartoonFont,
        fontWeight = FontWeight.Medium,
        color = color
    ),
    barItem = TextStyle(
        fontSize = 11.sp,
        lineHeight = 14.sp,
        fontFamily = interFont,
        fontWeight = FontWeight.SemiBold,
        color = color
    ),
    linkHeader = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontFamily = interFont,
        fontWeight = FontWeight.Bold,
        color = color
    ),
    text14 = dText14,
    text16 = dText16,
    h1 = dH1,
    h2 = dH2,
    h3 = dH3,
    h4 = dH4
)

private val dH1 = TextStyle(
    fontFamily = cartoonFont,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 36.sp,
    platformStyle = PlatformTextStyle(includeFontPadding = false),
    color = lightRickAndMortyColorScheme.text.primary,
)

private val dH2 = TextStyle(
    fontFamily = cartoonFont,
    fontWeight = FontWeight.Medium,
    fontSize = 26.sp,
    lineHeight = 30.sp,
    color = lightRickAndMortyColorScheme.text.primary,
)

private val dH3 = TextStyle(
    fontFamily = cartoonFont,
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    color = lightRickAndMortyColorScheme.text.primary,
)

private val dH4 = TextStyle(
    fontFamily = cartoonFont,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 24.sp,
    color = lightRickAndMortyColorScheme.text.primary,
)

private val dText16 = TextStyle(
    fontFamily = interFont,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = lightRickAndMortyColorScheme.text.secondary,
)

private val dText14 = TextStyle(
    fontFamily = interFont,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    color = lightRickAndMortyColorScheme.text.primary,
)

fun TextStyle.bold() = this.copy(fontWeight = FontWeight.Bold)
fun TextStyle.regular() = this.copy(fontWeight = FontWeight.Normal)
fun TextStyle.semiBold() = this.copy(fontWeight = FontWeight.SemiBold)
fun TextStyle.medium() = this.copy(fontWeight = FontWeight.Medium)

internal fun LocalTypography(color: Color) = staticCompositionLocalOf { rickAndMortyTypography(color) }
