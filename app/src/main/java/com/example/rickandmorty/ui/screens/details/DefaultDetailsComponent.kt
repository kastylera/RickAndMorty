package com.example.rickandmorty.ui.screens.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.rickandmorty.domain.models.CharacterData

class DefaultDetailComponent(
    componentContext: ComponentContext,
    data: CharacterData,
    private val onFinished: () -> Unit,
) : DetailComponent, ComponentContext by componentContext {

    override val model: Value<CharacterData> = MutableValue(data)

    override fun onBackPressed() = onFinished()

    class Factory : DetailComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            data: CharacterData,
            onFinished: () -> Unit,
        ): DetailComponent = DefaultDetailComponent(
            componentContext = componentContext,
            data = data,
            onFinished = onFinished,
        )
    }
}
