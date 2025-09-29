package com.example.rickandmorty.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.rickandmorty.ui.utils.BaseViewModel
import kotlinx.coroutines.flow.collectLatest

interface NavigationState

@Composable
fun NavigationEffect(viewModel: BaseViewModel, navFunction: (NavigationState) -> Unit) {
    LaunchedEffect(Unit) {
        viewModel
            .navigation
            .collectLatest { navigation ->
                navFunction(navigation)
            }
    }
}
