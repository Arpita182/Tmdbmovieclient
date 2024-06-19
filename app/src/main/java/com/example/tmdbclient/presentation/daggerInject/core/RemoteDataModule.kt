package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.data.api.TMDBservice
import com.example.tmdbclient.data.repository.datasource.MovieRemoteDatasource
import com.example.tmdbclient.data.repository.datasourceImpl.MovieRemoteDatasourceIMPL
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String){

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdBservice: TMDBservice):MovieRemoteDatasource{
        return MovieRemoteDatasourceIMPL(
            tmdBservice,apiKey
        )
    }
}