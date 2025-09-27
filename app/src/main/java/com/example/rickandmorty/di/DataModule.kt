package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.ApiRetrofitService
import com.example.rickandmorty.data.repositories.ApiRepositoryImpl
import com.example.rickandmorty.domain.repositories.ApiRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val dataModule = DI.Module("DataModule") {
    bind<ApiRepository>() with singleton {
        ApiRepositoryImpl(
            instance<ApiRetrofitService>(),
            instance(tag = IO_DISPATCHER)
        )
    }
}
