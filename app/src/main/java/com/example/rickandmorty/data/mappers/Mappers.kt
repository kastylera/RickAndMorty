package com.example.rickandmorty.data.mappers

import com.example.rickandmorty.data.roomModels.CharacterEntity
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.models.Location
import com.example.rickandmorty.domain.models.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun CharacterData.toEntity(): CharacterEntity = CharacterEntity(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    originJson = Gson().toJson(origin),
    locationJson = Gson().toJson(location),
    image = image,
    episodeJson = Gson().toJson(episode),
    url = url,
    created = created
)

fun CharacterEntity.toDomain(): CharacterData = CharacterData(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = Gson().fromJson(originJson, Origin::class.java),
    location = Gson().fromJson(locationJson, Location::class.java),
    image = image,
    episode = Gson().fromJson(episodeJson, object : TypeToken<List<String>>() {}.type),
    url = url,
    created = created
)
