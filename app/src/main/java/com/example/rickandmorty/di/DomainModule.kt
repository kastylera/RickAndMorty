package com.example.rickandmorty.di

import com.example.rickandmorty.domain.useCases.GetCharactersUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val domainModule = DI.Module("DomainModule") {
    bind<GetCharactersUseCase>() with provider {
        GetCharactersUseCase(instance())
    }
}
