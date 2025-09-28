package com.example.rickandmorty.data.datastores

import androidx.paging.PagingSource
import com.example.rickandmorty.data.roomModels.CharacterEntity
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.models.CharactersData
import com.example.rickandmorty.domain.utils.ResultWrapper

interface CharacterDataStore {
    fun getPagingSource(): PagingSource<Int, CharacterEntity>
    suspend fun getCharacters(page: Int): ResultWrapper<CharactersData>
    suspend fun saveCharacters(characters: List<CharacterData>)
    suspend fun clearCharacters()
    suspend fun countCharacters(): Int
}
