package com.example.rickandmorty.data.models

import com.example.rickandmorty.core.Dto
import com.example.rickandmorty.core.orZero
import com.example.rickandmorty.domain.models.PaginationInfo
import com.google.gson.annotations.SerializedName

data class PaginationInfoDto(
    @SerializedName("count") val count: Int? = null,
    @SerializedName("pages") val pages: Int? = null,
    @SerializedName("next") val next: String? = null,
    @SerializedName("prev") val prev: String? = null,
) : Dto<PaginationInfo> {
    override fun toDomain() = PaginationInfo(
        count = count.orZero(),
        pages = pages.orZero(),
        next = next.orEmpty(),
        prev = prev.orEmpty()
    )
}
