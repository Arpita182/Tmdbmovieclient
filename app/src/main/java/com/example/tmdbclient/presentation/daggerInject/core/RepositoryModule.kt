package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.data.repository.MovieRepositoryImpl
import com.example.tmdbclient.data.repository.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repository.datasource.MovieLocaldatasource
import com.example.tmdbclient.data.repository.datasource.MovieRemoteDatasource
import com.example.tmdbclient.domain.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocaldatasource: MovieLocaldatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocaldatasource,
            movieCacheDatasource
        )


    }
}