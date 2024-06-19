package com.example.tmdbclient.data.repository.datasource

import com.example.tmdbclient.data.model.Movie

interface MovieCacheDatasource {
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache():List<Movie>
}