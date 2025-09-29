package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.ApiRetrofitService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CONNECTION_TIMEOUT = 35L
    private const val BASE_URL = "https://rickandmortyapi.com"

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            addInterceptor(loggingInterceptor)
            writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        }.build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiRetrofitService(retrofit: Retrofit): ApiRetrofitService =
        retrofit.create(ApiRetrofitService::class.java)

}
