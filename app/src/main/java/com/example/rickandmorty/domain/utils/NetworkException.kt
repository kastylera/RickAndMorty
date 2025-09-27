package com.example.rickandmorty.domain.utils

import java.io.IOException

sealed class NetworkException(override val message: String?) : IOException(message) {
    class AppHttpException(val code: Int? = null, message: String? = "AppHttpException") : NetworkException(message)
    class ServerException(val code: Int? = null, message: String? = "ServerException") : NetworkException(message)
    class InternetConnectionException(message: String? = "Failed to connect to server") : NetworkException(message)
}
