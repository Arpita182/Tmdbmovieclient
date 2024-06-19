package com.example.tmdbclient.data.repository.datasource

import com.example.tmdbclient.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies():Response<MovieList>
}