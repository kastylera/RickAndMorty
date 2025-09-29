package com.example.rickandmorty.ui.state

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
) = remember(navController, context) {
    MutableStateFlow(AppState(navController, context))
}

class AppState(
    val navController: NavHostController,
    private val context: Context,
) {
    /* other general state: Toast, Hint, Loading
    Example:
    var fullscreenLoadingState by mutableStateOf(false)
        private set

    fun updateFullscreenLoadingState(isShowing: Boolean) {
        fullscreenLoadingState = isShowing
    }
     */

}
