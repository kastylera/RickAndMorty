package com.example.rickandmorty.di

import org.kodein.di.DI

val kodeinDI = DI {
    import(networkModule)
    import(coroutinesModule)
    import(dataModule)
    import(domainModule)
    import(uiModule)
}
