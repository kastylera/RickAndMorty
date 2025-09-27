package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.network.ApiRetrofitService
import com.example.rickandmorty.domain.repositories.ApiRepository
import com.example.rickandmorty.domain.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher

class ApiRepositoryImpl(
    private val retrofitService: ApiRetrofitService,
    private val ioDispatcher: CoroutineDispatcher,
) : ApiRepository {
    override suspend fun getCharacters(page: Int) = safeApiCall(ioDispatcher) {
        retrofitService.getCharacters(page).toDomain()
    }
}
