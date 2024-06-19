package com.example.tmdbclient.data.repository.datasourceImpl

import com.example.tmdbclient.data.model.MovieList
import com.example.tmdbclient.data.api.TMDBservice
import com.example.tmdbclient.data.repository.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceIMPL(
    private val tmdbservice: TMDBservice,
    private val apiKey:String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbservice.getPopularMovies(apiKey)
    }


