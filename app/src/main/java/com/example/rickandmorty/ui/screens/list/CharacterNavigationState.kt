package com.example.rickandmorty.ui.screens.list

import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.ui.state.NavigationState

sealed class CharacterNavigationState : NavigationState {
    data class ToDetails(val item: CharacterData) : CharacterNavigationState()
}
