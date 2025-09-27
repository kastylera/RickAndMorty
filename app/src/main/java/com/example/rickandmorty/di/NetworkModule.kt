package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.ApiRetrofitService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 35L
private const val BASE_URL = "https://rickandmortyapi.com"

val networkModule = DI.Module("NetworkModule") {
    bind<OkHttpClient>() with singleton {
        val clientBuilder = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        clientBuilder.addInterceptor(loggingInterceptor)

        clientBuilder
            .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    bind<Gson>() with singleton {
        GsonBuilder().create()
    }

    bind<GsonConverterFactory>() with singleton {
        GsonConverterFactory.create(instance())
    }

    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(instance())
            .addConverterFactory(instance())
            .build()
    }

    bind<ApiRetrofitService>() with singleton {
        instance<Retrofit>().create(ApiRetrofitService::class.java)
    }
}
