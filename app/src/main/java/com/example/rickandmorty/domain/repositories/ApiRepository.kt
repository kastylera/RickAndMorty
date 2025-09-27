package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.domain.models.CharactersData
import com.example.rickandmorty.domain.utils.ResultWrapper

interface ApiRepository {
    suspend fun getCharacters(page: Int): ResultWrapper<CharactersData>
}
