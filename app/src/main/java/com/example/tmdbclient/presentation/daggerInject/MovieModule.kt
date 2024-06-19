package com.example.tmdbclient.presentation.daggerInject

import com.example.tmdbclient.domain.GetmoviesUseCase
import com.example.tmdbclient.domain.UpdatemoviesUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getmoviesUseCase: GetmoviesUseCase,
        updatemoviesUseCase: UpdatemoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getmoviesUseCase,
            updatemoviesUseCase
        )
    }
}