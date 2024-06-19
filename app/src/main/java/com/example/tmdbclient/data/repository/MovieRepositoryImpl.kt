package com.example.tmdbclient.data.repository

import android.util.Log
import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.data.repository.datasource.MovieCacheDatasource
import com.example.tmdbclient.data.repository.datasource.MovieLocaldatasource
import com.example.tmdbclient.data.repository.datasource.MovieRemoteDatasource
import com.example.tmdbclient.domain.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocaldatasource: MovieLocaldatasource,
    private val movieCacheDatasource: MovieCacheDatasource
):MovieRepository {
    override suspend fun getmovies(): List<Movie>? {
      return getMoviesFromCache()
    }

    override suspend fun updatemovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocaldatasource.clearAll()
        movieLocaldatasource.saveMoviesToDb(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
        val response=movieRemoteDatasource.getMovies()
            val body=response.body()
            if(body!=null){
                movieList=body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFROMDB():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
           movieList=movieLocaldatasource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
          if (movieList.size>0){
               return movieList
                   }
          else{
             movieList=getMoviesFromAPI()
              movieLocaldatasource.saveMoviesToDb(movieList)
           }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
           movieList=movieCacheDatasource.getMoviesFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }
        else{
            movieList=getMoviesFROMDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}