package com.example.rickandmorty.domain.models

import com.example.rickandmorty.core.DEFAULT_ID
import com.example.rickandmorty.core.EMPTY_STRING
import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) {
    companion object {
        val DEFAULT = CharacterData(
            id = DEFAULT_ID,
            name = EMPTY_STRING,
            status = EMPTY_STRING,
            species = EMPTY_STRING,
            type = EMPTY_STRING,
            gender = EMPTY_STRING,
            origin = Origin.DEFAULT,
            location = Location.DEFAULT,
            image = EMPTY_STRING,
            episode = emptyList(),
            url = EMPTY_STRING,
            created = EMPTY_STRING
        )
    }
}

@Serializable
data class Origin(
    val name: String,
    val url: String
) {
    companion object {
        val DEFAULT = Origin(
            name = EMPTY_STRING,
            url = EMPTY_STRING
        )
    }
}

@Serializable
data class Location(
    val name: String,
    val url: String
) {
    companion object {
        val DEFAULT = Location(
            name = EMPTY_STRING,
            url = EMPTY_STRING
        )
    }
}
