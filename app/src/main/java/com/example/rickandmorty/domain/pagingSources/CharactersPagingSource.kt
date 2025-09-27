package com.example.rickandmorty.domain.pagingSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.domain.repositories.ApiRepository
import com.example.rickandmorty.domain.utils.ResultWrapper

class CharactersPagingSource(
    private val apiRepository: ApiRepository
) : PagingSource<Int, CharacterData>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        return try {
            val page = params.key ?: 1
            val result = apiRepository.getCharacters(page)
            when (result) {
                is ResultWrapper.Success -> {
                    val characters = result.data.characters
                    val nextPage = if (result.data.pagination.next.isNotEmpty()) page + 1 else null
                    val prevPage = if (page > 1) page - 1 else null

                    LoadResult.Page(
                        data = characters,
                        prevKey = prevPage,
                        nextKey = nextPage
                    )
                }

                is ResultWrapper.Error -> LoadResult.Error(result.exception)
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
