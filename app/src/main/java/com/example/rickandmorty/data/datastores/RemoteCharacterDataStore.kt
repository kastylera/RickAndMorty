package com.example.rickandmorty.data.datastores

import androidx.paging.PagingSource
import com.example.rickandmorty.data.network.ApiRetrofitService
import com.example.rickandmorty.data.roomModels.CharacterEntity
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.utils.noOp
import com.example.rickandmorty.domain.utils.noOpNothing
import com.example.rickandmorty.domain.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class RemoteCharacterDataStore(
    private val retrofitService: ApiRetrofitService,
    private val ioDispatcher: CoroutineDispatcher,
) : CharacterDataStore {

    override suspend fun getCharacters(page: Int) = safeApiCall(ioDispatcher) {
        retrofitService.getCharacters(page).toDomain()
    }

    override suspend fun saveCharacters(characters: List<CharacterData>) = noOp()
    override suspend fun clearCharacters() = noOp()
    override fun getPagingSource(): PagingSource<Int, CharacterEntity>  = noOpNothing()
    override suspend fun countCharacters() = noOpNothing()
}
