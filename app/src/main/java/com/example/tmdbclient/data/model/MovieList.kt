package com.example.tmdbclient.data.model


import com.example.tmdbclient.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)