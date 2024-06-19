package com.example.tmdbclient.domain

import com.example.tmdbclient.data.model.Movie
import dagger.Provides

interface MovieRepository {

    suspend fun getmovies():List<Movie>?
    suspend fun updatemovies():List<Movie>?
}