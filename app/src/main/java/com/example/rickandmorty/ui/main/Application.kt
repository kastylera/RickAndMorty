package com.example.rickandmorty.ui.main

import android.app.Application
import com.example.rickandmorty.di.coroutinesModule
import com.example.rickandmorty.di.dataModule
import com.example.rickandmorty.di.domainModule
import com.example.rickandmorty.di.networkModule
import com.example.rickandmorty.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class RickAndMortyApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApp)
            modules(
                networkModule,
                coroutinesModule,
                dataModule,
                domainModule,
                uiModule
            )
        }
    }
}
