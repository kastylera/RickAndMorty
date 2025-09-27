package com.example.rickandmorty.domain.models

data class CharactersData(
    val pagination: PaginationInfo,
    val characters: List<CharacterData>
)
