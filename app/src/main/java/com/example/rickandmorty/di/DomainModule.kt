package com.example.rickandmorty.di

import com.example.rickandmorty.domain.useCases.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetCharactersUseCase(get()) }
}
