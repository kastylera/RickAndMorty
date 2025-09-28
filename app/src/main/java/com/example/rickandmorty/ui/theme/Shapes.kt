package com.example.rickandmorty.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val circle: Shape,
    val r24: Shape,
    val r16: Shape,
    val r12: Shape,
    val r8: Shape,
    val r4: Shape,
    val bottomSheet: Shape,
) {
    companion object {
        val NORMAL = Shapes(
            circle = CircleShape,
            r24 = RoundedCornerShape(24.dp),
            r16 = RoundedCornerShape(16.dp),
            r12 = RoundedCornerShape(12.dp),
            r8 = RoundedCornerShape(8.dp),
            r4 = RoundedCornerShape(4.dp),
            bottomSheet = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
        )
    }
}

internal val LocalShapes = staticCompositionLocalOf { Shapes.NORMAL }
