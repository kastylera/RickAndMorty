package com.example.rickandmorty.domain.utils

sealed class DataException(override val message: String?) : Exception(message) {
   class DataNotExistException(message: String? = "Data not exist") : DataException(message)
}
