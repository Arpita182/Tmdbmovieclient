package com.example.tmdbclient.data.repository.datasource

import com.example.tmdbclient.data.model.Movie

interface MovieLocaldatasource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDb(movies:List<Movie>)
    suspend fun clearAll()
}