package com.example.rickandmorty.domain.utils

sealed class DataException(override val message: String?) : Exception(message) {
    class RoomObjectNotFoundException(message: String? = "This object does not exist in the database") : DataException(message)
    class OperationException(message: String? = "Can't complete operation") : DataException(message)
    class DataNotExistException(message: String? = "Data not exist") : DataException(message)
}
