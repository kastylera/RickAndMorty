package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.ApiRetrofitService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 35L
private const val BASE_URL = "https://rickandmortyapi.com"

val networkModule = module {

    single {
        OkHttpClient.Builder().apply {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            addInterceptor(loggingInterceptor)
            writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        }.build()
    }

    single { GsonBuilder().create() }

    single { GsonConverterFactory.create(get()) }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single { get<Retrofit>().create(ApiRetrofitService::class.java) }
}
