package com.example.rickandmorty.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.core.EMPTY_STRING
import com.example.rickandmorty.ui.state.NavigationState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val errorMessage = MutableStateFlow(EMPTY_STRING)
    protected val isLoading = MutableStateFlow(false)

    private val _navigation = Channel<NavigationState>(Channel.BUFFERED)
    val navigation = _navigation.receiveAsFlow()

    protected fun navigation(navigation: NavigationState) = launch { _navigation.send(navigation) }

    fun resetErrorMessage() {
        errorMessage.value = EMPTY_STRING
    }

    protected fun ViewModel.launch(
        scope: CoroutineScope = viewModelScope,
        block: suspend CoroutineScope.() -> Unit,
    ) = scope.launch {
        block()
    }
}
