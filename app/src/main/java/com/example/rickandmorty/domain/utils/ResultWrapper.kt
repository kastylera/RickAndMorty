package com.example.rickandmorty.domain.utils

import com.example.rickandmorty.core.EMPTY_STRING
import kotlinx.coroutines.CancellationException
import kotlin.text.isNullOrBlank
import kotlin.text.orEmpty

sealed class ResultWrapper<out R> {

    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val exception: Exception) : ResultWrapper<Nothing>() {
        companion object {
            const val NO_INTERNET_ERROR_MESSAGE = "NO_INTERNET_ERROR_MESSAGE"
            const val SERVER_ERROR_MESSAGE = "SERVER_ERROR_MESSAGE"
            const val DEFAULT_LOCAL_ERROR_MESSAGE = "DEFAULT_LOCAL_ERROR_MESSAGE"
        }

        override fun toString() =
            when (exception) {
                is NetworkException.InternetConnectionException -> NO_INTERNET_ERROR_MESSAGE
                is NetworkException.ServerException -> SERVER_ERROR_MESSAGE
                is NetworkException.AppHttpException ->
                    if (!exception.message.isNullOrBlank()) exception.message.orEmpty() else DEFAULT_LOCAL_ERROR_MESSAGE

                is CancellationException -> EMPTY_STRING

                else -> DEFAULT_LOCAL_ERROR_MESSAGE
            }
    }
}

val ResultWrapper<*>.succeeded
    get() = this is ResultWrapper.Success && data != null

fun <T> ResultWrapper<T>.successOr(fallback: T): T {
    return (this as? ResultWrapper.Success<T>)?.data ?: fallback
}

val <T> ResultWrapper<T>.data: T?
    get() = (this as? ResultWrapper.Success)?.data
