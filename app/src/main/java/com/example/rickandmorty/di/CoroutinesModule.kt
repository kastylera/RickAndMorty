package com.example.rickandmorty.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val coroutinesModule = DI.Module("CoroutinesModule") {
    bind<CoroutineDispatcher>(tag = DEFAULT_DISPATCHER) with singleton { Dispatchers.Default }
    bind<CoroutineDispatcher>(tag = IO_DISPATCHER) with singleton { Dispatchers.IO }
    bind<CoroutineDispatcher>(tag = MAIN_DISPATCHER) with singleton { Dispatchers.Main }
    bind<CoroutineDispatcher>(tag = MAIN_IMMEDIATE_DISPATCHER) with singleton { Dispatchers.Main.immediate }
}

const val DEFAULT_DISPATCHER = "DefaultDispatcher"
const val IO_DISPATCHER = "IoDispatcher"
const val MAIN_DISPATCHER = "MainDispatcher"
const val MAIN_IMMEDIATE_DISPATCHER = "MainImmediateDispatcher"
