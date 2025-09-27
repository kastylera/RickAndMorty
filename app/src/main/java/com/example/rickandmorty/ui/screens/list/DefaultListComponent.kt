package com.example.rickandmorty.ui.screens.list

import androidx.paging.PagingData
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.useCases.GetCharactersUseCase
import kotlinx.coroutines.flow.StateFlow

class DefaultListComponent(
    componentContext: ComponentContext,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val itemClicked: (item: CharacterData) -> Unit,
) : ListComponent, ComponentContext by componentContext {

    private val instance: CharacterInstance =
        instanceKeeper.getOrCreate { CharacterInstance(getCharactersUseCase) }

    override val characters: StateFlow<PagingData<CharacterData>>
        get() = instance.characters

    override fun onItemClicked(data: CharacterData) = itemClicked(data)

    class Factory(
        private val useCase: GetCharactersUseCase
    ) : ListComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            itemClicked: (CharacterData) -> Unit
        ): ListComponent {
            return DefaultListComponent(
                componentContext = componentContext,
                itemClicked = itemClicked,
                getCharactersUseCase = useCase,
            )
        }
    }
}
