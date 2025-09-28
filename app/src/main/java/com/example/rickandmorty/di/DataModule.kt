package com.example.rickandmorty.di

import com.example.rickandmorty.data.datastores.CharacterDataStore
import com.example.rickandmorty.data.datastores.LocalCharacterDataStore
import com.example.rickandmorty.data.datastores.RemoteCharacterDataStore
import com.example.rickandmorty.data.db.AppDatabase
import com.example.rickandmorty.data.repositories.ApiRepositoryImpl
import com.example.rickandmorty.domain.repositories.ApiRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single { get<AppDatabase>().characterDao() }
    single<CharacterDataStore>((named("LOCAL"))) { LocalCharacterDataStore(get()) }
    single<CharacterDataStore>((named("REMOTE"))) {
        RemoteCharacterDataStore(
            get(),
            get(named(IO_DISPATCHER))
        )
    }

    single<ApiRepository> {
        ApiRepositoryImpl(
            localCharacterDataStore = get<CharacterDataStore>(named("LOCAL")),
            remoteCharacterDataStore = get<CharacterDataStore>(named("REMOTE"))
        )
    }
}
