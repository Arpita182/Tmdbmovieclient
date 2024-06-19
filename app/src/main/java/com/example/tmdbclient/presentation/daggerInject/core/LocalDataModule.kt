package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.repository.datasource.MovieLocaldatasource
import com.example.tmdbclient.data.repository.datasourceImpl.MovieLocalDatasourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO):MovieLocaldatasource{
        return MovieLocalDatasourceIMPL(movieDAO)
    }
}