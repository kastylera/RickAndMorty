package com.example.rickandmorty.data.models

import com.example.rickandmorty.core.Dto
import com.example.rickandmorty.core.orZero
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.models.Location
import com.example.rickandmorty.domain.models.Origin
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("species")
    val species: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("gender")
    val gender: String? = null,

    @SerializedName("origin")
    val origin: OriginDto? = null,

    @SerializedName("location")
    val location: LocationDto? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("episode")
    val episode: List<String>? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("created")
    val created: String? = null
) : Dto<CharacterData> {
    override fun toDomain() = CharacterData(
        id = id.orZero(),
        name = name.orEmpty(),
        status = status.orEmpty(),
        species = species.orEmpty(),
        type = type.orEmpty(),
        gender = gender.orEmpty(),
        origin = origin?.toDomain() ?: Origin.DEFAULT,
        location = location?.toDomain() ?: Location.DEFAULT,
        image = image.orEmpty(),
        episode = episode.orEmpty(),
        url = url.orEmpty(),
        created = created.orEmpty()
    )
}

data class OriginDto(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
) : Dto<Origin> {
    override fun toDomain() = Origin(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}

data class LocationDto(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
) : Dto<Location> {
    override fun toDomain() = Location(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}
