package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.MovieList
import com.example.tmdbclient.domain.GetmoviesUseCase
import com.example.tmdbclient.domain.UpdatemoviesUseCase


class MovieViewModel(
    private val getmoviesUseCase: GetmoviesUseCase,
    private val updatemoviesUseCase: UpdatemoviesUseCase
):ViewModel() {

    fun getMovies() = liveData {
        val movieList = getmoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updatemoviesUseCase.execute()
        emit(movieList)
    }
}