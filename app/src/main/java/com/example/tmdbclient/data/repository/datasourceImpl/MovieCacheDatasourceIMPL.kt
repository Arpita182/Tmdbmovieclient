package com.example.tmdbclient.data.repository.datasourceImpl

import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.data.repository.datasource.MovieCacheDatasource

class MovieCacheDatasourceIMPL: MovieCacheDatasource {
    private var movieList =ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}