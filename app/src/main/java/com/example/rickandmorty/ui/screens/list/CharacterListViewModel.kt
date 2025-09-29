package com.example.rickandmorty.ui.screens.list

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.useCases.GetCharactersUseCase
import com.example.rickandmorty.ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    getCharactersUseCase: GetCharactersUseCase
): BaseViewModel(){

    val charactersPagingData = getCharactersUseCase.invoke().cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    fun onItemClicked(item: CharacterData) {
        navigation(CharacterNavigationState.ToDetails(item))
    }
}
