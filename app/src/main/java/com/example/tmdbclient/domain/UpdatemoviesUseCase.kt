package com.example.tmdbclient.domain

import com.example.tmdbclient.data.model.Movie

class UpdatemoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updatemovies()

}