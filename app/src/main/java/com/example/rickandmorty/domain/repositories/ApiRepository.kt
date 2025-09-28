package com.example.rickandmorty.domain.repositories

import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.CharacterData
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    fun getCharactersPaging(): Flow<PagingData<CharacterData>>
}
