package com.example.rickandmorty.domain.useCases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.pagingSources.CharactersPagingSource
import com.example.rickandmorty.domain.repositories.ApiRepository
import kotlinx.coroutines.flow.Flow

private const val PAGE_SIZE = 20

class GetCharactersUseCase(
    private val repository: ApiRepository,
) {
    operator fun invoke(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharactersPagingSource(repository) }
        ).flow
    }
}
