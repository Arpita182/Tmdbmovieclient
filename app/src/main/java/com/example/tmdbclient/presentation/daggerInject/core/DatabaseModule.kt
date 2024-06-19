package com.example.tmdbclient.presentation.daggerInject.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.MovieDAO
import com.example.tmdbclient.data.db.Moviedatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context): Moviedatabase{
        return Room.databaseBuilder(context,Moviedatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(moviedatabase: Moviedatabase):MovieDAO{
        return moviedatabase.movieDao()
    }

}