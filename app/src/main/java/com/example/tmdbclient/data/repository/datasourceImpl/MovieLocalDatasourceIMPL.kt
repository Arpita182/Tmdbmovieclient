package com.example.tmdbclient.data.repository.datasourceImpl

import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.repository.datasource.MovieLocaldatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceIMPL(private val movieDAO: MovieDAO): MovieLocaldatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }

}