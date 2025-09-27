package com.example.rickandmorty.data.models

import com.example.rickandmorty.core.Dto
import com.example.rickandmorty.domain.models.CharactersData
import com.example.rickandmorty.domain.models.PaginationInfo
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: PaginationInfoDto? = null,
    @SerializedName("results") val results: List<CharacterDto>? = null,
) : Dto<CharactersData> {
    override fun toDomain() = CharactersData(
        pagination = info?.toDomain() ?: PaginationInfo.DEFAULT,
        characters = results?.map { it.toDomain() }.orEmpty()
    )
}
