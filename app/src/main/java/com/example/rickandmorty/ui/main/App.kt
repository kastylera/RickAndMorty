package com.example.rickandmorty.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.rickandmorty.ui.navigation.AppNavigation
import com.example.rickandmorty.ui.navigation.Destination
import com.example.rickandmorty.ui.state.AppState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun App(appState: StateFlow<AppState>) {
    val state by appState.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()) {
        AppNavigation(Destination.CharacterList.route, state)
    }
}
