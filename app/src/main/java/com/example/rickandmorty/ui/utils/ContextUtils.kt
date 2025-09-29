package com.example.rickandmorty.ui.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

fun Context.getActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> this.baseContext.getActivity()
        else -> null
    }
}

fun Context.hideKeyboard() {
    getActivity()?.hideKeyboard()
}

private fun Activity.hideKeyboard() = WindowCompat.getInsetsController(window, window.decorView).hide(WindowInsetsCompat.Type.ime())
