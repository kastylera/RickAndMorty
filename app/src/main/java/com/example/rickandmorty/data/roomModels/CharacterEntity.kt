package com.example.rickandmorty.data.roomModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originJson: String,
    val locationJson: String,
    val image: String,
    val episodeJson: String,
    val url: String,
    val created: String
)
