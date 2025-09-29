package com.example.rickandmorty.ui.utils

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.IntOffset

private const val ANIMATION_DURATION = 500

private val animationSpec = tween<IntOffset>(ANIMATION_DURATION)

val rightOutAnimation = slideOutHorizontally(animationSpec)
val rightInAnimation = slideInHorizontally(animationSpec)

val leftInAnimation = slideInHorizontally(
    initialOffsetX = { it },
    animationSpec = animationSpec
)

val leftOutAnimation = slideOutHorizontally(
    targetOffsetX = { it },
    animationSpec = animationSpec
)
