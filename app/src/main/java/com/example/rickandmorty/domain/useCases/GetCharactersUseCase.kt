package com.example.rickandmorty.domain.useCases

import androidx.paging.PagingData
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.repositories.ApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: ApiRepository,
) {
    operator fun invoke(): Flow<PagingData<CharacterData>> = repository.getCharactersPaging()
}
