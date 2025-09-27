package com.example.rickandmorty.ui.screens.list

import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.useCases.GetCharactersUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ListInstance(
    getCharactersUseCase: GetCharactersUseCase,
) : InstanceKeeper.Instance {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    val characters: StateFlow<PagingData<CharacterData>> =
        getCharactersUseCase()
            .cachedIn(scope)
            .stateIn(scope, SharingStarted.Lazily, PagingData.empty())

    override fun onDestroy() {
        scope.cancel()
    }
}
