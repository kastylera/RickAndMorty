package com.example.rickandmorty.ui.screens.list

import androidx.paging.PagingData
import com.arkivanov.decompose.ComponentContext
import com.example.rickandmorty.domain.models.CharacterData
import kotlinx.coroutines.flow.Flow

interface ListComponent {
    val characters: Flow<PagingData<CharacterData>>

    fun onItemClicked(data: CharacterData)

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            itemClicked: (data: CharacterData) -> Unit,
        ): ListComponent
    }
}
