package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofitService {
    @GET("/api/character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersResponse
}
