package com.example.rickandmorty.data.datastores

import androidx.paging.PagingSource
import com.example.rickandmorty.data.db.dao.CharacterDao
import com.example.rickandmorty.data.mappers.toEntity
import com.example.rickandmorty.data.roomModels.CharacterEntity
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.utils.noOpResult

class LocalCharacterDataStore(
    private val dao: CharacterDao
    ) : CharacterDataStore {

    override fun getPagingSource(): PagingSource<Int, CharacterEntity> = dao.getAllCharacters()

    override suspend fun saveCharacters(characters: List<CharacterData>) {
        dao.insertAll(characters.map { it.toEntity() })
    }

    override suspend fun clearCharacters() {
        dao.clearAll()
    }

    override suspend fun countCharacters(): Int {
        return dao.countCharacters()
    }

    override suspend fun getCharacters(page: Int) = noOpResult()
}
