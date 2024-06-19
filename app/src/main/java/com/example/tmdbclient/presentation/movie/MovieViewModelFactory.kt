package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.GetmoviesUseCase
import com.example.tmdbclient.domain.UpdatemoviesUseCase

class MovieViewModelFactory(
    private val getmoviesUseCase: GetmoviesUseCase,
    private val updatemoviesUseCase: UpdatemoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getmoviesUseCase, updatemoviesUseCase) as T
    }
}