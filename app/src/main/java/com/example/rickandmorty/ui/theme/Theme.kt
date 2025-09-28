package com.example.rickandmorty.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun RickAndMortyTheme(content: @Composable () -> Unit) {

    CompositionLocalProvider(
        LocalRickAndMortyColorsLight provides lightRickAndMortyColorScheme,
        LocalRickAndMortyColorsDark provides darkRickAndMortyColorScheme,
        LocalTypography(AppTheme.colors.text.primary) provides rickAndMortyTypography(AppTheme.colors.text.primary)
    ) {
        MaterialTheme(
            colorScheme =  MaterialTheme.colorScheme.copy(
                primary = AppTheme.colors.buttons.primary,
                secondary = AppTheme.colors.buttons.secondary,
                background = AppTheme.colors.backgrounds.primary,
                surface = AppTheme.colors.backgrounds.card,
                error = AppTheme.colors.backgrounds.error,
                onPrimary = AppTheme.colors.text.white,
                onSecondary = AppTheme.colors.text.black,
                onBackground = AppTheme.colors.text.primary,
                onSurface = AppTheme.colors.text.secondary,
                onError = AppTheme.colors.text.error
            )
        ) {
            ProvideTextStyle(
                value = AppTheme.typography.body,
                content = content,
            )
        }
    }
}

object AppTheme {
    val colors: RickAndMortyColorGroupScheme
        @Composable
        get() = if (isSystemInDarkTheme()) LocalRickAndMortyColorsDark.current else LocalRickAndMortyColorsLight.current

    val typography: RickAndMortyTypography
        @Composable
        get() = LocalTypography(colors.text.primary).current

    val shapes: Shapes
        @Composable
        get() = LocalShapes.current

}
