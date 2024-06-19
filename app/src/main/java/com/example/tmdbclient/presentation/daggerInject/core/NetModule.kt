package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.data.api.TMDBservice
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTmdbService(retrofit: Retrofit): TMDBservice{
        return retrofit.create(TMDBservice::class.java)
    }
}