package com.example.rickandmorty.ui.main

import android.app.Application
import com.example.rickandmorty.di.coroutinesModule
import com.example.rickandmorty.di.dataModule
import com.example.rickandmorty.di.domainModule
import com.example.rickandmorty.di.networkModule
import com.example.rickandmorty.di.uiModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class RickAndMortyApp: Application(), DIAware {
    override val di by DI.lazy {
        import(networkModule)
        import(coroutinesModule)
        import(dataModule)
        import(domainModule)
        import(uiModule)
    }
}
