package com.example.rickandmorty.di

import android.content.Context
import com.example.rickandmorty.core.DI_LOCAL
import com.example.rickandmorty.core.DI_REMOTE
import com.example.rickandmorty.data.datastores.CharacterDataStore
import com.example.rickandmorty.data.datastores.LocalCharacterDataStore
import com.example.rickandmorty.data.datastores.RemoteCharacterDataStore
import com.example.rickandmorty.data.db.AppDatabase
import com.example.rickandmorty.data.db.dao.CharacterDao
import com.example.rickandmorty.data.network.ApiRetrofitService
import com.example.rickandmorty.data.repositories.ApiRepositoryImpl
import com.example.rickandmorty.domain.repositories.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideCharacterDao(@ApplicationContext context: Context): CharacterDao {
        val database = AppDatabase.getInstance(context)
        return database.characterDao()
    }

    @Singleton
    @Provides
    @Named(DI_LOCAL)
    fun provideLocalCharacterDataStore(dao: CharacterDao): CharacterDataStore =
        LocalCharacterDataStore(dao)

    @Singleton
    @Provides
    @Named(DI_REMOTE)
    fun provideRemoteCharacterDataStore(
        retrofitService: ApiRetrofitService, @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): CharacterDataStore = RemoteCharacterDataStore(retrofitService, ioDispatcher)

    @Provides
    @Singleton
    fun provideApiRepository(
        @Named(DI_LOCAL) localDS: CharacterDataStore,
        @Named(DI_REMOTE) remoteDS: CharacterDataStore,
    ): ApiRepository = ApiRepositoryImpl(localDS, remoteDS)
}
