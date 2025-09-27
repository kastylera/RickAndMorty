package com.example.rickandmorty.domain.models

import com.example.rickandmorty.core.EMPTY_STRING

data class PaginationInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
) {
    companion object {
        val DEFAULT = PaginationInfo(
            count = 0,
            pages = 0,
            next = EMPTY_STRING,
            prev = EMPTY_STRING
        )
    }
}
