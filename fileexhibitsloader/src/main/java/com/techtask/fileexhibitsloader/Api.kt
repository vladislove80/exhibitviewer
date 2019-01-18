package com.techtask.fileexhibitsloader

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class Api {

    @Provides
    @Singleton
    fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/u-android/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(OkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provide(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}