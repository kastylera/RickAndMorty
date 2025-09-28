package com.example.rickandmorty.domain.pagingSources

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.rickandmorty.data.datastores.CharacterDataStore
import com.example.rickandmorty.data.roomModels.CharacterEntity
import com.example.rickandmorty.domain.utils.ResultWrapper

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val remoteDataStore: CharacterDataStore,
    private val localDataStore: CharacterDataStore,
) : RemoteMediator<Int, CharacterEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) 1 else lastItem.id / state.config.pageSize + 1
            }
        }

        if (loadType == LoadType.REFRESH && localDataStore.countCharacters() > 0) {
            return MediatorResult.Success(endOfPaginationReached = false)
        }

        return try {
            val result = remoteDataStore.getCharacters(page)
            when (result) {
                is ResultWrapper.Success -> {
                    localDataStore.saveCharacters(result.data.characters)
                    MediatorResult.Success(endOfPaginationReached = result.data.pagination.next.isEmpty())
                }
                is ResultWrapper.Error -> MediatorResult.Error(result.exception)
            }


        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
