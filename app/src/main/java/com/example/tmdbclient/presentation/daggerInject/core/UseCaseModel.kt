package com.example.tmdbclient.presentation.daggerInject.core

import com.example.tmdbclient.domain.GetmoviesUseCase
import com.example.tmdbclient.domain.MovieRepository
import com.example.tmdbclient.domain.UpdatemoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModel {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetmoviesUseCase{
        return GetmoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdatemoviesUseCase
    {
        return UpdatemoviesUseCase(movieRepository)
    }
}