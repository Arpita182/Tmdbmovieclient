package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.data.repository.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repository.datasourceImpl.MovieCacheDatasourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class  CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDatasource{
        return MovieCacheDatasourceIMPL()
    }
}