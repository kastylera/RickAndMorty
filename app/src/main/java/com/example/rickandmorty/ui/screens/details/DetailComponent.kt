package com.example.rickandmorty.ui.screens.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.example.rickandmorty.domain.models.CharacterData

interface DetailComponent {
    val model: Value<CharacterData>

    fun onBackPressed()

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            data: CharacterData,
            onFinished: () -> Unit,
        ): DetailComponent
    }
}
