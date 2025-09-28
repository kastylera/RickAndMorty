package com.example.rickandmorty.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalRickAndMortyColorsLight = staticCompositionLocalOf { lightRickAndMortyColorScheme }
internal val LocalRickAndMortyColorsDark = staticCompositionLocalOf { darkRickAndMortyColorScheme }

data class RickAndMortyColorGroupScheme(
    val backgrounds: RickAndMortyColorScheme.Backgrounds,
    val text: RickAndMortyColorScheme.Text,
    val buttons: RickAndMortyColorScheme.Buttons,
    val icons: RickAndMortyColorScheme.Icons,
    val fields: RickAndMortyColorScheme.FieldsColors,
    val dividers: RickAndMortyColorScheme.Dividers,
    val toasts: RickAndMortyColorScheme.Toasts,
    val badges: RickAndMortyColorScheme.Badges,
    val base: RickAndMortyColorScheme.BaseColors
)

sealed class RickAndMortyColorScheme {

    data class Backgrounds(
        val primary: Color,
        val secondary: Color,
        val overlay: Color,
        val card: Color,
        val error: Color,
    ) : RickAndMortyColorScheme()

    data class Text(
        val primary: Color,
        val secondary: Color,
        val disabled: Color,
        val title: Color,
        val subtitle: Color,
        val accent: Color,
        val error: Color,
        val white: Color,
        val black: Color
    ) : RickAndMortyColorScheme()

    data class Buttons(
        val primary: Color,
        val secondary: Color,
        val accent: Color,
        val inactive: Color,
        val error: Color
    ) : RickAndMortyColorScheme()

    data class Icons(
        val primary: Color,
        val secondary: Color,
        val inactive: Color,
        val accent: Color,
        val error: Color
    ) : RickAndMortyColorScheme()

    data class FieldsColors(
        val focused: Color,
        val unfocused: Color,
        val disabled: Color,
        val error: Color
    ) : RickAndMortyColorScheme()

    data class Dividers(
        val primary: Color,
        val secondary: Color
    ) : RickAndMortyColorScheme()

    data class Toasts(
        val success: Color,
        val warning: Color,
        val error: Color,
        val info: Color
    ) : RickAndMortyColorScheme()

    data class Badges(
        val alive: Color,
        val dead: Color,
        val unknown: Color
    ) : RickAndMortyColorScheme()

    data class BaseColors(
        val white: Color,
        val black: Color,
        val grayLight: Color,
        val grayDark: Color,
        val green: Color,
        val red: Color,
        val blue: Color,
        val yellow: Color
    ) : RickAndMortyColorScheme()
}

val lightRickAndMortyColorScheme = RickAndMortyColorGroupScheme(
    backgrounds = RickAndMortyColorScheme.Backgrounds(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFEFFBF1),
        overlay = Color(0x804D4D4D),
        card = Color(0xFFF5F5F5),
        error = Color(0xFFFFCDD2)
    ),
    text = RickAndMortyColorScheme.Text(
        primary = Color(0xFF1C1C1C),
        secondary = Color(0xFF555555),
        disabled = Color(0xFF9E9E9E),
        title = Color(0xFF111111),
        subtitle = Color(0xFF777777),
        accent = Color(0xFF00C853),
        error = Color(0xFFD50000),
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000)
    ),
    buttons = RickAndMortyColorScheme.Buttons(
        primary = Color(0xFF00BFA5),
        secondary = Color(0xFFE0E0E0),
        accent = Color(0xFF7C4DFF),
        inactive = Color(0xFFBDBDBD),
        error = Color(0xFFD50000)
    ),
    icons = RickAndMortyColorScheme.Icons(
        primary = Color(0xFF212121),
        secondary = Color(0xFF757575),
        inactive = Color(0xFFBDBDBD),
        accent = Color(0xFF00C853),
        error = Color(0xFFD50000)
    ),
    fields = RickAndMortyColorScheme.FieldsColors(
        focused = Color(0xFF00BFA5),
        unfocused = Color(0xFF9E9E9E),
        disabled = Color(0xFFE0E0E0),
        error = Color(0xFFD50000)
    ),
    dividers = RickAndMortyColorScheme.Dividers(
        primary = Color(0xFFE0E0E0),
        secondary = Color(0xFFBDBDBD)
    ),
    toasts = RickAndMortyColorScheme.Toasts(
        success = Color(0xFFB9F6CA),
        warning = Color(0xFFFFF59D),
        error = Color(0xFFFF8A80),
        info = Color(0xFF80D8FF)
    ),
    badges = RickAndMortyColorScheme.Badges(
        alive = Color(0xFF4CAF50),
        dead = Color(0xFFF44336),
        unknown = Color(0xFF9E9E9E)
    ),
    base = RickAndMortyColorScheme.BaseColors(
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000),
        grayLight = Color(0xFFF5F5F5),
        grayDark = Color(0xFF212121),
        green = Color(0xFF00C853),
        red = Color(0xFFD50000),
        blue = Color(0xFF2962FF),
        yellow = Color(0xFFFFC107)
    )
)

val darkRickAndMortyColorScheme = RickAndMortyColorGroupScheme(
    backgrounds = RickAndMortyColorScheme.Backgrounds(
        primary = Color(0xFF121212),
        secondary = Color(0xFF1E1E1E),
        overlay = Color(0xB3000000),
        card = Color(0xFF1C1C1C),
        error = Color(0xFFB71C1C)
    ),
    text = RickAndMortyColorScheme.Text(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFB0BEC5),
        disabled = Color(0xFF757575),
        title = Color(0xFFFFFFFF),
        subtitle = Color(0xFF90A4AE),
        accent = Color(0xFF69F0AE),
        error = Color(0xFFFF5252),
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000)
    ),
    buttons = RickAndMortyColorScheme.Buttons(
        primary = Color(0xFF00E676),
        secondary = Color(0xFF424242),
        accent = Color(0xFF7C4DFF),
        inactive = Color(0xFF616161),
        error = Color(0xFFFF1744)
    ),
    icons = RickAndMortyColorScheme.Icons(
        primary = Color(0xFFFFFFFF),
        secondary = Color(0xFFB0BEC5),
        inactive = Color(0xFF757575),
        accent = Color(0xFF00E676),
        error = Color(0xFFFF1744)
    ),
    fields = RickAndMortyColorScheme.FieldsColors(
        focused = Color(0xFF00E676),
        unfocused = Color(0xFF616161),
        disabled = Color(0xFF424242),
        error = Color(0xFFFF1744)
    ),
    dividers = RickAndMortyColorScheme.Dividers(
        primary = Color(0xFF424242),
        secondary = Color(0xFF616161)
    ),
    toasts = RickAndMortyColorScheme.Toasts(
        success = Color(0xFF388E3C),
        warning = Color(0xFFFBC02D),
        error = Color(0xFFD32F2F),
        info = Color(0xFF1976D2)
    ),
    badges = RickAndMortyColorScheme.Badges(
        alive = Color(0xFF00E676),
        dead = Color(0xFFFF1744),
        unknown = Color(0xFF9E9E9E)
    ),
    base = RickAndMortyColorScheme.BaseColors(
        white = Color(0xFFFFFFFF),
        black = Color(0xFF000000),
        grayLight = Color(0xFF424242),
        grayDark = Color(0xFF121212),
        green = Color(0xFF00E676),
        red = Color(0xFFFF1744),
        blue = Color(0xFF448AFF),
        yellow = Color(0xFFFFEB3B)
    )
)
