package com.example.rickandmorty.domain.utils

fun noOp(): Unit = Unit
fun noOpNothing(exception: DataException = DataException.DataNotExistException()): Nothing = throw exception
fun noOpResult(exception: DataException = DataException.DataNotExistException()) = ResultWrapper.Error(exception)
