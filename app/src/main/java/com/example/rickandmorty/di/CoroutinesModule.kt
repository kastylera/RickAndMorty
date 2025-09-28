package com.example.rickandmorty.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coroutinesModule = module {
    single<CoroutineDispatcher>(named(DEFAULT_DISPATCHER)) { Dispatchers.Default }
    single<CoroutineDispatcher>(named(IO_DISPATCHER)) { Dispatchers.IO }
    single<CoroutineDispatcher>(named(MAIN_DISPATCHER)) { Dispatchers.Main }
    single<CoroutineDispatcher>(named(MAIN_IMMEDIATE_DISPATCHER)) { Dispatchers.Main.immediate }
}

const val DEFAULT_DISPATCHER = "DefaultDispatcher"
const val IO_DISPATCHER = "IoDispatcher"
const val MAIN_DISPATCHER = "MainDispatcher"
const val MAIN_IMMEDIATE_DISPATCHER = "MainImmediateDispatcher"
