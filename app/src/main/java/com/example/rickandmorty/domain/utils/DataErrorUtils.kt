package com.example.rickandmorty.domain.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun noOp(): Unit = Unit
fun <T> noOpFlow(exception: DataException = DataException.DataNotExistException()): Flow<T> =
    flow { throw exception }
fun noOpNothing(exception: DataException = DataException.DataNotExistException()): Nothing = throw exception
fun noOpResult(exception: DataException = DataException.DataNotExistException()) = ResultWrapper.Error(exception)
