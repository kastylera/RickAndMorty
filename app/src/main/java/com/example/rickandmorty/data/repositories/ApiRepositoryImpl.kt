package com.example.rickandmorty.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.rickandmorty.data.datastores.CharacterDataStore
import com.example.rickandmorty.data.mappers.toDomain
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.pagingSources.CharacterRemoteMediator
import com.example.rickandmorty.domain.repositories.ApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val PAGE_SIZE = 20

@OptIn(ExperimentalPagingApi::class)
class ApiRepositoryImpl(
    private val localCharacterDataStore: CharacterDataStore,
    private val remoteCharacterDataStore: CharacterDataStore,
) : ApiRepository {
    override fun getCharactersPaging(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            remoteMediator = CharacterRemoteMediator(remoteCharacterDataStore, localCharacterDataStore),
            pagingSourceFactory = { localCharacterDataStore.getPagingSource() }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }
}
