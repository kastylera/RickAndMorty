package com.example.rickandmorty.core

interface Dto<T> {
    fun toDomain(): T
}
