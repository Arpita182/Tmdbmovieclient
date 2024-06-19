package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.Movie

@Database(entities = [Movie::class],
    version= 1,
    exportSchema= false)
abstract class Moviedatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDAO
}