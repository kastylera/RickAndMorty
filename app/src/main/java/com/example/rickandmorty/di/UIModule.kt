package com.example.rickandmorty.di

import com.example.rickandmorty.ui.screens.details.DefaultDetailComponent
import com.example.rickandmorty.ui.screens.details.DetailComponent
import com.example.rickandmorty.ui.screens.list.DefaultListComponent
import com.example.rickandmorty.ui.screens.list.ListComponent
import com.example.rickandmorty.ui.screens.root.DefaultRootComponent
import com.example.rickandmorty.ui.screens.root.RootComponent
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val uiModule = DI.Module("UiModule") {
    bindSingleton<DetailComponent.Factory> {
        DefaultDetailComponent.Factory()
    }

    bindSingleton<ListComponent.Factory> {
        DefaultListComponent.Factory(
           useCase = instance(),
        )
    }

    bindSingleton<RootComponent.Factory> {
        DefaultRootComponent.Factory(
            detailComponentFactory = instance(),
            listComponentFactory = instance(),
        )
    }
}
