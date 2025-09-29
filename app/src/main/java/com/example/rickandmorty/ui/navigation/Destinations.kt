package com.example.rickandmorty.ui.navigation

const val CHARACTER = "character"

sealed class Destination(val route: String) {
    data object CharacterList : Destination("characters_list")
    data object CharacterDetails : Destination("character_details")
}
