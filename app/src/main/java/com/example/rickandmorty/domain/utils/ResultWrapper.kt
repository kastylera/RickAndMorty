package com.example.rickandmorty.domain.utils

sealed class ResultWrapper<out R> {

    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val exception: Exception) : ResultWrapper<Nothing>()
}

val <T> ResultWrapper<T>.data: T?
    get() = (this as? ResultWrapper.Success)?.data
