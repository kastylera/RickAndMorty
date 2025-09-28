package com.example.rickandmorty.di

import com.example.rickandmorty.ui.screens.details.DefaultDetailComponent
import com.example.rickandmorty.ui.screens.details.DetailComponent
import com.example.rickandmorty.ui.screens.list.DefaultListComponent
import com.example.rickandmorty.ui.screens.list.ListComponent
import com.example.rickandmorty.ui.screens.root.DefaultRootComponent
import com.example.rickandmorty.ui.screens.root.RootComponent
import org.koin.dsl.module

val uiModule = module {

    single<DetailComponent.Factory> { DefaultDetailComponent.Factory() }

    single<ListComponent.Factory> {
        DefaultListComponent.Factory(
            useCase = get()
        )
    }

    single<RootComponent.Factory> {
        DefaultRootComponent.Factory(
            detailComponentFactory = get(),
            listComponentFactory = get()
        )
    }
}
